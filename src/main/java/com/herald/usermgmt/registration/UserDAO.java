/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.registration;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Shahi
 */
public interface UserDAO {
    public int insertUser(User u);
    public User getUser(String user, String pass);
    public User getUser(int id);
  

    /**
     *
     * @param name
     * @param pass
     * @return
     */
    public boolean validate(String name, String pass);
    public int validateForgot(String name, String security);
    public List<User> listClient() throws SQLException;
     public List<User> listAdmin() throws SQLException;
    public int totalClient() throws SQLException;
    public int totalAdmin() throws SQLException;

    /**
     *
     * @param id
     * @return
     */
    public int deleteUser(int id);
    public boolean editUser(int id, User u);
    public boolean resetPassword(int id, User u);
   
}
