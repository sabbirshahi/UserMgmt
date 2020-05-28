package com.herald.usermgmt.registration;

import com.herald.usermgmt.historyLog.History;
import com.herald.usermgmt.historyLog.HistoryDAO;
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
        UserDAO cd = new UserDAOimpl();
        HistoryDAO hd = new HistoryDAO();
        History h = new History();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String name = request.getParameter("name");
        String security_question = request.getParameter("security_question");
        String submitType = request.getParameter("submit");
        
        User u = cd.getUser(username, password);
        boolean validation = cd.validate(username, password);
        
        

        HttpSession session = request.getSession();
        if (session != null) {
            System.out.println("Session with out login ");
        }

        if (submitType.equals("login")) {
            if (validation) {
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("user", u);
                session.setAttribute("user_type", u.getUser_type());
                
                if(u.getUser_type().equals("admin")){
                    User u2 = cd.getUser(username, password);
                h.setAdmin_id(u2.getId());
                h.setAdmin_username(u2.getUsername());
                h.setAction("logged in");
                hd.insertHistoryAdmin(h);
                }else{
                    User u2 = cd.getUser(username, password);
                h.setClient_id(u2.getId());
                h.setClient_username(u2.getUsername());
                h.setAction("logged in");
                hd.insertHistory(h);
                }
                
                
                response.sendRedirect("/UserMgmt/HomeServlet");
                if (session != null) {
                    System.out.println("Session started !");
                }
            } else {
                request.setAttribute("notmatch", "Username or password does not exist");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } else if (submitType.equals("register")) {
            if (password.equals(password2)) {
                u.setPassword(password);
                u.setUsername(username);
                u.setName(name);
                u.setSecurity_question(security_question);
                
                
                
                cd.insertUser(u);
                //for history log
                User u2 = cd.getUser(username, password);
                h.setClient_id(u2.getId());
                h.setClient_username(u2.getUsername());
                h.setAction("joined");
                hd.insertHistory(h);
                
                

                request.setAttribute("successMessage", "Hey, " + u.getUsername() + " Registration Done, please login to continue ! ");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else {
                request.setAttribute("notmatch", "Password and Confirm password does not match");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } else if (submitType.equals("create")) {
            if (password.equals(password2)) {
                u.setPassword(password);
                u.setUsername(username);
                u.setName(name);
                u.setSecurity_question(security_question);
                cd.insertUser(u);
                
                //for history log
                User client = cd.getUser(username, password);
                h.setClient_id(client.getId());
                h.setClient_username(client.getUsername());
                
                String admin_username = (String) session.getAttribute("username");
                String admin_password = (String) session.getAttribute("password");
                
                User admin = cd.getUser(admin_username, admin_password);
                h.setAdmin_id(admin.getId());
                h.setAdmin_username(admin.getUsername());
                h.setAction("create");
                
                hd.insertHistory(h, admin.getId());
                
                request.setAttribute("successMessage", "Hey, " + u.getUsername() + " Registration Done, please login to continue ! ");
                response.sendRedirect("/UserMgmt/HomeServlet");
            } else {
                request.setAttribute("notmatch", "Password and Confirm password does not match");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } else if (submitType.equals("forgot")) {
             int validationForgot = cd.validateForgot(username, security_question);
             if (validationForgot != 0) {
                u.setUsername(username);
                request.setAttribute("forgotuser", u.getUsername());
                request.setAttribute("forgotuserid", validationForgot);
                request.getRequestDispatcher("reset.jsp").forward(request, response);
               
            } else {
                request.setAttribute("notmatch", "Username or security question does not match");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } 
        else {

            request.setAttribute("message", "Data not found, click on Register haha");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
