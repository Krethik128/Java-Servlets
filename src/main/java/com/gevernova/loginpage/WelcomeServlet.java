package com.gevernova.loginpage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=(String)request.getAttribute("username");
        String password=(String)request.getAttribute("password");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<h1>Welcome, " + username + "!</h1>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // Allow POST as well
    }
}
