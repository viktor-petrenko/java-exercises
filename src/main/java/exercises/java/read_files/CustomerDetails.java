package exercises.java.read_files;

public class CustomerDetails {
    private String name;
    private String lastname;
    private int age;

    public String getName() {
        return name;
    }

    public CustomerDetails setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public CustomerDetails setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomerDetails{");
        sb.append("name='").append(name).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public CustomerDetails setAge(int age) {
        this.age = age;
        return this;
    }
}
