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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static project.system.FXMLDocumentController.prdstmt1;
import static project.system.SubjectsController.primaryStage;

/**
 * FXML Controller class
 *
 * @author mehulkothari
 */
//view group and create group
public class Page2Controller implements Initializable {
     public TextField name2;
    static Parent root;
    Connection conn;
    String names1,passwords1;
 FormController formController=new FormController();
    AllSwitches allSwitches=new AllSwitches();
    Stage primaryStage1;
    ResultSet rs=null;
     //Stage primarystage;
     //AnchorPane pane2;
    @FXML
    private  AnchorPane  pane1;
    @FXML
    AnchorPane pane2;
    

     void submit2(Node node) {
        System.out.println("whtasup");
        System.out.println(primaryStage1);
        pane1=(AnchorPane) setPane();
        System.out.println(pane1);
        
       // pane1.setCenternode);        //pane1=(AnchorPane) setPane();

        pane1.getChildren().setAll(node);
        System.out.println("whtasup");
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   /* public void page2controller(String names,String passwords) {
        names1=names;
        passwords1=passwords;
        System.out.println(names1);
    }*/
     

    private  Pane setPane() {
          FXMLLoader loader = new FXMLLoader();

        try {
              //AnchorPane pane2;
            loader.setLocation(Page2Controller.class.getResource("page2"
                    + ".fxml"));
              pane2 = (AnchorPane)loader.load();
              
              System.out.println("insider");
              return pane2;
        } catch (IOException ex) {
            Logger.getLogger(Page2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   // @FXML
   // AnchorPane pane1;
//
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // System.out.println(names);
        // TODO
    }
    public void getUser(String s)
    {
        System.out.println("done");
    }
    public void creategroup(ActionEvent event)
    {
        try{
          primaryStage1=new Stage();
                FXMLLoader loader=new FXMLLoader();
                System.out.println("hi");
                root = loader.load(getClass().getResource("Form.fxml").openStream());
                allSwitches.count++;
                 System.out.println("hi");
                // FormController formController=(FormController)loader.getController();
                 //formController.submit1(primaryStage1);
        //String css = this.getClass().getResource("user.css").toExternalForm(); 
        //scene.getStylesheets().add(css);
        
        Scene scene = new Scene(root);
        // String css = this.getClass().getResource("").toExternalForm(); 
        //scene.getStylesheets().add(css);
        
        primaryStage1.setScene(scene);
        primaryStage1.show();
        primaryStage1.resizableProperty().setValue(Boolean.FALSE);
        
        //formController.submit1(primaryStage1);
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    @FXML
    public void gotoselectsubjects(ActionEvent event) throws IOException
    {
        ((Node)event.getSource()).getScene().getWindow().hide();
        try{
        allSwitches.gotoselectsubects(new Stage());
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    @FXML
    public void editgroupdetails(ActionEvent event) throws IOException
    {
       allSwitches.displayform(new Stage());
        System.out.println(names1);
       // formController.filldetails(names1,passwords1);*/
         conn=DatabaseConnection.Connector();
          PreparedStatement prdstmt=null;
         rs=null;
        String query="Select username,password FROM form WHERE uid=?";
        try {
            prdstmt=conn.prepareStatement(query);
            prdstmt.setInt(1,1);
            //prdstmt.setString(2, pass);
            rs=prdstmt.executeQuery();
            rs.next();
            String user=rs.getString(1);
            String pass=rs.getString(2);
            System.out.println("before passing details" + user);
            //StringProperty s=
           // FormController.name1.setText(user);
           FXMLLoader loader=new FXMLLoader();
            FormController controller = (FormController)loader.getController();
            StringProperty s=controller.newLblText();
            s.set(user);
            System.out.println(s);
            //controller.name1.setText(user);
            ///allSwitches.displayform(new Stage());
            /*name2=controller.name1;
            System.out.println(name2);
            name2.appendText(user);
            
                    
            //controller.filldetails(user,pass);
            
            //controller.name1.setText(user);
        }*/}
            catch(Exception e){
            System.out.println(e);
        }
    

    }
    @FXML
    public void gotologin(ActionEvent event) throws IOException, SQLException
    {
        
        System.out.println("hello");
        ((Node)event.getSource()).getScene().getWindow().hide();
        allSwitches.logininterface(new Stage());
    }
    @FXML
    public void gotopage2(ActionEvent event) throws IOException, SQLException
    {
         conn=DatabaseConnection.Connector();
        System.out.println("hi");
       rs=null;
         PreparedStatement preparedStatement = null;
        String sql="SELECT uid FROM loggedin where loggedin=?";
         preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1,allSwitches.getip());  
          rs=preparedStatement.executeQuery();
          rs.next();
          int id=rs.getInt(1);
         sql = "DELETE FROM create_group " +
                   "WHERE uid = ?";
               preparedStatement = conn.prepareStatement(sql);
preparedStatement.setInt(1,id );
System.out.println(id);
//preparedStatement.setString(2, passwords);
//preparedStatement.setString(3, "Test3");
preparedStatement.executeUpdate(); 
         ((Node)event.getSource()).getScene().getWindow().hide();
       allSwitches.gotopage2(new Stage());
    }
    @FXML
    public void viewGroup(ActionEvent event) throws IOException
    {
         Stage primaryStage=new Stage();
                FXMLLoader loader=new FXMLLoader();
                Group root=new Group();
                Scene scene=new Scene(root, 400, 500);
                 //Parent root = loader.load(getClass().getResource("ViewGroup.fxml"));
                 //Page2Controller page2Controller=(Page2Controller)loader.getController();
                //page2.getUser(user);
       // String css = this.getClass().getResource("page2.css").toExternalForm(); 
        //scene.getStylesheets().add(css);
        
       // Scene scene = new Scene(root);
          Connection conn=DatabaseConnection.Connector();
          PreparedStatement prdstmt = null;
         //ResultSet rs=null;
        String query="Select groupname,subject FROM create_group";
         //System.out.println(ip1);
        try {        
            prdstmt1=conn.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(ViewGroupController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            VBox vBox=new VBox(20);
            Button[] btn = new Button[10];
            int i=0;
            //prdstmt1.setString(1,ip1);
            //System.out.println(ip1);
            //prdstmt.setString(2, pass);
            rs=prdstmt1.executeQuery();
            while(rs.next())
            {
                String a2=rs.getString(2);
                String a1=rs.getString(1);
                if(a2.equals(SubjectsController.subject))
                {
                System.out.println("inside rs.next");
                HBox hbox = new HBox(100);
                String label1=rs.getString(1);
                Label label=new Label(label1);
                 btn[i]=new Button("join");
                 btn[i].setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        System.out.println("pressed button");
        TextInputDialog dialog = new TextInputDialog();
dialog.setTitle("Enter password");
dialog.setHeaderText("Look, a Text Input Dialog");
dialog.setContentText("please enter the password");
        Optional<String> result = dialog.showAndWait();
        try {
            Boolean check=checkResult(result);
            if(check)
            {
               String sql="Insert into join_group(uid,groupname,subject) values(?,?,?)";
               PreparedStatement prdstmt2=conn.prepareStatement(sql);
                String s=allSwitches.getip();
                
                int z=FXMLDocumentController.getuid(s);
               prdstmt2.setInt(1,z);
               prdstmt2.setString(2, a1);
               prdstmt2.setString(3, a2);
               prdstmt2.executeUpdate();
              /*  sql="Insert into subject(uid,subject) values(?,?)";
                 prdstmt2=conn.prepareStatement(sql);
                 
                  prdstmt2.setInt(1,z);
               prdstmt2.setString(2, a2);
                prdstmt2.executeUpdate();*/
                primaryStage.hide();
                ((Node)event.getSource()).getScene().getWindow().hide();
                System.out.println("joined group");
                 pane2 = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                 System.out.println(pane2);
                 Scene scene=new Scene(pane2);
                  System.out.println(scene);
                  //String css = this.getClass().getResource("page2.css").toExternalForm(); 
        //scene.getStylesheets().add(css);
                  System.out.println( SubjectsController.primaryStage.getScene());
                Stage primarystage = SubjectsController.primaryStage;
                 primarystage.setScene(scene);
                
            }
            else
               System.out.println("not joined");
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Page2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

                    private Boolean checkResult(Optional<String> result) throws SQLException {
                        String query="Select groupname FROM password where password=?";
                        prdstmt1=conn.prepareStatement(query);
                        System.out.println(result.get());
                        prdstmt1.setString(1, result.get());
                        ResultSet rs1=null;
                        rs1=prdstmt1.executeQuery();
                       if(rs1.next())
                       {
                           System.out.println("true");
                           return true;
                       }
                       else
                       {
                             System.out.println("false");
                           return false;
                       }
                        
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
                 
                hbox.getChildren().add(label);
                hbox.getChildren().add(btn[i]);
                vBox.getChildren().add(hbox);
                i++;
            }
              

            }
            root.getChildren().add(vBox);
            // System.out.println("before resultset");
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(ViewGroupController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // String css = this.getClass().getResource("page2.css").toExternalForm(); 
        //scene.getStylesheets().add(css);
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
            
}
