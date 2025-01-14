# Lab Time 🎛️

Let’s create a program that demonstrates the use of Statement and PreparedStatement to insert, update, select, and delete data from a database. We’ll first use Statement and then modify it to use PreparedStatement for parameterized queries.

## 1. Program Using Statement for Basic SQL Queries

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/yourDatabaseName";
        String user = "yourUsername";
        String password = "yourPassword";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();

            // Insert a record
            String insertSql = "INSERT INTO employees (name, position) VALUES ('Alice', 'Manager')";
            statement.executeUpdate(insertSql);

            // Update a record
            String updateSql = "UPDATE employees SET position = 'Senior Manager' WHERE name = 'Alice'";
            statement.executeUpdate(updateSql);

            // Select records
            String selectSql = "SELECT * FROM employees";
            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
            }

            // Delete a record
            String deleteSql = "DELETE FROM employees WHERE name = 'Alice'";
            statement.executeUpdate(deleteSql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 2. Modified Program Using PreparedStatement for Parameterized Queries

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPreparedStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/yourDatabaseName";
        String user = "yourUsername";
        String password = "yourPassword";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            // Insert a record using PreparedStatement
            String insertSql = "INSERT INTO employees (name, position) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSql);
            insertStatement.setString(1, "Bob");
            insertStatement.setString(2, "Developer");
            insertStatement.executeUpdate();

            // Update a record using PreparedStatement
            String updateSql = "UPDATE employees SET position = ? WHERE name = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateSql);
            updateStatement.setString(1, "Senior Developer");
            updateStatement.setString(2, "Bob");
            updateStatement.executeUpdate();

            // Select records using PreparedStatement
            String selectSql = "SELECT * FROM employees";
            PreparedStatement selectStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
            }

            // Delete a record using PreparedStatement
            String deleteSql = "DELETE FROM employees WHERE name = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
            deleteStatement.setString(1, "Bob");
            deleteStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

---

### Key Takeaways 📝

- Statement is simple but not ideal for dynamic queries, as it’s prone to SQL injection and slower for repeated execution.
- PreparedStatement is the preferred way to handle dynamic queries, providing better performance and security.
- CallableStatement is used for executing stored procedures in the database.