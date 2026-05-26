# Java Class Structure

Package:

```java
package _1Z0830;
```

## 1. Fields and Methods

The two main elements, or **members**, of Java classes are:

- **fields**
- **methods**

Fields are sometimes referred to as variables.

To be precise:

> All fields are variables, but not all variables are fields.

### Fields

Fields hold information about the **state** of an object or a class.

Example:

```java
String name;
```

### Methods

Methods describe some action or operation on that state.

Methods are similar to functions in some older programming languages.

Example:

```java
public String getName() {
    return name;
}
```

---

## 2. Simplest Java Class

```java
class Student { }
```

---

## 3. Class in Its Own File

File name:

```text
Student.java
```

Code:

```java
public class Student {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String theName) {
        name = theName;
    }
}
```

### Method Details

For this method:

```java
public String getName() {
    return name;
}
```

Return type:

```text
String
```

For this method:

```java
public void setName(String theName) {
    name = theName;
}
```

Signature:

```text
setName(String theName)
```

---

## 4. Comments

Comments are used to make code more readable.

They are ignored by the compiler.

There are three common ways to write comments in Java.

---

### One-Line Comment

```java
// this is a one-line comment
```

Example:

```java
System.out.println(a); // this will print a
```

---

### Multi-Line Comment

```java
/*
 * usual way to write multiline comments
 * it's very readable like this
 */
```

Example:

```java
System.out.println(a); /* this will print a */
```

---

### Javadoc Comment

Javadoc comments start with:

```java
/**
```

Example:

```java
/**
 * Javadoc style offers you some nice features.
 *
 * @author Luka Popov
 */
```

---

## 5. Classes and Source Files

It is a good practice to have each class in its own `.java` file.

It is possible to have more than one class in one file, but only one of them can be a **public top-level class**.

A top-level class is often marked as `public`, but it is not required.

Important rule:

> If a top-level class is marked as `public`, then the filename must match the public class name.

Also:

> Only one top-level class in the file can be marked as `public`.

Small typo from the slide:

```text
only one class in the can be marked as public
```

Probably means:

```text
only one class in the file can be marked as public
```

---

## 6. Valid Example: One Public Class

File name:

```text
Student.java
```

Code:

```java
public class Student { }
```

This compiles because the public class name matches the file name.

---

## 7. Valid Example: One Public Class and One Non-Public Class

File name:

```text
Item.java
```

Code:

```java
public class Item { }

class SomeOtherItem { }
```

This compiles because only `Item` is public.

The file name matches the public class name:

```text
Item.java → Item
```

---

## 8. Invalid Example: Two Public Classes in One File

File name:

```text
Customer.java
```

Code:

```java
public class Customer { }

public class Client { } // DOES NOT COMPILE
```

This does not compile because there are two public classes in one file.

Also, `Client` is public, so Java would expect it to be in a file named:

```text
Client.java
```

---

## Key Rules to Remember

| Rule | Explanation |
|---|---|
| A class can be empty | `class Student { }` is valid |
| Fields store state | Example: `String name;` |
| Methods define behavior | Example: `getName()` or `setName()` |
| Comments are ignored by compiler | They help humans read code |
| Public class name must match file name | `public class Student` must be in `Student.java` |
| Only one public top-level class per file | Two public classes in one file will not compile |
| Non-public classes can share a file | As long as only one class is public |

---

## Complete Example

```java
package _1Z0830;

public class Student {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String theName) {
        name = theName;
    }
}
```
