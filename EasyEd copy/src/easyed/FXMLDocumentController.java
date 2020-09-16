/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyed;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Stan
 */
public class FXMLDocumentController implements Initializable {
    EasyEdConnect connect;
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField txtClassName;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        
       String class_name = txtClassName.getText();
       ClassDet classdet = new ClassDet(class_name);
       try{
           String sql = "INSERT INTO `class_details`(`class_name`) VALUES (?)";
           PreparedStatement pstmt;
           pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setString(1, classdet.getClassName());
           pstmt.execute();
           JOptionPane.showMessageDialog(null, "RECORD UPDATED SUCCESSFULLY");
           pstmt.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        connect = new EasyEdConnect();
        
    }    
    
}
