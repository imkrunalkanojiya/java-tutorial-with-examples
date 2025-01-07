# Lab Exercises: Let’s Put These Concepts into Action!

Now that you know the theory, let’s fire up your Java skills with some hands-on exercises. 🎮

---

## Exercise 1: Check if a Number is Even or Odd (If-Else)

Here’s a quick program to find out if a number is `even` or `odd`.
```java
import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        if (num % 2 == 0) {
            System.out.println(num + " is even!");
        } else {
            System.out.println(num + " is odd!");
        }
    }
}
```
You input a number, and the program checks if it’s even or odd by using the modulus operator `%`. If `num % 2 == 0`, it’s even; otherwise, it’s odd. 🔄

---

## Exercise 2: Create a Menu-Driven Program (Switch-Case)

Let's create a `menu-driven` program where you can choose between different options using a `switch-case`.

```java
import java.util.Scanner;

public class MenuExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("You chose Add.");
                break;
            case 2:
                System.out.println("You chose Subtract.");
                break;
            case 3:
                System.out.println("You chose Multiply.");
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
```

This menu gives you 4 options, and depending on what you choose, it will print a corresponding message. 🎮

---

## Exercise 3: Fibonacci Series Using Loops (For or While)

Let’s create a program that generates the famous **Fibonacci sequence** using a loop. The Fibonacci sequence starts with 0 and 1, and each subsequent number is the sum of the previous two.

```java
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms for Fibonacci series: ");
        int n = scanner.nextInt();

        int a = 0, b = 1;
        System.out.print("Fibonacci Series: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int nextTerm = a + b;
            a = b;
            b = nextTerm;
        }
    }
}
```

This program will print the Fibonacci sequence up to `n` terms. It uses a `for` loop to print the series and updates the terms using the variables `a` and `b`. 🔢

---

## Wrap-Up: You’re Ready to Control the Flow!

You’ve now mastered the if-else, switch-case, and loops in Java, making you a true control flow commander! 🧙‍♂️ Whether you're making decisions with if-else, looping like a boss with for, while, and do-while, or navigating through options with switch-case, you're ready to write some epic programs! 🚀
