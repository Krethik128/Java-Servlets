package com.gevernova.redirectpage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/input")
public class InputServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("username");

        if (name != null && !name.isEmpty()) {
            // Redirect with query param
            response.sendRedirect("details?name=" + name); //URL Rewriting
        } else {
            response.sendRedirect("input.html"); // Go back to form if empty
        }
    }
}
