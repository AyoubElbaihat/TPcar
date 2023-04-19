package com.example.tpcar.servlet;

import com.example.tpcar.Dao.CategoryJdbcDao;
import com.example.tpcar.model.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/list-category")
public class CategoryListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
        List<Category> categoryList = categoryJdbcDao.findAll();


        request.setAttribute("categorys", categoryList);
        request
                .getRequestDispatcher(request.getContextPath() +"/WEB-INF/list-category.jsp")
                .forward(request, response);
    }
}
