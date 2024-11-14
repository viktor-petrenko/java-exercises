package excercises.rest.typicode.clients;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.JacksonFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import excercises.rest.typicode.clients.pojos.EntityInformation;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import utils.PropertyLoader;

import java.util.Properties;

public class TypiCodeService {
    /**
      is that the first line registers the JacksonFeature, enabling automatic JSON handling
     (serialization and deserialization) using the Jackson library in the Jersey client.
     This feature allows Jersey to automatically convert JSON payloads to and from Java objects using Jackson.
     */
    static Client client = ClientBuilder.newClient().register(JacksonFeature.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

    static {
        Properties properties = PropertyLoader.loadProperties("config.properties");
    }

    public static EntityInformation[] getUsersPlain() {
        String url = String.format(BASE_URL);
        WebTarget target = client.target(url);
        Invocation.Builder invocationBuilder = target.request();
        Response response = invocationBuilder.get();

        //return response.readEntity(EntityInformation[].class);
        String jsonResponse = response.readEntity(String.class);

        try {
            return objectMapper.readValue(jsonResponse, EntityInformation[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public static JsonNode getUsersJson() {
        WebTarget target = client.target(BASE_URL);
        Invocation.Builder invocationBuilder = target.request();
        Response response = invocationBuilder.get();

        String jsonResponse = response.readEntity(String.class);
        try {
            return objectMapper.readTree(jsonResponse);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


}