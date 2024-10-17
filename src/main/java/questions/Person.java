package questions;

import com.google.common.base.Objects;

public class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    // 1) if two object are equal then they must have the same hash code
    // 2) if two objects have the same hash code they may or may not be equal

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equal(name, person.name);
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.getName());
    }

//    @Override
//    public int compareTo(Person o) {
//       return Integer.compare(this.age, o.age);
//    }
}
