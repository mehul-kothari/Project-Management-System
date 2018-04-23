/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.system;

import com.mysql.jdbc.ResultSet;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static project.system.FXMLDocumentController.prdstmt1;

/**
 * FXML Controller class
 *
 * @author mehulkothari
 */
public class MainPage1Controller implements Initializable {
    
     @FXML
    ListView<String> choices;
     String choice;
     AllSwitches allSwitches=new AllSwitches();
     @FXML
    AnchorPane pane1;
     @FXML
    AnchorPane panemain;
      @FXML
    AnchorPane pane2;
      @FXML
    AnchorPane panesubmit;
     @FXML
     SplitPane split;
      @FXML
     TextArea text1;
      Scene scene;
      @FXML
    Button send1;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<String> items =FXCollections.observableArrayList ("View projects","Make Notes","Read messages");
            choices.setItems(items);
           choices.scrollTo(0);
        choices.getSelectionModel().select(0);
        pane1.getChildren().remove(pane2);
        
         scene=new Scene(pane1);
        
        // TODO
    }
     @FXML
    public void selectChoice(MouseEvent event) throws IOException, SQLException
    {
         choice=choices.getSelectionModel().getSelectedItem();
           if(choice.equalsIgnoreCase("View Projects"))
            {
               viewprojects();
            }
           if(choice.equalsIgnoreCase("make notes"))
           {
               makenotes();
           }
            /*if(choice.equalsIgnoreCase("Read messages"))
            {
                readmessages();
            }*/
    }
    public void viewprojects() throws SQLException
    {
         VBox vBox=new VBox(20);
        PreparedStatement preparedStatement=null;
        PreparedStatement preparedStatement1=null;
        
    ResultSet rs=null;
    Connection conn=DatabaseConnection.Connector();
    System.out.println(SubjectsController.subject);
        //String s=allSwitches.getip();
             //z=FXMLDocumentController.getuid(s);
        String sql="Select groupname from create_group where subject=?";
                preparedStatement=conn.prepareStatement(sql);
                //preparedStatement.setInt(1, z);
                 preparedStatement.setString(1, SubjectsController.subject);
                rs=(ResultSet) preparedStatement.executeQuery();
                while(rs.next())
                {      
                    System.out.println(rs.getString(1));
                    ResultSet rs1=null;
                    String query1="Select done from submit where groupname=? and subject=?";
                    preparedStatement1=conn.prepareStatement(query1);
                    preparedStatement1.setString(1,rs.getString(1));
                    preparedStatement1.setString(2,SubjectsController.subject);
                    rs1=(ResultSet) preparedStatement1.executeQuery();
                    rs1.next();
                    String done="done";
                    String query2;
                    ResultSet rs3=null;
                    PreparedStatement pre=null;
                    if(rs1.getString(1).equals(done))
                    {
                        System.out.println(rs1.getString(1));
                        query2="Select filename from upload where groupname=?";
                pre=conn.prepareStatement(query2);
                pre.setString(1,rs.getString(1));
                rs3=(ResultSet) pre.executeQuery();
            if(rs3.next()){
                System.out.println(rs3.getString(1));
            
            String file4=rs3.getString(1);
            Hyperlink link = new Hyperlink(file4);
            File file1=new File(file4);
            //pane2.getChildren().add(link);
link.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                   if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }
        
        Desktop desktop = Desktop.getDesktop();
        if(file1.exists()) try {
            desktop.open(file1);
                   } catch (IOException ex) {
                       Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
                   }
        
        //let's try to open PDF file
      
                }
            });
HBox hbox = new HBox(100);
                    String label1=rs.getString(1);
                    Label label=new Label(label1);
                    hbox.getChildren().add(label);
                hbox.getChildren().add(link);
                vBox.getChildren().add(hbox);
                

            
            }}
                }
                panemain.getChildren().add(vBox);
                pane1.getChildren().remove(pane2);
                pane1.getChildren().add(panemain);
                
                    }
public void makenotes() throws SQLException, IOException
{
    
    /*pane4.getChildren().remove(pane2);
          pane4.getChildren().remove(pane10);
         pane3.getChildren().remove(pane5);
          pane4.getChildren().add(pane3);*/
          //Stage primaryStage=new Stage();
    System.out.println(pane1.getChildren());
    System.out.println(pane2.getChildren());
    pane2.getChildren().remove(panesubmit);
    System.out.println(pane2.getChildren());
    pane1.getChildren().remove(panemain);
    pane1.getChildren().add(pane2);
    System.out.println(pane1.getChildren());
    VBox vBox = null;
          ResultSet rs=null;
                FXMLLoader loader=new FXMLLoader();
                Group root=new Group();
                //Scene scene=new Scene(root, 400, 500);
                 //Parent root = loader.load(getClass().getResource("ViewGroup.fxml"));
                 //Page2Controller page2Controller=(Page2Controller)loader.getController();
                //page2.getUser(user);
       // String css = this.getClass().getResource("page2.css").toExternalForm(); 
        //scene.getStylesheets().add(css);
        
       // Scene scene = new Scene(root);
          Connection conn=DatabaseConnection.Connector();
          PreparedStatement prdstmt = null;
         //ResultSet rs=null;
        String query="SELECT groupname FROM create_group where subject=?";
         //System.out.println(ip1);
                System.out.println(SubjectsController.subject);
            String s=allSwitches.getip();
             int z=FXMLDocumentController.getuid(s);
            prdstmt=conn.prepareStatement(query);
            prdstmt.setString(1, SubjectsController.subject);
             rs=(ResultSet) prdstmt.executeQuery();
             vBox=new VBox(20);
             while(rs.next())
             {
                String group1=rs.getString(1);
                System.out.println(group1);
                
             
            
            
             
            
            Button[] btn = new Button[10];
            int i=0;
            //prdstmt1.setString(1,ip1);
            //System.out.println(ip1);
            //prdstmt.setString(2, pass);
           
                System.out.println("inside rs.next");
                HBox hbox = new HBox(100);
                String label1=rs.getString(1);
                //String label2=Integer.toString(label1);
                Label label=new Label(label1);
                 btn[i]=new Button("message");
                 text1.setWrapText(true);
                 btn[i].setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
       
         pane2.getChildren().add(panesubmit);
         try{
        pane1.getChildren().add(pane2);
         }catch(Exception e1)
         {
             System.out.println(e1);
         }
        Stage primStage=new Stage();
       primStage.setScene(scene);
       String s1=text1.getText();
     
           
       
       send1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event)  {
                String s1=text1.getText();
                pane2.getChildren().remove(panesubmit);
                
                String query="Insert into teacher_students(from_uid,to_group,message) values(?,?,?)";
        PreparedStatement preparedStatement=null;
        try{
        preparedStatement=conn.prepareStatement(query);
        preparedStatement.setInt(1, z);
        preparedStatement.setString(2,group1);
        preparedStatement.setString(3, s1);
     
        preparedStatement.executeUpdate();
        }catch(Exception e)
        {
            System.out.println(e);
        }
                
               
            }
        });
       
         
       
        System.out.println("pressed button");
    }
        });
         hbox.getChildren().add(label);
                hbox.getChildren().add(btn[i]);
                vBox.getChildren().add(hbox);
                i++;
                 }
           
             
            pane2.getChildren().add(vBox);
            
         
      
         //pane4.getChildren().add(pane3);
         //scene.setRoot(pane1);
       Stage primStage=new Stage();
       primStage.setScene(scene);
    }
}
                
    
    
