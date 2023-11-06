package com.ranjith.controller;

import com.ranjith.dao.UserDao;
import com.ranjith.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class RegisterController extends HttpServlet {

    UserDao userDao;

    public RegisterController() {
        this.userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String Cpassword = req.getParameter("Confirm-password");

        if (username != null && password != null && Cpassword != null) {
            List<User> users = userDao.getUsers();
            for (User user : users) {
                System.out.println();
                if (user.getUsername().equals(username)) {
                    req.setAttribute("user_error", true);
                    RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
                    dispatcher.forward(req, resp);

                }
            }

            if (!Objects.equals(Cpassword, password)) {
                req.setAttribute("pass_error", true);
                RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
                dispatcher.forward(req, resp);
            } else {
                userDao.addUser(username, password);
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                dispatcher.forward(req, resp);
            }

        }
    }
}
