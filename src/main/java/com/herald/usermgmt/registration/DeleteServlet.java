/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.registration;

/**
 *
 * @author Shahi
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delete")

public class DeleteServlet extends HttpServlet {

    UserDAO cd = new UserDAOimpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Object sessionUser = (Object) session.getAttribute("user");
        String sessionUsername = (String) session.getAttribute("username");
        String sessionPassword = (String) session.getAttribute("password");
        String sessionUserType = (String) session.getAttribute("user_type");
        if (session != null) {
            if (sessionUserType.equals("admin")) {
                String sid = request.getParameter("id");
                int id = Integer.parseInt(sid);
                cd.deleteUser(id);
                response.sendRedirect("HomeServlet");
            } else {
                System.out.println("You donot have this Permission");
                request.setAttribute("editerror", "You do not have this permission");
                request.getRequestDispatcher("HomeServlet").include(request, response);
            }
        } else {
            request.setAttribute("sessionLogin", "You do not have this access");
            System.out.println("Please login first");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
    }
}
