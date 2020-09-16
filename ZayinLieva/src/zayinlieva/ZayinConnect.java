/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zayinlieva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;

/**
 *
 * @author STANLEY
 */
public class ZayinConnect {
    String url = "jdbc:mysql://localhost/zayin_lieva";
     String username = "root";
     String password ="";
     Connection conn = null;
     PreparedStatement pstmt = null;
     ResultSet rst = null;
     ResultSetMetaData meta = null;
     Statement st = null;
     
     
     public Connection getConnection(){
      try {
          conn = DriverManager.getConnection(url,username,password);
          JOptionPane.showMessageDialog(null, "CONNECTION SUCCESFFUL");
          
          
      } catch (SQLException e) {
      
  }
      return conn;
  }
  
  public void insertUser(Users user) throws SQLException{
       try {
          //Step 1
            conn = DriverManager.getConnection(url,username,password);
          //Step2
            String sql;
            sql = "INSERT INTO userdetails(firstname, lastname, email, phonenumber, username, password, secretword) VALUES (?,?,?,?,?,?) ";
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1,user.getFirstName());
            pstmt.setString(2,user.getLastName());
            pstmt.setString(3,user.getEmail());
            pstmt.setString(4,user.getPhoneNumber());
            pstmt.setString(5,user.getUserName());
            pstmt.setString(6,user.getPassword());
            pstmt.setString(7,user.getSecretWord());
            
           // pstmt.setBinaryStream(7,(InputStream)fis,(int)file.length());
          //step3
            pstmt.execute();
            JOptionPane.showMessageDialog(null,"INSERT SUCCESSFULLY");       
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
 }
  
  public ResultSet SelectUser(){
      try {
          String sql = "SELECT * FROM users";
          pstmt = getConnection().prepareStatement(sql); 
          rst = pstmt.executeQuery();
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
      }
      return rst;
  }
  
  
  public ResultSet UpdateUser(Users user){
      ResultSetMetaData meta = null;
       try {
            conn = DriverManager.getConnection(url, username, password);
            //step2
            String sql = "Select * from userdetails";
            pstmt = conn.prepareStatement(sql);
            //step3
            rst = pstmt.executeQuery();
            //step4
            meta = rst.getMetaData();
            int cols = meta.getColumnCount();
            while(rst.next()){
                for (int i =1; i<= cols; i++){
                    System.out.printf("%10s\t", rst.getObject(i));  
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
      return rst;
  }
  
  public ResultSet checkLogin(Users user){
      String sql = "SELECT * FROM userdetails WHERE username = ? AND password = ? AND role = ? ";
      try {
          pstmt = getConnection().prepareStatement(sql);
          pstmt.setString(1, user.getUserName());
          pstmt.setString(2, user.getPassword());
          pstmt.setString(3, user.getRole());
          rst = pstmt.executeQuery();
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "LOGIN USER ERROR: " + e);
      }
      return rst;
  }
  
  
  public ResultSet SelectItems(){
        try {
          String sql = "SELECT * FROM itemdetails";
          pstmt = getConnection().prepareStatement(sql);
          rst = pstmt.executeQuery();
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
      }
      return rst;
  }
  
  public ResultSet getInvoice(){
        try {
          String sql = "SELECT * FROM invoice ";
          pstmt = getConnection().prepareStatement(sql);
          rst = pstmt.executeQuery();
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
      }
      return rst;
  }
 
    
}
