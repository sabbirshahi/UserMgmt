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
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String submitType = request.getParameter("submit");
        User u= cd.getUser(id); 
         if(password .equals(password2)){
                u.setPassword(password);
              cd.resetPassword(id, u);
request.setAttribute("successMessage", "Hey, " + u.getUsername() + " Password changed, please login to continue ! ");
request.getRequestDispatcher("register.jsp").include(request, response); 
            }
         else{
             System.out.println( "Password and Confirm password do not match");
             request.setAttribute("notmatch", "Password and Confirm password do not match");
request.getRequestDispatcher("register.jsp").include(request, response); 

         }
          
    }
}
