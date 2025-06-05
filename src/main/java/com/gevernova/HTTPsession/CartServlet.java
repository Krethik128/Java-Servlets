package com.gevernova.HTTPsession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/view-cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (session != null) {
            HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");

            if (cart != null && !cart.isEmpty()) {
                out.println("<h2>Your Shopping Cart:</h2><ul>");

                // Loop through the cart using streams
                cart.entrySet().stream().forEach(entry ->
                        out.println("<li>" + entry.getKey() + " - Quantity: " + entry.getValue() + "</li>")
                );

                out.println("</ul>");
            } else {
                out.println("<h2>Your cart is empty.</h2>");
            }
        } else {
            out.println("<h2>No session found. Please add items to cart first.</h2>");
        }
    }

}
