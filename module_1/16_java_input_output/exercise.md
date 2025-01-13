# Lab Time

Let’s get our hands dirty with some code!

## 1. Read Input from the Console Using Scanner

```java
import java.util.Scanner;

public class ConsoleInputExample {
    public static void main(String[] args) {
        // Create a Scanner object for reading input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.println("Hello, " + name + "! You are " + age + " years old.");
        scanner.close();  // Close the scanner
    }
}
```

---

## 2. File Copy Program Using FileInputStream and FileOutputStream

Here's how to copy a file from one location to another using byte streams.

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyExample {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);  // Write each byte from source to destination
            }

            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.out.println("Error during file copy: " + e.getMessage());
        }
    }
}
```

---

## 3. Read from One File and Write to Another File

This program reads content from one file and writes it to another using character streams (`BufferedReader` and `BufferedWriter`).

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWriteExample {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);  // Write each line to the output file
                writer.newLine();    // Add a new line after each line
            }

            System.out.println("File read and written successfully!");
        } catch (IOException e) {
            System.out.println("Error during file read/write: " + e.getMessage());
        }
    }
}
```

---

## Streams, Streams Everywhere! 🛠️💡

Java I/O is like the water system of a city, channeling data where it needs to go! From reading user input via `Scanner` to copying files and reading/writing data, streams are the tools that make it all possible. With this power, you can manipulate files, interact with users, and manage data flow effortlessly.

---

At this exercise we are completing basics of java.