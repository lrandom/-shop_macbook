package controllers.admin.category;

import dals.CategoryDal;
import helpers.Helper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        CategoryDal dal = new CategoryDal();
        dal.delete(new Integer(id).intValue());
        resp.sendRedirect( Helper.BASE_URL +req.getContextPath()+"/admin/category/list");
    }
}
