# Playing with ResultSet! 👨‍💻

We’ll create a program that executes a SELECT query and then navigates through the `ResultSet` to display all records.

## Step 1: Setup Your Table

Before running the Java code, let’s make sure you have some data in your employees table:

```sql
INSERT INTO employees (name, position) VALUES ('Alice', 'Manager');
INSERT INTO employees (name, position) VALUES ('Bob', 'Developer');
INSERT INTO employees (name, position) VALUES ('Charlie', 'Designer');
```

---

## Step 2: Java Program to Work with ResultSet

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetExample {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/yourDatabaseName";
    private static final String DB_USER = "yourUsername";
    private static final String DB_PASSWORD = "yourPassword";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            // Execute a SELECT query and get the ResultSet
            String sql = "SELECT * FROM employees";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, 
                                        ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                        ResultSet.CONCUR_READ_ONLY);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                // Navigate through ResultSet
                displayResultSet(resultSet);

                // Navigate to first row
                if (resultSet.first()) {
                    System.out.println("\nFirst Record: " + resultSet.getString("name") + " - " + resultSet.getString("position"));
                }

                // Navigate to last row
                if (resultSet.last()) {
                    System.out.println("\nLast Record: " + resultSet.getString("name") + " - " + resultSet.getString("position"));
                }

                // Move to a specific row
                if (resultSet.absolute(2)) {
                    System.out.println("\nRecord at position 2: " + resultSet.getString("name") + " - " + resultSet.getString("position"));
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to display all records in the ResultSet
    public static void displayResultSet(ResultSet resultSet) throws SQLException {
        System.out.println("Employee List:");
        resultSet.beforeFirst();  // Reset cursor to before the first row
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id") +
                               ", Name: " + resultSet.getString("name") +
                               ", Position: " + resultSet.getString("position"));
        }
    }
}
```

---

## Explanation of the Code 🔍

- ResultSet with Scrollability: We specify ResultSet.TYPE_SCROLL_INSENSITIVE to make the ResultSet scrollable (so we can move forward, backward, or jump to specific rows).

- Navigating the ResultSet:
  - next(): Moves the cursor to the next row.
  - first(): Moves to the first row.
  - last(): Moves to the last row.
  - absolute(int row): Jumps to the specified row number.

- Displaying the ResultSet:
  - The displayResultSet() method iterates through the ResultSet using next() to display all records.


### Output

```bash
Employee List:
ID: 1, Name: Alice, Position: Manager
ID: 2, Name: Bob, Position: Developer
ID: 3, Name: Charlie, Position: Designer

First Record: Alice - Manager
Last Record: Charlie - Designer
Record at position 2: Bob - Developer
```