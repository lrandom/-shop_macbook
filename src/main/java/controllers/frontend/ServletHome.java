package controllers.frontend;

import dals.ProductDal;
import helpers.Helper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletHome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDal productDal = new ProductDal();
        req.setAttribute("list", productDal.getList());
        Helper.loadView(req, "/WEB-INF/frontend/home.jsp").forward(req, resp);
    }
}
