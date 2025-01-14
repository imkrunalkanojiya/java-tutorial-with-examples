# Types of JDBC Statements: Let’s Talk to the Database the Smart Way! 🗣️💡

In JDBC, there are three types of statements you can use to execute SQL queries in your Java applications: Statement, PreparedStatement, and CallableStatement. Each has its own use cases and advantages, depending on what you're trying to achieve.

---

## Overview of JDBC Statements 📝

### 1. Statement 📄

- What it is: A basic SQL statement that allows you to run simple SQL queries (like `SELECT`, `INSERT`, `UPDATE`, and `DELETE`) without any parameters.
- When to use: For basic, static SQL queries where you don’t need to pass dynamic parameters.
- Drawback: If you need to execute a query with user inputs, you have to concatenate the SQL string, which can make your code prone to SQL injection attacks.

```java
Statement statement = connection.createStatement();
String sql = "SELECT * FROM employees";
ResultSet resultSet = statement.executeQuery(sql);
```

### 2. PreparedStatement 🧩

- What it is: A precompiled SQL statement that you can use with parameters. The query is compiled only once and can be executed multiple times with different values.
- When to use: When you need to pass dynamic parameters to your SQL queries (like inserting user data). It’s safer and prevents SQL injection.
- Advantage: You don’t need to dynamically build your query strings. It’s faster for repeated execution and more secure.

```java
String sql = "INSERT INTO employees (name, position) VALUES (?, ?)";
PreparedStatement preparedStatement = connection.prepareStatement(sql);
preparedStatement.setString(1, "John");
preparedStatement.setString(2, "Developer");
preparedStatement.executeUpdate();
```

### 3. CallableStatement 📞

- What it is: Used to call stored procedures in the database. Stored procedures are precompiled SQL code that can be executed in the database directly.
- When to use: When your SQL logic is stored in the database in the form of procedures or functions, and you need to call them from your Java code.

```java
CallableStatement callableStatement = connection.prepareCall("{call getEmployee(?)}");
callableStatement.setInt(1, 101); // Pass parameter to stored procedure
ResultSet resultSet = callableStatement.executeQuery();
```

---

## Differences Between Statement, PreparedStatement, and CallableStatement ⚔️

| **Feature** | **Statement** | **PreparedStatement**  | **CallableStatement** |
|---|---|---|---|
| SQL Compilation | Each time it runs | Compiled once and reused | Precompiled stored procedure |
| Parameterized Query | Not supported | Supported with `?` placeholders | Supported with ? placeholders |
| SQL Injection Risk | High (if user input is concatenated) | Low (handles parameters safely) | Low (parameters handled by the DB) |
| Performance | Slower for repeated queries | Faster for repeated queries | Depends on stored procedure |
| Use Case | Simple queries | Queries with dynamic parameters | Calling stored procedures |

