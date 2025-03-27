import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/UserRegistration")
public class UserRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Initialize servlet
    public void init() throws ServletException {
        // Optional initialization code
        log("UserRegistrationServlet initialized");
    }

    // Handle GET requests
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        
        // Get PrintWriter to write response
        PrintWriter out = response.getWriter();

        // Retrieve parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String age = request.getParameter("age");

        // Input validation
        if (name == null || name.trim().isEmpty()) {
            name = "Unknown User";
        }

        // Generate dynamic HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <title>User Registration Result</title>");
        out.println("    <style>");
        out.println("        body { font-family: Arial, sans-serif; max-width: 600px; margin: 0 auto; padding: 20px; }");
        out.println("        .result { background-color: #f4f4f4; padding: 20px; border-radius: 5px; }");
        out.println("    </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h1>Registration Details</h1>");
        out.println("    <div class='result'>");
        
        // Display user information
        out.println("        <h2>Welcome, " + escapeHtml(name) + "!</h2>");
        out.println("        <p><strong>Name:</strong> " + escapeHtml(name) + "</p>");
        
        // Conditionally display optional parameters
        if (email != null && !email.trim().isEmpty()) {
            out.println("        <p><strong>Email:</strong> " + escapeHtml(email) + "</p>");
        }
        
        if (age != null && !age.trim().isEmpty()) {
            out.println("        <p><strong>Age:</strong> " + escapeHtml(age) + "</p>");
        }
        
        // Additional server-side processing information
        out.println("        <hr>");
        out.println("        <p><em>Processed by: " + this.getServletName() + "</em></p>");
        out.println("    </div>");
        out.println("</body>");
        out.println("</html>");
    }

    // Handle POST requests (similar to GET in this example)
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
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

    // Servlet destruction method
    public void destroy() {
        log("UserRegistrationServlet destroyed");
    }
}