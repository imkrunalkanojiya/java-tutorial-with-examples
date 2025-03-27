import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(
    name = "LifecycleServlet", 
    urlPatterns = {"/LifecycleDemo"},
    loadOnStartup = 1  // Ensures servlet is loaded on server startup
)
public class LifecycleServlet extends HttpServlet {
    // Logger for tracking servlet lifecycle events
    private static final Logger LOGGER = Logger.getLogger(LifecycleServlet.class.getName());
    
    // Atomic counter to track number of requests
    private AtomicInteger requestCount;
    
    // Servlet initialization timestamp
    private long initializationTime;

    // Initialization method
    @Override
    public void init() throws ServletException {
        // Initialize request counter
        requestCount = new AtomicInteger(0);
        
        // Record initialization time
        initializationTime = System.currentTimeMillis();
        
        // Log initialization details
        LOGGER.info("===== SERVLET INITIALIZATION =====");
        LOGGER.info("Servlet Name: " + getServletName());
        LOGGER.info("Initialization Timestamp: " + initializationTime);
        LOGGER.info("Servlet Class: " + this.getClass().getName());
        LOGGER.info("==================================");
    }

    // Request handling method for GET requests
    @Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Increment request counter
        int currentRequestCount = requestCount.incrementAndGet();
        
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Generate dynamic response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Servlet Lifecycle Demo</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; max-width: 600px; margin: 0 auto; padding: 20px; }");
        out.println(".info { background-color: #f4f4f4; padding: 15px; border-radius: 5px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Lifecycle Demonstration</h1>");
        out.println("<div class='info'>");
        out.println("<h2>Request Processing Details</h2>");
        out.println("<p><strong>Request Number:</strong> " + currentRequestCount + "</p>");
        out.println("<p><strong>Servlet Uptime:</strong> " + 
            (System.currentTimeMillis() - initializationTime) + " ms</p>");
        out.println("<p><strong>Servlet Name:</strong> " + getServletName() + "</p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

        // Log request details
        LOGGER.info("===== REQUEST PROCESSING =====");
        LOGGER.info("Request Number: " + currentRequestCount);
        LOGGER.info("Request URI: " + request.getRequestURI());
        LOGGER.info("Client IP: " + request.getRemoteAddr());
        LOGGER.info("==================================");
    }

    // Destruction method
    @Override
    public void destroy() {
        // Log destruction details
        LOGGER.info("===== SERVLET DESTRUCTION =====");
        LOGGER.info("Servlet Name: " + getServletName());
        LOGGER.info("Total Requests Processed: " + requestCount.get());
        LOGGER.info("Uptime: " + (System.currentTimeMillis() - initializationTime) + " ms");
        LOGGER.info("==================================");

        // Perform cleanup
        requestCount = null;
    }

    // Optional: Custom initialization with ServletConfig
    @Override
    public void init(ServletConfig config) throws ServletException {
        // Call parent initialization
        super.init(config);
        
        // Additional custom initialization
        LOGGER.info("===== CUSTOM INITIALIZATION =====");
        LOGGER.info("Servlet Config Initialized");
        LOGGER.info("Initialization Parameters:");
        
        // Log initialization parameters
        java.util.Enumeration<String> paramNames = config.getInitParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            LOGGER.info(paramName + ": " + config.getInitParameter(paramName));
        }
        LOGGER.info("==================================");
    }
}