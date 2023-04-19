package com.example.tpcar.servlet;

import com.example.tpcar.Dao.CategoryJdbcDao;
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

@WebServlet(urlPatterns = "/add-category")
public class AddCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request
                .getRequestDispatcher("/WEB-INF/add-category.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String catname = req.getParameter("catname");

        CategoryService categoryService = new CategoryService();
        categoryService.createCategory(catname);
        resp.sendRedirect("list-category");

    }
}
