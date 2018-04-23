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
//import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static project.system.FXMLDocumentController.conn;
import static project.system.FXMLDocumentController.prdstmt1;

/**
 * FXML Controller class
 *
 * @author mehulkothari
 */
public class SubjectsController implements Initializable  {
   static Stage primaryStage;
   AllSwitches allSwitches=new  AllSwitches();
    static String collegeclass,subject;
    @FXML
    AnchorPane pane2;
    String branch,class1;
    @FXML
    ListView<String> subjects;
    @FXML
    ListView<String> classes;
    FormController formController=new FormController();
    int uid1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    // subjects = new ListView<>();
        try{
          conn=DatabaseConnection.Connector();
         String ip= allSwitches.getip();
          uid1=FXMLDocumentController.getuid(ip);
        prdstmt1 = null;
        ResultSet rs=null;
        String query;
        if(uid1<100){
         query="Select branch,class FROM student WHERE uid= ?";
        }
        else{
             query="Select branch,class FROM teacher_subjects WHERE uid= ?";
        }
            System.out.println("before selecting branch");
      
           prdstmt1=conn.prepareStatement(query);
       
            prdstmt1.setInt(1, uid1);
            rs=prdstmt1.executeQuery();
            System.out.println("after selecting branch");
            ObservableList<String> items =FXCollections.observableArrayList ();
             while(rs.next()){
             branch=rs.getString("branch");
            System.out.println(branch);
             class1=rs.getString("class");
             
             items.add(class1 + " " + branch);
        
             }
             classes.setItems(items);
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    
        
        
        
        // TODO
    }
    @FXML
    public void selectClass(MouseEvent event)
    {
        try{
            System.out.println("hello evergi");
        //collegeclass=classes.getSelectionModel().getSelectedItem();
        //System.out.println(collegeclass);
       printSubjectList();
        //System.out.println(collegeclass);
        //((Node)event.getSource()).getScene().getWindow().hide();
                /*primaryStage=new Stage();
                FXMLLoader loader=new FXMLLoader();
                 Parent root = loader.load(getClass().getResource("page2.fxml").openStream());
                 Page2Controller page2Controller=(Page2Controller)loader.getController();
                //page2.getUser(user);
       // String css = this.getClass().getResource("page2.css").toExternalForm(); 
        //scene.getStylesheets().add(css);
        
        Scene scene = new Scene(root);
         String css = this.getClass().getResource("page2.css").toExternalForm(); 
        scene.getStylesheets().add(css);
        
        primaryStage.setScene(scene);
        primaryStage.show();*/
        formController.submit1(primaryStage);
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    private void printSubjectList() throws SQLException {
        int flag=0;
         Connection conn=DatabaseConnection.Connector();
        class1=classes.getSelectionModel().getSelectedItem();
        System.out.println(class1);
        if(class1.equalsIgnoreCase("FE comps"))
        {
            if(uid1<100)
            {
                
            
            ObservableList<String> items1 =FXCollections.observableArrayList ( "BEE", "MECHANICAL", "PHYSICS", "CHEMISTRY");
            subjects.setItems(items1);
            }
            else{
                String query="Select subjects from teacher_subjects where uid=? and class=? and branch=?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, uid1);
         preparedStatement.setString(2, "FE");
          preparedStatement.setString(3, "comps");
          ObservableList<String> items1 =FXCollections.observableArrayList ();
        
//preparedStatement.setInt(1, uid);
ResultSet rs=null;
 rs=preparedStatement.executeQuery();
 while(rs.next()){
     items1.add(rs.getString(1));
 }
 subjects.setItems(items1);

            }
            
            
            
           
        }
        else if(class1.equalsIgnoreCase("TE comps"))
        {
            if(uid1<100)
            {
                   ObservableList<String> items1 =FXCollections.observableArrayList ( "SOAAD", "OS", "WT", "MP");
                    subjects.setItems(items1);
            }
            else{
                String query="Select subjects from teacher_subjects where uid=? and class=? and branch=?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, uid1);
         preparedStatement.setString(2, "TE");
          preparedStatement.setString(3, "comps");
          ObservableList<String> items1 =FXCollections.observableArrayList ();
        
//preparedStatement.setInt(1, uid);
ResultSet rs=null;
 rs=preparedStatement.executeQuery();
 while(rs.next()){
     items1.add(rs.getString(1));
 }
 subjects.setItems(items1);

            }
        }
         else if(class1.equalsIgnoreCase("FE it"))
        {
            if(uid1<100)
            {
                   ObservableList<String> items1 =FXCollections.observableArrayList ("BEE", "MECHANICAL", "PHYSICS", "CHEMISTRY");
                    subjects.setItems(items1);
            }
            else{
                String query="Select subjects from teacher_subjects where uid=? and class=? and branch=?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, uid1);
         preparedStatement.setString(2, "FE");
          preparedStatement.setString(3, "it");
          ObservableList<String> items1 =FXCollections.observableArrayList ();
        
//preparedStatement.setInt(1, uid);
ResultSet rs=null;
 rs=preparedStatement.executeQuery();
 while(rs.next()){
     items1.add(rs.getString(1));
 }
 subjects.setItems(items1);

            }
        }
           
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @FXML
    public void gotologin(ActionEvent event) throws IOException, SQLException
    {
        System.out.println("hello");
        ((Node)event.getSource()).getScene().getWindow().hide();
        allSwitches.logininterface(new Stage());
        /* ((Node)event.getSource()).getScene().getWindow().hide();
       // allSwitches.logininterface(primaryStage
        Stage stage=new Stage();
         Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        //String css = this.getClass().getResource("user.css").toExternalForm(); 
        //scene.getStylesheets().add(css);
        
        Scene scene = new Scene(root);
         String css = this.getClass().getResource("user.css").toExternalForm(); 
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.show();*/
    }
   public void selectSubject(MouseEvent event) throws IOException, SQLException
   {
       subject=subjects.getSelectionModel().getSelectedItem();
       if(uid1<100){
       System.out.println(subject);
       String s=allSwitches.getip();
       Connection conn=DatabaseConnection.Connector();
        int uid=FXMLDocumentController.getuid(s);
       String sql="select uid from create_group where subject=?";
       
       //String sql="select create_group.uid,join_group.uid,create_group.subject from create_group Inner JOIN join_group on create_group.groupname = join_group.groupname";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, subject);
//preparedStatement.setInt(1, uid);
ResultSet rs=null;
int flag2=0;
int flag1=0;
 rs=preparedStatement.executeQuery();
 int flag=0;
 while(rs.next()){
     System.out.println("inside select subjects"+rs.getInt(1));
 if(rs.getInt(1)==uid)
 {
     System.out.println("it is there in create group");
     flag1=1;
     break;
 }
 System.out.println(flag1);
 }
if(flag1==0)
{
      sql="select uid from join_group where subject=?";
      PreparedStatement preparedStatement1 = conn.prepareStatement(sql);
       preparedStatement1.setString(1, subject);
        rs=null;

 rs=preparedStatement1.executeQuery();
 while(rs.next()){
     System.out.println("inside select subjects1"+rs.getInt(1));
     if(rs.getInt(1)==uid)
 {
     System.out.println("it is there in join group");
     flag2=1;
     break;
 }
}
}
 
 
/*int uid2=rs.getInt(2);
 String value=rs.getString(3);
 if((uid1==uid && subject.equals(value)) || (uid2==uid && subject.equals(value)))
 {
     System.out.println("already created group in this subject");
     flag=1;
     break;
 }*/
 //}
 if(flag1==1 || flag2==1){
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
     
 }
 else{
 
//preparedStatement.setString(2, names);
//int z=fXMLDocumentController.getuid(allSwitches.getip());
//System.out.println(z);
//preparedStatement.setInt(3, z);
//preparedStatement.setString(3, "Test3");
       ((Node)event.getSource()).getScene().getWindow().hide();
       allSwitches.gotopage2(new Stage());
 }
   }
   
   else{
    ((Node)event.getSource()).getScene().getWindow().hide();
                Stage primaryStage=new Stage();
                FXMLLoader loader=new FXMLLoader();
                 Parent root = loader.load(getClass().getResource("MainPage1.fxml").openStream());
                 MainPage1Controller mainPageController=(MainPage1Controller)loader.getController();
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
    
}
   }
    
}
