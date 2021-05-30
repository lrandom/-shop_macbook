package controllers.admin.category;

import dals.CategoryDal;
import helpers.Helper;
import models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletList")
public class ServletList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDal dal = new CategoryDal();
        ArrayList<Category> categories = dal.getList();
        request.setAttribute("list", categories);
        Helper.loadView(request, "/WEB-INF/admin/category/index.jsp").forward(request, response);
    }
}
