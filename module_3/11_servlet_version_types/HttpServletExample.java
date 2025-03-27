import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

// Generic Servlet Implementation
@WebServlet("/GenericServletDemo")
public class GenericServletExample extends GenericServlet {
    private static final long serialVersionUID = 1L;
    private ServletConfig config;

    // Initialization method
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        // Perform one-time initialization
        log("Generic Servlet Initialized");
    }

    // Service method (handles all types of requests)
    public void service(ServletRequest request, ServletResponse response) 
            throws ServletException, IOException {
        
        // Set content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Generic request processing
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Generic Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Generic Servlet Demonstration</h1>");
        out.println("<p>Protocol: " + request.getProtocol() + "</p>");
        out.println("<p>Servlet Name: " + config.getServletName() + "</p>");
        out.println("</body>");
        out.println("</html>");
    }

    // Destruction method
    public void destroy() {
        log("Generic Servlet Destroyed");
    }
}

// HTTP Servlet Implementation
@WebServlet("/HttpServletDemo")
public class HttpServletExample extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Initialization method
    public void init() throws ServletException {
        log("HTTP Servlet Initialized");
    }

    // Handle GET requests
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get request parameters
        String name = request.getParameter("name");
        name = (name != null && !name.trim().isEmpty()) ? name : "Guest";

        // HTTP-specific processing
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>HTTP Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>HTTP Servlet Demonstration</h1>");
        out.println("<p>Welcome, " + escapeHtml(name) + "!</p>");
        out.println("<p>Request Method: " + request.getMethod() + "</p>");
        out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
        
        // Session tracking example
        HttpSession session = request.getSession(true);
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        visitCount = (visitCount == null) ? 1 : visitCount + 1;
        session.setAttribute("visitCount", visitCount);
        
        out.println("<p>Visit Count: " + visitCount + "</p>");
        out.println("</body>");
        out.println("</html>");
    }

    // Handle POST requests
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
            throws ServletException, IOException {
        // Delegate to doGet for simplicity
        doGet(request, response);
    }

    // Destruction method
    public void destroy() {
        log("HTTP Servlet Destroyed");
    }

    // Utility method to escape HTML special characters
    private String escapeHtml(String input) {
        if (input == null) return "";
        return input
            .replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("\"", "&quot;")
            .replace("'", "&#x27;");
    }
}