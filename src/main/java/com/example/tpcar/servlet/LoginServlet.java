package com.example.tpcar.servlet;

import com.example.tpcar.Dao.UserJdbcDao;
import com.example.tpcar.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserJdbcDao userJdbcDao = new UserJdbcDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(req.getContextPath() +"/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userJdbcDao.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            System.out.println("1");
            HttpSession session = req.getSession(true);
            session.setAttribute("username", user);
            resp.sendRedirect("/list-car");
        } else {
            req.setAttribute("isError", true);
            req.getRequestDispatcher(req.getContextPath() +"/WEB-INF/login.jsp").forward(req, resp);
        }
    }
}

