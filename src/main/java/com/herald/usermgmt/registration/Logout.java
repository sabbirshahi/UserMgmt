/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.registration;

import com.herald.usermgmt.historyLog.History;
import com.herald.usermgmt.historyLog.HistoryDAO;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

@WebServlet("/Logout")

public class Logout extends HttpServlet {  
    UserDAO cd = new UserDAOimpl();
     HistoryDAO hd = new HistoryDAO();
        History h = new History();
        protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {   
                response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
              
            request.getRequestDispatcher("register.jsp").include(request, response);  
              
            HttpSession session=request.getSession(); 
            String sessionUsername = (String) session.getAttribute("username");
            String sessionPassword = (String) session.getAttribute("password");
           
            User u = cd.getUser(sessionUsername, sessionPassword);
            if(u.getUser_type().equals("admin")){
                h.setAdmin_id(u.getId());
                h.setAdmin_username(u.getUsername());
                h.setAction("logged of");
                hd.insertHistoryAdmin(h);
            }else{
                h.setClient_id(u.getId());
                h.setClient_username(u.getUsername());
                h.setAction("logged of");
                hd.insertHistory(h);
            }
            
            
            session.invalidate();  

              
//            out.print("You are successfully logged out!");  
            System.out.println("Session ended !");
              
            out.close();  
    }  
}  