# Java: Compile, Run, and Archive Files

Topic: compiling Java files, running Java programs, using classpath, and creating JAR files.

---

## 1. Main Java Commands

Java has several important command-line tools.

| Command | Purpose |
|---|---|
| `javac` | Compiles `.java` source files into `.class` files |
| `java` | Runs compiled Java classes |
| `jar` | Creates or manages `.jar` archive files |

---

## 2. Example Project Structure

Imagine we have two packages:

```text
com/
└── udemy/
    ├── ocp/
    │   └── OCP.java
    └── oca/
        └── OCA.java
```

The files are:

```text
com/udemy/ocp/OCP.java
com/udemy/oca/OCA.java
```

The package declarations inside those files should match the folder structure.

Example:

```java
package com.udemy.ocp;

public class OCP {
}
```

And:

```java
package com.udemy.oca;

public class OCA {
}
```

---

## 3. Where to Run Commands From

Before compiling or running, position yourself in the common parent folder.

For this structure:

```text
com/
└── udemy/
    ├── ocp/
    │   └── OCP.java
    └── oca/
        └── OCA.java
```

The common parent folder is the folder that contains `com`.

From there, Java commands can use the package paths correctly.

---

## 4. Compiling Java Files with `javac`

The `javac` command compiles Java source files.

Example:

```bash
javac com/udemy/ocp/OCP.java com/udemy/oca/OCA.java
```

This creates `.class` files:

```text
com/
└── udemy/
    ├── ocp/
    │   ├── OCP.java
    │   └── OCP.class
    └── oca/
        ├── OCA.java
        └── OCA.class
```

---

## 5. Compiling Multiple Java Files with Wildcards

If there are many Java files in one folder, you can use a wildcard.

Example:

```bash
javac com/udemy/ocp/*.java com/udemy/oca/*.java
```

This compiles all `.java` files directly inside those folders.

Important:

> The wildcard `*.java` matches files in that folder only. It does not automatically include subfolders.

---

## 6. Running a Java Program with `java`

After compiling, you run the program with the `java` command.

Example:

```bash
java com.udemy.ocp.OCP
```

Important:

> When running a class, use the fully qualified class name, not the file path.

Correct:

```bash
java com.udemy.ocp.OCP
```

Incorrect:

```bash
java com/udemy/ocp/OCP
```

Incorrect:

```bash
java com.udemy.ocp.OCP.class
```

You do **not** write `.class` when running the program.

---

## 7. Compile Output in the Same Folder

By default, `javac` puts the `.class` file next to the `.java` file.

Command:

```bash
javac com/udemy/ocp/OCP.java
```

Result:

```text
com/
└── udemy/
    └── ocp/
        ├── OCP.java
        └── OCP.class
```

---

## 8. Compiling to a Separate Folder with `-d`

You can tell `javac` where to place compiled `.class` files.

Use the `-d` option.

Example:

```bash
javac -d classes com/udemy/ocp/OCP.java com/udemy/oca/OCA.java
```

This creates a separate `classes` folder:

```text
classes/
└── com/
    └── udemy/
        ├── ocp/
        │   └── OCP.class
        └── oca/
            └── OCA.class
```

Source files stay where they are:

```text
com/
└── udemy/
    ├── ocp/
    │   └── OCP.java
    └── oca/
        └── OCA.java
```

---

## 9. Running Classes from a Separate Folder

If `.class` files are in a separate folder, Java needs to know where to find them.

Use the classpath option.

Short form:

```bash
java -cp classes com.udemy.ocp.OCP
```

Long form:

```bash
java -classpath classes com.udemy.ocp.OCP
```

Another long form:

```bash
java --class-path classes com.udemy.ocp.OCP
```

All three are equivalent:

| Option | Meaning |
|---|---|
| `-cp` | Short form of classpath |
| `-classpath` | Long form |
| `--class-path` | Long GNU-style form |

---

## 10. What Is Classpath?

Classpath tells Java where to look for compiled classes and dependencies.

Example:

```bash
java -cp classes com.udemy.ocp.OCP
```

This means:

| Part | Meaning |
|---|---|
| `java` | Run Java program |
| `-cp classes` | Look for compiled classes inside the `classes` folder |
| `com.udemy.ocp.OCP` | Run this class |

---

## 11. Classpath Can Also Be Used with `javac`

The classpath option is not only for running programs.

It can also be used when compiling.

Example:

```bash
javac -cp classes com/udemy/ocp/OCP.java
```

This is useful when the file being compiled depends on already compiled classes located somewhere else.

---

## 12. Running with Multiple Dependencies

Sometimes an application depends on:

- classes in the current folder
- classes in another folder
- classes inside a JAR file

The classpath can include multiple locations.

---

## 13. Windows Classpath Separator

On Windows, classpath entries are separated by semicolons:

```bash
java -cp ".;deps;myjar.jar" mypackage.MyApp
```

Meaning:

| Entry | Meaning |
|---|---|
| `.` | Current folder |
| `deps` | Folder with dependency classes |
| `myjar.jar` | JAR file dependency |
| `mypackage.MyApp` | Class to run |

---

## 14. Unix / macOS Classpath Separator

On Unix and macOS, classpath entries are separated by colons:

```bash
java -cp ".:deps:myjar.jar" mypackage.MyApp
```

Meaning is the same as on Windows, but the separator is different.

| Operating System | Classpath Separator |
|---|---|
| Windows | `;` |
| Unix / macOS | `:` |

---

## 15. The Current Directory: `.`

The dot means current directory.

Example:

```bash
java -cp "." mypackage.MyApp
```

This tells Java:

> Look for classes starting from the current folder.

Usually, when adding several classpath entries, the current directory is included explicitly:

Windows:

```bash
java -cp ".;deps;myjar.jar" mypackage.MyApp
```

Unix / macOS:

```bash
java -cp ".:deps:myjar.jar" mypackage.MyApp
```

---

## 16. Using Wildcards for JAR Files

If you have many JAR files in one folder, you can use `*`.

Windows:

```bash
java -cp ".;myjars/*" mypackage.MyApp
```

Unix / macOS:

```bash
java -cp ".:myjars/*" mypackage.MyApp
```

This includes all JAR files directly inside the `myjars` folder.

Important:

> The wildcard does not include JAR files from subfolders.

---

## 17. What Is a JAR File?

A JAR file is a Java archive file.

It is similar to a ZIP file, but it is used for Java applications and libraries.

JAR files usually contain:

- compiled `.class` files
- package folder structure
- resources
- optional metadata

Example:

```text
myapp.jar
```

---

## 18. Creating a JAR from the Current Folder

Use the `jar` command.

Short form:

```bash
jar -cvf mynewjar.jar .
```

Meaning:

| Option | Meaning |
|---|---|
| `c` | create a new archive |
| `v` | verbose output |
| `f` | specify the file name |
| `mynewjar.jar` | name of the JAR file |
| `.` | include current folder |

---

## 19. Long Form for Creating a JAR

The same command can be written in a longer form:

```bash
jar --create --verbose --file mynewjar.jar .
```

This means the same thing as:

```bash
jar -cvf mynewjar.jar .
```

---

## 20. Creating a JAR from a Custom Folder

If the files are in another folder, use `-C`.

Example:

```bash
jar -cvf mynewjar.jar -C classes .
```

Meaning:

| Part | Meaning |
|---|---|
| `jar` | Run the JAR tool |
| `-cvf` | Create verbose file |
| `mynewjar.jar` | New JAR file name |
| `-C classes` | Change to the `classes` folder |
| `.` | Include everything from that folder |

Important:

> `-C` has no long version.

---

## 21. Common Exam Traps

### Trap 1: Running with `.class`

Incorrect:

```bash
java com.udemy.ocp.OCP.class
```

Correct:

```bash
java com.udemy.ocp.OCP
```

When using `java`, do not include `.class`.

---

### Trap 2: Using File Path Instead of Package Name

Incorrect:

```bash
java com/udemy/ocp/OCP
```

Correct:

```bash
java com.udemy.ocp.OCP
```

When running, use dots, not slashes.

---

### Trap 3: Forgetting Classpath

If classes are compiled into a separate folder:

```bash
javac -d classes com/udemy/ocp/OCP.java
```

Then this may fail:

```bash
java com.udemy.ocp.OCP
```

Use classpath:

```bash
java -cp classes com.udemy.ocp.OCP
```

---

### Trap 4: Wrong Classpath Separator

Windows:

```bash
java -cp ".;deps;myjar.jar" mypackage.MyApp
```

Unix / macOS:

```bash
java -cp ".:deps:myjar.jar" mypackage.MyApp
```

Do not mix `;` and `:` across operating systems.

---

### Trap 5: Wildcards Do Not Include Subfolders

This includes JARs directly in `myjars`:

```bash
java -cp ".:myjars/*" mypackage.MyApp
```

It does not include JARs inside:

```text
myjars/extra/
```

---

## 22. Key Rules to Remember

| Rule | Explanation |
|---|---|
| `javac` compiles Java files | Converts `.java` to `.class` |
| `java` runs compiled classes | Runs the class with `main` method |
| `jar` creates Java archive files | Similar to ZIP for Java |
| Do not use `.class` with `java` | Use `java package.ClassName` |
| Use dots when running classes | `com.udemy.ocp.OCP` |
| Use slashes when compiling files | `com/udemy/ocp/OCP.java` |
| `-d` controls output directory | Example: `javac -d classes ...` |
| `-cp` sets classpath | Tells Java where classes/dependencies are |
| `-classpath` and `--class-path` are also valid | Longer forms of `-cp` |
| Windows classpath separator is `;` | Example: `.;deps;myjar.jar` |
| Unix/macOS classpath separator is `:` | Example: `.:deps:myjar.jar` |
| `.` means current directory | Often included in classpath |
| JAR wildcard includes JARs in one folder | It does not include subfolders |
| `jar -cvf file.jar .` creates a JAR | Short form |
| `jar --create --verbose --file file.jar .` also creates a JAR | Long form |

---

## 23. Complete Example

Project structure:

```text
com/
└── udemy/
    ├── ocp/
    │   └── OCP.java
    └── oca/
        └── OCA.java
```

Compile to `classes` folder:

```bash
javac -d classes com/udemy/ocp/OCP.java com/udemy/oca/OCA.java
```

Run the program:

```bash
java -cp classes com.udemy.ocp.OCP
```

Create a JAR from compiled classes:

```bash
jar -cvf app.jar -C classes .
```

Run using the JAR on the classpath:

```bash
java -cp app.jar com.udemy.ocp.OCP
```
