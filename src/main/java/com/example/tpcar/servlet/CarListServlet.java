package com.example.tpcar.servlet;

import com.example.tpcar.Dao.CarJdbcDao;
import com.example.tpcar.model.Car;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet("/list-car")
public class CarListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CarJdbcDao carJdbcDao = new CarJdbcDao();
        List<Car> carList = carJdbcDao.findAll();


        req.setAttribute("cars", carList);
        req
                .getRequestDispatcher(req.getContextPath() +"/WEB-INF/list-car.jsp")
                .forward(req, resp);
    }
}
