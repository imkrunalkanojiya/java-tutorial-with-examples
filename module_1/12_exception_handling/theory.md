# 🎯 Oops! Something Went Wrong… But We Can Fix It!

Errors are like those unexpected roadblocks in a video game—they pop up at the worst times. But fear not! Java has a cool system for handling them: Exception Handling. By catching and managing exceptions, we can keep our programs running smoothly even when things go wrong.

---

## Types of Exceptions – The Two Troublemakers!

There are two main types of exceptions in Java:

### 1. Checked Exceptions (Compile-Time Exceptions):

These are the exceptions that Java forces you to handle at compile-time. If you don’t, your program won’t even compile! Examples include `IOException`, `SQLException`, and `FileNotFoundException`.

```java
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("non_existent_file.txt");
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }
}
```

### 2. Unchecked Exceptions (Runtime Exceptions):

These exceptions occur during the execution of the program and can be ignored at compile-time. However, it's good practice to handle them! Common examples include `NullPointerException`, `ArrayIndexOutOfBoundsException`, and `ArithmeticException`.

```java
public class DivisionExample {
    public static void main(String[] args) {
        int num = 5;
        int divisor = 0;

        try {
            int result = num / divisor;  // Will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }
    }
}
```

---

## The Exception Handling Block Party: `try, catch, finally, throw, throws`

### 1. try and catch – Error Catchers!

The try block is where you "try" to run code that could throw an exception. If an exception occurs, it’s caught by the catch block, which handles it gracefully without crashing the program.

```java
public class TryCatchExample {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);  // Will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
```

### 2. finally – Cleaning Up the Mess!

The `finally` block always executes, whether an exception was thrown or not. It's typically used for resource cleanup, like closing files or database connections.

```java
public class FinallyExample {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try block");
        } catch (Exception e) {
            System.out.println("Caught an exception");
        } finally {
            System.out.println("Finally block always executes!");
        }
    }
}
```

### 3. throw – Throwing Custom Exceptions!

The `throw` keyword is used to throw an exception manually. You can use it to create your own exception or throw a standard Java exception.

```java
public class ThrowExample {
    public static void main(String[] args) {
        throw new ArithmeticException("You can’t divide by zero here!");
    }
}
```

### 4. throws – Passing the Buck!

The `throws` keyword is used in method declarations to indicate that a method can throw one or more exceptions. If a method is likely to throw an exception but doesn’t handle it, it must declare the exception using `throws`.

```java
import java.io.IOException;

public class ThrowsExample {
    public static void riskyMethod() throws IOException {
        throw new IOException("File not found!");
    }

    public static void main(String[] args) {
        try {
            riskyMethod();
        } catch (IOException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
```

---

## Custom Exception Classes – Creating Your Own Trouble!

Sometimes, the built-in exceptions don’t quite fit the bill. That's where custom exceptions come in! You can define your own exception class to handle specific scenarios in your program.

### Creating a Custom Exception:

Create your custom exception by extending the `Exception` class (or `RuntimeException` for unchecked exceptions).

```java
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
```

### Using Custom Exception:

Now, you can use your custom exception like any other exception!

```java
public class CustomExceptionDemo {
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be at least 18!");
        } else {
            System.out.println("Age is valid!");
        }
    }

    public static void main(String[] args) {
        try {
            validateAge(16);  // This will throw InvalidAgeException
        } catch (InvalidAgeException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
    }
}
```
