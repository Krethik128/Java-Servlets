package com.gevernova.loginpage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || username.isEmpty()) {
            request.setAttribute("error", "Username cannot be empty");
            request.getRequestDispatcher("/loginpage.jsp").forward(request, response);
            return;
        }

        if (!isUsernameValid(username)) {
            request.setAttribute("error", "Username must be 3-15 characters and only contain letters, numbers, _ or -");
            request.getRequestDispatcher("/loginpage.jsp").forward(request, response);
            return;
        }

        if (password == null || password.isEmpty()) {
            request.setAttribute("error", "Password cannot be empty");
            request.getRequestDispatcher("/loginpage.jsp").forward(request, response);
            return;
        }

        if (!isPasswordValid(password)) {
            request.setAttribute("error", "Password must be at least 8 characters and contain uppercase, lowercase, number, and special character");
            request.getRequestDispatcher("/loginpage.jsp").forward(request, response);
            return;
        }

        // Success
        request.setAttribute("username", username);
        request.setAttribute("password", password);

        RequestDispatcher requestDispatcher=request.getRequestDispatcher("welcome");
        requestDispatcher.forward(request,response);

    }

    private boolean isUsernameValid(String username) {
        return username.matches("^[a-zA-Z0-9_-]{3,15}$");
    }

    private boolean isPasswordValid(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    }
}
