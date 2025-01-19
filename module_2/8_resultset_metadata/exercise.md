# Lab Time! Let’s Get Our Hands Dirty! 💻🎨

Here’s where the magic happens. We’ll write a program that retrieves and displays the column names, types, and count of a ResultSet using ResultSetMetaData.

```java
import java.sql.*;

public class ResultSetMetaDataDemo {
    public static void main(String[] args) {
        try {
            // Connect to your database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/your_db_name", "your_username", "your_password");

            // Create a statement
            Statement statement = connection.createStatement();
            
            // Execute a SELECT query on your specific table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table_name");

            // Get ResultSetMetaData from the ResultSet
            ResultSetMetaData rsMetaData = resultSet.getMetaData();

            // Retrieve and display the column count
            int columnCount = rsMetaData.getColumnCount();
            System.out.println("Number of columns: " + columnCount);

            // Display column names and types
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ":");
                System.out.println("Name: " + rsMetaData.getColumnName(i));
                System.out.println("Type: " + rsMetaData.getColumnTypeName(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

🎮 What this program does:

- Connects to your database and executes a SELECT query on a table.
- Fetches the ResultSetMetaData from the result set.
- Displays the number of columns.
- For each column, it prints the name and type—like a detailed blueprint of the query result!

---

### Time to Shine 🌟

Now that you’ve run the program, you’ll have all the meta-information about your query’s results at your fingertips! You can confidently work with dynamic tables and generate reports on the fly.