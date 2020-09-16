/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyed;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Stan
 */
public class EasyEdConnect {

    String url = "jdbc:mysql://localhost/easy_ed";
    String username = "root";
    String password = "";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rst = null;
    ResultSetMetaData meta = null;
    Statement st = null;
    private AnchorPane rootPane;
//    public ComboBox<String> cmbSession;
//    public ComboBox<MyTerm> cmbTerm;

    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(url, username, password);
//          JOptionPane.showMessageDialog(null, "CONNECTION SUCCESFFUL");          
        } catch (SQLException e) {

        }
        return conn;
    }

    public ResultSet selectStudents() {
        try {
            String sql = "SELECT * FROM `student_details`";
            pstmt = getConnection().prepareStatement(sql);
            rst = pstmt.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
        }
        return rst;
    }

    public ResultSet getStaffs() {
        try {
            String sql = "SELECT * FROM `staff_tbl`";
            pstmt = getConnection().prepareStatement(sql);
            rst = pstmt.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
        }
        return rst;
    }

    public Stage getDScene(String fxmlUrl) throws IOException {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource(fxmlUrl));
        Scene scene = new Scene(parent, 500, 200);
        stage.setScene(scene);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        //set Stage boundaries to visible bounds of the main screen
        stage.setX(primaryScreenBounds.getMinX());
        stage.setY(primaryScreenBounds.getMinY());
        stage.setWidth(primaryScreenBounds.getWidth());
        stage.setHeight(primaryScreenBounds.getHeight());
        stage.show();
        return stage;
    }

    public ResultSet selectMyClass() {
        try {
            String sql = "SELECT * FROM `class_details` ";
            pstmt = getConnection().prepareStatement(sql);
            rst = pstmt.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
        }
        return rst;
    }

    public ResultSet getMySession() {
        try {
            String sql = "SELECT * FROM `session_tbl` ";
            pstmt = getConnection().prepareStatement(sql);
            rst = pstmt.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
        }
        return rst;
    }

    public ResultSet getMyTerm() {
        try {
            String sql = "SELECT * FROM `term` ";
            pstmt = getConnection().prepareStatement(sql);
            rst = pstmt.executeQuery();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
        }
        return rst;
    }

    public ResultSet getMyStates() {
        try {
            String sql = "SELECT * FROM `states` ";
            pstmt = getConnection().prepareStatement(sql);
            rst = pstmt.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
        }
        return rst;
    }

    public ResultSet getMyFees() {
        try {
            String sql = "SELECT * FROM `fees_tbl`";
            pstmt = getConnection().prepareStatement(sql);
            rst = pstmt.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
        }
        return rst;
    }

    public ResultSet getMyUniforms() {
        try {
            String sql = "SELECT * FROM `uniforms_tbl`";
            pstmt = getConnection().prepareStatement(sql);
            rst = pstmt.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
        }
        return rst;
    }

    public ResultSet getMyBooks(String id) {
        try {
            String sql = "SELECT * FROM `books_tbl` WHERE `class_id` = '"+id+"'";
            pstmt = getConnection().prepareStatement(sql);
            rst = pstmt.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
        }
        return rst;
    }

    public ResultSet getMyTransaction() {
        try {
            String sql = "SELECT `first_name`,`last_name`,`class_name`,`item_desc`,`price`,`trans_date`,`quantity`,`trans_id` FROM student_details s JOIN class_stud c ON s.stud_id = c.stud_id JOIN transaction_tbl t ON c.class_stud_id = t.class_stud_id JOIN class_details cd ON cd.class_id = c.class_id ";
            pstmt = getConnection().prepareStatement(sql);
            rst = pstmt.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
        }
        return rst;
    }
    
      public ResultSet checkLogin(UsersEd user){
      String sql = "SELECT * FROM userdetails WHERE username = ? AND password = ?";
      try {
          pstmt = getConnection().prepareStatement(sql);
          pstmt.setString(1, user.getUserName());
          pstmt.setString(2, user.getPassword());
          rst = pstmt.executeQuery();
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "LOGIN USER ERROR: " + e);
      }
      return rst;
  }

     
}
