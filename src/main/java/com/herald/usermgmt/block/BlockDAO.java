/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.block;

/**
 *
 * @author Shahi
 */import com.herald.usermgmt.config.MySqlCon;
import com.herald.usermgmt.registration.UserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class BlockDAO {
        static Connection con;
    static PreparedStatement ps, ps2;
    

    public int[] blockClient(int id){  
        int []status =null;  

        try{  
             con = MySqlCon.getConnection(); 
                Statement s = con.createStatement();
                String s1 = "INSERT INTO block (SELECT * FROM user WHERE user_id = "+id+" )";
                String s2 = "DELETE FROM user WHERE user_id ="+id;  
                s.addBatch(s1);
                s.addBatch(s2);     
                status=s.executeBatch();
            
            con.close();

        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    
        public int[] unblockClient(int id){  
        int []status =null;  

        try{  
             con = MySqlCon.getConnection(); 
                Statement s = con.createStatement();
                String s1 = "INSERT INTO user (SELECT * FROM block WHERE user_id = "+id+" )";
                String s2 = "DELETE FROM block WHERE user_id ="+id;  
                s.addBatch(s1);
                s.addBatch(s2);     
                status=s.executeBatch();
            
            con.close();

        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    
        public List<Block> listBlockClient() throws SQLException {
        List<Block> listBlockClient = new ArrayList<>();
        String client = "client";
        String sql = "SELECT * FROM block where user_type=? ";

        con = MySqlCon.getConnection();

        ps = con.prepareStatement(sql);
        ps.setString(1, client);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("user_id");
            String username = resultSet.getString("username");
            String name = resultSet.getString("name");
            String user_type = resultSet.getString("user_type");
            Object join_date = resultSet.getObject("join_date");
            Block blockUser = new Block(id, username, name, user_type, join_date);
            listBlockClient.add(blockUser);
        }

        resultSet.close();
        return listBlockClient;
    }
        
            public int totalBlockClient() throws SQLException {
        int totaluser = 0;

        String sql = "SELECT COUNT(*) FROM block ";

        con = MySqlCon.getConnection();

        ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            totaluser = rs.getInt("count(*)");
        }

        con.close();
        return totaluser;
    }

    
}


