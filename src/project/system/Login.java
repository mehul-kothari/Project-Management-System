/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.system;

import com.sun.corba.se.impl.logging.ORBUtilSystemException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mehulkothari
 */
public class Login {
    Connection conn=null;
    public boolean isLogin(String username, String pass) throws SQLException
    {
        conn=DatabaseConnection.Connector();
        PreparedStatement prdstmt=null;
        ResultSet rs=null;
        String query="Select * FROM student WHERE username= ? and password= ?";
        try {
            prdstmt=conn.prepareStatement(query);
            prdstmt.setString(1, username);
            prdstmt.setString(2, pass);
            rs=prdstmt.executeQuery();
            if(rs.next())
            {
                System.out.println("true");
                return true;
            }
            else
            {
                System.out.println("false");
                return false;
            }
            
        } catch (Exception e) {
           System.out.println(e);
            return false;
        }
        finally{
            prdstmt.close();
            rs.close();
        }
        
        
    }

    public boolean isLogintec(String username, String pass) throws SQLException
    {
        conn=DatabaseConnection.Connector();
        PreparedStatement prdstmt=null;
        ResultSet rs=null;
        String query="Select * FROM teacher WHERE username= ? and password= ?";
        try {
            prdstmt=conn.prepareStatement(query);
            prdstmt.setString(1, username);
            prdstmt.setString(2, pass);
            rs=prdstmt.executeQuery();
            if(rs.next())
            {
                System.out.println("true");
                return true;
            }
            else
            {
                System.out.println("false");
                return false;
            }
            
        } catch (Exception e) {
           System.out.println(e);
            return false;
        }
        finally{
            prdstmt.close();
            rs.close();
        }
        
        
    }

    boolean firsttimelogin(String s) throws SQLException {
        System.out.println(s);
         conn=DatabaseConnection.Connector();
          PreparedStatement prdstmt=null;
        ResultSet rs=null;
        String query="Select * FROM loggedin WHERE loggedin=?";
        try {
            prdstmt=conn.prepareStatement(query);
            prdstmt.setString(1,s);
            //prdstmt.setString(2, pass);
            rs=prdstmt.executeQuery();
            if(rs.next())
            {
                System.out.println("true");
                return true;
            }
            else
            {
                System.out.println("false");
                System.out.println("false");
                return false;
            }
            
        } catch (Exception e) {
           System.out.println(e);
            return false;
        }
        finally{
            prdstmt.close();
            rs.close();
        }
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
