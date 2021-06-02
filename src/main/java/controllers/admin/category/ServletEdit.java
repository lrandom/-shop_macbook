package controllers.admin.category;

import dals.CategoryDal;
import helpers.Helper;
import models.Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        CategoryDal categoryDal = new CategoryDal();
        Category category = categoryDal.getById(new Integer(id).intValue());
        if (category != null) {
            req.setAttribute("category", category);
        }
        Helper.loadView(req, "/WEB-INF/admin/category/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDal categoryDal = new CategoryDal();
        Category category = new Category();
        category.setName(req.getParameter("name"));
        String id = req.getParameter("id");
        category.setId(new Integer(id).intValue());
        categoryDal.update(category);
        resp.sendRedirect(Helper.BASE_URL + req.getContextPath() + "/admin/category/list");
    }
}
