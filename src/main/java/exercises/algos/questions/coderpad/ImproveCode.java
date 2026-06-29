package exercises.algos.questions.coderpad;

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