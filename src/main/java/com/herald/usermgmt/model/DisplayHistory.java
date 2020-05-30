/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.model;

/**
 *
 * @author Shahi
 */
public class DisplayHistory {
    
     protected int h_id;
    private String action;
    private int user_id;
    private Object date;
    private Object time;

      protected int u_id;
    private String username;
    private String password;
    private String name;
    private String security_question;
    private String user_type;
    private String image;
    private Object join_date;

    public DisplayHistory(int h_id, String action, int user_id, Object date, Object time, int u_id, String username,  String name, String security_question, String user_type, String image, Object join_date) {
        this.h_id = h_id;
        this.action = action;
        this.user_id = user_id;
        this.date = date;
        this.time = time;
        this.u_id = u_id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.security_question = security_question;
        this.user_type = user_type;
        this.image = image;
        this.join_date = join_date;
    }

    public int getH_id() {
        return h_id;
    }

    public void setH_id(int h_id) {
        this.h_id = h_id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public Object getTime() {
        return time;
    }

    public void setTime(Object time) {
        this.time = time;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecurity_question() {
        return security_question;
    }

    public void setSecurity_question(String security_question) {
        this.security_question = security_question;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Object join_date) {
        this.join_date = join_date;
    }
    
    
    
}
