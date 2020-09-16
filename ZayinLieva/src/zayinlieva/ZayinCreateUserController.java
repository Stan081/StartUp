/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zayinlieva;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author STANLEY
 */
public class ZayinCreateUserController implements Initializable {

    private BorderPane adminDashBoard;
    @FXML
    private Button btnStore;
    @FXML
    private Button btnAddItem;
    @FXML
    private Button btnLogout;
    @FXML
    private ComboBox<String> cmbRole;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private RadioButton rdMale;
    @FXML
    private RadioButton rdFemale;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtPhone;
    @FXML
    private Button btnUserSection;
    @FXML
    private TextField txtSecretWord;
    @FXML
    private BorderPane createUserPane;
    ZayinConnect connect;
    ResultSet rst;
    Statement st;
    @FXML
    private ToggleGroup gender;
    @FXML
    private Label lb1;
    private ComboBox<String> cmbSearch;
    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtSearch;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connect = new ZayinConnect();
        cmbRole.getItems().addAll("Admin","Sales");
    }    


    @FXML
    private void btnStoreAction(ActionEvent event) throws IOException {
         BorderPane store = FXMLLoader.load(getClass().getResource("ZayinDashBoard.fxml"));
         createUserPane.getChildren().setAll(store);
    }

    @FXML
    private void btnAddItemAction(ActionEvent event) throws IOException {
        BorderPane addItem = FXMLLoader.load(getClass().getResource("ZayinAddItem.fxml"));
        createUserPane.getChildren().setAll(addItem);
    }

    @FXML
    private void btnLogoutAction(ActionEvent event) throws IOException {
          btnLogout.getScene().getWindow().hide();
          newscene("ZayinLoginFXML.fxml");
    }

    @FXML
    private void cmbRoleAction(ActionEvent event) {
       String role = cmbRole.getValue();
    }

    @FXML
    private void btnSaveAction(ActionEvent event) {
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String email = txtEmail.getText();
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        String phoneNumber = txtPhone.getText();
        String role = cmbRole.getValue();
        String sex = lb1.getText();
        String secretWord = txtSecretWord.getText();
        
        Users users = new Users(firstName,lastName,email,phoneNumber,userName,password,sex,role,secretWord);
        try {
            String sql = "INSERT INTO userdetails (firstname,lastname,email,userName,password,phoneNumber,role,sex,secretWord) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt;
            pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setString(1, users.getFirstName());
            pstmt.setString(2, users.getLastName());
            pstmt.setString(3, users.getEmail());
            pstmt.setString(4, users.getUserName());
            pstmt.setString(5, users.getPassword());
            pstmt.setString(6, users.getPhoneNumber());
            pstmt.setString(7, users.getRole());
            pstmt.setString(8, users.getSex());
            pstmt.setString(9, users.getSecretWord());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "RECORD INSERTED SUCCESSFULLY");
            pstmt.close();
            
            clearFields();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e);
        }
        
    }

    @FXML
    private void btnUpdateAction(ActionEvent event) {
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String email = txtEmail.getText();
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        String phoneNumber = txtPhone.getText();
        String role = cmbRole.getValue();
        String sex = lb1.getText();
        String secretWord = txtSecretWord.getText();
        
        Users users = new Users(firstName,lastName,email,phoneNumber,userName,password,sex,role,secretWord);
        try{
            String sql = "Update userdetails set(firstname = ?,lastname= ?,email= ?,userName,password= ?,phoneNumber= ?,role= ?,sex= ?,secretWord= ?) where userName = '"+txtUserName.getText()+"')VALUES(?,?,?,?,?,?,?,?,?) ";
            PreparedStatement pstmt;
            pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setString(1, users.getFirstName());
            pstmt.setString(2, users.getLastName());
            pstmt.setString(3, users.getEmail());
            pstmt.setString(4, users.getUserName());
            pstmt.setString(5, users.getPassword());
            pstmt.setString(6, users.getPhoneNumber());
            pstmt.setString(7, users.getRole());
            pstmt.setString(8, users.getSex());
            pstmt.setString(9, users.getSecretWord());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "RECORD UPDATED SUCCESSFULLY");
            pstmt.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    private void btnDeleteAction(ActionEvent event) {
    }

    @FXML
    private void btnUserSectionAction(ActionEvent event) {
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

    @FXML
    private void rdGenderAction(ActionEvent event) {
        
        String sex = "";
        if (rdMale.isSelected()) {
            sex= rdMale.getText();
        }
        if (rdFemale.isSelected()) {
            sex= rdFemale.getText();
        }
        lb1.setText(sex);
        
    }
    
  
    
     private void clearFields(){
        txtFirstName.clear();
        txtLastName.clear();
        txtEmail.clear();
        txtUserName.clear();
        txtPassword.clear();
        txtPhone.clear();
        cmbRole.getItems().clear();
        txtSecretWord.clear();
     
     }

    @FXML
    private void btnSearchAction(ActionEvent event) {
        try {
            Connection conn = connect.getConnection();
            st = conn.createStatement();
            rst = st.executeQuery("SELECT * FROM userdetails where username = '"+txtSearch.getText()+"'");
            
            while(rst.next()){
                 txtFirstName.setText(rst.getString("FirstName"));
                 txtLastName.setText(rst.getString("LastName"));
                 txtEmail.setText(rst.getString("Email"));
                 txtUserName.setText(rst.getString("Username"));
                 txtPassword.setText(rst.getString("Password"));
                 txtPhone.setText(rst.getString("PhoneNumber"));
                 cmbRole.setValue(rst.getString("Role"));
                 txtSecretWord.setText(rst.getString("SecretWord"));
            }
        } catch (SQLException e) {
        }
    }
}
