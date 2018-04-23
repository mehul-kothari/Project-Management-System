/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.system;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static project.system.FXMLDocumentController.uid;
import static project.system.Page2Controller.root;
import static project.system.SubjectsController.primaryStage;


/**
 *
 * @author mehulkothari
 */
public class AllSwitches {
    int count=0;
    Connection conn;
   //FXMLDocumentController fXMLDocumentController=new FXMLDocumentController();
    public  void logininterface(Stage stage) throws IOException, SQLException
    {
       // FXMLLoader loader=new FXMLLoader();
       // FXMLDocumentController fXMLDocumentController=(FXMLDocumentController)loader.getController();
         //uid=fXMLDocumentController.getuid(FXMLDocumentController.user);
        String ip=getip();
           String sql = "UPDATE loggedin " +
                   "SET loggedin = ? WHERE loggedin=?";
           conn=DatabaseConnection.Connector();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
preparedStatement.setString(1, "No");
preparedStatement.setString(2, ip);
try{
preparedStatement.executeUpdate();
}catch(Exception e)
{
    System.out.println(e);
}

          Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        //String css = this.getClass().getResource("user.css").toExternalForm(); 
        //scene.getStylesheets().add(css);
        
        Scene scene = new Scene(root);
         String css = this.getClass().getResource("user.css").toExternalForm(); 
        scene.getStylesheets().add(css);
         stage.resizableProperty().setValue(Boolean.FALSE);
      //  ResponsiveHandler.addResponsiveToWindow(stage);
        
        stage.setScene(scene);
        stage.show();
    }
    public String getip() throws MalformedURLException, IOException
    {
        java.net.URL URL = new java.net.URL("http://bot.whatismyipaddress.com");
 
		java.net.HttpURLConnection Conn = (HttpURLConnection)URL.openConnection();
		 
		java.io.InputStream InStream = Conn.getInputStream();
		 
		java.io.InputStreamReader Isr = new java.io.InputStreamReader(InStream);
		 
		java.io.BufferedReader Br = new java.io.BufferedReader(Isr);
                String s=Br.readLine();
                return s;
    }
    public void gotopage2(Stage stage) throws IOException
    {
        //((Node)event.getSource()).getScene().getWindow().hide();
                 primaryStage=new Stage();
                FXMLLoader loader=new FXMLLoader();
                 Parent root = loader.load(getClass().getResource("page2.fxml").openStream());
                 //Page2Controller page2Controller=(Page2Controller)loader.getController();
                //page2.getUser(user);
       // String css = this.getClass().getResource("page2.css").toExternalForm(); 
        //scene.getStylesheets().add(css);
        
        Scene scene = new Scene(root);
         String css = this.getClass().getResource("page2.css").toExternalForm(); 
        scene.getStylesheets().add(css);
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void gotoselectsubects(Stage stage) throws IOException {
       // Stage primaryStage=new Stage();
                FXMLLoader loader=new FXMLLoader();
                 Parent root = loader.load(getClass().getResource("Subjects.fxml").openStream());
                 SubjectsController subjectsController=(SubjectsController)loader.getController();
                //subjectsController.getUser(user);
                 Scene scene = new Scene(root);
        String css = this.getClass().getResource("ListStyle.css").toExternalForm(); 
        scene.getStylesheets().add(css);
        stage.resizableProperty().setValue(Boolean.FALSE);
        
       // Scene scene = new Scene(root);
        // String css = this.getClass().getResource("page2.css").toExternalForm(); 
        //scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.show();
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void displayform(Stage stage) throws IOException
    {
         stage=new Stage();
                FXMLLoader loader=new FXMLLoader();
                System.out.println("hi");
                root = loader.load(getClass().getResource("Form.fxml").openStream());
                 System.out.println("hi");
                 FormController formController=(FormController)loader.getController();
                 //formController.submit1(primaryStage1);
        //String css = this.getClass().getResource("user.css").toExternalForm(); 
        //scene.getStylesheets().add(css);
        
        Scene scene = new Scene(root);
        // String css = this.getClass().getResource("").toExternalForm(); 
        //scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.show();
        stage.resizableProperty().setValue(Boolean.FALSE);
    }
    
}
