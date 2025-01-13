# Lab Time

Let’s dive into some code to explore how JDBC works in practice!

## 1. A Simple Java Program to Connect to a MySQL Database Using JDBC

Here’s how you can connect to a MySQL database and execute a simple query.

Steps:

- Make sure you have the MySQL JDBC driver (`mysql-connector-java.jar`) in your classpath.
- Replace `yourDatabaseName`, `yourUsername`, and `yourPassword` with actual values.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCExample {
    public static void main(String[] args) {
        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/yourDatabaseName";
        String user = "yourUsername";
        String password = "yourPassword";

        // SQL query to execute
        String query = "SELECT * FROM yourTableName";

        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Step 3: Create a statement
            Statement statement = connection.createStatement();

            // Step 4: Execute the query and retrieve the result
            ResultSet resultSet = statement.executeQuery(query);

            // Step 5: Process the result
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
            }

            // Step 6: Close the connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 2. Loading a JDBC Driver and Establishing a Connection

Here’s the process of loading a JDBC driver and connecting to a database in more detail.

- **Step 1**: Loading the Driver: The driver class for MySQL is `com.mysql.cj.jdbc.Driver`. We use `Class.forName()` to load this driver.

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

- **Step 2**: Establishing the Connection: We use `DriverManager.getConnection()` to establish a connection to the database. You need to specify the database URL, username, and password.

```java
String url = "jdbc:mysql://localhost:3306/yourDatabaseName";
String user = "yourUsername";
String password = "yourPassword";

Connection connection = DriverManager.getConnection(url, user, password);
```

- **Step 3**: Executing a Query: Using the `Statement` object, we can execute SQL queries like `SELECT`, `INSERT`, `UPDATE`, or `DELETE`.

```java
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery("SELECT * FROM yourTableName");
```

- **Step 4**: Processing the ResultSet: The `ResultSet` object contains the data retrieved from the database. You can access data using the appropriate `getXXX()` methods like `getInt()`, `getString()`, etc.

```java
while (resultSet.next()) {
    System.out.println("ID: " + resultSet.getInt("id"));
    System.out.println("Name: " + resultSet.getString("name"));
}
```

- **Step 5**: Closing the Connection: Always close the `Connection`, `Statement`, and `ResultSet` objects to free up resources.

```java
connection.close();
```

---

## Key Takeaways 📝

- JDBC is essential for Java applications to communicate with relational databases.
- The JDBC architecture provides a standard way to connect to databases and execute SQL commands.
- You can perform common database operations like querying, inserting, and updating data using the JDBC API.