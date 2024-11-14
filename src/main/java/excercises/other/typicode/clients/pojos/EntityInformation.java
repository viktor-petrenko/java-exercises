package excercises.other.typicode.clients.pojos;

public class EntityInformation {
    String id;
    String name;
    String username;
    String email;
    Address address;
    String phone;
    String website;
    Company company;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("entityInformation{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", address=").append(address);
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", website='").append(website).append('\'');
        sb.append(", company=").append(company);
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public EntityInformation setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EntityInformation setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public EntityInformation setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EntityInformation setEmail(String email) {
        this.email = email;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public EntityInformation setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public EntityInformation setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public EntityInformation setWebsite(String website) {
        this.website = website;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public EntityInformation setCompany(Company company) {
        this.company = company;
        return this;
    }
}
