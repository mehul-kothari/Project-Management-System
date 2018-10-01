/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mehulkothari
 */
//database connector class
public class DatabaseConnection {
    public static Connection Connector() {
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println ("Database connection established");
         //   Connection conn; 
            conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/logindb","root","");
           // conn = DriverManager.getConnection("jdbc::sqlite:C://Users/mehulkothari/Documents/NetBeansProjects/user.sqlite");
             System.out.println("hi");
             System.out.println(conn);
            return conn;
        } catch (Exception e) {
            System.out.println(e);
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
       // return conn;
    }
    
}
