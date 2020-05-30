package com.herald.usermgmt.controller;

import com.herald.usermgmt.model.User;
import com.herald.usermgmt.DAO.UserDAOimpl;
import com.herald.usermgmt.DAO.UserDAO;
import com.herald.usermgmt.model.History;
import com.herald.usermgmt.DAO.HistoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginRegister() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Initializing objects
        UserDAO cd = new UserDAOimpl();
        HistoryDAO hd = new HistoryDAO();
        History h = new History();

        //getting value from forms
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String name = request.getParameter("name");
        String security_question = request.getParameter("security_question");
        String submitType = request.getParameter("submit");

        //getting user details
        User u = cd.getUser(username, password);
        //validating user if user exists or not
        boolean validation = cd.validate(username, password);

        HttpSession session = request.getSession();

        if (submitType.equals("login")) {
            //checking whether user exist or not
            if (validation) {
                //storing users data in session
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("user", u);
                session.setAttribute("user_type", u.getUser_type());

                //checking whether user is admin or client
              
                    User u2 = cd.getUser(username, password);
                    h.setUser_id(u2.getId());
                    h.setUsername(u2.getUsername());
//                    h.setAdmin_username(u2.getUsername());
                    h.setAction("logged in");
                    
                    //action logged in recorded in histort table
                    hd.insertHistory(h);
                
                //redirected to HomeServlet
                response.sendRedirect("/UserMgmt/HomeServlet");
               
            } 
            //if user does not exist
            else {
                request.setAttribute("notmatch", "Username or password does not exist");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } else if (submitType.equals("register")) {
            if (password.equals(password2)) {
                u.setPassword(password);
                u.setUsername(username);
                u.setName(name);
                u.setSecurity_question(security_question);
                //user inserted
                cd.insertUser(u);
                //for history log
                User u2 = cd.getUser(username, password);
                h.setUser_id(u2.getId());
                h.setUsername(u2.getUsername());
                h.setAction("joined");
                //action joined recorded in history table
                hd.insertHistory(h);
                //shows succes message after registration
                request.setAttribute("successMessage", "Hey, " + u.getUsername() + " Registration Done, please login to continue ! ");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } 
            //when password and confirm password are different
            else {
                request.setAttribute("notmatch", "Password and Confirm password does not match");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } 
        //when admins create users
        else if (submitType.equals("create")) {
            if (password.equals(password2)) {
                u.setPassword(password);
                u.setUsername(username);
                u.setName(name);
                u.setSecurity_question(security_question);
                //User created
                cd.insertUser(u);

                //for history log
                User client = cd.getUser(username, password);
                h.setUser_id(client.getId());
                h.setUsername(client.getUsername());
                

                h.setAction("joined");
                //create action recorded in history along with new user and admin
                hd.insertHistory(h);

                request.setAttribute("successMessage", "Hey, " + u.getUsername() + " Registration Done, please login to continue ! ");
                response.sendRedirect("/UserMgmt/HomeServlet");
            } 
            //when password and confirm password are different
            else {
                request.setAttribute("notmatch", "Password and Confirm password does not match");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } 
        //for clients when they forget their password
        else if (submitType.equals("forgot")) {
            //checking sexurity question and validating user
            int validationForgot = cd.validateForgot(username, security_question);
            if (validationForgot != 0) {
                //forgot user details
                u.setUsername(username);
                request.setAttribute("forgotuser", u.getUsername());
                request.setAttribute("forgotuserid", validationForgot);
                //reset form
                request.getRequestDispatcher("reset.jsp").forward(request, response);

            } 
            //security question failed
            else {
                request.setAttribute("notmatch", "Username or security question does not match");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } else {

            request.setAttribute("message", "Data not found, click on Register ");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
