package com.example.tpcar.servlet;

import com.example.tpcar.Dao.CarJdbcDao;
import com.example.tpcar.Dao.CategoryJdbcDao;
import com.example.tpcar.model.Car;
import com.example.tpcar.model.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/auth/delete-category")
public class DeleteCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();

        int categorieId = Integer.parseInt(req.getParameter("id"));
        Category category = categoryJdbcDao.findById(categorieId);
        Category categoryToDelete = category;
        categoryJdbcDao.delete(categoryToDelete);
        resp.sendRedirect(req.getContextPath() +"/list-category");
    }
}
