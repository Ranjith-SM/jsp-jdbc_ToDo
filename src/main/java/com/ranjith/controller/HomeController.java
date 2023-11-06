package com.ranjith.controller;

import com.ranjith.dao.TodoDao;
import com.ranjith.model.Todo;
import com.sun.org.apache.bcel.internal.generic.LSTORE;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HomeController extends HttpServlet {
    private final TodoDao todoDao;
    public HomeController() {
        todoDao = new TodoDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("herr");
        String id = req.getParameter("id");
        if (id != null) {
            todoDao.deleteTodo(id);
        }
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
        int userid = Integer.parseInt(req.getSession().getAttribute("userid").toString());

        String item = req.getParameter("todo");
        if (item != null && !item.trim().isEmpty()) {
            todoDao.addTodo(item, userid);
        }

        List<Todo> todos = todoDao.getallTodo(userid);
        req.setAttribute("todos", todos);

        dispatcher.forward(req,resp);
    }
}
