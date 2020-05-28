/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.historyLog;

import com.herald.usermgmt.config.MySqlCon;
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
            ps = con.prepareStatement("insert into history (action,client_id,client_username,admin_id,admin_username,date,time) values(?,?,?,?,?,?,?)");

            ps.setString(1, h.getAction());
            ps.setInt(2, h.getClient_id());
            ps.setString(3, h.getClient_username());
            ps.setInt(4, 0);
            ps.setString(5, "null");
            ps.setObject(6, LocalDate.now());
            ps.setObject(7, LocalTime.now());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public int insertHistory(History h, int id) {
        int status = 0;
        try {
            con = MySqlCon.getConnection();
            ps = con.prepareStatement("insert into history (action,client_id,client_username,admin_id,admin_username,date,time) values(?,?,?,?,?,?,?)");

            ps.setString(1, h.getAction());
            ps.setInt(2, h.getClient_id());
            ps.setString(3, h.getClient_username());
            ps.setInt(4, h.getAdmin_id());
            ps.setString(5, h.getAdmin_username());
            ps.setObject(6, LocalDate.now());
            ps.setObject(7, LocalTime.now());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public int insertHistoryAdmin(History h) {
        int status = 0;
        try {
            con = MySqlCon.getConnection();
            ps = con.prepareStatement("insert into history (action,client_id,client_username,admin_id,admin_username,date,time) values(?,?,?,?,?,?,?)");

            ps.setString(1, h.getAction());
            ps.setInt(2, 0);
            ps.setString(3, "null");
            ps.setInt(4, h.getAdmin_id());
            ps.setString(5, h.getAdmin_username());
            ps.setObject(6, LocalDate.now());
            ps.setObject(7, LocalTime.now());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public List<History> listHistory() throws SQLException {
        List<History> listHistory = new ArrayList<>();

        String sql = "SELECT * FROM HISTORY order by time DESC";

        con = MySqlCon.getConnection();

        ps = con.prepareStatement(sql);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("history_id");
            String action = resultSet.getString("action");
            int client_id = resultSet.getInt("client_id");
            String client_username = resultSet.getString("client_username");
            int admin_id = resultSet.getInt("admin_id");
            String admin_username = resultSet.getString("admin_username");

            Object date = resultSet.getObject("date");
            Object time = resultSet.getObject("time");

            History h = new History(id, action, client_id, client_username, admin_id, admin_username, date, time);
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

        String sql = "SELECT distinct date FROM HISTORY where client_username = ? order by date DESC";

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

}
