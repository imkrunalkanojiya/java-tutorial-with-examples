# Lab Time: Implementing CRUD in Java 🧑‍💻

Let’s create a Java program that performs the following operations:

- Insert: Add a new employee.
- Update: Modify an existing employee’s position.
- Select: Retrieve and display all employees.
- Delete: Remove an employee by their ID.

---

## 1. Setup: Database and Table

Before diving into the Java code, let’s create a simple table called employees in your MySQL database:

```sql
CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    position VARCHAR(100) NOT NULL
);
```

---

## 2. Java Code for CRUD Operations

Here’s how we can perform CRUD operations using JDBC:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCCRUDExample {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/yourDatabaseName";
    private static final String DB_USER = "yourUsername";
    private static final String DB_PASSWORD = "yourPassword";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            // Insert a new record
            insertEmployee(connection, "John Doe", "Developer");

            // Update an existing record
            updateEmployeePosition(connection, 1, "Senior Developer");

            // Select and display all records
            selectAllEmployees(connection);

            // Delete a record
            deleteEmployee(connection, 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method for inserting a new employee
    public static void insertEmployee(Connection connection, String name, String position) throws SQLException {
        String sql = "INSERT INTO employees (name, position) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, position);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " record(s) inserted.");
        }
    }

    // Method for updating an employee's position
    public static void updateEmployeePosition(Connection connection, int id, String newPosition) throws SQLException {
        String sql = "UPDATE employees SET position = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newPosition);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " record(s) updated.");
        }
    }

    // Method for selecting and displaying all employees
    public static void selectAllEmployees(Connection connection) throws SQLException {
        String sql = "SELECT * FROM employees";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            System.out.println("Employee List:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                                   ", Name: " + resultSet.getString("name") +
                                   ", Position: " + resultSet.getString("position"));
            }
        }
    }

    // Method for deleting an employee by ID
    public static void deleteEmployee(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " record(s) deleted.");
        }
    }
}
```

---

## Explanation of the Code 🤔

- Database Connection: We establish a connection to our MySQL database using DriverManager.getConnection().

- Insert Operation:
  - We insert a new employee into the employees table using the insertEmployee() method, where we use a PreparedStatement to pass dynamic values (name and position).

- Update Operation:
  - We update the position of the employee by calling the updateEmployeePosition() method. It updates the position of the employee with the provided id.

- Select Operation:
  - The selectAllEmployees() method retrieves all the employees from the database and prints them to the console.

- Delete Operation:
  - We delete the employee with a specific id by calling the deleteEmployee() method.


---

## Running the Program 🎬

- Insert: You’ll see a message confirming that a new employee has been inserted.
- Update: You’ll see a message confirming that the employee’s position has been updated.
- Select: The program will display all the records in the employees table.
- Delete: You’ll see a message confirming that the employee has been deleted.

