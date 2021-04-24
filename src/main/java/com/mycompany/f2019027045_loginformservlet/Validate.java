
package com.mycompany.f2019027045_loginformservlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Arslan Shabbir
 */
public class Validate {
   public static boolean checkUser(String email,String pass) 
    {
        boolean st =false;
        try {
                
            Connection conn;
            
            String dbURL = "jdbc:sqlserver://DESKTOP-PJUCQ7K\\SQLEXPRESS;databaseName=arslan_04";
            String userName = "sa";
            String password = "arslan123";
            
            conn = DriverManager.getConnection(dbURL, userName, password);
            
            PreparedStatement ps = conn.prepareStatement("select * from tbl_login where email=? and pass=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            st = rs.next();
            

        }
        catch(SQLException ex) 
        
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return st;                 
    }   
}