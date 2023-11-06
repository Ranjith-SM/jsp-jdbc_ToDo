package com.ranjith.controller;

import com.ranjith.dao.UserDao;
import com.ranjith.db.Database;
import com.ranjith.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthController extends HttpServlet {

    private final UserDao userDao;
    public AuthController () {
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username= req.getParameter("username");
        String password= req.getParameter("password");

        User loggedUser = UserDao.loginUser(username, password);

        if(loggedUser != null) {

            HttpSession session = req.getSession();
            session.setAttribute("userid", User.getId());
            RequestDispatcher dispatcher = req.getRequestDispatcher("home");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("error",true);
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
