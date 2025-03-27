# ServletContext and Web Application Listeners

## ServletContext: Application-Wide Configuration and Resources

### What is ServletContext?

ServletContext is an interface that represents the entire web application, providing a way to access application-level resources, configuration, and shared information across all servlets in the application.

## Key ServletContext Characteristics

### Scope and Lifecycle
- Created when web application starts
- Destroyed when web application shuts down
- Shared across all servlets in the application
- Provides application-wide configuration and resources

## Core ServletContext Methods

### 1. Attribute Management
```java
// Set application-wide attribute
servletContext.setAttribute("globalConfig", configObject);

// Get application-wide attribute
Object config = servletContext.getAttribute("globalConfig");

// Remove application-wide attribute
servletContext.removeAttribute("globalConfig");
```

### 2. Configuration and Resource Access
```java
// Get real path of a resource
String realPath = servletContext.getRealPath("/WEB-INF/config.properties");

// Get resource as input stream
InputStream is = servletContext.getResourceAsStream("/WEB-INF/config.properties");

// Get initialization parameters
String appName = servletContext.getInitParameter("application.name");
```

### 3. Logging
```java
// Log messages
servletContext.log("Application started");
servletContext.log("Error occurred", exception);
```

## Web Application Listeners

### Types of Listeners

1. **ServletContextListener**
   - Notifies about web application lifecycle events
   - `contextInitialized()`: Called when application starts
   - `contextDestroyed()`: Called when application stops

2. **ServletContextAttributeListener**
   - Tracks changes to ServletContext attributes
   - `attributeAdded()`
   - `attributeRemoved()`
   - `attributeReplaced()`

3. **HttpSessionListener**
   - Tracks session creation and destruction
   - `sessionCreated()`
   - `sessionDestroyed()`

4. **HttpSessionAttributeListener**
   - Monitors changes to session attributes
   - `attributeAdded()`
   - `attributeRemoved()`
   - `attributeReplaced()`

## Listener Implementation Example

```java
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationLifecycleListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        
        // Load configuration
        String dbUrl = context.getInitParameter("database.url");
        
        // Initialize resources
        context.log("Application is starting up");
        context.setAttribute("startTime", System.currentTimeMillis());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        
        // Cleanup resources
        context.log("Application is shutting down");
        context.removeAttribute("startTime");
    }
}
```

## Configuration in web.xml

```xml
<web-app>
    <!-- Context Parameters -->
    <context-param>
        <param-name>database.url</param-name>
        <param-value>jdbc:mysql://localhost:3306/myapp</param-value>
    </context-param>

    <!-- Listeners -->
    <listener>
        <listener-class>com.example.ApplicationLifecycleListener</listener-class>
    </listener>
</web-app>
```

## Best Practices

1. Use ServletContext for application-wide configurations
2. Minimize the use of global attributes
3. Ensure thread-safety when sharing resources
4. Use listeners for initialization and cleanup
5. Log important application events
6. Avoid storing large objects in ServletContext

## Use Cases

- Centralized configuration management
- Shared resource initialization
- Application-wide logging
- Tracking application lifecycle
- Implementing application-level caches

## Performance Considerations

- Minimize complex operations in listeners
- Be cautious with resource-intensive initializations
- Use lazy loading when possible
- Consider using dependency injection frameworks

## Security Considerations

- Avoid storing sensitive information
- Use proper access controls
- Implement secure initialization
- Validate and sanitize configuration parameters

## Advanced Techniques

- Dynamic resource loading
- Cross-servlet communication
- Application-wide initialization strategies
- Centralized error handling

## Limitations

- Shared state can lead to concurrency issues
- Limited to single application scope
- Performance overhead with complex initializations

## Modern Alternatives

- Dependency Injection Containers
- Spring ApplicationContext
- Microservices architectures
- Cloud-native configuration management