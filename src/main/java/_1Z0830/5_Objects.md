# Java Objects

Topic: creating objects, constructors, fields, instance variables, and initialization order.

Package example:

```java
package _1Z0830;
```

---

## 1. What Is an Object?

An **object** is an instance of a class.

A class is like a blueprint.

An object is the real thing created from that blueprint.

Example analogy:

| Concept | Analogy |
|---|---|
| Class | House blueprint |
| Object | Real house built from the blueprint |

In Java:

```java
Student s = new Student();
```

Here, `Student` is the class, and `s` refers to an object created from that class.

---

## 2. Creating Objects with `new`

A new object is created using the `new` keyword.

Example:

```java
Student s = new Student();
```

Meaning:

| Part | Meaning |
|---|---|
| `Student` | Type of the reference variable |
| `s` | Reference variable name |
| `new Student()` | Creates a new `Student` object |
| `Student()` | Calls the constructor |

Full example:

```java
package _1Z0830;

public class Student {
}
```

Another class:

```java
package _1Z0830;

public class MyApp {
    public static void main(String[] args) {
        Student s = new Student();
    }
}
```

---

## 3. What Happens When an Object Is Created?

When this line runs:

```java
Student s = new Student();
```

Java does two main things:

1. Creates a new object in memory
2. Calls the constructor of the class

The constructor is called automatically when the object is created.

---

## 4. Constructor

A **constructor** is a special block of code used when creating an object.

Example:

```java
package _1Z0830;

public class Student {
    public Student() {
        System.out.println("New student is created");
    }
}
```

When this object is created:

```java
Student s = new Student();
```

Output:

```text
New student is created
```

---

## 5. Constructor Rules

A constructor has two important rules:

| Rule | Explanation |
|---|---|
| Constructor name must match class name | `Student` constructor must be named `Student` |
| Constructor has no return type | Not even `void` |

Correct constructor:

```java
public class Student {
    public Student() {
        System.out.println("New student is created");
    }
}
```

Incorrect if you mean constructor:

```java
public class Student {
    public void Student() {
        System.out.println("New student is created");
    }
}
```

This compiles, but it is **not** a constructor.

It is a regular method because it has a return type: `void`.

---

## 6. Constructor vs Method with Same Name

This is a constructor:

```java
public Student() {
    System.out.println("New student is created");
}
```

This is a method:

```java
public void Student() {
    System.out.println("New student is created");
}
```

Why?

Because methods have a return type.

Constructors do not.

| Code | Constructor or Method? | Why |
|---|---|---|
| `public Student()` | Constructor | Same name as class and no return type |
| `public void Student()` | Method | Has return type `void` |

---

## 7. Example: Constructor Runs Automatically

File:

```text
Student.java
```

Code:

```java
package _1Z0830;

public class Student {
    public Student() {
        System.out.println("New student is created");
    }
}
```

File:

```text
MyApp.java
```

Code:

```java
package _1Z0830;

public class MyApp {
    public static void main(String[] args) {
        Student s = new Student();
    }
}
```

Output:

```text
New student is created
```

The constructor runs automatically because the object was created with `new Student()`.

---

## 8. Example: Method Does Not Run Automatically

File:

```text
Student.java
```

Code:

```java
package _1Z0830;

public class Student {
    public void Student() {
        System.out.println("New student is created");
    }
}
```

File:

```text
MyApp.java
```

Code:

```java
package _1Z0830;

public class MyApp {
    public static void main(String[] args) {
        Student s = new Student();
    }
}
```

Output:

```text

```

Nothing is printed.

Why?

Because `public void Student()` is not a constructor. It is just a method.

To run it, you must call it explicitly:

```java
s.Student();
```

---

## 9. Default Constructor

If you do not write any constructor, Java automatically creates a default no-argument constructor.

Example:

```java
public class Student {
}
```

Java treats it as if it had this constructor:

```java
public class Student {
    public Student() {
    }
}
```

Important:

> The compiler creates a default constructor only if you do not write any constructor yourself.

---

## 10. If You Write a Constructor, Java Does Not Add the Default One

Example:

```java
public class Student {
    public Student(String name) {
    }
}
```

Now Java does **not** add this automatically:

```java
public Student() {
}
```

So this will not compile:

```java
Student s = new Student();
```

Because there is no no-argument constructor anymore.

---

## 11. Fields / Instance Variables

A field is a variable that belongs to an object or class.

An **instance variable** belongs to an object instance.

Example:

```java
public class Student {
    String name;
}
```

Here, `name` is an instance variable.

Each `Student` object can have its own `name`.

---

## 12. Reading and Modifying Fields

Example:

```java
package _1Z0830;

public class Student {
    String name;

    public static void main(String[] args) {
        Student s = new Student();

        s.name = "John Wayne";

        System.out.println(s.name);
    }
}
```

Output:

```text
John Wayne
```

Explanation:

| Code | Meaning |
|---|---|
| `Student s = new Student();` | Creates a new object |
| `s.name = "John Wayne";` | Sets the `name` field |
| `System.out.println(s.name);` | Reads and prints the `name` field |

---

## 13. Dot Operator

The dot operator is used to access fields and methods of an object.

Example:

```java
s.name = "John Wayne";
```

Here:

| Part | Meaning |
|---|---|
| `s` | Object reference |
| `.` | Dot operator |
| `name` | Field |

Another example:

```java
s.Student();
```

Here, the dot operator is used to call a method.

---

## 14. Naming Conventions

Java has common naming conventions.

| Element | Convention | Example |
|---|---|---|
| Class names | Start with uppercase letter | `Student`, `Dog`, `MyApp` |
| Constructor names | Same as class name | `Student()` |
| Method names | Start with lowercase letter | `getName()`, `setName()` |
| Variable names | Start with lowercase letter | `student`, `dog`, `name` |

These are conventions, not compiler rules.

The exam may show strange names to test whether you understand the rules.

---

## 15. Code Block

A **code block** is code between curly braces.

Example:

```java
{
    System.out.println("Inside block");
}
```

Code blocks appear in:

- classes
- methods
- constructors
- initializer blocks

---

## 16. Instance Initializer Block

An **instance initializer block** is a block of code inside a class but outside any method or constructor.

Example:

```java
public class Dog {
    {
        System.out.println("Inside initializer block");
    }
}
```

This block runs when a new object is created.

---

## 17. Initialization Order

When an object is created, Java initializes it in this order:

1. Fields and instance initializer blocks execute in the order they appear in the class
2. Constructor executes after that

Important:

> Instance initializer blocks run before the constructor body.

---

## 18. Initialization Order Example

Code:

```java
package _1Z0830;

public class Dog {
    private String name = "Chip";

    public Dog() {
        name = "Teddy";
        System.out.println("Inside the constructor");
    }

    {
        System.out.println("Inside the initializer block");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.name);
    }
}
```

Output:

```text
Inside the initializer block
Inside the constructor
Teddy
```

---

## 19. Why This Output Happens

When this line runs:

```java
Dog dog = new Dog();
```

Java creates a new `Dog` object.

Then initialization happens.

### Step 1: Field is initialized

```java
private String name = "Chip";
```

Now:

```text
name = "Chip"
```

### Step 2: Instance initializer block runs

```java
{
    System.out.println("Inside the initializer block");
}
```

Output:

```text
Inside the initializer block
```

### Step 3: Constructor runs

```java
public Dog() {
    name = "Teddy";
    System.out.println("Inside the constructor");
}
```

Now:

```text
name = "Teddy"
```

Output:

```text
Inside the constructor
```

### Step 4: Main method continues

```java
System.out.println(dog.name);
```

Output:

```text
Teddy
```

---

## 20. Important Note About Source Order

Fields and initializer blocks run before the constructor body.

Even if the initializer block appears after the constructor in the source file, it still runs before the constructor body.

Example:

```java
public class Dog {
    public Dog() {
        System.out.println("Constructor");
    }

    {
        System.out.println("Initializer block");
    }
}
```

Output when object is created:

```text
Initializer block
Constructor
```

---

## 21. Common Exam Traps

### Trap 1: Method Looks Like Constructor

```java
public void Student() {
}
```

This is not a constructor.

It is a method because it has a return type.

### Trap 2: Default Constructor Disappears

```java
public class Student {
    public Student(String name) {
    }
}
```

This class does not automatically get:

```java
public Student() {
}
```

So this does not compile:

```java
Student s = new Student();
```

### Trap 3: Constructor Has No Return Type

Correct:

```java
public Student() {
}
```

Incorrect if intended as constructor:

```java
public void Student() {
}
```

### Trap 4: Instance Initializer Runs Before Constructor

```java
public class Test {
    public Test() {
        System.out.println("constructor");
    }

    {
        System.out.println("initializer");
    }

    public static void main(String[] args) {
        new Test();
    }
}
```

Output:

```text
initializer
constructor
```

### Trap 5: Object Field Can Be Modified After Creation

```java
Student s = new Student();
s.name = "John";
```

This is valid if the field is accessible.

---

## 22. Key Rules to Remember

| Rule | Explanation |
|---|---|
| Object is an instance of a class | Class is blueprint, object is real instance |
| `new` creates an object | Example: `new Student()` |
| Constructor runs when object is created | Called automatically by `new` |
| Constructor name matches class name | Example: `Student()` |
| Constructor has no return type | Not even `void` |
| A method can have same name as class | But if it has return type, it is not a constructor |
| Default constructor is added only if no constructors exist | If you write any constructor, Java does not add default one |
| Instance variables store object state | Example: `String name;` |
| Dot operator accesses fields and methods | Example: `s.name` |
| Instance initializer block runs during object creation | Before constructor body |
| Fields and initializer blocks run before constructor | In source order among fields and initializer blocks |

---

## 23. Complete Example

File:

```text
Student.java
```

Code:

```java
package _1Z0830;

public class Student {
    String name;

    public Student() {
        System.out.println("New student is created");
    }

    public static void main(String[] args) {
        Student s = new Student();

        s.name = "John Wayne";

        System.out.println(s.name);
    }
}
```

Output:

```text
New student is created
John Wayne
```

---

## 24. Complete Dog Example

File:

```text
Dog.java
```

Code:

```java
package _1Z0830;

public class Dog {
    private String name = "Chip";

    public Dog() {
        name = "Teddy";
        System.out.println("Inside the constructor");
    }

    {
        System.out.println("Inside the initializer block");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.name);
    }
}
```

Output:

```text
Inside the initializer block
Inside the constructor
Teddy
```
