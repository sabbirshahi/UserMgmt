/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.historyLog;


public class History {
    protected int id;
    private String action;
    private int client_id;
    private String client_username;
    private int admin_id;
    private String admin_username;
    private Object date;
    private Object time;
    
    public History(){}
    
     public History(Object date){
      this.date = date;
     }

    public History(int id, String action, int client_id, String client_username, int admin_id, String admin_username, Object date, Object time) {
        this.id = id;
        this.action = action;
        this.client_id = client_id;
        this.client_username = client_username;
        this.admin_id = admin_id;
        this.admin_username = admin_username;
        this.date = date;
        this.time = time;
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

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getClient_username() {
        return client_username;
    }

    public void setClient_username(String client_username) {
        this.client_username = client_username;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_username() {
        return admin_username;
    }

    public void setAdmin_username(String admin_username) {
        this.admin_username = admin_username;
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
