/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.DAO;

/**
 *
 * @author Shahi
 */
import com.herald.usermgmt.config.MySqlCon;
import com.herald.usermgmt.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDAOimpl implements UserDAO {

    static Connection con;
    static PreparedStatement ps;

    @Override
    public int insertUser(User u) {
        int status = 0;
        try {
            con = MySqlCon.getConnection();
            ps = con.prepareStatement("insert into user (username, password, name, user_type, security_question, image, join_date) values(?,?,?,?,?,?,?)");
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getName());
            ps.setString(4, "client");
            ps.setString(5, u.getSecurity_question());
            ps.setString(6, "default");
            ps.setObject(7, LocalDate.now());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    @Override
    public User getUser(String user, String pass) {
        User u = new User();

        try {
            con = MySqlCon.getConnection();
            ps = con.prepareStatement("select * from user where username=? and password=?");
            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int user_id = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String user_type = resultSet.getString("user_type");
                String security_question = resultSet.getString("security_question");
                String image = resultSet.getString("image").trim();
                Object join_date = resultSet.getObject("join_date");

                User users = new User(user_id, username, password, name, user_type, security_question, image, join_date);
                return users;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return u;

    }

    @Override
    public User getUser(int id) {
        User u = new User();

        try {
            con = MySqlCon.getConnection();
            ps = con.prepareStatement("select * from user where user_id = ?");
            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int user_id = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String user_type = resultSet.getString("user_type");
                String security_question = resultSet.getString("security_question");
                String image = resultSet.getString("image").trim();
                Object join_date = resultSet.getObject("join_date");
                User users = new User(user_id, username, password, name, user_type, security_question, image, join_date);
                return users;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return u;

    }

    @Override
    public boolean validate(String name, String pass) {
        boolean status = false;
        User u = new User();
        try {

            con = MySqlCon.getConnection();

            ps = con.prepareStatement(
                    "select * from user where username=? and password=?");
            ps.setString(1, name);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

            while (rs.next()) {
                rs.getString("username");
                u.setUsername(rs.getString(1));
                u.setPassword(rs.getString(3));

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    @Override
    public int validateForgot(String name, String security) {
        int user_id = 0;
        User u = new User();
        try {

            con = MySqlCon.getConnection();

            ps = con.prepareStatement(
                    "select * from user where username=? and security_question=?");
            ps.setString(1, name);
            ps.setString(2, security);

            ResultSet rs = ps.executeQuery();
//            status = rs.next();

            while (rs.next()) {
                user_id = rs.getInt("user_id");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return user_id;
    }

    @Override
    public List<User> listClient() throws SQLException {
        List<User> listClient = new ArrayList<>();
        String client = "client";
        String sql = "SELECT * FROM user where user_type=? ";

        con = MySqlCon.getConnection();

        ps = con.prepareStatement(sql);
        ps.setString(1, client);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("user_id");
            String username = resultSet.getString("username");
            String name = resultSet.getString("name");
            String user_type = resultSet.getString("user_type");
            String image = resultSet.getString("image");
            Object join_date = resultSet.getObject("join_date");
            User user = new User(id, username, name, user_type, image, join_date);
            listClient.add(user);
        }

        resultSet.close();
        return listClient;
    }

    @Override
    public List<User> listAdmin() throws SQLException {
        List<User> listAdmin = new ArrayList<>();
        String client = "admin";
        String sql = "SELECT * FROM user where user_type=? ";

        con = MySqlCon.getConnection();

        ps = con.prepareStatement(sql);
        ps.setString(1, client);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("user_id");
            String username = resultSet.getString("username");
            String name = resultSet.getString("name");
            String user_type = resultSet.getString("user_type");
            String image = resultSet.getString("image");
            Object join_date = resultSet.getObject("join_date");
            User user = new User(id, username, name, user_type, image, join_date);
            listAdmin.add(user);
        }

        resultSet.close();
        return listAdmin;
    }

    @Override
    public int totalClient() throws SQLException {
        int totalclient = 0;
        String client = "client";
        String sql = "SELECT COUNT(*) FROM user where user_type = ? ";

        con = MySqlCon.getConnection();

        ps = con.prepareStatement(sql);
        ps.setString(1, client);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            totalclient = rs.getInt("count(*)");
        }

        con.close();
        return totalclient;
    }

    @Override
    public int totalAdmin() throws SQLException {
        int totaladmin = 0;
        String client = "admin";
        String sql = "SELECT COUNT(*) FROM user where user_type = ? ";

        con = MySqlCon.getConnection();

        ps = con.prepareStatement(sql);
        ps.setString(1, client);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            totaladmin = rs.getInt("count(*)");
        }

        con.close();
        return totaladmin;
    }

    @Override
    public boolean editUser(int id, User u) {
        boolean rowUpdated = true;
        try {
            String sql = "UPDATE `user` SET `username`=?,`password`=?,`name`=?,`security_question`=? WHERE user_id= ?; ";
            con = MySqlCon.getConnection();
            Statement s = con.createStatement();
            ps = con.prepareStatement(sql);

            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getName());

            ps.setString(4, u.getSecurity_question());
            ps.setInt(5, id);
            rowUpdated = ps.executeUpdate() > 0;

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }

    @Override
    public int deleteUser(int id) {
        int status = 0;
        try {
            con = MySqlCon.getConnection();
            Statement s = con.createStatement();
            String s1 = "delete from user where user_id=" + id;
            String s2 = "DELETE FROM block WHERE user_id =" + id;
            s.addBatch(s1);
            s.addBatch(s2);
            s.executeBatch();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public boolean resetPassword(int id, User u) {
        boolean rowUpdated = true;
        try {
            String sql = "UPDATE `user` SET `password`=? WHERE user_id= ?; ";
            con = MySqlCon.getConnection();
            Statement s = con.createStatement();
            ps = con.prepareStatement(sql);

            ps.setString(1, u.getPassword());
            ps.setInt(2, id);
            rowUpdated = ps.executeUpdate() > 0;

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }
}
