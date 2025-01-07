# Lab Exercise: Let’s Code It!

Now that we've got the theory, let’s dive into hands-on coding. Time to roll up your sleeves and have some fun!

---

## Exercise 1: Demonstrate Different Data Types

Write a program that showcases various data types. Here’s an example:

```java
public class DataTypesDemo {
    public static void main(String[] args) {
        int myInt = 100;
        float myFloat = 3.14f;
        double myDouble = 9.876;
        char myChar = 'A';
        boolean isJavaCool = true;

        System.out.println("Integer: " + myInt);
        System.out.println("Float: " + myFloat);
        System.out.println("Double: " + myDouble);
        System.out.println("Character: " + myChar);
        System.out.println("Boolean: " + isJavaCool);
    }
}
```

---

## Exercise 2: Build a Simple Calculator

Use **arithmetic** and **relational** operators to create a simple calculator.

```java
public class Calculator {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        int quotient = a / b;
        int remainder = a % b;

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);
    }
}
```

---

## Exercise 3: Demonstrate Type Casting

Show both **implicit** and **explicit** type casting.

```java
public class TypeCasting {
    public static void main(String[] args) {
        // Implicit Casting
        int myInt = 50;
        double myDouble = myInt;  // Implicit cast
        System.out.println("Implicit Casting: " + myDouble);

        // Explicit Casting
        double anotherDouble = 9.87;
        int myInt2 = (int) anotherDouble;  // Explicit cast
        System.out.println("Explicit Casting: " + myInt2);
    }
}
```

---

## Wrap-Up! You’re Now a Data Type and Operator Master! 🏆

That’s it! Now you’ve got a solid understanding of data types, variables, and operators in Java. You’re ready to handle numbers, words, comparisons, and more like a pro. Time to get creative and code some cool stuff! 💻✨
