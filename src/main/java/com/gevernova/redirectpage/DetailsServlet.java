package com.gevernova.redirectpage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/details")
public class DetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (name != null && !name.isEmpty()) {
            out.println("<h1>Hello, " + name + "! Welcome to the Details Page</h1>");
        } else {
            out.println("<h1>No name provided.</h1>");
        }
    }
}
