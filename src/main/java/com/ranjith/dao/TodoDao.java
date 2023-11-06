package com.ranjith.dao;

import com.ranjith.db.Database;
import com.ranjith.model.Todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    private static final String INSERT_TODO = "INSERT INTO todo (userid,item) VALUES(?, ?);";
    private static final String SELECT_ALL = "SELECT id,item FROM todo WHERE userid = ? AND delete_flag = false;";

    private static final String DELETE_TODO = "UPDATE todo SET delete_flag = true WHERE id = ? ;";
    private static final String ALTER_ID = "ALTER TABLE todo AUTO_INCREMENT= 1;";
    private final Connection con;

    public TodoDao() {
        con = Database.getconnection();
    }

    public void addTodo(String todo, int userId) {
        try {
            PreparedStatement statement = con.prepareStatement(INSERT_TODO);
            statement.setInt(1, userId);
            statement.setString(2, todo);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Todo> getallTodo(int userid) {
        List<Todo> todos = new ArrayList<>();
        try{
            PreparedStatement statement = con.prepareStatement(SELECT_ALL);
            statement.setInt(1, userid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setTodo(rs.getString("item"));
                todos.add(todo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return todos;
    }

    public void deleteTodo(String id) {
        try {
            PreparedStatement statement = con.prepareStatement(DELETE_TODO);
            PreparedStatement alt = con.prepareStatement(ALTER_ID);
            statement.setString(1, id);
            statement.executeUpdate();
                alt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
