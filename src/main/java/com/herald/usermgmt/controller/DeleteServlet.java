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
import com.herald.usermgmt.model.User;
import com.herald.usermgmt.DAO.UserDAOimpl;
import com.herald.usermgmt.DAO.UserDAO;
import com.herald.usermgmt.model.History;
import com.herald.usermgmt.DAO.HistoryDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delete")

public class DeleteServlet extends HttpServlet {
    
    //Initializing objects

    UserDAO cd = new UserDAOimpl();
    HistoryDAO hd = new HistoryDAO();
    History h = new History();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        //false does not let to create a new session
        HttpSession session = request.getSession(false);
        //storing session data
        Object sessionUser = (Object) session.getAttribute("user");
        String sessionUsername = (String) session.getAttribute("username");
        String sessionPassword = (String) session.getAttribute("password");
        String sessionUserType = (String) session.getAttribute("user_type");
        //checking whether session exists or not
        if (session != null) {
            if (sessionUserType.equals("admin")) {
                //value of id comes from the website
                String sid = request.getParameter("id");
                int id = Integer.parseInt(sid);
                
                //for history log
                User client = cd.getUser(id);
                h.setUser_id(client.getId());
                h.setUsername(client.getUsername());

                h.setAction("delete");
                //value stored in history
                hd.insertHistory(h);
                //user deleted
                cd.deleteUser(id);
                //redirected to HomeServlet
                response.sendRedirect("HomeServlet");
            } 
            //if client is trying to access the delete feature
            else {
                System.out.println("You donot have this Permission");
                request.setAttribute("permission", "You do not have this permission");
                request.getRequestDispatcher("HomeServlet").include(request, response);
            }
        } 
        //if session doesnot exist
        else {
            request.setAttribute("sessionLogin", "You do not have this access");
            System.out.println("Please login first");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
    }
}
