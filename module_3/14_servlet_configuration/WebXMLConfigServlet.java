// Java Servlet Class
package com.example.servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class WebXMLConfigServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Servlet configuration parameter
    private String applicationName;

    // Initialization method
    public void init() throws ServletException {
        // Retrieve initialization parameter
        ServletConfig config = getServletConfig();
        applicationName = config.getInitParameter("applicationName");
        
        // Log initialization
        log("WebXMLConfigServlet initialized");
        log("Application Name: " + 
            (applicationName != null ? applicationName : "Not Configured"));
    }

    // Handle GET requests
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Generate dynamic HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Web XML Servlet Configuration</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; max-width: 600px; margin: 0 auto; padding: 20px; }");
        out.println(".config-info { background-color: #f4f4f4; padding: 15px; border-radius: 5px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Web XML Servlet Configuration Demo</h1>");
        out.println("<div class='config-info'>");
        out.println("<h2>Servlet Configuration Details</h2>");
        
        // Display configuration details
        out.println("<p><strong>Servlet Name:</strong> " + getServletName() + "</p>");
        out.println("<p><strong>Application Name:</strong> " + 
            (applicationName != null ? escapeHtml(applicationName) : "Not Configured") + "</p>");
        
        // Display request information
        out.println("<p><strong>Request URI:</strong> " + escapeHtml(request.getRequestURI()) + "</p>");
        out.println("<p><strong>Request Method:</strong> " + request.getMethod() + "</p>");
        
        out.println("</div>");
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

    // Destruction method
    public void destroy() {
        log("WebXMLConfigServlet destroyed");
    }
}