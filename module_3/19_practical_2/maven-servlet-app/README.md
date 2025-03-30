# maven-servlet-app

This is a Maven-based web application that demonstrates the use of servlets to fetch shared data from the `ServletContext`. The application includes multiple servlets that interact with the web.xml deployment descriptor.

## Project Structure

```
maven-servlet-app
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           ├── servlets
│   │   │           │   ├── FirstServlet.java
│   │   │           │   └── SecondServlet.java
│   │   │           └── util
│   │   │               └── Constants.java
│   │   ├── resources
│   │   └── webapp
│   │       ├── WEB-INF
│   │       │   └── web.xml
│   │       └── index.jsp
│   └── test
│       └── java
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd maven-servlet-app
   ```

2. **Build the project**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   You can deploy the generated WAR file to a servlet container like Apache Tomcat.

## Application Overview

- **FirstServlet**: Fetches shared data from the `ServletContext` and sends it as a response.
- **SecondServlet**: Retrieves and processes shared data from the `ServletContext`.
- **Constants**: Contains constant values used throughout the application.
- **web.xml**: Defines the servlets and their mappings.
- **index.jsp**: Main entry point for the web application.

## Dependencies

This project uses Maven for dependency management. Please refer to the `pom.xml` file for the list of dependencies.