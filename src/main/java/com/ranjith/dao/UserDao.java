package com.ranjith.dao;

import com.ranjith.db.Database;
import com.ranjith.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String SELECT_USERS = "SELECT username FROM auth;";
    private static Connection connection;
    private static final String LoginQuery = "SELECT id, username, password FROM auth WHERE username=? and password=?";

    private static String INSERT_USER = "INSERT INTO auth (username, password) VALUES(?,?);";

    public UserDao() {

        connection = Database.getconnection();
    }

    public static User loginUser(String username, String password) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(LoginQuery);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }

        } catch (Exception e) {
            throw new RuntimeException();
        }
        return user;
    }

    public void addUser(String username, String password) {

        try {

            PreparedStatement statement = connection.prepareStatement(INSERT_USER);
            statement.setString(1, username);
            statement.setString(2, password);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_USERS);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
