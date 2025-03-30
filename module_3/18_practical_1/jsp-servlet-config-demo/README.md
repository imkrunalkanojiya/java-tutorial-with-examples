# JSP Servlet Config Demo

This project demonstrates how to fetch and display initialization parameters from `web.xml` using `ServletConfig` in a JSP Servlet application.

## Project Structure

- `src/main/java/com/example/servlets/ConfigDemoServlet.java`: Contains the `ConfigDemoServlet` class which handles HTTP requests.
- `src/main/resources`: Directory for additional resource files.
- `src/main/webapp/WEB-INF/web.xml`: Deployment descriptor for the web application.
- `src/main/webapp/index.jsp`: Entry point for the web application.
- `pom.xml`: Maven configuration file.

## Setup Instructions

1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn clean install` to build the project.
4. Deploy the generated WAR file to a servlet container (e.g., Apache Tomcat).
5. Access the application via `http://localhost:8080/jsp-servlet-config-demo/`.

## Usage

Once deployed, you can access the `index.jsp` page, which will interact with the `ConfigDemoServlet` to display the initialization parameters defined in `web.xml`.