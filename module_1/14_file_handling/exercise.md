# Lab Time

## Write a program that reads and writes content to a file using `FileReader` and `FileWriter`.

```java
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandlingLab {
    public static void main(String[] args) {
        String content = "This is a lab exercise for file handling.";
        String fileName = "labFile.txt";

        // Write to file
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read from file
        try (FileReader reader = new FileReader(fileName)) {
            int data;
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## Write a program that reads a file line by line using `BufferedReader`.

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderLab {
    public static void main(String[] args) {
        String fileName = "labFile.txt";

        // Read file line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## Create a program that demonstrates object serialization and deserialization.

```java
import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String toString() {
        return "Student Name: " + name + ", Roll No: " + rollNo;
    }
}

public class SerializationLab {
    public static void main(String[] args) {
        String fileName = "student.ser";

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            Student student = new Student("Alice", 123);
            oos.writeObject(student);
            System.out.println("Serialized student object to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Student student = (Student) ois.readObject();
            System.out.println("Deserialized student: " + student);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

---

File handling is an essential part of any application that needs to persist data beyond the runtime. Whether you're reading from or writing to files, or even working with object serialization, Java's `java.io` package provides the tools you need to get the job done efficiently.
