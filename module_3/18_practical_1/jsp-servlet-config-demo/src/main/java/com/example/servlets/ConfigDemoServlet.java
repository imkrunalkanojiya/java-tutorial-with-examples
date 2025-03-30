package com.example.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ConfigDemoServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        ServletConfig config = getServletConfig();
        
        out.println("<html><body>");
        out.println("<h2>ServletConfig Demo</h2>");
        out.println("<h3>Initialization Parameters:</h3>");
        out.println("<table border='1'>");
        out.println("<tr><th>Parameter Name</th><th>Parameter Value</th></tr>");
        
        Enumeration<String> paramNames = config.getInitParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String paramValue = config.getInitParameter(paramName);
            out.println("<tr><td>" + paramName + "</td><td>" + paramValue + "</td></tr>");
        }
        
        out.println("</table>");
        out.println("</body></html>");
    }
}