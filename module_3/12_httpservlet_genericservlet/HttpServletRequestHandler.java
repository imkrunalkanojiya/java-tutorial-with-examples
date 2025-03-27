import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/RequestHandler")
public class HttpServletRequestHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Initialization method
    public void init() throws ServletException {
        log("Request Handler Servlet Initialized");
    }

    // Handle GET requests
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Prepare HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>GET Request Handler</title></head>");
        out.println("<body>");
        out.println("<h1>GET Request Details</h1>");
        
        // Display request parameters
        out.println("<h2>Request Parameters:</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>Parameter Name</th><th>Parameter Value</th></tr>");
        
        // Enumerate request parameters
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            
            for (String paramValue : paramValues) {
                out.println("<tr>");
                out.println("<td>" + escapeHtml(paramName) + "</td>");
                out.println("<td>" + escapeHtml(paramValue) + "</td>");
                out.println("</tr>");
            }
        }
        out.println("</table>");
        
        // Additional request information
        out.println("<h2>Request Information:</h2>");
        out.println("<ul>");
        out.println("<li><strong>Request Method:</strong> " + request.getMethod() + "</li>");
        out.println("<li><strong>Request URI:</strong> " + request.getRequestURI() + "</li>");
        out.println("<li><strong>Query String:</strong> " + 
            (request.getQueryString() != null ? escapeHtml(request.getQueryString()) : "No query string") + 
            "</li>");
        out.println("</ul>");
        
        out.println("</body>");
        out.println("</html>");
    }

    // Handle POST requests
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Prepare HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>POST Request Handler</title></head>");
        out.println("<body>");
        out.println("<h1>POST Request Details</h1>");
        
        // Display POST request parameters
        out.println("<h2>Submitted Form Data:</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>Parameter Name</th><th>Parameter Value</th></tr>");
        
        // Enumerate request parameters
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            
            for (String paramValue : paramValues) {
                out.println("<tr>");
                out.println("<td>" + escapeHtml(paramName) + "</td>");
                out.println("<td>" + escapeHtml(paramValue) + "</td>");
                out.println("</tr>");
            }
        }
        out.println("</table>");
        
        // Request headers
        out.println("<h2>Request Headers:</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>Header Name</th><th>Header Value</th></tr>");
        
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            out.println("<tr>");
            out.println("<td>" + escapeHtml(headerName) + "</td>");
            out.println("<td>" + escapeHtml(request.getHeader(headerName)) + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        
        out.println("</body>");
        out.println("</html>");
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
        log("Request Handler Servlet Destroyed");
    }
}