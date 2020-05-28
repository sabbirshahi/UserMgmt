/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.block;

/**
 *
 * @author Shahi
 */
public class Block {
    protected int id;
    private String username;
    private String password;
    private String name;
    private String security_question;
    private String user_type;
    private Object join_date;

    public Object getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Object join_date) {
        this.join_date = join_date;
    }

    public Block(String username, String password, String name, String user_type, String security_question, Object join_date) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.security_question = security_question;
        this.user_type = user_type;
        this.join_date = join_date;
    }
    public Block(int id, String username, String name, String user_type, Object join_date){
          this.id = id;
          this.username = username;
        this.name = name;
        this.user_type = user_type;
        this.join_date = join_date;
    }
    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }


    public String getSecurity_question() {
        return security_question;
    }

    public void setSecurity_question(String security_question) {
        this.security_question = security_question;
    }
  public Block() {
    }
 
    public Block(int id) {
        this.id = id;
    }

  

    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
