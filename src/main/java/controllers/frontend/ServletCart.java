package controllers.frontend;

import dals.ProductDal;
import helpers.Cart;
import helpers.Helper;
import models.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ServletCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //session.setAttribute("TEST", new String("TEST"));
        //resp.sendRedirect(Helper.BASE_URL+req.getContextPath()+"/show-cart");

        //lấy id sản phẩm
        String id = req.getParameter("id");
        String action = req.getParameter("action");
        switch (action) {
            case "addItem":
                ProductDal productDal = new ProductDal();
                Product product = productDal.getById(new Integer(id).intValue());
                Cart cart = (Cart) session.getAttribute(Cart.CART_KEY);
                if (cart == null) {
                    //nếu giỏ hàng ko tồn tại, thì tạo mới giỏ hàng
                    System.out.println("does not exist");
                    cart = new Cart();
                }
                cart.addItem(product);
                //đẩy ngược cart vào session
                session.setAttribute(Cart.CART_KEY, cart);
                System.out.println("CHECK");
                System.out.println(((Cart)session.getAttribute(Cart.CART_KEY)).getCartItems().size());
                break;

            case "removeItem":
                cart = (Cart) session.getAttribute(Cart.CART_KEY);
                if (cart != null) {
                    cart.removeItem(new Integer(id).intValue());
                }
                //đẩy ngược cart vào session
                session.setAttribute(Cart.CART_KEY, cart);
                break;


            case "empty":
                cart = (Cart) session.getAttribute(Cart.CART_KEY);
                if (cart != null) {
                    cart.emptyCart();
                }
                //đẩy ngược cart vào session
                session.setAttribute(Cart.CART_KEY, cart);
                break;

            case "updateQuantity":
                String offset = req.getParameter("offset");
                cart = (Cart) session.getAttribute(Cart.CART_KEY);
                if (cart != null) {
                    cart.updateQuantity(new Integer(id).intValue(), new Integer(offset).intValue());
                }
                //đẩy ngược cart vào session
                session.setAttribute(Cart.CART_KEY, cart);
                break;
        }



        resp.sendRedirect(Helper.BASE_URL+req.getContextPath()+"/show-cart");
    }
}
