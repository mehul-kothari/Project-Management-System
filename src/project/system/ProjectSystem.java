/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.system;

import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mehulkothari
 */
//entry file.
public class ProjectSystem extends Application {
    Parent root;
    Connection conn;
    Login login=new Login();
    AllSwitches allSwitches=new AllSwitches();
    
    @Override
    public void start(Stage stage) throws Exception {
        conn=DatabaseConnection.Connector();
        try{
            String s=allSwitches.getip();
    	
    	
    
		 
		System.out.print("Your IP address is " + s);
                boolean check2=login.firsttimelogin(s);
		//check for logged in user
                if(check2)
                {
                    System.out.println("second page will open");
                     Stage primaryStage=new Stage();
                     System.out.println("second page will open");
                FXMLLoader loader=new FXMLLoader();
                System.out.println("second page will open");
                 root = loader.load(getClass().getResource("Subjects.fxml").openStream());
                 System.out.println("second page will open");
                 SubjectsController subjectsController=(SubjectsController)loader.getController();
                //subjectsController.getUser(user);
                 Scene scene = new Scene(root);
        String css = this.getClass().getResource("ListStyle.css").toExternalForm(); 
        scene.getStylesheets().add(css);
        
       // Scene scene = new Scene(root);
        // String css = this.getClass().getResource("page2.css").toExternalForm(); 
        //scene.getStylesheets().add(css);
        System.out.println("second page will open");
        
        primaryStage.setScene(scene);
        primaryStage.show();
                }
                else
                {
                    //boolean check3=getuid();
                     ResultSet rs=null;
        /*String sql = "INSERT INTO loggedin (loggedin)" +
        "VALUES (?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
preparedStatement.setString(1, s);
//preparedStatement.setString(2, passwords);
//preparedStatement.setString(3, "Test3");
preparedStatement.executeUpdate(); */
allSwitches.logininterface(stage);

                     
                }
                    
		//JOptionPane.showMessageDialog(null, "IP is: " + Br.readLine() );
		
    	}catch(Exception e){e.printStackTrace();}
       // boolean check2=firsttimelogin(Br.readLine());
		
    	
        
       /* Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        //String css = this.getClass().getResource("user.css").toExternalForm(); 
        //scene.getStylesheets().add(css);
        
        Scene scene = new Scene(root);
         String css = this.getClass().getResource("user.css").toExternalForm(); 
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.show();*/
        /*conn=DatabaseConnection.Connector();
        if(conn==null)
        {
            System.out.println("not connected");
        }
        else
            System.out.println("connected");
        */
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
