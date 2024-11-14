package excercises.other.typicode.clients.pojos;

import java.util.List;

public class Addresses {
    List<EntityInformation> addresses;

    public List<EntityInformation> getAddresses() {
        return addresses;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Addresses{");
        sb.append("addresses=").append(addresses);
        sb.append('}');
        return sb.toString();
    }

    public Addresses setAddresses(List<EntityInformation> addresses) {
        this.addresses = addresses;
        return this;
    }
}
