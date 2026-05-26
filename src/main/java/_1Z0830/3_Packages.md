# Java Packages

Package example:

```java
package _1Z0830;
```

## 1. What Is a Package?

A **package** is a place where Java classes are stored and organized.

You can think about it like this:

| Java Concept | Similar File System Concept |
|---|---|
| Class | File |
| Package | Folder |
| Subpackage | Subfolder |

If a project has many classes, packages help organize them into logical groups.

Example:

```text
com.udemy.javacourse.ocp
```

This package name represents this folder structure:

```text
com/
└── udemy/
    └── javacourse/
        └── ocp/
```

---

## 2. Why Packages Are Used

Packages are used to:

- organize classes
- avoid naming conflicts
- group related code together
- make code easier to find and maintain
- separate code by feature, layer, or module

Example package names:

```java
package com.company.app.model;
package com.company.app.service;
package com.company.app.controller;
```

---

## 3. Package Naming Convention

In real projects, package names usually use a reversed domain name.

Example:

```java
package com.udemy.javacourse.ocp;
```

If the company domain is:

```text
udemy.com
```

The package often starts with:

```text
com.udemy
```

For exam examples, package names can be very simple:

```java
package a.b.c;
```

This is valid, even if it is not a good real-project naming style.

---

## 4. Package Statement

The package statement tells Java which package the class belongs to.

Example:

```java
package com.udemy.oca;

public class Student {
}
```

Important rule:

> The package statement must be the first statement in the Java file.

Comments and blank lines can appear before it, but no Java statements can appear before it.

Correct:

```java
package com.udemy.oca;

public class Student {
}
```

Incorrect:

```java
import java.util.Random;

package com.udemy.oca;

public class Student {
}
```

This does not compile because the `package` statement must come before imports.

---

## 5. Packages and Folder Structure

The package name must match the folder structure.

If the package is:

```java
package com.udemy.oca;
```

Then the file should be located in:

```text
com/udemy/oca/
```

Example:

```text
com/
└── udemy/
    └── oca/
        └── OCA.java
```

File:

```text
OCA.java
```

Code:

```java
package com.udemy.oca;

public class OCA {
}
```

---

## 6. Importing Classes from Packages

To use a class from another package, you usually need to import it.

Example:

```java
import java.util.Random;
```

Full example:

```java
package _1Z0830;

import java.util.Random;

public class NumberGenerator {
    public static void main(String[] args) {
        Random randomNumber = new Random();
        System.out.println(randomNumber.nextInt(100));
    }
}
```

Here:

| Code | Meaning |
|---|---|
| `Random` | Class name |
| `randomNumber` | Reference variable |
| `new Random()` | New object of the `Random` class |
| `nextInt(100)` | Method call that generates a number from `0` to `99` |

---

## 7. What Happens Without Import?

If you write this:

```java
package _1Z0830;

public class NumberGenerator {
    public static void main(String[] args) {
        Random randomNumber = new Random();
        System.out.println(randomNumber.nextInt(100));
    }
}
```

It does not compile because Java does not know where to find `Random`.

You need this import:

```java
import java.util.Random;
```

---

## 8. Wildcard Imports

Instead of importing one class:

```java
import java.util.Random;
```

You can import all classes from one package:

```java
import java.util.*;
```

This imports classes directly inside `java.util`.

Example:

```java
package _1Z0830;

import java.util.*;

public class NumberGenerator {
    public static void main(String[] args) {
        Random randomNumber = new Random();
        System.out.println(randomNumber.nextInt(100));
    }
}
```

---

## 9. Wildcards Do Not Import Subpackages

This import:

```java
import java.util.*;
```

imports classes inside `java.util`.

It does **not** import classes from subpackages.

For example, it does not import classes from:

```text
java.util.concurrent
```

To use classes from a subpackage, you need a separate import:

```java
import java.util.concurrent.*;
```

---

## 10. Invalid Wildcard Usage

Wildcards can be used only to import classes from one package.

Correct:

```java
import java.util.*;
```

Incorrect:

```java
import java.*.*;
```

This does not compile.

Java does not allow wildcard imports across multiple package levels.

---

## 11. Fully Qualified Class Name

A **fully qualified class name** includes the package name plus the class name.

Example:

```java
java.util.Random
```

You can use it without an import:

```java
package _1Z0830;

public class NumberGenerator {
    public static void main(String[] args) {
        java.util.Random randomNumber = new java.util.Random();
        System.out.println(randomNumber.nextInt(100));
    }
}
```

This works, but it is usually less readable.

Usually, this is better:

```java
import java.util.Random;

Random randomNumber = new Random();
```

---

## 12. When Fully Qualified Names Are Useful

Fully qualified names are useful when two classes have the same simple name.

Example:

```java
java.util.Date
java.sql.Date
```

Both classes are called `Date`, but they are different classes from different packages.

This can cause a conflict.

---

## 13. Import Conflict Example

This does not compile:

```java
import java.util.Date;
import java.sql.Date;

public class DateExample {
    Date date;
}
```

The compiler does not know which `Date` class to use.

---

## 14. Solving Import Conflicts

One possible solution is to import one class and use the fully qualified name for the other.

Example:

```java
import java.util.Date;

public class DateExample {
    Date utilDate;
    java.sql.Date sqlDate;
}
```

Here:

| Code | Meaning |
|---|---|
| `Date` | Refers to `java.util.Date` because it is explicitly imported |
| `java.sql.Date` | Uses the fully qualified class name |

---

## 15. Explicit Import Wins Over Wildcard Import

This compiles:

```java
import java.util.Date;
import java.sql.*;

public class DateExample {
    Date date;
}
```

Java uses:

```java
java.util.Date
```

because explicit imports have priority over wildcard imports.

But if you need `java.sql.Date`, you should write:

```java
java.sql.Date sqlDate;
```

---

## 16. Creating Your Own Package

Example folder structure:

```text
com/
└── udemy/
    └── oca/
        └── OCA.java
```

File:

```text
OCA.java
```

Code:

```java
package com.udemy.oca;

public class OCA {
}
```

This means:

| Item | Value |
|---|---|
| Package | `com.udemy.oca` |
| File name | `OCA.java` |
| Public class | `OCA` |
| Folder path | `com/udemy/oca/` |

---

## 17. Using Your Own Package from Another Class

Folder structure:

```text
com/
└── udemy/
    ├── oca/
    │   └── OCA.java
    └── ocp/
        └── OCP.java
```

File:

```text
OCA.java
```

Code:

```java
package com.udemy.oca;

public class OCA {
}
```

File:

```text
OCP.java
```

Code:

```java
package com.udemy.ocp;

import com.udemy.oca.OCA;

public class OCP {
    public static void main(String[] args) {
        OCA oca = new OCA();
    }
}
```

The `OCP` class can use `OCA` because it imports it:

```java
import com.udemy.oca.OCA;
```

---

## 18. Import Order

The usual order in a Java file is:

```java
package com.example;

import java.util.Random;

public class Example {
}
```

Order:

1. package statement
2. imports
3. class declaration

Example:

```java
package _1Z0830;

import java.util.Random;

public class NumberGenerator {
    public static void main(String[] args) {
        Random randomNumber = new Random();
        System.out.println(randomNumber.nextInt(100));
    }
}
```

---

## 19. Common Exam Traps

### Trap 1: Package is not first

Incorrect:

```java
import java.util.Random;
package a.b.c;

public class Test {
}
```

Does not compile.

### Trap 2: Wildcard does not import subpackages

```java
import java.util.*;
```

This does not import:

```java
java.util.concurrent.*
```

### Trap 3: Invalid wildcard package import

Incorrect:

```java
import java.*.*;
```

Does not compile.

### Trap 4: Two explicit imports with same class name

Incorrect:

```java
import java.util.Date;
import java.sql.Date;
```

Does not compile if you use `Date` without clarification.

### Trap 5: Fully qualified name can replace import

This works without import:

```java
java.util.Random random = new java.util.Random();
```

---

## 20. Key Rules to Remember

| Rule | Explanation |
|---|---|
| Packages organize classes | Similar to folders |
| Package names follow folder structure | `com.udemy.oca` → `com/udemy/oca/` |
| Package statement comes first | Before imports and class declaration |
| Imports allow using classes from other packages | Example: `import java.util.Random;` |
| Wildcard imports classes in one package | Example: `import java.util.*;` |
| Wildcards do not import subpackages | `java.util.*` does not import `java.util.concurrent.*` |
| Fully qualified name can avoid import | Example: `java.util.Random` |
| Same class name can exist in different packages | Example: `java.util.Date` and `java.sql.Date` |
| Explicit import has priority over wildcard import | `import java.util.Date;` beats `import java.sql.*;` |

---

## Complete Example

File:

```text
NumberGenerator.java
```

Code:

```java
package _1Z0830;

import java.util.Random;

public class NumberGenerator {
    public static void main(String[] args) {
        Random randomNumber = new Random();
        System.out.println(randomNumber.nextInt(100));
    }
}
```

Compile:

```bash
javac NumberGenerator.java
```

Run from the parent folder of `_1Z0830`:

```bash
java _1Z0830.NumberGenerator
```

Output example:

```text
57
```

The exact number can be different because it is randomly generated.
