# What is a ResultSet? 🤔

A ResultSet is an object that stores the results returned by a SELECT SQL query executed via JDBC. Once you have the results, you can move around the ResultSet and retrieve data from each row.

## Navigating through the ResultSet 🧭

The `ResultSet` provides a set of methods to navigate and interact with the data:

- `next()`: Moves to the next row in the result set.
- `previous()`: Moves to the previous row.
- `first()`: Moves to the first row in the result set.
- `last()`: Moves to the last row.
- `getInt()` / `getString()` / `getXXX()`: Retrieves column values for the current row.
