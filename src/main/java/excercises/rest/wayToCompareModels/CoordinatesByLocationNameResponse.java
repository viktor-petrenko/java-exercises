package excercises.rest.wayToCompareModels;


import java.util.Map;

public class CoordinatesByLocationNameResponse extends Model {
    private String name;
    private Map<String, String> local_names;
    private double lat;
    private double lon;
    private String country;
    private String state;

    public String getName() {
        return name;
    }

    public CoordinatesByLocationNameResponse setName(String name) {
        this.name = name;
        return this;
    }

    public Map<String, String> getLocal_names() {
        return local_names;
    }

    public CoordinatesByLocationNameResponse setLocal_names(Map<String, String> local_names) {
        this.local_names = local_names;
        return this;
    }

    public double getLat() {
        return lat;
    }

    public CoordinatesByLocationNameResponse setLat(double lat) {
        this.lat = lat;
        return this;
    }

    public double getLon() {
        return lon;
    }

    public CoordinatesByLocationNameResponse setLon(double lon) {
        this.lon = lon;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public CoordinatesByLocationNameResponse setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getState() {
        return state;
    }

    public CoordinatesByLocationNameResponse setState(String state) {
        this.state = state;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CoordinatesByLocationNameResponse{");
        sb.append("name='").append(name).append('\'');
        sb.append(", local_names=").append(local_names);
        sb.append(", lat=").append(lat);
        sb.append(", lon=").append(lon);
        sb.append(", country='").append(country).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append('}');
        return sb.toString();
    }
}