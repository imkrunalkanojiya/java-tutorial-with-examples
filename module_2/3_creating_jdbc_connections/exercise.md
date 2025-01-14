# Lab Time 🎛️

Let’s write a simple Java program that establishes a connection to a MySQL database and prints a confirmation message when the connection is successful.

## Java Program: Connecting to MySQL 🌐

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionExample {
    public static void main(String[] args) {
        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/yourDatabaseName";
        String user = "yourUsername";
        String password = "yourPassword";

        // Step 2: Register the JDBC Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 3: Open a connection to the database
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Step 4: Confirm successful connection
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

---

### Key Takeaways 📝

- Step 1: Import JDBC packages.
- Step 2: Register your JDBC driver.
- Step 3: Use the DriverManager to open a connection.
- Step 4: Create a statement to execute SQL commands.
- Step 5: Execute your SQL queries.
- Step 6: Process the results in the ResultSet.
- Step 7: Close the connection to free up resources.

By following these steps, you'll be able to connect your Java applications to any relational database using JDBC! 🎉