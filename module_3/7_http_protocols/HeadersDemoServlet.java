import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HeadersDemo")
public class HeadersDemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set content type to HTML
        response.setContentType("text/html");
        
        // Add custom response headers
        response.setHeader("X-Custom-Header", "Java Servlet Demo");
        response.setHeader("Server", "HTTP Protocol Learning Server");
        
        // Get PrintWriter to write response
        PrintWriter out = response.getWriter();
        
        // HTML Response Start
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>HTTP Headers Demo</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; max-width: 800px; margin: 0 auto; padding: 20px; }");
        out.println("table { width: 100%; border-collapse: collapse; }");
        out.println("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
        out.println("h1 { color: #333; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>HTTP Request Headers</h1>");
        
        // Display Request Headers
        out.println("<table>");
        out.println("<tr><th>Header Name</th><th>Header Value</th></tr>");
        
        // Enumerate through all request headers
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            out.println("<tr>");
            out.println("<td>" + headerName + "</td>");
            out.println("<td>" + headerValue + "</td>");
            out.println("</tr>");
        }
        
        out.println("</table>");
        
        // Response Details
        out.println("<h2>Response Headers</h2>");
        out.println("<p>Custom headers have been added to the response:</p>");
        out.println("<ul>");
        out.println("<li>X-Custom-Header: Java Servlet Demo</li>");
        out.println("<li>Server: HTTP Protocol Learning Server</li>");
        out.println("</ul>");
        
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Handle POST requests similarly if needed
        doGet(request, response);
    }
}