/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zayinlieva;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author STANLEY
 */
public class ZayinLoginFXMLController implements Initializable {
    
    private Label label;
    @FXML
    private TextField txtUsername;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnFPassword;
    
    String role;
    
    ZayinConnect connect;
    ResultSet rst;
    
    @FXML
    private AnchorPane loginPane;
    @FXML
    private ComboBox <String> cmbRole;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       connect = new ZayinConnect();
//    ComboBox <String> cmbRole = new ComboBox();
    cmbRole.getItems().addAll("Admin","Sales");
     
    }    
    
      

    @FXML
    private void btnLoginAction(ActionEvent event) throws SQLException, IOException {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
//        ObservableList<String> cmbRoleList;
//        cmbRoleList = new FXCollections.observableArrayList("Admin", "Sales");
        
        Users student = new Users(username, password, role); 
        rst = connect.checkLogin(student);
        role = cmbRole.getValue();
        if(rst.next()){
            //meaninng the correct detials were inputed
            if(role.equals("Sales")){
              btnLogin.getScene().getWindow().hide();
              newscene("ZayinUserDashBoard.fxml");
       
            }else if(role.equals("Admin")){
             //meaninng the correct detials were inputed
               btnLogin.getScene().getWindow().hide();
              newscene("ZayinDashBoard.fxml");
          
        }
    }else{
            JOptionPane.showMessageDialog(null, "WRONG CREDENTIALS", "LOGIN DETAILS", JOptionPane.INFORMATION_MESSAGE);

            
        }
    }

    @FXML
    private void btnFPasswordAction(ActionEvent event) {
    }
    
    

    @FXML
    private void cmbRoleAction(ActionEvent event) {
        role = cmbRole.getValue();
      
   
    }
    
      private void newscene(String url){
        try{
            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }catch(IOException ex){
        ex.getMessage();
    }
    }
   
}
