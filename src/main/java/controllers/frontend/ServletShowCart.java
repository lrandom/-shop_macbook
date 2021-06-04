package controllers.frontend;

import helpers.Cart;
import helpers.Helper;
import models.CartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ServletShowCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute(Cart.CART_KEY);
        ArrayList<CartItem> cartItems = new ArrayList<>();
        if (cart != null) {
            cartItems = cart.getCartItems();
        }
        System.out.println("CART_ITEM_LENGTH" + cartItems.size());
        req.setAttribute("cartItems", cartItems);
        req.setAttribute("tax", cart.getTax());
        req.setAttribute("subTotal", cart.getSubTotal());
        req.setAttribute("total", cart.getTotal());
        Helper.loadView(req, "/WEB-INF/frontend/cart.jsp").forward(req, resp);
    }
}
