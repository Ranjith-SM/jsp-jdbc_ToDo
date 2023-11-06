package com.ranjith.model;

import com.ranjith.db.Database;

import java.sql.Connection;

public class User {
    private static int id ;
    private static  String username = "";
    private static String password = "null";

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

}
