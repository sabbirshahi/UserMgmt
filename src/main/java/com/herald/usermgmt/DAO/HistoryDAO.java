/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.DAO;

import com.herald.usermgmt.config.MySqlCon;
import com.herald.usermgmt.model.DisplayHistory;
import com.herald.usermgmt.model.History;
import com.herald.usermgmt.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HistoryDAO {

    static Connection con;
    static PreparedStatement ps;

    public int insertHistory(History h) {
        int status = 0;
        try {
            con = MySqlCon.getConnection();
            ps = con.prepareStatement("insert into history (action,user_id,username,date,time) values(?,?,?,?,?)");

            ps.setString(1, h.getAction());
            ps.setInt(2, h.getUser_id());
            ps.setString(3, h.getUsername());
            ps.setObject(4, LocalDate.now());
            ps.setObject(5, LocalTime.now());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public List<History> listHistory() throws SQLException {
        List<History> listHistory = new ArrayList<>();
        List<User> listUserHistory = new ArrayList<>();

        String sql = "SELECT * FROM `history` order by time DESC";

        con = MySqlCon.getConnection();

        ps = con.prepareStatement(sql);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            int hid = resultSet.getInt("history_id");
            String action = resultSet.getString("action");
            int huser_id = resultSet.getInt("user_id");
            String username = resultSet.getString("username");
            Object hdate = resultSet.getObject("date");
            Object htime = resultSet.getObject("time");

            History h = new History(hid, action, huser_id, username, hdate, htime);
            listHistory.add(h);

        }

        resultSet.close();
        return listHistory;
    }

    public List<History> listDate() throws SQLException {
        List<History> listDate = new ArrayList<>();

        String sql = "SELECT distinct date FROM HISTORY order by date DESC";

        con = MySqlCon.getConnection();

        ps = con.prepareStatement(sql);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {

            Object date = resultSet.getObject("date");

            History h = new History(date);
            listDate.add(h);
        }

        resultSet.close();
        return listDate;
    }

    public List<History> listClientDate(String client_username) throws SQLException {
        List<History> listClientDate = new ArrayList<>();

        String sql = "SELECT DISTINCT date FROM `history` where username = ? ORDER BY date DESC";

        con = MySqlCon.getConnection();

        ps = con.prepareStatement(sql);
        ps.setString(1, client_username);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {

            Object date = resultSet.getObject("date");

            History h = new History(date);
            listClientDate.add(h);
        }

        resultSet.close();
        return listClientDate;
    }

    public List<History> reportCreateList(Object startdate, Object enddate) throws SQLException {
        List<History> reportCreateList = new ArrayList<>();

        String sql = "SELECT * FROM `history` WHERE date between '"+startdate+"' and '"+enddate+"' and ACTION = 'joined' ";

        con = MySqlCon.getConnection();

        ps = con.prepareStatement(sql);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            int hid = resultSet.getInt("history_id");
            String action = resultSet.getString("action");
            int huser_id = resultSet.getInt("user_id");
            String username = resultSet.getString("username");
            Object hdate = resultSet.getObject("date");
            Object htime = resultSet.getObject("time");

            History h = new History(hid, action, huser_id, username, hdate, htime);
            reportCreateList.add(h);

        }

        resultSet.close();
        return reportCreateList;
    }

    public List<History> reportBlockList(Object startdate, Object enddate) throws SQLException {
        List<History> reportBlockList = new ArrayList<>();

        String sql = "SELECT * FROM `history` WHERE date between '"+startdate+"' and '"+enddate+"' and ACTION = 'blocked' ";

        con = MySqlCon.getConnection();

        ps = con.prepareStatement(sql);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            int hid = resultSet.getInt("history_id");
            String action = resultSet.getString("action");
            int huser_id = resultSet.getInt("user_id");
            String username = resultSet.getString("username");
            Object hdate = resultSet.getObject("date");
            Object htime = resultSet.getObject("time");

            History h = new History(hid, action, huser_id, username, hdate, htime);
            reportBlockList.add(h);

        }

        resultSet.close();
        return reportBlockList;
    }

    //max date in history log
    public Object maxDate() throws SQLException {
        Object maxDate = null;
        String sql = "SELECT MAX(date) FROM history";
        //connection
        con = MySqlCon.getConnection();
        //sql passed to prepare statement
        ps = con.prepareStatement(sql);
        //query excecuted
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            //maxdate
            maxDate = rs.getObject("MAX(date)");
        }
        //connection closed
        con.close();
        return maxDate;
    }

    //min date in history log
    public Object minDate() throws SQLException {
        Object minDate = null;
        String sql = "SELECT MIN(date) FROM history";
        //connection
        con = MySqlCon.getConnection();
        //sql passed to prepare statement
        ps = con.prepareStatement(sql);
        //query excecuted
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            //maxdate
            minDate = rs.getObject("MIN(date)");
        }
        //connection closed
        con.close();
        return minDate;
    }

}
