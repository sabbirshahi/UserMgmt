/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.block;

/**
 *
 * @author Shahi
 */
import com.herald.usermgmt.registration.UserDAO;
import com.herald.usermgmt.registration.UserDAOimpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/block")

public class BlockServlet extends HttpServlet {

    UserDAO cd = new UserDAOimpl();
    BlockDAO bd = new BlockDAO();

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
                bd.blockClient(id);

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
