# Java Main Class and `main` Method

Package:

```java
package _1Z0830;
```

## 1. What Is the `main` Method?

The `main` method is the starting point of a Java program.

When you run a Java application, Java starts execution from the `main` method.

That is why the `main` method has a special required structure.

---

## 2. Standard `main` Method Syntax

The most common form is:

```java
public static void main(String[] args) {
    // program starts here
}
```

Full example:

```java
package _1Z0830;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
    }
}
```

---

## 3. Meaning of Each Part

```java
public static void main(String[] args)
```

| Part | Meaning |
|---|---|
| `public` | The method is accessible from outside the class |
| `static` | The method belongs to the class, not to an object |
| `void` | The method does not return any value |
| `main` | The required method name Java looks for when starting the program |
| `String[] args` | An array of command-line arguments passed to the program |

---

## 4. Why `static` Is Required

The `main` method is called before any object is created.

Because of that, Java needs to call it directly from the class.

That is why `main` must be `static`.

Example:

```java
public class MainClass {
    public static void main(String[] args) {
        System.out.println("Program started");
    }
}
```

Java can run this without creating an object manually:

```bash
java MainClass
```

---

## 5. Why `void` Is Required

`void` means the method does not return anything.

The `main` method starts the program, runs the code, and finishes.

Correct:

```java
public static void main(String[] args) {
    System.out.println("Done");
}
```

Incorrect:

```java
public static int main(String[] args) {
    return 0;
}
```

This is not a valid Java entry point.

---

## 6. Command-Line Arguments

The parameter:

```java
String[] args
```

means that the program can receive input values from the command line.

Example class:

```java
package _1Z0830;

public class Names {
    public static void main(String[] args) {
        System.out.println("First name: " + args[0]);
        System.out.println("Last name: " + args[1]);
    }
}
```

Compile:

```bash
javac Names.java
```

Run:

```bash
java Names John Wayne
```

Output:

```text
First name: John
Last name: Wayne
```

---

## 7. Array Indexes Start from Zero

Command-line arguments are stored in an array.

Arrays in Java start from index `0`.

For this command:

```bash
java Names John Wayne
```

Java reads the arguments like this:

| Argument | Value |
|---|---|
| `args[0]` | `John` |
| `args[1]` | `Wayne` |

---

## 8. What Happens If Not Enough Arguments Are Passed?

Code:

```java
System.out.println(args[0]);
System.out.println(args[1]);
```

Run:

```bash
java Names John
```

Java receives only one argument:

| Argument | Value |
|---|---|
| `args[0]` | `John` |
| `args[1]` | Does not exist |

Result:

```text
ArrayIndexOutOfBoundsException
```

The program tries to access `args[1]`, but there is no second argument.

---

## 9. What Happens If Extra Arguments Are Passed?

Run:

```bash
java Names John D Wayne
```

Java receives three arguments:

| Argument | Value |
|---|---|
| `args[0]` | `John` |
| `args[1]` | `D` |
| `args[2]` | `Wayne` |

If the program only uses `args[0]` and `args[1]`, then `args[2]` is ignored.

Output:

```text
First name: John
Last name: D
```

---

## 10. Arguments with Spaces

If you want several words to be treated as one argument, use quotes.

Run:

```bash
java Names "John D" Wayne
```

Java receives two arguments:

| Argument | Value |
|---|---|
| `args[0]` | `John D` |
| `args[1]` | `Wayne` |

Output:

```text
First name: John D
Last name: Wayne
```

---

## 11. Valid Ways to Write the `main` Method

The most common version:

```java
public static void main(String[] args) {
}
```

The argument name does not have to be `args`:

```java
public static void main(String[] someName) {
}
```

Array brackets can be placed after the parameter name:

```java
public static void main(String args[]) {
}
```

Varargs are also allowed:

```java
public static void main(String... args) {
}
```

You can use `final`:

```java
public static final void main(final String[] args) {
}
```

You can switch `public` and `static`:

```java
static public void main(String[] args) {
}
```

---

## 12. Important Rule: `void main` Must Stay Together

The return type and method name must be in the correct order:

```java
void main
```

Correct:

```java
public static void main(String[] args) {
}
```

Incorrect:

```java
public static main void(String[] args) {
}
```

Incorrect:

```java
public static void final main(String[] args) {
}
```

The return type must come directly before the method name.

---

## 13. Complete Example

File name:

```text
Names.java
```

Code:

```java
package _1Z0830;

public class Names {
    public static void main(String[] args) {
        System.out.println("First name: " + args[0]);
        System.out.println("Last name: " + args[1]);
    }
}
```

Compile:

```bash
javac Names.java
```

Run:

```bash
java Names John Wayne
```

Output:

```text
First name: John
Last name: Wayne
```

---

## 14. Simple Hello World Practice

File name:

```text
MainClass.java
```

Code:

```java
package _1Z0830;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

Compile:

```bash
javac MainClass.java
```

Run:

```bash
java MainClass
```

Output:

```text
Hello World
```

---

## Key Rules to Remember

| Rule | Explanation |
|---|---|
| Java starts from `main` | The first executed method is `main` |
| `main` must be `public` | Java must be able to access it |
| `main` must be `static` | Java calls it from the class, not from an object |
| `main` must be `void` | It does not return anything |
| The name must be `main` | Java looks for this exact method name |
| `String[] args` stores input arguments | These are command-line arguments |
| Argument indexes start at `0` | First argument is `args[0]` |
| Missing arguments can cause an exception | Example: `ArrayIndexOutOfBoundsException` |
| Extra arguments are allowed | Unused arguments are simply ignored |
| Quotes group words into one argument | Example: `"John D"` |
