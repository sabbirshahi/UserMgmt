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
import com.herald.usermgmt.historyLog.History;
import com.herald.usermgmt.historyLog.HistoryDAO;
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
    HistoryDAO hd = new HistoryDAO();
        History h = new History();

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
                
                //for history log
                User client = cd.getUser(id);
                h.setClient_id(client.getId());
                h.setClient_username(client.getUsername());
                
                String admin_username = (String) session.getAttribute("username");
                String admin_password = (String) session.getAttribute("password");
                
                User admin = cd.getUser(admin_username, admin_password);
                h.setAdmin_id(admin.getId());
                h.setAdmin_username(admin.getUsername());
                h.setAction("delete");
                
                hd.insertHistory(h, admin.getId());
                
                cd.deleteUser(id);
                response.sendRedirect("HomeServlet");
            } else {
                System.out.println("You donot have this Permission");
                request.setAttribute("permission", "You do not have this permission");
                request.getRequestDispatcher("HomeServlet").include(request, response);
            }
        } else {
            request.setAttribute("sessionLogin", "You do not have this access");
            System.out.println("Please login first");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
    }
}
