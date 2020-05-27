/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herald.usermgmt.image;

import com.herald.usermgmt.block.Block;
import com.herald.usermgmt.config.MySqlCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shahi
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Shahi
 */import com.herald.usermgmt.config.MySqlCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class ImageDAO {
        static Connection con;
    static PreparedStatement ps;
    

    
         public int insertImg(int id, String path) {
        int status = 0;
        try {
            con = MySqlCon.getConnection();
            ps = con.prepareStatement("UPDATE `user` SET `image`=' "+path+" ' WHERE user_id = "+id);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
         
//        public String imagePath() throws SQLException {
//        String imagePath = "";
//            try {
//        String sql = "SELECT img FROM image where id = '1' ";
//
//        con = MySqlCon.getConnection();
//        ps = con.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        
//        while (rs.next()) {
//            imagePath = rs.getString("img");
//        }
//        
//          con.close();
// } catch (SQLException e) {
//            System.out.println(e);
//        }
//      
//        return imagePath;
//    }
        

    
}



