package controllers.admin.category;


import dals.CategoryDal;
import helpers.Helper;
import models.Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDal categoryDal = CategoryDal.getInstance();
        Category category = new Category();
        category.setName(req.getParameter("name"));
        categoryDal.insert(category);
        resp.sendRedirect( "/"+req.getContextPath()+"/admin/category/list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Helper.loadView(req, "/WEB-INF/admin/category/add.jsp").forward(req, resp);
    }
}
