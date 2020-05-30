/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.controller;

import com.herald.usermgmt.model.User;
import com.herald.usermgmt.DAO.UserDAOimpl;
import com.herald.usermgmt.DAO.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//web servlet
@WebServlet("/reset")
public class ResetServlet extends HttpServlet {

    UserDAO cd;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        cd = new UserDAOimpl();
        //getting value from website
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        //getting value from reset form
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String submitType = request.getParameter("submit");
        //getting user details
        User u = cd.getUser(id);
        if (password.equals(password2)) {
            //setting new password
            u.setPassword(password);
            cd.resetPassword(id, u);
            request.setAttribute("successMessage", "Hey, " + u.getUsername() + " Password changed, please login to continue ! ");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
        //if password and confirm password do not match
        else {
            System.out.println("Password and Confirm password do not match");
            request.setAttribute("notmatch", "Password and Confirm password do not match");
            request.getRequestDispatcher("register.jsp").include(request, response);

        }

    }
}
