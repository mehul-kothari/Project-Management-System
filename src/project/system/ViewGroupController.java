/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.system;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import static project.system.FXMLDocumentController.prdstmt1;

/**
 * FXML Controller class
 *
 * @author mehulkothari
 */
public class ViewGroupController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection conn=DatabaseConnection.Connector();
          PreparedStatement prdstmt = null;
        ResultSet rs=null;
        String query="Select username FROM form";
         //System.out.println(ip1);
        try {        
            prdstmt1=conn.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(ViewGroupController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //prdstmt1.setString(1,ip1);
            //System.out.println(ip1);
            //prdstmt.setString(2, pass);
            rs=prdstmt1.executeQuery();
            if(rs.next())
            {
                HBox hbox = new HBox();
                String label1=rs.getString(1);
                Label label=new Label(label1);
                Button button=new Button("join");
                hbox.getChildren().add(label);
                hbox.getChildren().add(button);

            }
            // System.out.println("before resultset");
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(ViewGroupController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
