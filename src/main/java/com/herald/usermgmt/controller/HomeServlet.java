/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.controller;

import com.herald.usermgmt.model.User;
import com.herald.usermgmt.DAO.UserDAOimpl;
import com.herald.usermgmt.DAO.UserDAO;
import com.herald.usermgmt.model.Block;
import com.herald.usermgmt.DAO.BlockDAO;
import com.herald.usermgmt.model.History;
import com.herald.usermgmt.DAO.HistoryDAO;
import com.herald.usermgmt.model.DisplayHistory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//web servlet
@WebServlet("/HomeServlet")

public class HomeServlet extends HttpServlet {

    //Initializing objects
    UserDAO cd;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //false does not create a new session
        HttpSession session = request.getSession(false);  //false doesnot create new session here

        UserDAO cd = new UserDAOimpl();
        //checking whether session exists
        if (session != null) {
            //getting and storing session user data
            String sessionUsername = (String) session.getAttribute("username");
            String sessionPassword = (String) session.getAttribute("password");
            Object sessionUser = (Object) session.getAttribute("user");
            String sessionUserType = (String) session.getAttribute("user_type");
            System.out.println("homeservlet" + session.getAttribute("user.getUsername()"));
            //method to get users data
            User u2 = cd.getUser(sessionUsername, sessionPassword);

            //demo 
            User demo = new User();
            demo.setUsername(sessionUsername);
            demo.setPassword(sessionPassword);
            demo.setUser_type(u2.getUser_type());

            //user type = client
            String type = "client";

            request.setAttribute("message", " | ukername =" + u2.getUsername() + " |password =" + u2.getPassword() + " |Name =" + u2.getName() + " |type =" + u2.getUser_type() + " |security question =" + u2.getSecurity_question());
            //users data
            request.setAttribute("username", u2.getUsername());
            request.setAttribute("name", u2.getName());
            request.setAttribute("user_type", u2.getUser_type());
            request.setAttribute("user_id", u2.getId());
            request.setAttribute("join_date", u2.getJoin_date());
            System.out.println(u2.getUsername() + " --updated username");
            System.out.print(u2.getImage() + " ---image url demo");
            request.setAttribute("image", u2.getImage().trim().trim());

            //if user is client 
            if (type.equals(u2.getUser_type())) {

                out.print("Hello, " + sessionUsername + " Welcome to Client Profile");
                try {
                    //lists all client
                    listClient(request, response);
                    //counts total clients
                    totalUser(request, response);
                    //counts toatal blocked clients
                    totalBlockClient(request, response);
                    
                    
                    //for History log
                    HistoryDAO historyDA03 = new HistoryDAO();
                    //lists all date where the sesssion user has interacted
                    List<History> listClientDate = historyDA03.listClientDate(sessionUsername);
                    request.setAttribute("listClientDate", listClientDate);
                    //dashboard-client.jsp is shown
                    RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard-client.jsp");
                    dispatcher.forward(request, response);

                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            } 
            //if user is admin
            else {

                out.print("Hello, " + sessionUsername + " Welcome to Admin Profile");

                try {
                    //list all client
                    listClient(request, response);
                    //counts total user
                    totalUser(request, response);
                    //counts total block client
                    totalBlockClient(request, response);
                    //max and min date for report
                    maxMinDate(request,response);
                    //dashboard-client.jsp is shown
                    RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard-admin.jsp");
                    dispatcher.forward(request, response);

                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            }
        } 
        //if session does not exist
        else {
            out.print("Please login first");
            request.setAttribute("sessionLogin", "Please Login first");
            System.out.println("Please login first");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
        out.close();

    }

    private void listClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        //to list all active client
        UserDAO userDAO = new UserDAOimpl();
        List<User> listClient = userDAO.listClient();
        request.setAttribute("listClient", listClient);
        
        //to list all admin
        UserDAO adminDAO = new UserDAOimpl();
        List<User> listAdmin = userDAO.listAdmin();
        request.setAttribute("listAdmin", listAdmin);
        
        //to list all block client
        BlockDAO blockDAO = new BlockDAO();
        List<Block> listBlockClient = blockDAO.listBlockClient();
        request.setAttribute("listBlockClient", listBlockClient);

        //to list all history
        HistoryDAO historyDA0 = new HistoryDAO();
        List<History> listHistory = historyDA0.listHistory();
        request.setAttribute("listHistory", listHistory);

        //to list all disticnt date from history table
        HistoryDAO historyDA02 = new HistoryDAO();
        List<History> listDate = historyDA02.listDate();
        request.setAttribute("listDate", listDate);
        
    }
    private void maxMinDate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        HistoryDAO historyDAO = new HistoryDAO();
        //total number of client 
        System.out.println(historyDAO.minDate() +"min date");
        request.setAttribute("minDate", historyDAO.minDate());
        //total number of admin
        request.setAttribute("maxDate", historyDAO.maxDate());
        

    }
    private void totalUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        UserDAO userDAO = new UserDAOimpl();
        //total number of client 
        request.setAttribute("totalClient", userDAO.totalClient());
        //total number of admin
        request.setAttribute("totalAdmin", userDAO.totalAdmin());
        

    }

    private void totalBlockClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        BlockDAO blockDAO = new BlockDAO();
        //total number of blocked clients
        request.setAttribute("totalBlockClient", blockDAO.totalBlockClient());
        System.out.println(blockDAO.totalBlockClient() + " < total");

    }

}
