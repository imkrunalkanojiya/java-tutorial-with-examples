# Lab Time! Roll up those sleeves! 💻🎉

Let’s get our hands dirty by writing a program that pulls metadata from a database, like a boss!

```java
import java.sql.*;

public class MetaDataExtractor {
    public static void main(String[] args) {
        try {
            // Connect to your database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/your_db_name", "your_username", "your_password");

            // Get the DatabaseMetaData object
            DatabaseMetaData metaData = connection.getMetaData();

            // Display database name and version
            System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());

            // List all tables
            ResultSet tables = metaData.getTables(null, null, "%", new String[] {"TABLE"});
            System.out.println("Tables in the database:");
            while (tables.next()) {
                System.out.println(tables.getString("TABLE_NAME"));
            }

            // Check for some cool SQL features
            System.out.println("Supports Stored Procedures? " + metaData.supportsStoredProcedures());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

🎮 What this program does:
- Connects to your database like a secret agent on a mission.
- Retrieves and prints the database product name and version.
- Lists all tables in your database—no more guessing what’s inside!
- Shows whether your database supports stored procedures (like finding out if it knows some cool magic tricks).

### Time to Flex! 💪

Once you’ve run this, you’ll know more about your database than it knows about itself (almost!). Now you can confidently boast about your newfound database metadata mastery!