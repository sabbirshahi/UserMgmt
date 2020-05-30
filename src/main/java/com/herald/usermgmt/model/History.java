/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.model;

public class History {

    protected int id;
    private String action;
    private int user_id;
    private String username;
    private Object date;
    private Object time;
    
   

    public History() {
    }

    public History(Object date) {
        this.date = date;
    }

    public History(int id, String action, int user_id,String username, Object date, Object time) {
        this.id = id;
        this.action = action;
        this.user_id = user_id;
        this.date = date;
        this.time = time;
        this.username=username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    

}
