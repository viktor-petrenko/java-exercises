package jwt;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.function.Consumer;

/**
 * Small JWT toolkit focused on clean architecture:
 * - Immutable JwtToken model
 * - Parser / Editor / Builder separation
 * - Signer strategy
 * - HS256 implementation
 * - KeyProvider for kid-based key resolution
 * - Enum roles
 * - Validation layer
 * - Custom exception model
 *
 * Scope:
 * - Supports compact JWS tokens: header.payload.signature
 * - Implements HS256 signing and verification
 * - Designed so RS256 / ES256 can be added later through JwtSigner
 */
public final class JwtToolkit {

    private JwtToolkit() {}

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Base64.Decoder URL_DECODER = Base64.getUrlDecoder();
    private static final Base64.Encoder URL_ENCODER = Base64.getUrlEncoder().withoutPadding();

    // ---------------------------------------------------------------------
    // Public facade
    // ---------------------------------------------------------------------

    public static JwtParser parser() {
        return new JwtParser();
    }

    public static JwtBuilder builder() {
        return new JwtBuilder();
    }

    public static JwtEditor edit(String jwt) {
        return new JwtEditor(parser().parseUntrusted(jwt));
    }

    public static JwtSigner hs256(String secret) {
        return new HmacSha256Signer(secret);
    }

    public static JwtSigner hs256(String keyId, String secret) {
        return new HmacSha256Signer(keyId, secret);
    }

    // ---------------------------------------------------------------------
    // Role enum
    // ---------------------------------------------------------------------

    public enum Role {
        ADMIN,
        USER,
        AUDITOR,
        SUPPORT
    }

    // ---------------------------------------------------------------------
    // Immutable token model
    // ---------------------------------------------------------------------

    public static final class JwtToken {
        private final String encodedHeader;
        private final String encodedPayload;
        private final String signature;
        private final Map<String, Object> header;
        private final Map<String, Object> payload;

        private JwtToken(
                String encodedHeader,
                String encodedPayload,
                String signature,
                Map<String, Object> header,
                Map<String, Object> payload
        ) {
            this.encodedHeader = requireNotBlank(encodedHeader, "encodedHeader");
            this.encodedPayload = requireNotBlank(encodedPayload, "encodedPayload");
            this.signature = requireNotBlank(signature, "signature");
            this.header = deepUnmodifiableCopy(header);
            this.payload = deepUnmodifiableCopy(payload);
        }

        public String encodedHeader() {
            return encodedHeader;
        }

        public String encodedPayload() {
            return encodedPayload;
        }

        public String signature() {
            return signature;
        }

        public String signingInput() {
            return encodedHeader + "." + encodedPayload;
        }

        public String compact() {
            return signingInput() + "." + signature;
        }

        public String[] parts() {
            return new String[]{encodedHeader, encodedPayload, signature};
        }

        public Map<String, Object> header() {
            return header;
        }

        public Map<String, Object> payload() {
            return payload;
        }

        public String algorithm() {
            return getString(header, "alg");
        }

        public Optional<String> keyId() {
            return Optional.ofNullable(getString(header, "kid"));
        }

        public Optional<String> subject() {
            return Optional.ofNullable(getString(payload, "sub"));
        }

        public Optional<String> issuer() {
            return Optional.ofNullable(getString(payload, "iss"));
        }

        public Optional<String> audience() {
            return Optional.ofNullable(getString(payload, "aud"));
        }

        public Optional<Long> expiresAtEpochSeconds() {
            return Optional.ofNullable(getLong(payload, "exp"));
        }

        public Optional<Long> issuedAtEpochSeconds() {
            return Optional.ofNullable(getLong(payload, "iat"));
        }

        public Optional<Long> notBeforeEpochSeconds() {
            return Optional.ofNullable(getLong(payload, "nbf"));
        }

        public List<Role> roles() {
            Object rawRoles = payload.get("roles");
            if (!(rawRoles instanceof Collection<?> values)) {
                return List.of();
            }

            List<Role> roles = new ArrayList<>();
            for (Object value : values) {
                if (value == null) {
                    continue;
                }
                try {
                    roles.add(Role.valueOf(value.toString()));
                } catch (IllegalArgumentException ignored) {
                    // Unknown role is ignored in the safe accessor.
                    // Strict validation can be added in JwtValidator if needed.
                }
            }
            return List.copyOf(roles);
        }

        public String prettyPrint() {
            try {
                return "HEADER:\n" + MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(header)
                        + "\n\nPAYLOAD:\n" + MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(payload);
            } catch (Exception e) {
                throw new JwtProcessingException("Failed to pretty print JWT", e);
            }
        }
    }

    // ---------------------------------------------------------------------
    // Parser
    // ---------------------------------------------------------------------

    public static final class JwtParser {

        /**
         * Parses token into header/payload/signature but does NOT verify trust.
         */
        public JwtToken parseUntrusted(String jwt) {
            requireNotBlank(jwt, "jwt");

            String[] parts = jwt.split("\\.", -1);
            if (parts.length != 3) {
                throw new JwtParseException("JWT must contain exactly 3 parts: header.payload.signature");
            }
            if (parts[0].isBlank() || parts[1].isBlank() || parts[2].isBlank()) {
                throw new JwtParseException("JWT header, payload and signature must be non-empty");
            }

            Map<String, Object> header = decodeJson(parts[0], "header");
            Map<String, Object> payload = decodeJson(parts[1], "payload");

            String alg = getString(header, "alg");
            if (alg == null || alg.isBlank()) {
                throw new JwtParseException("JWT header is missing alg");
            }
            if ("none".equalsIgnoreCase(alg)) {
                throw new JwtParseException("JWT alg=none is not supported");
            }

            return new JwtToken(parts[0], parts[1], parts[2], header, payload);
        }

        public JwtToken parseAndVerify(String jwt, KeyProvider keyProvider) {
            JwtToken token = parseUntrusted(jwt);
            JwtSigner signer = keyProvider.resolve(token);

            if (!signer.algorithm().equals(token.algorithm())) {
                throw new JwtSignatureException("Token alg does not match signer alg. token="
                        + token.algorithm() + ", signer=" + signer.algorithm());
            }

            if (!signer.verify(token.signingInput(), token.signature())) {
                throw new JwtSignatureException("JWT signature verification failed");
            }

            return token;
        }
    }

    // ---------------------------------------------------------------------
    // Builder
    // ---------------------------------------------------------------------

    public static final class JwtBuilder {
        private final Map<String, Object> header = new LinkedHashMap<>();
        private final Map<String, Object> payload = new LinkedHashMap<>();
        private Clock clock = Clock.systemUTC();

        private JwtBuilder() {}

        public JwtBuilder keyId(String kid) {
            header.put("kid", requireNotBlank(kid, "kid"));
            return this;
        }

        public JwtBuilder header(String key, Object value) {
            header.put(requireNotBlank(key, "header key"), value);
            return this;
        }

        public JwtBuilder claim(String key, Object value) {
            payload.put(requireNotBlank(key, "claim key"), value);
            return this;
        }

        public JwtBuilder subject(String subject) {
            payload.put("sub", requireNotBlank(subject, "subject"));
            return this;
        }

        public JwtBuilder issuer(String issuer) {
            payload.put("iss", requireNotBlank(issuer, "issuer"));
            return this;
        }

        public JwtBuilder audience(String audience) {
            payload.put("aud", requireNotBlank(audience, "audience"));
            return this;
        }

        public JwtBuilder roles(Role... roles) {
            return roles(Arrays.asList(roles));
        }

        public JwtBuilder roles(Collection<Role> roles) {
            Objects.requireNonNull(roles, "roles");
            payload.put("roles", roles.stream().filter(Objects::nonNull).map(Role::name).toList());
            return this;
        }

        public JwtBuilder issuedNow() {
            payload.put("iat", Instant.now(clock).getEpochSecond());
            return this;
        }

        public JwtBuilder expiresIn(Duration duration) {
            Objects.requireNonNull(duration, "duration");
            payload.put("exp", Instant.now(clock).plus(duration).getEpochSecond());
            return this;
        }

        public JwtBuilder notBeforeNow() {
            payload.put("nbf", Instant.now(clock).getEpochSecond());
            return this;
        }

        public JwtBuilder clock(Clock clock) {
            this.clock = Objects.requireNonNull(clock, "clock");
            return this;
        }

        public JwtToken signWith(JwtSigner signer) {
            Objects.requireNonNull(signer, "signer");

            header.put("alg", signer.algorithm());
            signer.keyId().ifPresent(kid -> header.put("kid", kid));

            return buildSignedToken(header, payload, signer);
        }
    }

    // ---------------------------------------------------------------------
    // Editor
    // ---------------------------------------------------------------------

    public static final class JwtEditor {
        private final Map<String, Object> header;
        private final Map<String, Object> payload;
        private Clock clock = Clock.systemUTC();

        private JwtEditor(JwtToken token) {
            this.header = deepMutableCopy(token.header());
            this.payload = deepMutableCopy(token.payload());
        }

        public JwtEditor header(String key, Object value) {
            header.put(requireNotBlank(key, "header key"), value);
            return this;
        }

        public JwtEditor removeHeader(String key) {
            header.remove(key);
            return this;
        }

        public JwtEditor keyId(String kid) {
            header.put("kid", requireNotBlank(kid, "kid"));
            return this;
        }

        public JwtEditor claim(String key, Object value) {
            payload.put(requireNotBlank(key, "claim key"), value);
            return this;
        }

        public JwtEditor removeClaim(String key) {
            payload.remove(key);
            return this;
        }

        public JwtEditor subject(String subject) {
            payload.put("sub", requireNotBlank(subject, "subject"));
            return this;
        }

        public JwtEditor issuer(String issuer) {
            payload.put("iss", requireNotBlank(issuer, "issuer"));
            return this;
        }

        public JwtEditor audience(String audience) {
            payload.put("aud", requireNotBlank(audience, "audience"));
            return this;
        }

        public JwtEditor roles(Role... roles) {
            return roles(Arrays.asList(roles));
        }

        public JwtEditor roles(Collection<Role> roles) {
            Objects.requireNonNull(roles, "roles");
            payload.put("roles", roles.stream().filter(Objects::nonNull).map(Role::name).toList());
            return this;
        }

        public JwtEditor issuedNow() {
            payload.put("iat", Instant.now(clock).getEpochSecond());
            return this;
        }

        public JwtEditor expiresIn(Duration duration) {
            Objects.requireNonNull(duration, "duration");
            payload.put("exp", Instant.now(clock).plus(duration).getEpochSecond());
            return this;
        }

        public JwtEditor notBeforeNow() {
            payload.put("nbf", Instant.now(clock).getEpochSecond());
            return this;
        }

        public JwtEditor mutatePayload(Consumer<Map<String, Object>> mutator) {
            mutator.accept(payload);
            return this;
        }

        public JwtEditor mutateHeader(Consumer<Map<String, Object>> mutator) {
            mutator.accept(header);
            return this;
        }

        public JwtEditor clock(Clock clock) {
            this.clock = Objects.requireNonNull(clock, "clock");
            return this;
        }

        public JwtToken signWith(JwtSigner signer) {
            Objects.requireNonNull(signer, "signer");

            header.put("alg", signer.algorithm());
            signer.keyId().ifPresent(kid -> header.put("kid", kid));

            return buildSignedToken(header, payload, signer);
        }
    }

    // ---------------------------------------------------------------------
    // Signer strategy
    // ---------------------------------------------------------------------

    public interface JwtSigner {
        String algorithm();
        Optional<String> keyId();
        String sign(String signingInput);
        boolean verify(String signingInput, String signature);
    }

    public static final class HmacSha256Signer implements JwtSigner {
        private static final String ALG = "HS256";
        private final String keyId;
        private final byte[] secret;

        public HmacSha256Signer(String secret) {
            this(null, secret);
        }

        public HmacSha256Signer(String keyId, String secret) {
            this.keyId = keyId;
            this.secret = requireNotBlank(secret, "secret").getBytes(StandardCharsets.UTF_8);
        }

        @Override
        public String algorithm() {
            return ALG;
        }

        @Override
        public Optional<String> keyId() {
            return Optional.ofNullable(keyId);
        }

        @Override
        public String sign(String signingInput) {
            try {
                Mac mac = Mac.getInstance("HmacSHA256");
                mac.init(new SecretKeySpec(secret, "HmacSHA256"));
                return URL_ENCODER.encodeToString(mac.doFinal(signingInput.getBytes(StandardCharsets.UTF_8)));
            } catch (Exception e) {
                throw new JwtSignatureException("Failed to sign JWT with HS256", e);
            }
        }

        @Override
        public boolean verify(String signingInput, String signature) {
            String expected = sign(signingInput);
            return MessageDigest.isEqual(
                    expected.getBytes(StandardCharsets.UTF_8),
                    signature.getBytes(StandardCharsets.UTF_8)
            );
        }
    }

    // ---------------------------------------------------------------------
    // Key provider
    // ---------------------------------------------------------------------

    public interface KeyProvider {
        JwtSigner resolve(JwtToken token);
    }

    public static final class StaticKeyProvider implements KeyProvider {
        private final JwtSigner signer;

        public StaticKeyProvider(JwtSigner signer) {
            this.signer = Objects.requireNonNull(signer, "signer");
        }

        @Override
        public JwtSigner resolve(JwtToken token) {
            return signer;
        }
    }

    public static final class KidKeyProvider implements KeyProvider {
        private final Map<String, JwtSigner> signersByKid;

        public KidKeyProvider(Map<String, JwtSigner> signersByKid) {
            if (signersByKid == null || signersByKid.isEmpty()) {
                throw new IllegalArgumentException("signersByKid must not be empty");
            }
            this.signersByKid = Map.copyOf(signersByKid);
        }

        @Override
        public JwtSigner resolve(JwtToken token) {
            String kid = token.keyId()
                    .orElseThrow(() -> new JwtSignatureException("JWT header is missing kid"));

            JwtSigner signer = signersByKid.get(kid);
            if (signer == null) {
                throw new JwtSignatureException("No signer configured for kid=" + kid);
            }
            return signer;
        }
    }

    // ---------------------------------------------------------------------
    // Validator
    // ---------------------------------------------------------------------

    public static final class JwtValidator {
        private Clock clock = Clock.systemUTC();
        private Duration clockSkew = Duration.ofSeconds(60);
        private String expectedIssuer;
        private String expectedAudience;
        private boolean requireExpiration = true;

        public JwtValidator clock(Clock clock) {
            this.clock = Objects.requireNonNull(clock, "clock");
            return this;
        }

        public JwtValidator clockSkew(Duration clockSkew) {
            this.clockSkew = Objects.requireNonNull(clockSkew, "clockSkew");
            return this;
        }

        public JwtValidator expectedIssuer(String issuer) {
            this.expectedIssuer = requireNotBlank(issuer, "issuer");
            return this;
        }

        public JwtValidator expectedAudience(String audience) {
            this.expectedAudience = requireNotBlank(audience, "audience");
            return this;
        }

        public JwtValidator requireExpiration(boolean requireExpiration) {
            this.requireExpiration = requireExpiration;
            return this;
        }

        public void validate(JwtToken token) {
            Objects.requireNonNull(token, "token");

            long now = Instant.now(clock).getEpochSecond();
            long skew = clockSkew.getSeconds();

            Optional<Long> exp = token.expiresAtEpochSeconds();
            if (requireExpiration && exp.isEmpty()) {
                throw new JwtValidationException("JWT is missing required exp claim");
            }
            if (exp.isPresent() && now - skew > exp.get()) {
                throw new JwtValidationException("JWT is expired");
            }

            Optional<Long> nbf = token.notBeforeEpochSeconds();
            if (nbf.isPresent() && now + skew < nbf.get()) {
                throw new JwtValidationException("JWT is not valid yet");
            }

            if (expectedIssuer != null) {
                String actualIssuer = token.issuer().orElse(null);
                if (!expectedIssuer.equals(actualIssuer)) {
                    throw new JwtValidationException("Invalid issuer. expected=" + expectedIssuer + ", actual=" + actualIssuer);
                }
            }

            if (expectedAudience != null) {
                String actualAudience = token.audience().orElse(null);
                if (!expectedAudience.equals(actualAudience)) {
                    throw new JwtValidationException("Invalid audience. expected=" + expectedAudience + ", actual=" + actualAudience);
                }
            }
        }
    }

    // ---------------------------------------------------------------------
    // Exceptions
    // ---------------------------------------------------------------------

    public static class JwtException extends RuntimeException {
        public JwtException(String message) {
            super(message);
        }

        public JwtException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static final class JwtParseException extends JwtException {
        public JwtParseException(String message) {
            super(message);
        }

        public JwtParseException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static final class JwtSignatureException extends JwtException {
        public JwtSignatureException(String message) {
            super(message);
        }

        public JwtSignatureException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static final class JwtValidationException extends JwtException {
        public JwtValidationException(String message) {
            super(message);
        }
    }

    public static final class JwtProcessingException extends JwtException {
        public JwtProcessingException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    // ---------------------------------------------------------------------
    // Internal helpers
    // ---------------------------------------------------------------------

    private static JwtToken buildSignedToken(
            Map<String, Object> header,
            Map<String, Object> payload,
            JwtSigner signer
    ) {
        try {
            String encodedHeader = encodeJson(header);
            String encodedPayload = encodeJson(payload);
            String signingInput = encodedHeader + "." + encodedPayload;
            String signature = signer.sign(signingInput);

            return new JwtToken(
                    encodedHeader,
                    encodedPayload,
                    signature,
                    header,
                    payload
            );
        } catch (Exception e) {
            throw new JwtProcessingException("Failed to build signed JWT", e);
        }
    }

    private static Map<String, Object> decodeJson(String encoded, String partName) {
        try {
            byte[] decoded = URL_DECODER.decode(encoded);
            return MAPPER.readValue(decoded, new TypeReference<Map<String, Object>>() {});
        } catch (Exception e) {
            throw new JwtParseException("Failed to decode JWT " + partName, e);
        }
    }

    private static String encodeJson(Map<String, Object> json) {
        try {
            return URL_ENCODER.encodeToString(MAPPER.writeValueAsBytes(json));
        } catch (Exception e) {
            throw new JwtProcessingException("Failed to encode JWT JSON", e);
        }
    }

    private static String requireNotBlank(String value, String name) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(name + " must not be blank");
        }
        return value;
    }

    private static String getString(Map<String, Object> map, String key) {
        Object value = map.get(key);
        return value == null ? null : value.toString();
    }

    private static Long getLong(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value == null) {
            return null;
        }
        if (value instanceof Number number) {
            return number.longValue();
        }
        try {
            return Long.parseLong(value.toString());
        } catch (NumberFormatException e) {
            throw new JwtValidationException("Claim " + key + " must be numeric");
        }
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> deepMutableCopy(Map<String, Object> original) {
        Map<String, Object> copy = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : original.entrySet()) {
            copy.put(entry.getKey(), deepCopyValue(entry.getValue(), false));
        }
        return copy;
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> deepUnmodifiableCopy(Map<String, Object> original) {
        Map<String, Object> copy = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : original.entrySet()) {
            copy.put(entry.getKey(), deepCopyValue(entry.getValue(), true));
        }
        return Collections.unmodifiableMap(copy);
    }

    @SuppressWarnings("unchecked")
    private static Object deepCopyValue(Object value, boolean unmodifiable) {
        if (value instanceof Map<?, ?> map) {
            Map<String, Object> copy = new LinkedHashMap<>();
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                copy.put(String.valueOf(entry.getKey()), deepCopyValue(entry.getValue(), unmodifiable));
            }
            return unmodifiable ? Collections.unmodifiableMap(copy) : copy;
        }

        if (value instanceof Collection<?> collection) {
            List<Object> copy = collection.stream()
                    .map(v -> deepCopyValue(v, unmodifiable))
                    .toList();
            return unmodifiable ? List.copyOf(copy) : new ArrayList<>(copy);
        }

        return value;
    }

    // ---------------------------------------------------------------------
    // Example usage
    // ---------------------------------------------------------------------

    public static final class Example {
        public static void main(String[] args) {
            JwtSigner oldSigner = JwtToolkit.hs256("old-key", "old-secret");
            JwtSigner newSigner = JwtToolkit.hs256("new-key", "new-secret");

            JwtToken original = JwtToolkit.builder()
                    .subject("user-123")
                    .issuer("auth-service")
                    .audience("my-api")
                    .roles(Role.USER)
                    .issuedNow()
                    .expiresIn(Duration.ofHours(1))
                    .signWith(oldSigner);

            JwtToken edited = JwtToolkit.edit(original.compact())
                    .roles(Role.ADMIN, Role.USER)
                    .claim("tenantId", "tenant-777")
                    .expiresIn(Duration.ofHours(2))
                    .signWith(newSigner);

            JwtToken verified = JwtToolkit.parser().parseAndVerify(
                    edited.compact(),
                    new JwtToolkit.KidKeyProvider(Map.of("new-key", newSigner))
            );

            new JwtToolkit.JwtValidator()
                    .expectedIssuer("auth-service")
                    .expectedAudience("my-api")
                    .validate(verified);

            System.out.println(verified.compact());
            System.out.println(verified.prettyPrint());
        }
    }
}
