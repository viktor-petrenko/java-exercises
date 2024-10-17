package questions.coderpad;

/**
 * Key Changes:
 * <p>
 * Centralized getName() in Animal: Reduces code duplication.
 * Constructor in Animal: Ensures all animals are named through the superclass constructor.
 * Direct method call in getAnimalName: Utilizes polymorphism to simplify the code and make it more maintainable.
 * <p>
 * This ver sion adheres to principles of object-oriented programming such as DRY (Don't Repeat Yourself) and encapsulation, and takes full advantage of polymorphism to simplify type handling and method calls.
 */
abstract class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
}

class ImproveCode {

    static String getAnimalName(Animal a) {
        return a.getName();
    }

    public static void main(String[] args) {
        Animal myDog = new Dog("Rover");
        Animal myCat = new Cat("Whiskers");
        System.out.println(getAnimalName(myDog)); // Outputs: Rover
        System.out.println(getAnimalName(myCat)); // Outputs: Whiskers
    }
}