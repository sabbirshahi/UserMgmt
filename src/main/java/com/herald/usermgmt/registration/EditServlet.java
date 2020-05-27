/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/edit")

public class EditServlet extends HttpServlet {

    UserDAO cd;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Object sessionUser = (Object) session.getAttribute("user");
        String sessionUsername = (String) session.getAttribute("username");
        String sessionPassword = (String) session.getAttribute("password");
        String sessionUserType = (String) session.getAttribute("user_type");

        System.out.println("userType= " + sessionUserType);

        sessionUser.getClass();

        if (session != null ) {

            System.out.println(sessionUser + " user object in session| " + sessionUsername + " |username");
            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);
            cd = new UserDAOimpl();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String password2 = request.getParameter("password2");
            String name = request.getParameter("name");
            String security_question = request.getParameter("security_question");
            String submitType = request.getParameter("submit");
            User u = cd.getUser(username, password);
            if (password.equals(password2)) {
                u.setPassword(password);
                u.setUsername(username);
                u.setName(name);
                u.setSecurity_question(security_question);
                cd.editUser(id, u);
                session.setAttribute("username", username);
                session.setAttribute("password", password);
//            User u2 = cd.getUser(username, password);
                response.sendRedirect("HomeServlet");
            } else {
                System.out.println("Password and Confirm password do not match");
                request.setAttribute("editerror", "Password and Confirm password do not match");
                request.getRequestDispatcher("HomeServlet").include(request, response);

            }

        } else {
            request.setAttribute("sessionLogin", "You do not have this access");
            System.out.println("Please login first");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
    }
}
