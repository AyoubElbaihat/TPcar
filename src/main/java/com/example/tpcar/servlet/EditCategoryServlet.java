package com.example.tpcar.servlet;

import com.example.tpcar.Dao.CarJdbcDao;
import com.example.tpcar.Dao.CategoryJdbcDao;
import com.example.tpcar.model.Car;
import com.example.tpcar.model.Category;
import com.example.tpcar.service.CarService;
import com.example.tpcar.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/edit-category")
public class EditCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryJdbcDao.findById(id);
        req.setAttribute("id",id);
        req.setAttribute("catname",category.getName());

        req
                .getRequestDispatcher("/WEB-INF/edit-category.jsp")
                .forward(req, resp);





    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String catname = req.getParameter("catname");

        CategoryService categoryService = new CategoryService();
        categoryService.updateCategory(id,catname);
        resp.sendRedirect("list-category");

    }
}
