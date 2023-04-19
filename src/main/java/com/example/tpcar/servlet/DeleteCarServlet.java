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

@WebServlet(urlPatterns = "/auth/delete-car")
public class DeleteCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarJdbcDao carJdbcDao = new CarJdbcDao();

        int carId = Integer.parseInt(req.getParameter("id"));
        Car carToDelete = new Car(carId);
        carJdbcDao.delete(carToDelete);
        resp.sendRedirect(req.getContextPath() +"/list-car");
    }
}
