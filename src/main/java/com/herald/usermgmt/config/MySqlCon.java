package com.herald.usermgmt.config;

import java.sql.*;

public class MySqlCon implements MySqlConInterface {
    
    static Connection conn = null;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connected !");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database connection failed !");
            System.out.println(e);
        }
        return conn;
    }
}
