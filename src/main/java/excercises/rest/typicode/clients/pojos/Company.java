package excercises.rest.typicode.clients.pojos;

public class Company {
    String name;
    String catchPhrase;
    String bs;

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public Company setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Company{");
        sb.append("name='").append(name).append('\'');
        sb.append(", catchPhrase='").append(catchPhrase).append('\'');
        sb.append(", bs='").append(bs).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getBs() {
        return bs;
    }

    public Company setBs(String bs) {
        this.bs = bs;
        return this;
    }
}
