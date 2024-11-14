package excercises.other.wayToCompareModels;



public class CoordinatesByZipCodeResponse extends Model {
    private String zip;
    private String name;
    private double lat;
    private double lon;
    private String country;

    public String getZip() {
        return zip;
    }

    public CoordinatesByZipCodeResponse setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public String getName() {
        return name;
    }

    public CoordinatesByZipCodeResponse setName(String name) {
        this.name = name;
        return this;
    }

    public double getLat() {
        return lat;
    }

    public CoordinatesByZipCodeResponse setLat(double lat) {
        this.lat = lat;
        return this;
    }

    public double getLon() {
        return lon;
    }

    public CoordinatesByZipCodeResponse setLon(double lon) {
        this.lon = lon;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public CoordinatesByZipCodeResponse setCountry(String country) {
        this.country = country;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CoordinatesByZipCodeResponse{");
        sb.append("zip='").append(zip).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", lat=").append(lat);
        sb.append(", lon=").append(lon);
        sb.append(", country='").append(country).append('\'');
        sb.append('}');
        return sb.toString();
    }
}