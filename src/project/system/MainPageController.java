/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.system;

import com.mysql.jdbc.ResultSet;
import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import static project.system.FXMLDocumentController.prdstmt1;

/**
 * FXML Controller class
 *
 * @author mehulkothari
 */
public class MainPageController implements Initializable {
    AllSwitches allSwitches=new AllSwitches();
    @FXML
    ListView<String> topics;
    String choice;
    @FXML
    AnchorPane pane2;
    @FXML
    Button send1;
     @FXML
     TextArea text1;
    @FXML
    AnchorPane pane5;
     @FXML
    AnchorPane pane6;
    @FXML
    AnchorPane pane1;
    Parent root;
    @FXML
    AnchorPane pane3;
    Scene scene;
     Stage primStage;
    String group;
     @FXML
    AnchorPane pane4;
     @FXML
    AnchorPane pane10;
     @FXML
    Button button1;
     int z;
     VBox vBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ObservableList<String> items =FXCollections.observableArrayList ("Upload Project","View Progress","Make Notes","Read messages");
            topics.setItems(items);
           topics.scrollTo(0);
        topics.getSelectionModel().select(0);
        scene=new Scene(pane4);
        
        System.out.println(scene);
        System.out.println(pane1);
        System.out.println(pane2);
        System.out.println(pane2.getChildren());
        System.out.println(pane3); 
        System.out.println(pane3.getChildren());
        System.out.println(pane4.getChildren());
        pane4.getChildren().remove(pane3);
        pane4.getChildren().remove(pane10);
       //pane4.getChildren().remove(pane3);
       //pane4.getChildren().remove(pane6);
        System.out.println(pane4.getChildren());
         PreparedStatement preparedStatement=null;
    ResultSet rs=null;
   Connection conn=DatabaseConnection.Connector();
    String query="SELECT uid,groupname,subject FROM create_group UNION SELECT uid,groupname,subject FROM join_group";
         //System.out.println(ip1);
        try {        
            String s=allSwitches.getip();
             z=FXMLDocumentController.getuid(s);
            preparedStatement=conn.prepareStatement(query);
             rs=(ResultSet) preparedStatement.executeQuery();
              System.out.println("hiiiiii");
              while(rs.next())
             {
                 System.out.println("hiiiiii");
                 if(z==rs.getInt(1) && SubjectsController.subject.equalsIgnoreCase(rs.getString(3)))
                 {
                     System.out.println("hiiiiii");
                     group=rs.getString(2);
                     break;
                 }
             }
            System.out.println(group);  
            query="Select done from submit where groupname=?";
            preparedStatement=conn.prepareStatement(query);
            preparedStatement.setString(1,group);
             rs=(ResultSet) preparedStatement.executeQuery();
            if(rs.next()){
            String s2="done";
            ResultSet rs1=null;
            if(rs.getString(1).equals(s2))
            {
                button1.setDisable(true);
                query="Select filename from upload where groupname=?";
                preparedStatement=conn.prepareStatement(query);
                preparedStatement.setString(1,group);
                rs1=(ResultSet) preparedStatement.executeQuery();
            rs1.next();
            String file4=rs1.getString(1);
            Hyperlink link = new Hyperlink(file4);
            File file1=new File(file4);
            pane2.getChildren().add(link);
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
            
            }}
        }catch(Exception e1)
                    {
                    e1.printStackTrace();
                    }
// TODO
// TODO
    }
    public void uploadproject()
    {
        Connection conn=DatabaseConnection.Connector();
         pane4.getChildren().remove(pane3);
         System.out.println(pane4.getChildren());
        pane4.getChildren().remove(pane10);
        System.out.println(pane4.getChildren());
        pane4.getChildren().add(pane2);
        System.out.println(pane4.getChildren());
        
       
       // pane3.getChildren().remove(pane5);
        pane4.getChildren().remove(vBox);
        //pane2.getChildren();
      
       System.out.println(scene);
        pane2.getChildren().remove(pane3);
     
         //System.out.println(ip1);
               
          /*  String s=allSwitches.getip();
             z=FXMLDocumentController.getuid(s);
            prdstmt=conn.prepareStatement(query);
            prdstmt.setString
             rs=(ResultSet) prdstmt1.executeQuery();
        
        if()*/
         //scene.setRoot(pane1);
        primStage=new Stage();
       primStage.setScene(scene);
    }
    @FXML
    public void selectChoice(MouseEvent event) throws IOException, SQLException
    {
         choice=topics.getSelectionModel().getSelectedItem();
           if(choice.equalsIgnoreCase("Upload Project"))
            {
                uploadproject();
            }
           if(choice.equalsIgnoreCase("make notes"))
           {
               makenotes();
           }
            if(choice.equalsIgnoreCase("Read messages"))
            {
                readmessages();
            }
    }
    public void readmessages() throws IOException, SQLException
    {
        pane4.getChildren().remove(pane2);
        pane4.getChildren().remove(vBox);
         //pane3.getChildren().remove(pane5);
          pane4.getChildren().remove(pane3);
        VBox vBox1=new VBox(20);
        PreparedStatement preparedStatement=null;
    ResultSet rs=null;
    Connection conn=DatabaseConnection.Connector();
        String s=allSwitches.getip();
             z=FXMLDocumentController.getuid(s);
        String sql="Select message,from_uid from message where to_uid=? and subject=?";
                preparedStatement=conn.prepareStatement(sql);
                preparedStatement.setInt(1, z);
                 preparedStatement.setString(2, SubjectsController.subject);
                rs=(ResultSet) preparedStatement.executeQuery();
                while(rs.next())
                {
                    System.out.println(rs.getString(2));
                    HBox hbox = new HBox(100);
                    String label1=rs.getString(2);
                    Label label=new Label(label1);
                    String label2=rs.getString(1);
                    Label label3=new Label(label2);
                    hbox.getChildren().add(label);
                hbox.getChildren().add(label3);
                vBox1.getChildren().add(hbox);
                            
                }
                sql="Select groupname from create_group where uid=? and subject=?  union Select groupname from join_group where uid=? and subject=? ";
                System.out.println("have come inside");
                preparedStatement=conn.prepareStatement(sql);
                //preparedStatement.setInt(1, z);
                 preparedStatement.setInt(1,z);
                 preparedStatement.setString(2, SubjectsController.subject);
                 preparedStatement.setInt(3,z);
                 preparedStatement.setString(4, SubjectsController.subject);
                rs=(ResultSet) preparedStatement.executeQuery();
                rs.next();
                 String group1=rs.getString(1);
                 System.out.println(group1);
                 sql="Select message,from_uid from teacher_students where to_group=?";
                preparedStatement=conn.prepareStatement(sql);
               
                 preparedStatement.setString(1, group1);
                rs=(ResultSet) preparedStatement.executeQuery();
                while(rs.next())
                {
                   System.out.println(rs.getString(2));
                    HBox hbox = new HBox(100);
                    String label1=rs.getString(2);
                    Label label=new Label(label1);
                    String label2=rs.getString(1);
                    Label label3=new Label(label2);
                    hbox.getChildren().add(label);
                hbox.getChildren().add(label3);
                vBox1.getChildren().add(hbox);
                            
                }
                 
                pane10.getChildren().add(vBox1);
               
                pane4.getChildren().add(pane10);
                
    }
    @FXML
    public void uploadfinal(Event event) throws SQLException, FileNotFoundException, IOException
    {
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
         new ExtensionFilter("Text Files", "*.txt"),
         new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
         new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
         new ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(primStage);
       //ByteArrayInputStream bais = new ByteArrayInputStream(selectedFile.toByteArray());
        if (selectedFile != null) {
             FileInputStream fis = new FileInputStream(selectedFile);
       
            
    System.out.println(selectedFile);
    PreparedStatement preparedStatement=null;
    ResultSet rs=null;
    Connection conn=DatabaseConnection.Connector();
    String query="SELECT uid,groupname,subject FROM create_group UNION SELECT uid,groupname,subject FROM join_group";
         //System.out.println(ip1);
        try {        
            String s=allSwitches.getip();
             z=FXMLDocumentController.getuid(s);
            preparedStatement=conn.prepareStatement(query);
             rs=(ResultSet) preparedStatement.executeQuery();
              System.out.println("hiiiiii");
              while(rs.next())
             {
                 System.out.println("hiiiiii");
                 if(z==rs.getInt(1) && SubjectsController.subject.equalsIgnoreCase(rs.getString(3)))
                 {
                     System.out.println("hiiiiii");
                     group=rs.getString(2);
                     break;
                 }
             }
            System.out.println(group);  
     query="Update submit set done='done' where groupname=? and subject=?";
    preparedStatement=conn.prepareStatement(query);
    preparedStatement.setString(1, group);
    preparedStatement.setString(2, SubjectsController.subject);
    preparedStatement.executeUpdate();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
   /* String sql="Insert into upload(upload) values(?)";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setBinaryStream(1, fis, fis.available());
            
            preparedStatement.executeUpdate();*/
            //File dest=new File("C:\\Users\\mehulkothari\\Desktop\\pro\\username");
       // Files.copy(selectedFile,"C:\\Users\\mehulkothari\\Desktop\\project" , StandardCopyOption.REPLACE_EXISTING);
            //Files.copy(selectedFile.toPath(),dest.toPath(), REPLACE_EXISTING);
          
          
          File theDir = new File("C:\\Users\\mehulkothari\\Desktop\\pro\\"+group);
          theDir.mkdir();
if(selectedFile.isDirectory()) {
    File[] content = selectedFile.listFiles();
   // File theDir = new File("new folder");
   // theDir.mkdir();
    for(int i = 0; i < content.length; i++) {
        File dest=new File("C:\\Users\\mehulkothari\\Desktop\\pro\\"+group+"\\"+content[i].getName());
          Files.copy(content[i].toPath(),dest.toPath(), REPLACE_EXISTING);
        //move content[i]
    }
}
else
{
    File dest=new File("C:\\Users\\mehulkothari\\Desktop\\pro\\"+group+"\\"+selectedFile.getName().toString());
          Files.copy(selectedFile.toPath(),dest.toPath(), REPLACE_EXISTING);
}
button1.setDisable(true);
System.out.println(new File("C:\\Users\\mehulkothari\\Desktop\\pro\\"+group+"\\"+selectedFile.getName().toString()).toURI().toURL());
Hyperlink link = new Hyperlink("C:\\Users\\mehulkothari\\Desktop\\pro\\"+group+"\\"+selectedFile.getName().toString());
File file1=new File("C:\\Users\\mehulkothari\\Desktop\\pro\\"+group+"\\"+selectedFile.getName());
String file2="C:\\Users\\mehulkothari\\Desktop\\pro\\"+group+"\\"+selectedFile.getName().toString();
pane2.getChildren().add(link);
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
String sql1="Insert into upload(groupname,filename) values(?,?)";
PreparedStatement prdstmt1 = null;
 prdstmt1=conn.prepareStatement(sql1);
 prdstmt1.setString(1, group);
 prdstmt1.setString(2, file2);
 prdstmt1.executeUpdate();
            //TextField tx=new TextField(new File("C:\\Users\\mehulkothari\\Desktop\\pro\\username\\"+selectedFile.getName()).toURI().toURL());
            

 }
    }
    public void makenotes() throws IOException
    {
         pane4.getChildren().remove(pane2);
          pane4.getChildren().remove(pane10);
         pane3.getChildren().remove(pane5);
          pane4.getChildren().add(pane3);
          //Stage primaryStage=new Stage();
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
        String query="SELECT uid,groupname,subject FROM create_group UNION SELECT uid,groupname,subject FROM join_group";
         //System.out.println(ip1);
        try {        
            String s=allSwitches.getip();
             z=FXMLDocumentController.getuid(s);
            prdstmt1=conn.prepareStatement(query);
             rs=(ResultSet) prdstmt1.executeQuery();
             
             while(rs.next())
             {
                 if(z==rs.getInt(1) && SubjectsController.subject.equalsIgnoreCase(rs.getString(3)))
                 {
                     group=rs.getString(2);
                     break;
                 }
             }
             System.out.println(group);
        } catch (SQLException ex) {
            Logger.getLogger(ViewGroupController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
             prdstmt1=conn.prepareStatement(query);  
             rs=(ResultSet) prdstmt1.executeQuery();
            vBox=new VBox(20);
            Button[] btn = new Button[10];
            int i=0;
            //prdstmt1.setString(1,ip1);
            //System.out.println(ip1);
            //prdstmt.setString(2, pass);
            
            while(rs.next())
            {
                String a2=rs.getString(3);
                String a1=rs.getString(2);
                if(rs.getString(3).equalsIgnoreCase(SubjectsController.subject) && rs.getString(2).equalsIgnoreCase(group))
                {
                    if(z!=rs.getInt(1))
                    {
                System.out.println("inside rs.next");
                HBox hbox = new HBox(100);
                int label1=rs.getInt(1);
                String label2=Integer.toString(label1);
                Label label=new Label(label2);
                 btn[i]=new Button("join");
                 text1.setWrapText(true);
                 btn[i].setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        System.out.println(pane3.getChildren());
         pane3.getChildren().add(pane5);
         try{
        pane4.getChildren().add(pane3);
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
                pane3.getChildren().remove(pane5);
                
                String query="Insert into message(from_uid,to_uid,groupname,subject,message) values(?,?,?,?,?)";
        PreparedStatement preparedStatement=null;
        try{
        preparedStatement=conn.prepareStatement(query);
        preparedStatement.setInt(1, z);
        preparedStatement.setInt(2,label1);
        preparedStatement.setString(3, a1);
        preparedStatement.setString(4, a2);
        preparedStatement.setString(5, s1);
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
            }}
             Button button=new Button("join for all");
         vBox.getChildren().add(button);
            pane4.getChildren().add(vBox);
            } catch (SQLException ex) {
            Logger.getLogger(ViewGroupController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
      
         //pane4.getChildren().add(pane3);
         //scene.setRoot(pane1);
       Stage primStage=new Stage();
       primStage.setScene(scene);
    }
    @FXML
    public void send(Event event) throws SQLException
    {
       
    }
    @FXML
    public void shift(ActionEvent event)
    {
        ((Node)event.getSource()).getScene().getWindow().hide();
        try{
        allSwitches.gotoselectsubects(new Stage());
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
