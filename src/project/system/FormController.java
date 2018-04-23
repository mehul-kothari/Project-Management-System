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
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mehulkothari
 */
public class FormController implements Initializable {
    AllSwitches allSwitches=new AllSwitches();
//    Page2Controller p2=new Page2Controller();
    Stage primarystage;
    Parent p1;
    Connection conn;
     String names;
    String passwords;
    @FXML
    public  TextField name1;
    @FXML
    TextField password1;
    @FXML
    AnchorPane pane2;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
      
        // TODO
    }
    public StringProperty newLblText() { 
    return name1.textProperty();
}
    
    public void submit(ActionEvent event) throws SQLException, IOException
    {
        Boolean check;
        names=name1.getText();
        passwords=password1.getText();
        conn=DatabaseConnection.Connector();
        System.out.println("hi");
        String s=allSwitches.getip();
        int z=FXMLDocumentController.getuid(s);
        if(!(names.isEmpty()))
        check=checkForSameGroupName(names);
        else
            check=false;
       if(check)
       {
             Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Error selecting group name");
alert.setHeaderText(null);
alert.setContentText("groupname already selected please choose another one");
alert.showAndWait();
name1.clear();
       }
       else{
        //FXMLLoader loader=new FXMLLoader();
      // FXMLDocumentController fXMLDocumentController=(FXMLDocumentController)loader.getController();
        //System.out.println(allSwitches.getip());
       // String s=allSwitches.getip();
        //int z=FXMLDocumentController.getuid(s);
System.out.println(z);
        ResultSet rs=null;
        PreparedStatement preparedStatement=null;
 try{
     
        // Stage primaryStage1=new Stage();
          ((Node)event.getSource()).getScene().getWindow().hide();
                //FXMLLoader loader=new FXMLLoader();
                System.out.println("whtasup");
                 String sql = "INSERT into create_group(uid,groupname,subject) " +
                   "values(?,?,?)";
         preparedStatement = conn.prepareStatement(sql);
preparedStatement.setInt(1, z);
preparedStatement.setString(2, names);
//preparedStatement.setString(3, passwords);
preparedStatement.setString(3, SubjectsController.subject);
//int z=fXMLDocumentController.getuid(allSwitches.getip());
//System.out.println(z);
//preparedStatement.setInt(3, z);
//preparedStatement.setString(3, "Test3");
preparedStatement.executeUpdate(); 
  sql = "INSERT into groupinfo(groupname,password) " +
                   "values(?,?)";
         preparedStatement = conn.prepareStatement(sql);
preparedStatement.setString(1, names);
preparedStatement.setString(2, passwords);
//int z=fXMLDocumentController.getuid(allSwitches.getip());
//System.out.println(z);
//preparedStatement.setInt(3, z);
//preparedStatement.setString(3, "Test3");
preparedStatement.executeUpdate(); 
 sql = "INSERT into submit(groupname,subject) values(?,?)";
  preparedStatement = conn.prepareStatement(sql);
preparedStatement.setString(1, names);
preparedStatement.setString(2, SubjectsController.subject);
preparedStatement.executeUpdate(); 
               
                
               // p2.submit2(FXMLLoader.load(FormController.class.getResource("page2(2).fxml")));
                 //pane2 = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                 /*System.out.println(pane2);
                 Scene scene=new Scene(pane2);
                  System.out.println(scene);
                 String css = this.getClass().getResource("MainList.css").toExternalForm(); 
        scene.getStylesheets().add(css);
                  System.out.println( SubjectsController.primaryStage.getScene());
                  primarystage=SubjectsController.primaryStage;
                 primarystage.setScene(scene);
                //p1.getChildren().setAll(FXMLLoader.load("page2(2).fxml"));
                 System.out.println("hi");
                 //Page2Controller page2Controller=new Page2Controller();
                // page2Controller.page2controller(names, passwords);
                 System.out.println("hi");
                 //page2Controller.getUser(user);
        //String css = this.getClass().getResource("user.css").toExternalForm(); 
        //scene.getStylesheets().add(css);
        
      //  Scene scene = new Scene(root);
        // String css = this.getClass().getResource("").toExternalForm(); 
        //scene.getStylesheets().add(css);
        
      //  primarystage.setScene(scene);
        //primarystage.show();*/
((Node)event.getSource()).getScene().getWindow().hide();
                Stage primaryStage=new Stage();
                FXMLLoader loader=new FXMLLoader();
                 Parent root = loader.load(getClass().getResource("MainPage.fxml").openStream());
                 MainPageController mainPageController=(MainPageController)loader.getController();
                //subjectsController.getUser(user);
                 Scene scene = new Scene(root);
        String css = this.getClass().getResource("MainList.css").toExternalForm(); 
        scene.getStylesheets().add(css);
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        
       // Scene scene = new Scene(root);
        // String css = this.getClass().getResource("page2.css").toExternalForm(); 
        //scene.getStylesheets().add(css);
        
        primaryStage.setScene(scene);
        primaryStage.show();
     
        }catch(Exception e)
        {
            System.out.println(e);
        }
//rs=preparedStatement.executeQuery();
/*if(rs.next())
{
    System.out.println("database updated");
}
else
    System.out.println("database fail to update");
    }*/
    
}
    }

    void submit1(Stage primaryStage1) {
        System.out.println(primaryStage1);
        primarystage=primaryStage1;
        //primarystage=primaryStage1;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void filldetails(String name2,String password2) {
       System.out.println(name2);
        name1.setText(name2);
        password1.setText(password2);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean checkForSameGroupName(String names) throws SQLException {
        ResultSet rs=null;
        String sql = "select groupname from form where groupname=?" ;
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
preparedStatement.setString(1, names);
 rs=preparedStatement.executeQuery();
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
//preparedStatement.setString(2, names);
        
                   
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
