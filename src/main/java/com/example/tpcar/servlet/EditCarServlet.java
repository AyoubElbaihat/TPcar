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

@WebServlet("/auth/edit-car")
public class EditCarServlet extends HttpServlet {
    CarJdbcDao carJdbcDao = new CarJdbcDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
        List<Category> categoryList = categoryJdbcDao.findAll();
        int id = Integer.parseInt(req.getParameter("id"));
        CarJdbcDao carJdbcDao = new CarJdbcDao();
        Car car = carJdbcDao.findById(id);
        req.setAttribute("id",id);
        req.setAttribute("carname",car.getCarname());
        req.setAttribute("description",car.getDescription());
        req.setAttribute("urlimg",car.getUrlimg());
        req.setAttribute("prix",car.getPrix());

        req.setAttribute("categorys", categoryList);
        req
                .getRequestDispatcher(req.getContextPath() +"/WEB-INF/edit-car.jsp")
                .forward(req, resp);





    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String carname = req.getParameter("carname");
        String description = req.getParameter("description");
        String urlimg = req.getParameter("urlimg");
        double prix = Double.parseDouble(req.getParameter("prix"));
        String catname = req.getParameter("catname");
        CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
        Category category = categoryJdbcDao.findByCategory(catname);
        int category_id = category.getId();

        CarService carService = new CarService();
        carService.updateCar(id,carname, description, urlimg,prix,category_id);
        resp.sendRedirect(req.getContextPath() +"/list-car");

}
}
