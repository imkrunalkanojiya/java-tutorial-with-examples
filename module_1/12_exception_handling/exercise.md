# Lab Time 🎛️

## 1. Exception Handling with try-catch-finally:

```java
public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[3]);  // Will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block executes no matter what.");
        }
    }
}
```

## 2. Multiple Catch Blocks:

```java
public class MultipleCatchExample {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);  // Will throw ArrayIndexOutOfBoundsException
            int result = 10 / 0;  // Will throw ArithmeticException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception: " + e.getMessage());
        } finally {
            System.out.println("Always executed: cleanup here.");
        }
    }
}
```

## 3. Custom Exception Class:

```java
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    static void validateInput(String input) throws InvalidInputException {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException("Input cannot be null or empty.");
        }
        System.out.println("Valid input: " + input);
    }

    public static void main(String[] args) {
        try {
            validateInput("");  // Will throw InvalidInputException
        } catch (InvalidInputException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
    }
}
```

---

Exception Handling is the safety net of Java programming. With tools like try, catch, finally, throw, and throws, you can catch problems before they cause a crash. And by creating custom exceptions, you can handle very specific issues in your program.

Mastering these concepts makes your code resilient, reliable, and ready for real-world applications!
