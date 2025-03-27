# Spring BeanFactory and ApplicationContext

## Understanding Spring IoC Containers

Spring's Inversion of Control (IoC) containers are responsible for managing the lifecycle of application objects, known as beans. The two primary container implementations are BeanFactory and ApplicationContext.

## BeanFactory

### Definition and Characteristics

BeanFactory is the most basic container in the Spring framework, providing fundamental support for Dependency Injection (DI).

```java
// Basic BeanFactory usage
Resource resource = new ClassPathResource("applicationContext.xml");
BeanFactory beanFactory = new XmlBeanFactory(resource);

// Retrieving a bean
MyService myService = (MyService) beanFactory.getBean("myService");
```

### Key Features of BeanFactory
- Lazy initialization of beans
- Basic dependency injection
- Lightweight container
- Minimal memory footprint

### Pros and Cons

**Pros:**
- Minimal resource consumption
- Suitable for resource-constrained environments
- Lazy bean initialization

**Cons:**
- Limited features compared to ApplicationContext
- No automatic bean post-processing
- No support for advanced features like internationalization

## ApplicationContext

### Definition and Characteristics

ApplicationContext is an advanced container that extends BeanFactory with additional enterprise-specific functionality.

```java
// Creating ApplicationContext
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
// Or with Java configuration
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

// Retrieving a bean
MyService myService = context.getBean(MyService.class);
```

### Key Features of ApplicationContext
- Eager initialization of beans by default
- Advanced features like:
  - Event propagation
  - AOP support
  - Internationalization
  - Automatic bean post-processing
- Multiple ways of configuration (XML, Java annotations, Java configuration)

### Pros and Cons

**Pros:**
- Rich feature set
- Supports enterprise-level applications
- Provides additional services like:
  - Event publication
  - Resource loading
  - Message resolution

**Cons:**
- Slightly higher memory consumption
- More complex compared to BeanFactory

## Comparison: BeanFactory vs ApplicationContext

| Feature | BeanFactory | ApplicationContext |
|---------|-------------|-------------------|
| Initialization | Lazy | Eager (by default) |
| Bean Post-Processing | Limited | Automatic |
| Advanced Features | Minimal | Comprehensive |
| Resource Management | Basic | Advanced |
| Event Handling | Not Supported | Supported |
| Internationalization | Not Supported | Supported |

## Spring Beans

### What is a Bean?

A bean is an object that is instantiated, assembled, and managed by the Spring IoC container. It is created using the configuration metadata provided to the container.

```java
// Bean definition using Java configuration
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyService();
    }
}

// Bean definition using annotations
@Component
public class MyService {
    // Service implementation
}
```

### Bean Scopes

#### 1. Singleton (Default)
- One instance per Spring container
- Shared across the entire application

```java
@Component
@Scope("singleton")
public class SingletonBean {
    // Only one instance will be created
}
```

#### 2. Prototype
- New instance created each time the bean is requested

```java
@Component
@Scope("prototype")
public class PrototypeBean {
    // New instance created on each getBean() call
}
```

#### 3. Request (Web Applications)
- One instance per HTTP request

```java
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestScopedBean {
    // One instance per HTTP request
}
```

#### 4. Session (Web Applications)
- One instance per HTTP session

```java
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionScopedBean {
    // One instance per HTTP session
}
```

### Bean Lifecycle

#### Initialization Phase
```java
public class MyBean {
    // Method called after all properties are set
    @PostConstruct
    public void init() {
        System.out.println("Bean is being initialized");
    }
    
    // Alternative using InitializingBean interface
    public void afterPropertiesSet() throws Exception {
        // Initialization logic
    }
}
```

#### Destruction Phase
```java
public class MyBean {
    // Method called before bean is destroyed
    @PreDestroy
    public void cleanup() {
        System.out.println("Bean is being destroyed");
    }
    
    // Alternative using DisposableBean interface
    public void destroy() throws Exception {
        // Cleanup logic
    }
}
```

### Bean Lifecycle Stages

1. **Instantiation**: Container creates bean instance
2. **Populating Properties**: Dependencies are injected
3. **Bean Post-Processing**: 
   - `BeanPostProcessor` methods called
   - Custom initialization
4. **Ready for Use**: Bean is fully configured
5. **Destruction**: Bean is taken out of service

## Configuration Methods

### XML Configuration
```xml
<bean id="myService" class="com.example.MyService">
    <property name="dependency" ref="anotherBean"/>
</bean>
```

### Java Configuration
```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyService();
    }
}
```

### Annotation-Based Configuration
```java
@Component
public class MyService {
    @Autowired
    private MyDependency dependency;
}
```

## Best Practices

1. Prefer ApplicationContext for most applications
2. Use appropriate bean scopes
3. Implement proper initialization and destruction methods
4. Utilize bean post-processors for custom logic
5. Be mindful of bean lifecycle and dependencies

## Conclusion

Understanding BeanFactory and ApplicationContext is crucial for effective Spring application development. Each container has its strengths, and choosing the right one depends on your specific application requirements.