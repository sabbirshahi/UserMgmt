/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.controller;

/**
 *
 * @author Shahi
 */
import com.herald.usermgmt.DAO.BlockDAO;
import com.herald.usermgmt.model.History;
import com.herald.usermgmt.DAO.HistoryDAO;
import com.herald.usermgmt.model.User;
import com.herald.usermgmt.DAO.UserDAO;
import com.herald.usermgmt.DAO.UserDAOimpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/block")

public class BlockServlet extends HttpServlet {
    //Initialization of Object
    UserDAO cd = new UserDAOimpl();
    BlockDAO bd = new BlockDAO();
    HistoryDAO hd = new HistoryDAO();
    History h = new History();

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
                String sid = request.getParameter("id");
                int id = Integer.parseInt(sid);

                //for history log
                User client = cd.getUser(id);
                h.setUser_id(client.getId());
                h.setUsername(client.getUsername());

                h.setAction("blocked");
                //inserts history in history log
                hd.insertHistory(h);
               
                bd.blockClient(id);

                response.sendRedirect("HomeServlet");
            } 
            //if user is not admin
            else {
                System.out.println("You do not have this Permission");
                request.setAttribute("permission", "You do not have this permission");
                request.getRequestDispatcher("HomeServlet").include(request, response);
            }

        } 
        //if session does not exist
        else {
            request.setAttribute("sessionLogin", "You do not have this access");
            System.out.println("Please login first");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
    }

}
