# Lab Exercises: Time to Show Off Your Superpowers!

## 1. Find the Maximum of Three Numbers

**Task** : Write a method that finds the largest of three numbers. Think of it as a mini-battle between three rivals to determine who reigns supreme. Your method will be the ultimate judge!

```java
public class MaxNumber {
    // Method to find the maximum of three numbers
    public static int findMax(int num1, int num2, int num3) {
        int max = num1;  // Assume first number is the max
        if (num2 > max) max = num2;  // If second number is greater, it becomes the max
        if (num3 > max) max = num3;  // If third number is greater, it becomes the max
        return max;  // Return the winner (max number)
    }

    public static void main(String[] args) {
        // Call the method with three numbers
        System.out.println("The maximum number is: " + findMax(10, 20, 15));
    }
}
```

### Output

```bash
The maximum number is: 20
```

---

## 2. Overload Like a Pro

**Task**: Method overloading is all about versatility. Write different methods to handle different data types, like an overachiever who can switch between math, cooking, and gaming without breaking a sweat.

```java
public class MethodOverloading {

    // Overloaded method to add two integers
    public static int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add two doubles
    public static double add(double a, double b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        // Calling overloaded methods
        System.out.println("Sum of two integers: " + add(10, 20));
        System.out.println("Sum of two doubles: " + add(10.5, 20.5));
        System.out.println("Sum of three integers: " + add(10, 20, 30));
    }
}
```

### Output

```bash
Sum of two integers: 30
Sum of two doubles: 31.0
Sum of three integers: 60
```

---

## 3. Static Class Showdown

**Task**: Create a class with static variables and methods. Make them like the all-powerful band that doesn’t need instruments (objects). They just show up and perform whenever you summon them with their name.

```java
public class StaticDemo {
    // Static variable
    static int counter = 0;

    // Static method to increment the counter
    public static void incrementCounter() {
        counter++;
    }

    // Static method to display the counter
    public static void displayCounter() {
        System.out.println("Counter value is: " + counter);
    }

    public static void main(String[] args) {
        // Static methods and variables can be accessed without creating an object
        StaticDemo.incrementCounter();
        StaticDemo.incrementCounter();
        StaticDemo.displayCounter();  // Should display "Counter value is: 2"
    }
}
```

### Output

```bash
Counter value is: 2
```