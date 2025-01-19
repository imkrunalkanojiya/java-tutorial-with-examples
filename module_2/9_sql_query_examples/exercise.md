# Practical SQL Query Examples: Get Your Hands Dirty with JDBC! 💻⚙️

## Let’s Build Some SQL Queries! 🛠️

In this lab exercise, we’re going to write SQL queries to:

- Insert records into a table. 📝
- Update specific fields of a record. ✏️
- Select records based on certain conditions. 🔍
- Delete specific records. 🗑️

And to spice things up, we’ll implement these queries in Java using JDBC! 🎉

---

### 1. Inserting a Record Into a Table 📝

Let’s say you have a `users` table and want to insert a new user. Here’s your SQL query:

```sql
INSERT INTO users (id, username, email) VALUES (1, 'johndoe', 'john@example.com');
```

---

### 2. Updating Specific Fields of a Record ✏️

Oops! There was a typo in John's email. Let’s fix that:

```sql
UPDATE users SET email = 'john.doe@example.com' WHERE id = 1;
```

---

### 3. Selecting Records Based on Conditions 🔍

Now, let’s retrieve all users whose usernames start with 'john':

```sql
SELECT * FROM users WHERE username LIKE 'john%';
```

---

### 4. Deleting Specific Records 🗑️

John decided to leave. Let’s remove his record from the table:

```sql
DELETE FROM users WHERE id = 1;
```

---

## Lab Exercise: Implementing These Queries in Java Using JDBC! 🚀

Now, let’s see how we can implement these SQL queries in Java using JDBC.

```java
import java.sql.*;

public class JdbcQueryDemo {
    public static void main(String[] args) {
        try {
            // 1. Establish a connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/your_db_name", "your_username", "your_password");

            // 2. Insert a record
            String insertSQL = "INSERT INTO users (id, username, email) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
            insertStatement.setInt(1, 1);
            insertStatement.setString(2, "johndoe");
            insertStatement.setString(3, "john@example.com");
            insertStatement.executeUpdate();
            System.out.println("Record inserted!");

            // 3. Update specific fields
            String updateSQL = "UPDATE users SET email = ? WHERE id = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);
            updateStatement.setString(1, "john.doe@example.com");
            updateStatement.setInt(2, 1);
            updateStatement.executeUpdate();
            System.out.println("Record updated!");

            // 4. Select records based on conditions
            String selectSQL = "SELECT * FROM users WHERE username LIKE ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
            selectStatement.setString(1, "john%");
            ResultSet resultSet = selectStatement.executeQuery();
            System.out.println("Selected records:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Username: " + resultSet.getString("username") + ", Email: " + resultSet.getString("email"));
            }

            // 5. Delete specific records
            String deleteSQL = "DELETE FROM users WHERE id = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteSQL);
            deleteStatement.setInt(1, 1);
            deleteStatement.executeUpdate();
            System.out.println("Record deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

---

## What This Java Code Does:

- Inserts a new record into the users table.
- Updates the email of the user with ID = 1.
- Selects and prints all users whose usernames start with 'john'.
- Deletes the user with ID = 1.

---

### Now It’s Your Turn! 🎉

Run these queries and the Java program on your machine, and watch the magic happen in your database! This hands-on exercise will make you a SQL + JDBC ninja in no time! 🥷