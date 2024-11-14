package exercises.rest.typicode.clients.pojos;

public class Geo {
    String lat;

    public String getLat() {
        return lat;
    }

    public Geo setLat(String lat) {
        this.lat = lat;
        return this;
    }

    public String getLng() {
        return lng;
    }

    public Geo setLng(String lng) {
        this.lng = lng;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Geo{");
        sb.append("lat='").append(lat).append('\'');
        sb.append(", lng='").append(lng).append('\'');
        sb.append('}');
        return sb.toString();
    }

    String lng;
}
