# Java Data Types

Topic: primitive data types, numeric literals, underscores in numbers, wrapper classes, and Strings.

Package example:

```java
package _1Z0830;
```

---

## 1. Data Types in Java

Java has two major groups of data types:

| Type Group | Meaning | Examples |
|---|---|---|
| Primitive types | Basic built-in values, not objects | `int`, `boolean`, `char` |
| Reference types | Objects created from classes | `String`, `Integer`, `Student` |

This lesson focuses on:

- primitive types
- numeric formats
- underscores in numbers
- wrapper classes
- `String`

---

## 2. Primitive Types

Java has 8 primitive types:

| Primitive Type | Category |
|---|---|
| `boolean` | true / false value |
| `byte` | integer number |
| `short` | integer number |
| `int` | integer number |
| `long` | integer number |
| `float` | decimal number |
| `double` | decimal number |
| `char` | single character |

---

## 3. Primitive Type Summary

| Type | Size | Values / Range | Default Value | Example |
|---|---:|---|---|---|
| `boolean` | JVM-dependent | `true` or `false` | `false` | `true` |
| `byte` | 8-bit | `-128` to `127` | `0` | `118` |
| `short` | 16-bit | `-32,768` to `32,767` | `0` | `12000` |
| `int` | 32-bit | about `-2.1 billion` to `2.1 billion` | `0` | `100000` |
| `long` | 64-bit | very large integer range | `0L` | `100000L` |
| `float` | 32-bit | decimal / scientific notation | `0.0f` | `2.7f` |
| `double` | 64-bit | decimal / scientific notation | `0.0d` | `2.7` |
| `char` | 16-bit | Unicode character, `0` to `65,535` | `'\u0000'` | `'C'` |

---

## 4. `boolean`

A `boolean` can have only two values:

```java
true
false
```

Example:

```java
boolean active = true;
boolean deleted = false;
```

Important:

> In Java, `true` and `false` are not the same as `1` and `0`.

This does not compile:

```java
boolean active = 1; // DOES NOT COMPILE
```

Correct:

```java
boolean active = true;
```

---

## 5. Integer Primitive Types

Java has four integer primitive types:

```java
byte
short
int
long
```

They are all signed.

That means they can store:

- negative numbers
- zero
- positive numbers

Example:

```java
byte b = 100;
short s = 20000;
int i = 1000000;
long l = 10000000000L;
```

---

## 6. `byte`

`byte` is an 8-bit integer type.

Range:

```text
-128 to 127
```

Example:

```java
byte b = 118;
```

This does not compile:

```java
byte b = 200; // DOES NOT COMPILE
```

Why?

Because `200` is outside the range of `byte`.

---

## 7. `short`

`short` is a 16-bit integer type.

Range:

```text
-32,768 to 32,767
```

Example:

```java
short s = 12000;
```

`byte` and `short` are less common in real projects, but they are important for the Java exam.

---

## 8. `int`

`int` is the most common integer type.

It is a 32-bit signed integer.

Example:

```java
int number = 100000;
```

By default, whole number literals are treated as `int`.

Example:

```java
int x = 12;
```

---

## 9. `long`

`long` is a 64-bit integer type.

Example:

```java
long bigNumber = 10000000000L;
```

Important:

> Use `L` at the end of a long literal.

Recommended:

```java
long x = 10000000000L;
```

Avoid lowercase `l`:

```java
long x = 10000000000l;
```

It works, but it looks too much like the number `1`.

---

## 10. Why `L` Is Needed for `long`

This does not compile:

```java
long x = 10000000000;
```

Why?

Because without `L`, Java treats the number as an `int` first.

But this number is too large for `int`.

Correct:

```java
long x = 10000000000L;
```

---

## 11. Decimal Primitive Types

Java has two decimal primitive types:

```java
float
double
```

| Type | Size | Common Usage |
|---|---:|---|
| `float` | 32-bit | Less common |
| `double` | 64-bit | Default decimal type |

---

## 12. `float`

A `float` is a 32-bit floating-point number.

Example:

```java
float x = 2.7f;
```

Important:

> Use `F` or `f` at the end of a float literal.

This does not compile:

```java
float x = 2.7; // DOES NOT COMPILE
```

Why?

Because `2.7` is treated as a `double` by default.

Correct:

```java
float x = 2.7F;
```

or:

```java
float x = 2.7f;
```

---

## 13. `double`

A `double` is a 64-bit floating-point number.

Decimal numbers are treated as `double` by default.

Example:

```java
double price = 19.99;
```

You can also write:

```java
double price = 19.99D;
```

But the `D` is usually not needed.

---

## 14. `char`

A `char` represents one character.

Example:

```java
char letter = 'C';
```

A `char` can also be assigned a number because characters correspond to Unicode values.

Example:

```java
char letter = 67;
```

This represents:

```text
C
```

The default value of `char` is:

```java
'\u0000'
```

This is the empty/null Unicode character.

---

## 15. Important Primitive Rules

### Rule 1: Boolean is not numeric

```java
boolean b = true;
```

This is not the same as:

```java
int x = 1;
```

Java does not treat `true` as `1` or `false` as `0`.

### Rule 2: Numeric types are signed

Numeric primitive types can store negative numbers.

Example:

```java
int x = -10;
long y = -100L;
double z = -3.14;
```

### Rule 3: `float` requires `F`

```java
float x = 2.7f;
```

Without `f`, Java treats `2.7` as a `double`.

### Rule 4: `long` should use uppercase `L`

```java
long x = 123456789L;
```

Uppercase `L` is preferred because lowercase `l` looks like `1`.

---

## 16. Number Systems in Java

Java supports several number systems.

| Number System | Base | Digits | Prefix | Example |
|---|---:|---|---|---|
| Decimal | 10 | `0-9` | none | `17` |
| Octal | 8 | `0-7` | `0` | `017` |
| Hexadecimal | 16 | `0-9`, `A-F` | `0x` or `0X` | `0x17` |
| Binary | 2 | `0-1` | `0b` or `0B` | `0b101` |

---

## 17. Decimal Literals

Decimal is the normal number system.

Example:

```java
int x = 17;
```

Digits allowed:

```text
0 1 2 3 4 5 6 7 8 9
```

---

## 18. Octal Literals

Octal uses base 8.

It starts with `0`.

Example:

```java
int x = 017;
```

This is not seventeen in decimal.

Octal `017` equals decimal `15`.

Digits allowed:

```text
0 1 2 3 4 5 6 7
```

This does not compile:

```java
int x = 018; // DOES NOT COMPILE
```

Why?

Because `8` is not allowed in octal.

---

## 19. Hexadecimal Literals

Hexadecimal uses base 16.

It starts with `0x` or `0X`.

Example:

```java
int x = 0x17;
```

Digits allowed:

```text
0 1 2 3 4 5 6 7 8 9 A B C D E F
```

Case does not matter:

```java
int a = 0xFF;
int b = 0xff;
```

Both are valid.

---

## 20. Binary Literals

Binary uses base 2.

It starts with `0b` or `0B`.

Example:

```java
int x = 0b101;
```

Digits allowed:

```text
0 1
```

This does not compile:

```java
int x = 0b102; // DOES NOT COMPILE
```

Why?

Because `2` is not allowed in binary.

---

## 21. Underscores in Numbers

Java allows underscores in numeric literals to make large numbers easier to read.

Example:

```java
int million = 1_000_000;
```

This is the same as:

```java
int million = 1000000;
```

---

## 22. Valid Underscore Examples

These compile:

```java
int a = 1_000_000;
int b = 1_2;
int c = 1_____2;
double d = 1_000_000.00_01;
```

The underscores are only for readability.

They do not change the value.

---

## 23. Invalid Underscore Examples

You cannot put underscores:

- at the beginning of a number
- at the end of a number
- right before a decimal point
- right after a decimal point

Invalid:

```java
int a = _1000;      // DOES NOT COMPILE
int b = 1000_;      // DOES NOT COMPILE
double c = 1000_.0; // DOES NOT COMPILE
double d = 1000._0; // DOES NOT COMPILE
```

Correct:

```java
int a = 1_000;
double b = 1000.0_0;
```

---

## 24. Primitive Types Are Not Objects

Primitive values are not objects.

Example:

```java
int x = 5;
```

`x` is a primitive value, not an object.

That means primitives do not have object methods.

This does not compile:

```java
int x = 5;
x.byteValue(); // DOES NOT COMPILE
```

---

## 25. Wrapper Classes

Each primitive type has a corresponding wrapper class.

A wrapper class lets you work with a primitive value as an object.

| Primitive | Wrapper Class |
|---|---|
| `boolean` | `Boolean` |
| `byte` | `Byte` |
| `short` | `Short` |
| `int` | `Integer` |
| `long` | `Long` |
| `float` | `Float` |
| `double` | `Double` |
| `char` | `Character` |

Most wrapper class names are the same as the primitive type, but with an uppercase first letter.

Exceptions:

| Primitive | Wrapper |
|---|---|
| `int` | `Integer` |
| `char` | `Character` |

---

## 26. Creating Wrapper Objects with `valueOf`

The common way to create a wrapper object is with `valueOf`.

Example:

```java
Integer a = Integer.valueOf(5);
```

Here:

| Part | Meaning |
|---|---|
| `Integer` | Wrapper class |
| `a` | Reference variable |
| `Integer.valueOf(5)` | Creates or returns an `Integer` object |
| `5` | Primitive int literal |

---

## 27. Wrapper Class Examples

```java
Boolean b = Boolean.valueOf(true);

Byte by = Byte.valueOf((byte) 12);

Short s = Short.valueOf((short) 12);

Integer i = Integer.valueOf(12);

Long l = Long.valueOf(12L);

Float f = Float.valueOf(12.5f);

Double d = Double.valueOf(12.5);

Character c = Character.valueOf('C');
```

Important:

For `Byte` and `Short`, casting is often needed because whole number literals are treated as `int`.

Example:

```java
Byte by = Byte.valueOf((byte) 12);
Short s = Short.valueOf((short) 12);
```

---

## 28. `valueOf` with Strings

`valueOf` can also convert valid strings into wrapper objects.

Example:

```java
Integer i = Integer.valueOf("12");
```

This creates an `Integer` object with value `12`.

Another example:

```java
Double d = Double.valueOf("3.14");
```

---

## 29. `parseInt`

`parseInt` converts a `String` into a primitive `int`.

Example:

```java
int m = Integer.parseInt("12");
```

Difference:

| Code | Result Type |
|---|---|
| `Integer.valueOf("12")` | `Integer` wrapper object |
| `Integer.parseInt("12")` | primitive `int` |

Example:

```java
Integer a = Integer.valueOf("12");
int b = Integer.parseInt("12");
```

---

## 30. Old Wrapper Constructors

Before Java 9, it was possible to create wrapper objects using constructors.

Example:

```java
Integer i = new Integer(5);
```

This is deprecated and should not be used.

Modern Java style:

```java
Integer i = Integer.valueOf(5);
```

---

## 31. Wrapper Value Methods

Wrapper classes provide methods to extract primitive values.

Examples:

```java
byteValue()
shortValue()
intValue()
longValue()
floatValue()
doubleValue()
booleanValue()
charValue()
```

Not every wrapper has every method.

For example:

- numeric wrappers have numeric conversion methods
- `Boolean` has `booleanValue()`
- `Character` has `charValue()`

---

## 32. Numeric Wrapper Value Example

```java
Double d = Double.valueOf(314.67);

byte b = d.byteValue();
int i = d.intValue();
double x = d.doubleValue();
```

Results:

```text
byte value: 58
int value: 314
double value: 314.67
```

Why is the byte value `58`?

Because `byte` has a limited range.

The value wraps around according to byte conversion rules.

Simplified idea:

```text
314 = 256 + 58
```

So the byte result becomes:

```text
58
```

The `intValue()` result is:

```text
314
```

It does not round.

It simply removes the decimal part.

---

## 33. String

`String` is used for text.

Example:

```java
String greeting = "Hello";
String name = "John Wayne";
```

Important:

> `String` is not a primitive type.

`String` is a class.

That is why it starts with uppercase `S`.

---

## 34. String Concatenation

The `+` operator can combine strings.

Example:

```java
String greeting = "Hello";
String name = "John Wayne";

System.out.println(greeting + ", " + name + "!");
```

Output:

```text
Hello, John Wayne!
```

---

## 35. `String` Feels Like a Primitive, But It Is Not

`String` is used so often that it can feel like a primitive type.

But technically it is a class.

Example:

```java
String text = "Hello";
```

This creates a `String` object.

---

## 36. Common Exam Traps

### Trap 1: Boolean is not `1` or `0`

Incorrect:

```java
boolean b = 1;
```

Correct:

```java
boolean b = true;
```

### Trap 2: Float needs `F`

Incorrect:

```java
float x = 2.7;
```

Correct:

```java
float x = 2.7f;
```

### Trap 3: Large long needs `L`

Incorrect:

```java
long x = 10000000000;
```

Correct:

```java
long x = 10000000000L;
```

### Trap 4: Octal cannot contain `8` or `9`

Incorrect:

```java
int x = 018;
```

Correct:

```java
int x = 017;
```

### Trap 5: Binary can contain only `0` and `1`

Incorrect:

```java
int x = 0b102;
```

Correct:

```java
int x = 0b101;
```

### Trap 6: Underscore placement matters

Incorrect:

```java
int x = _100;
int y = 100_;
double z = 100_.0;
double q = 100._0;
```

Correct:

```java
int x = 1_000;
double y = 100.0_0;
```

### Trap 7: `String` is not primitive

```java
String name = "John";
```

`String` is a class, not a primitive.

### Trap 8: `valueOf` vs `parseInt`

```java
Integer a = Integer.valueOf("12"); // wrapper object
int b = Integer.parseInt("12");    // primitive int
```

---

## 37. Key Rules to Remember

| Rule | Explanation |
|---|---|
| Java has 8 primitive types | `boolean`, `byte`, `short`, `int`, `long`, `float`, `double`, `char` |
| `boolean` is only `true` or `false` | Not `1` or `0` |
| Whole numbers are `int` by default | Use `L` for long literals |
| Decimal numbers are `double` by default | Use `F` for float literals |
| All numeric primitive types are signed | They can store negative values |
| `char` stores one Unicode character | Example: `'C'` |
| Octal starts with `0` | Example: `017` |
| Hex starts with `0x` or `0X` | Example: `0xFF` |
| Binary starts with `0b` or `0B` | Example: `0b101` |
| Underscores can improve readability | Example: `1_000_000` |
| Underscores cannot be at invalid positions | Not at start, end, or beside decimal point |
| Primitive types are not objects | They do not have methods |
| Wrapper classes represent primitives as objects | Example: `Integer` for `int` |
| `valueOf` creates wrapper objects | Example: `Integer.valueOf("12")` |
| `parseInt` returns primitive `int` | Example: `Integer.parseInt("12")` |
| `String` is a class | It is not a primitive type |

---

## 38. Complete Example

```java
package _1Z0830;

public class DataTypesExample {
    public static void main(String[] args) {
        boolean active = true;

        byte b = 118;
        short s = 12000;
        int i = 1_000_000;
        long l = 10_000_000_000L;

        float f = 2.7f;
        double d = 3.14;

        char c = 'C';

        int decimal = 17;
        int octal = 017;
        int hex = 0x17;
        int binary = 0b101;

        Integer wrapper = Integer.valueOf("12");
        int primitive = Integer.parseInt("12");

        String greeting = "Hello";
        String name = "John Wayne";

        System.out.println(greeting + ", " + name + "!");
        System.out.println(wrapper);
        System.out.println(primitive);
    }
}
```
