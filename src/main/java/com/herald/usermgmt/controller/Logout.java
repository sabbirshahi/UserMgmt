/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.controller;

import com.herald.usermgmt.model.User;
import com.herald.usermgmt.DAO.UserDAOimpl;
import com.herald.usermgmt.DAO.UserDAO;
import com.herald.usermgmt.model.History;
import com.herald.usermgmt.DAO.HistoryDAO;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//web servlet
@WebServlet("/Logout")

public class Logout extends HttpServlet {
    //Initializing objects
    UserDAO cd = new UserDAOimpl();
    HistoryDAO hd = new HistoryDAO();
    History h = new History();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("register.jsp").include(request, response);

        //getting user details from session
        HttpSession session = request.getSession();
        String sessionUsername = (String) session.getAttribute("username");
        String sessionPassword = (String) session.getAttribute("password");
        User u = cd.getUser(sessionUsername, sessionPassword);
        
        //checks user is admin or client
//        if (u.getUser_type().equals("admin")) {
            h.setUser_id(u.getId());
            h.setUsername(u.getUsername());
            h.setAction("logged off");
            //inserts history of admin
            hd.insertHistory(h);
//        } else {
//            h.setClient_id(u.getId());
//            h.setClient_username(u.getUsername());
//            h.setAction("logged of");
//            //inserts history in client's history log
//            hd.insertHistory(h);
//        }
        //ends session
        session.invalidate();
        System.out.println("Session ended !");

        out.close();
    }
}
