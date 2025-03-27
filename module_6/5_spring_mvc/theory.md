# Spring MVC: Web Development Framework

## Understanding MVC Design Pattern

### What is MVC?

Model-View-Controller (MVC) is an architectural pattern that separates an application into three main logical components:

1. **Model**: Represents the application's data and business logic
2. **View**: Handles the presentation and user interface
3. **Controller**: Manages the communication between Model and View

#### Traditional MVC Flow
```
User Interaction → Controller → Model → Controller → View → User Interface
```

## Spring MVC Framework

### Overview

Spring MVC is a powerful web framework that implements the MVC design pattern, providing a robust solution for building flexible and loosely coupled web applications.

### Key Benefits
- Separation of concerns
- Easy testability
- Flexible configuration
- Seamless integration with other Spring modules

## Spring MVC Architecture Components

### 1. DispatcherServlet

The central component that manages the entire request processing flow in Spring MVC.

```java
// Typically configured in web.xml or using Java configuration
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
```

### 2. Controller

Handles incoming HTTP requests and returns appropriate responses.

```java
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // GET request to fetch all users
    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    // GET request to show user creation form
    @GetMapping("/new")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new User());
        return "create-user";
    }

    // POST request to create a new user
    @PostMapping
    public String createUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "create-user";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

    // Path variable example
    @GetMapping("/{id}")
    public String getUserDetails(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-details";
    }
}
```

### 3. Model

Holds data to be displayed in the view.

```java
@GetMapping("/dashboard")
public String showDashboard(Model model) {
    // Adding attributes to the model
    model.addAttribute("username", "JohnDoe");
    model.addAttribute("totalOrders", 25);
    model.addAttribute("recentActivity", activityService.getRecentActivities());
    
    return "dashboard";
}
```

### 4. View

Renders the data from the model. Example using Thymeleaf:

```html
<!-- users.html (Thymeleaf template) -->
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>
    <h1>User List</h1>
    <table>
        <tr th:each="user : ${users}">
            <td th:text="${user.username}">Username</td>
            <td th:text="${user.email}">Email</td>
        </tr>
    </table>
</body>
</html>
```

## Request Mapping Annotations

### 1. @RequestMapping
Provides the most comprehensive mapping configuration.

```java
@Controller
@RequestMapping("/api")
public class ApiController {
    // Maps to /api/users
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers() { ... }
}
```

### 2. Specific HTTP Method Mappings

```java
@RestController
@RequestMapping("/products")
public class ProductController {
    // GET request
    @GetMapping
    public List<Product> listProducts() { ... }

    // POST request
    @PostMapping
    public Product createProduct(@RequestBody Product product) { ... }

    // PUT request
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) { ... }

    // DELETE request
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) { ... }
}
```

### 3. Request Parameter Handling

```java
@GetMapping("/search")
public List<Product> searchProducts(
    @RequestParam(required = false) String name,
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size
) {
    return productService.searchProducts(name, page, size);
}
```

## Configuration

### Java-based Configuration

```java
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.controllers")
public class WebConfig implements WebMvcConfigurer {
    // MVC configuration
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }
}
```

## Best Practices

1. Use constructor injection
2. Keep controllers lean
3. Validate input data
4. Use appropriate HTTP methods
5. Handle exceptions gracefully
6. Use meaningful URL mappings

## Common Pitfalls

1. Tight coupling between components
2. Overloading controllers
3. Ignoring validation
4. Improper error handling

## Conclusion

Spring MVC provides a powerful, flexible framework for building web applications. By understanding its core components and following best practices, developers can create robust, maintainable web solutions.