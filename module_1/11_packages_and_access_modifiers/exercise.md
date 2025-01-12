# Let's Exercise

Let’s put these concepts into action!

## Creating a Package and Using Access Modifiers:

- **Step 1**: Create a package `com.myapp.utils` and declare a class in it with different access modifiers.

```java
package com.myapp.utils;

public class Utility {
    public void publicMethod() {
        System.out.println("Public method can be accessed from anywhere.");
    }

    protected void protectedMethod() {
        System.out.println("Protected method can be accessed by subclasses and package members.");
    }

    void defaultMethod() {
        System.out.println("Default method is package-private.");
    }

    private void privateMethod() {
        System.out.println("Private method can only be accessed within this class.");
    }
}
```

- **Step 2**: Create another class in a different package to see how the access modifiers behave.

```java
package com.myapp.test;

import com.myapp.utils.Utility;

public class TestUtility {
    public static void main(String[] args) {
        Utility util = new Utility();
        util.publicMethod();  // This will work

        // The following will throw access errors
        // util.protectedMethod();  // Not allowed (unless this class is a subclass)
        // util.defaultMethod();    // Not allowed (since it's in a different package)
        // util.privateMethod();    // Not allowed (private access)
    }
}
```

## Implementing a Class in the Same Package:

- Create another class in the same package `com.myapp.utils` to test access to package-private and protected methods.

```java
package com.myapp.utils;

public class TestUtilityInSamePackage {
    public static void main(String[] args) {
        Utility util = new Utility();
        util.publicMethod();  // Works
        util.protectedMethod();  // Works (same package)
        util.defaultMethod();  // Works (same package)
        // util.privateMethod();  // Error! Still not accessible
    }
}
```

---

Packages and access modifiers aren’t just theoretical—they help keep your code organized, modular, and secure. Imagine you’re building a big project with hundreds of classes. Packages keep it all neat and tidy, while access modifiers protect sensitive data and functionality. No one’s touching your private variables without permission!

When you build applications like banking systems, APIs, or even games, you can control which parts of your code are public, private, or accessible to certain classes. It’s like running your own little Java city, where you control all the gates and doors!

## The Big Picture 🎬

- `Packages` organize your code into neat little neighborhoods, making your project scalable and easy to manage.
- `Access modifiers` act as security layers, allowing you to control who gets in and who stays out, protecting your code like a boss.

With packages and access modifiers, your Java code will be structured, secure, and ready for action!
