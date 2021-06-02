package controllers.admin.product;

import dals.CategoryDal;
import dals.ProductDal;
import helpers.Helper;
import models.Category;
import models.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ServletAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDal categoryDal = new CategoryDal();
        ArrayList<Category> categories = categoryDal.getList();
        req.setAttribute("categories", categories);
        Helper.loadView(req, "/WEB-INF/admin/product/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDal categoryDal = new ProductDal();
        Product product = new Product();
        product.setCategory(new Integer(req.getParameter("category_id")).intValue());
        product.setDescription(req.getParameter("description"));
        product.setKeyword(req.getParameter("keyword"));
        product.setName(req.getParameter("name"));
        product.setPrice(new Float(req.getParameter("price")).floatValue());
        product.setSku(req.getParameter("sku"));
        product.setQuantity(new Integer(req.getParameter("quantity")));
        product.setImage("https://macstores.vn/wp-content/uploads/2020/05/macbook_pro_2020_new_1.jpg");
        categoryDal.insert(product);
        resp.sendRedirect(Helper.BASE_URL + req.getContextPath() + "/admin/product/list");
    }
}
