/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.controller;

import com.herald.usermgmt.DAO.HistoryDAO;
import com.herald.usermgmt.model.History;
import java.io.IOException;
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

/**
 *
 * @author Shahi
 */
//web servlet
@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
    //Initialization of Object

   
    History h = new History();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //false does not create a new session
        HttpSession session = request.getSession(false);
        Object sessionUser = (Object) session.getAttribute("user");
        String sessionUsername = (String) session.getAttribute("username");
        String sessionPassword = (String) session.getAttribute("password");
        String sessionUserType = (String) session.getAttribute("user_type");
        //checks whether session exists on not
        if (session != null) {
            //checks whether user is admin or client
            if (sessionUserType.equals("admin")) {
                System.out.println(request.getParameter("startdate")+"start date");
                Object startdate = request.getParameter("startdate");
                Object enddate = request.getParameter("enddate");
                String submitType = request.getParameter("submit");
                
                System.out.println(startdate +" "+ enddate+ "  dates");
                
                try {
                     HistoryDAO hd = new HistoryDAO();
                    List<History> reportCreateList = hd.reportCreateList(startdate, enddate);
                    request.setAttribute("reportCreateList", reportCreateList);
                    System.out.println(hd.reportCreateList(startdate, enddate)+"r c l s o p");
                    
                    List<History> reportBlockList =hd.reportBlockList(startdate, enddate);
                    request.setAttribute("reportBlockList", reportBlockList);
                    
                    RequestDispatcher dispatcher = request.getRequestDispatcher("HomeServlet");
                    dispatcher.forward(request, response);
//                    response.sendRedirect("HomeServlet");
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

                
            } //if user is not admin
            else {
                System.out.println("You do not have this Permission");
                request.setAttribute("permission", "You do not have this permission");
                request.getRequestDispatcher("HomeServlet").include(request, response);
            }

        } //if session does not exist
        else {
            request.setAttribute("sessionLogin", "You do not have this access");
            System.out.println("Please login first");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
    }
    
    
}
