package com.example.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        ServletContext context = getServletContext();
        String companyName = context.getInitParameter("company-name");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>First Servlet</h2>");
        out.println("<p>Company Name from ServletContext: " + companyName + "</p>");
        out.println("<a href='second'>Go to Second Servlet</a>");
        out.println("</body></html>");
    }
}