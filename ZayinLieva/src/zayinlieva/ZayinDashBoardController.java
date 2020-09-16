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
import java.util.ArrayList;
import java.util.ResourceBundle; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author STANLEY
 */
public class ZayinDashBoardController implements Initializable {

    @FXML
    private Button btnStore;
    @FXML
    private BorderPane adminDashBoard;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnAddItem;
    @FXML
    private Button btnCreateUser;
    @FXML
    private ComboBox<String> cmbCat;
    @FXML
    private ComboBox<String> cmbName;
    @FXML
    private Button btnAdd;
    @FXML
    private ComboBox<String> cmbColor;
    @FXML
    private ComboBox<String> cmbSize;
    @FXML
    private Button btnCheckout;
    
    ZayinConnect connect;
    ResultSet rst;
    Statement st;
    @FXML
    private Button btnClear;
    ObservableList<Items> listItems;
    @FXML
    private TableView<Items> tbl2;
    @FXML
    private TableColumn<Items, String> colName;
    @FXML
    private TableColumn<Items, String> colCat;
    @FXML
    private TableColumn<Items, String> colColor;
    @FXML
    private TableColumn<Items, String> colSize;
    @FXML
    private TableColumn<Items, String> colPrice;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connect= new ZayinConnect();
        BindCombo();

    }    
    
    
    public void BindCombo(){
       
        try {
            Connection conn = connect.getConnection();
            st= conn.createStatement();
            rst = st.executeQuery("SELECT * FROM `category`");
            while(rst.next()){
                cmbCat.getItems().addAll(rst.getString("categories"));
            }
            
        } catch (SQLException e) {
        }
        
    }
    
      public void getNameC(){
      try{
      Connection conn = connect.getConnection();
      st = conn.createStatement();
      rst = st.executeQuery("SELECT * FROM `itemdetails` WHERE Item_Category = '"+cmbCat.getValue()+"'");
      while(rst.next()){
         cmbName.getItems().addAll(rst.getString("Item_Name"));
      }
      
      }catch(SQLException e){
      }
     
  }
       public void getSizeC(){
      try{
      Connection conn = connect.getConnection();
      st = conn.createStatement();
      rst = st.executeQuery("SELECT Item_Size FROM `itemdetails` WHERE (Item_Category = '"+cmbCat.getValue()+"' And Item_Name = '"+cmbName.getValue()+"')");
      while(rst.next()){
         cmbSize.getItems().addAll(rst.getString("Item_Size"));
      }
      
      }catch(SQLException e){
      }
      }
      
       public void getColorC(){
      try{
      Connection conn = connect.getConnection();
      st = conn.createStatement();
      rst = st.executeQuery("SELECT Item_desc FROM `itemdetails` WHERE Item_Category = '"+cmbCat.getValue()+"'");
      while(rst.next()){
         cmbColor.getItems().addAll(rst.getString("Item_desc"));
      }
      
      }catch(SQLException e){
      }
     
  }
        public String getPrice(){
       String price = null;
        try {
           
            Connection conn = connect.getConnection();
            st = conn.createStatement();
            rst = st.executeQuery("SELECT Item_Price FROM `itemdetails` WHERE Item_Name = '"+cmbName.getValue()+"'");
            while(rst.next()){
                price = rst.getString("Item_Price");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ZayinDashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     return price;
  }

    @FXML
    private void btnStoreAction(ActionEvent event) throws IOException {
       
    }

    @FXML
    private void btnCreateUserAction(ActionEvent event) throws IOException {
         BorderPane createUser = FXMLLoader.load(getClass().getResource("ZayinCreateUser.fxml"));
         adminDashBoard.getChildren().setAll(createUser);
    }




    @FXML
    private void btnLogoutAction(ActionEvent event) throws IOException {
        btnLogout.getScene().getWindow().hide();
        newscene("ZayinLoginFXML.fxml");
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
    private void btnAddItemAction(ActionEvent event) throws IOException {
         BorderPane addItem = FXMLLoader.load(getClass().getResource("ZayinAddItem.fxml"));
         adminDashBoard.getChildren().setAll(addItem);
    }

    @FXML
    private void btnAddAction(ActionEvent event) {
       String itemName = cmbName.getValue();
       String itemDesc = cmbColor.getValue();
       String itemCategory = cmbCat.getValue();
       String itemSize = cmbSize.getValue();
       String itemPrice = getPrice();
       Items items = new Items(itemName,itemDesc,itemCategory,itemSize,itemPrice);
       try{
           String sql = "insert into invoice(itemCategory,itemName,itemColor,itemSize,itemPrice) Values(?,?,?,?,?)";
           PreparedStatement pstmt;
           pstmt = connect.getConnection().prepareStatement(sql);
           pstmt.setString(1, items.getItemCategory());
           pstmt.setString(2, items.getItemName());
           pstmt.setString(3, items.getItemDescription());
           pstmt.setString(4, items.getItemSize());
           pstmt.setString(5, items.getItemPrice());
           pstmt.execute();
           pstmt.close();
    }catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e);
        }
        getItems();
        
        
    }
        
        
      public ResultSet getItems(){
     listItems = FXCollections.observableArrayList();
         try{
          rst = connect.getInvoice();
          while(rst.next()){
       String itemName = rst.getString("itemName");
       String itemDesc = rst.getString("ItemColor");
       String itemCategory = rst.getString("itemCategory");
       String itemSize = rst.getString("itemSize");
       String itemPrice = rst.getString("itemPrice");
          
             listItems.add(new Items(itemName,itemDesc,itemCategory,itemSize,itemPrice));
      
             }
         }catch(SQLException e){
             }
       
        colCat.setCellValueFactory(new PropertyValueFactory<>("itemCategory"));
        colName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("itemDescription"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        colSize.setCellValueFactory(new PropertyValueFactory<>("itemSize"));
        tbl2.setItems(listItems);
          return rst;
    }
    
        
    
    
    

    @FXML
    private void cmbCatAction(ActionEvent event) throws SQLException {
         getNameC();
       
    }

    @FXML
    private void cmbNameAction(ActionEvent event) {
         getSizeC();
         getColorC();
    }

    @FXML
    private void cmbColorAction(ActionEvent event) {
    }

    @FXML
    private void cmbSizeAction(ActionEvent event) {
    }

    @FXML
    private void btnCheckoutAction(ActionEvent event) throws IOException {
        try {
          PreparedStatement pstmt;
       
          String sql = "TRUNCATE TABLE invoice";
          pstmt = connect.getConnection().prepareStatement(sql);
          if(pstmt.execute())
          {JOptionPane.showMessageDialog(null, "Deleted + e");
          }  
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e"+e);
      }
      
        BorderPane store = FXMLLoader.load(getClass().getResource("ZayinDashBoard.fxml"));
        adminDashBoard.getChildren().setAll(store);
    }

    @FXML
    private void btnClearAction(ActionEvent event) {
        cmbCat.getItems().clear();
        cmbSize.getItems().clear();
        cmbName.getItems().clear();
        cmbColor.getItems().clear();
        BindCombo();
    }

   
 
}
