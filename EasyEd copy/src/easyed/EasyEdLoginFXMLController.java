/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyed;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class EasyEdLoginFXMLController implements Initializable {

    @FXML
    private AnchorPane loginPane;
    @FXML
    private TextField txtUsername;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtPassword;
    EasyEdConnect connect;
    ResultSet rst;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        connect = new EasyEdConnect();
    }    

    @FXML
    private void btnLoginAction(ActionEvent event) throws SQLException {
         String username = txtUsername.getText();
        String password = txtPassword.getText();
        
        UsersEd student = new UsersEd(username, password); 
        rst = connect.checkLogin(student);
        if(rst.next()){
            //meaninng the correct detials were inputed
            
              btnLogin.getScene().getWindow().hide();
              newscene("dashBoardFXML.fxml");
        
    }else{
            JOptionPane.showMessageDialog(null, "WRONG CREDENTIALS", "LOGIN DETAILS", JOptionPane.INFORMATION_MESSAGE);

            
        }
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
