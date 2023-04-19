package com.example.tpcar.servlet;

import com.example.tpcar.Dao.CarJdbcDao;
import com.example.tpcar.Dao.CategoryJdbcDao;
import com.example.tpcar.model.Car;
import com.example.tpcar.model.Category;
import com.example.tpcar.service.CarService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/auth/add-car")
public class AddCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
        List<Category> categoryList = categoryJdbcDao.findAll();


        request.setAttribute("categorys", categoryList);
        request
                .getRequestDispatcher(request.getContextPath() +"/WEB-INF/add-car.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String carname = req.getParameter("carname");
        String description = req.getParameter("description");
        String urlimg = req.getParameter("urlimg");
        double prix = Double.parseDouble(req.getParameter("prix"));
        String catname = req.getParameter("catname");
        CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
        Category category = categoryJdbcDao.findByCategory(catname);
        int category_id = category.getId();



        CarService carService = new CarService();
        carService.createCar(carname, description, urlimg,prix,category_id);
        resp.sendRedirect(req.getContextPath() +"/list-car");

    }
}
