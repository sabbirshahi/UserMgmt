/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.registration;

import com.herald.usermgmt.block.Block;
import com.herald.usermgmt.block.BlockDAO;
import com.herald.usermgmt.historyLog.History;
import com.herald.usermgmt.historyLog.HistoryDAO;
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

@WebServlet("/HomeServlet")

public class HomeServlet extends HttpServlet {

    UserDAO cd;

    public void init() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);  //false doesnot create new session here

        UserDAO cd = new UserDAOimpl();

        if (session != null) {

            String sessionUsername = (String) session.getAttribute("username");
            String sessionPassword = (String) session.getAttribute("password");
            Object sessionUser = (Object) session.getAttribute("user");
            String sessionUserType = (String) session.getAttribute("user_type");
            System.out.println("homeservlet"+ session.getAttribute("user.getUsername()"));
            User u2 = cd.getUser(sessionUsername, sessionPassword);
            User demo = new User();
            demo.setUsername(sessionUsername);
            demo.setPassword(sessionPassword);
            demo.setUser_type(u2.getUser_type());
            String type = "client";

            request.setAttribute("message", " | ukername =" + u2.getUsername() + " |password =" + u2.getPassword() + " |Name =" + u2.getName() + " |type =" + u2.getUser_type() + " |security question =" + u2.getSecurity_question());
            request.setAttribute("username", u2.getUsername());
            request.setAttribute("name", u2.getName());
            request.setAttribute("user_type", u2.getUser_type());
            request.setAttribute("user_id", u2.getId());
            request.setAttribute("join_date", u2.getJoin_date());
            System.out.println(u2.getUsername() + " --updated username");
            System.out.print(u2.getImage() + " ---image url demo");
            request.setAttribute("image", u2.getImage().trim().trim());

            if (type.equals(u2.getUser_type())) {
                System.out.println("session logged in succes");
                System.out.println(sessionPassword);
                out.print("Hello, " + sessionUsername + " Welcome to Client Profile");
                try {

                    listClient(request, response);
                    totalUser(request, response);
                    totalBlockClient(request, response);
                    
                    HistoryDAO historyDA03 = new HistoryDAO();
        List<History> listClientDate = historyDA03.listClientDate(sessionUsername);
        request.setAttribute("listClientDate", listClientDate);
        
                    RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard-client.jsp");
                    dispatcher.forward(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(ListUser.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                System.out.println("session logged in succes");
                System.out.println(sessionPassword);
                out.print("Hello, " + sessionUsername + " Welcome to Admin Profile");

                try {

                    listClient(request, response);
            
                    totalUser(request, response);
                    totalBlockClient(request, response);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard-admin.jsp");
                    dispatcher.forward(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(ListUser.class.getName()).log(Level.SEVERE, null, ex);
                }
//              request.getRequestDispatcher("dashboard-admin.jsp").include(request, response); 
            }
        } else {
            out.print("Please login first");
            request.setAttribute("sessionLogin", "Please Login first");
            System.out.println("Please login first");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
        out.close();

    }

    private void listClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        UserDAO userDAO = new UserDAOimpl();
        List<User> listClient = userDAO.listClient();
        request.setAttribute("listClient", listClient);

        UserDAO adminDAO = new UserDAOimpl();
        List<User> listAdmin = userDAO.listAdmin();
        request.setAttribute("listAdmin", listAdmin);

        BlockDAO blockDAO = new BlockDAO();
        List<Block> listBlockClient = blockDAO.listBlockClient();
        request.setAttribute("listBlockClient", listBlockClient);
        
        HistoryDAO historyDA0 = new HistoryDAO();
        List<History> listHistory = historyDA0.listHistory();
        request.setAttribute("listHistory", listHistory);
        
        HistoryDAO historyDA02 = new HistoryDAO();
        List<History> listDate = historyDA0.listDate();
        request.setAttribute("listDate", listDate);

    }

    
    
    private void totalUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        UserDAO userDAO = new UserDAOimpl();

        request.setAttribute("totalClient", userDAO.totalClient());
        request.setAttribute("totalAdmin", userDAO.totalAdmin());
        System.out.println(userDAO.totalClient() + " < total");

    }

    private void totalBlockClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        BlockDAO blockDAO = new BlockDAO();

        request.setAttribute("totalBlockClient", blockDAO.totalBlockClient());
        System.out.println(blockDAO.totalBlockClient() + " < total");

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
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
            cd.insertUser(u);
            request.getRequestDispatcher("dashboard-admin.jsp").forward(request, response);
        }
    }

}
