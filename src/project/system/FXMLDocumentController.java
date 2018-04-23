/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.system;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author mehulkothari
 */
public class FXMLDocumentController implements Initializable {
    static int uid;
     static PreparedStatement  prdstmt1;
    static String user;
   static Connection conn;
    String ip;
    Login login=new Login();
    AllSwitches allSwitches=new AllSwitches();
    @FXML
    private Label label;
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    Button loginbutton;
    
    
    

    
    
   
   /* public void check(ActionEvent event) {
       String user=username.getText();
       String pass=password.getText();
       System.out.println(user);
        try {
            Boolean check1=login.isLogin(user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn=DatabaseConnection.Connector();
        if(conn==null)
        {
            System.out.println("not connected");
        }
        else
            System.out.println("connected");
    }
     
    
     public void check(ActionEvent event) throws IOException {
          conn=DatabaseConnection.Connector();
        user=username.getText();
       String pass=password.getText();
       //uid=getuid(user);
       System.out.println(user);
        try {
            Boolean check1=login.isLogin(user, pass);
            Boolean check3=login.isLogintec(user,pass);
            if(check1 || check3)
            {
                
                 ip=allSwitches.getip();
                 if(check1)
                 uid=getui(user);
                 else
                     uid=getui1(user);
                  //uid=getuid(user);
                System.out.println(uid);
                
                //ip=allSwitches.getip();
                System.out.println(ip);
                
                     ResultSet rs=null;
        String sql = "update loggedin set loggedin=? " +
                   "where uid=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
preparedStatement.setString(1, ip);
preparedStatement.setInt(2, uid);
System.out.println("hello2");
//preparedStatement.setString(2, passwords);
//preparedStatement.setString(3, "Test3");
try{
preparedStatement.executeUpdate();
System.out.println("after update");
}catch(Exception e)
{
    System.out.println(e);
}
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage primaryStage=new Stage();
                FXMLLoader loader=new FXMLLoader();
                 Parent root = loader.load(getClass().getResource("Subjects.fxml").openStream());
                 SubjectsController subjectsController=(SubjectsController)loader.getController();
                //subjectsController.getUser(user);
                 Scene scene = new Scene(root);
        String css = this.getClass().getResource("ListStyle.css").toExternalForm(); 
        scene.getStylesheets().add(css);
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        
        System.out.println("leaving the class");
        
       // Scene scene = new Scene(root);
        // String css = this.getClass().getResource("page2.css").toExternalForm(); 
        //scene.getStylesheets().add(css);
        
        primaryStage.setScene(scene);
        primaryStage.show();
            }
           
            else{
                Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("Error Login");
alert.setHeaderText(null);
alert.setContentText("Add correct username and password");

alert.showAndWait();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     public static int getuid(String ip1) throws SQLException
     {
          conn=DatabaseConnection.Connector();
         System.out.println(ip1);
             //PreparedStatement  prdstmt1;
        prdstmt1 = null;
        ResultSet rs=null;
        String query="Select uid FROM loggedin WHERE loggedin= ?";
         System.out.println(ip1);
        
            prdstmt1=conn.prepareStatement(query);
            prdstmt1.setString(1,ip1);
             System.out.println(ip1);
            //prdstmt.setString(2, pass);
            rs=prdstmt1.executeQuery();
             System.out.println("before resultset");
              rs.next();
            int value=rs.getInt("uid");
            System.out.println(value);
            return value;
        
     }
      public int getui(String user1) throws SQLException
     {
          conn=DatabaseConnection.Connector();
         System.out.println();
             //PreparedStatement  prdstmt1;
        prdstmt1 = null;
        ResultSet rs=null;
        String query="Select uid FROM student WHERE username= ?";
         System.out.println(user);
        
            prdstmt1=conn.prepareStatement(query);
            prdstmt1.setString(1,user);
             System.out.println(user);
            //prdstmt.setString(2, pass);
            rs=prdstmt1.executeQuery();
             System.out.println("before resultset");
              rs.next();
            int value=rs.getInt("uid");
            System.out.println(value);
            return value;
        
     }
       public int getui1(String user1) throws SQLException
     {
          conn=DatabaseConnection.Connector();
         System.out.println();
             //PreparedStatement  prdstmt1;
        prdstmt1 = null;
        ResultSet rs=null;
        String query="Select uid FROM teacher WHERE username= ?";
         System.out.println(user);
        
            prdstmt1=conn.prepareStatement(query);
            prdstmt1.setString(1,user);
             System.out.println(user);
            //prdstmt.setString(2, pass);
            rs=prdstmt1.executeQuery();
             System.out.println("before resultset");
              rs.next();
            int value=rs.getInt("uid");
            System.out.println(value);
            return value;
        
     }
    
}
