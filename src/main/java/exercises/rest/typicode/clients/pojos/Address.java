package exercises.rest.typicode.clients.pojos;

public class Address {
    String street;
    String suite;
    String city;
    String zipcode;
    Geo geo;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("street='").append(street).append('\'');
        sb.append(", suite='").append(suite).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", zipcode='").append(zipcode).append('\'');
        sb.append(", geo=").append(geo);
        sb.append('}');
        return sb.toString();
    }

    public Geo getGeo() {
        return geo;
    }

    public Address setGeo(Geo geo) {
        this.geo = geo;
        return this;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Address setZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getSuite() {
        return suite;
    }

    public Address setSuite(String suite) {
        this.suite = suite;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }
}
