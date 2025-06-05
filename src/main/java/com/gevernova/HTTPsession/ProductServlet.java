package com.gevernova.HTTPsession;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/add-product")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String product = request.getParameter("product");

        HttpSession session =request.getSession();

        Object cartObj = session.getAttribute("cart");
        Map<String, Integer> cart;

        if (cartObj instanceof Map) {
            cart = (Map<String, Integer>) cartObj;
        } else {
            cart = new HashMap<>();
        }

        // Safely add product
        cart.put(product, cart.getOrDefault(product, 0) + 1);
        session.setAttribute("cart", cart);

        response.sendRedirect("view-cart"); // redirect to CartServlet

    }
}
