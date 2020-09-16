/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zayinlieva;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author STANLEY
 */
public class ZayinAddItemController implements Initializable {

    @FXML
    private BorderPane adminDashBoard;
    @FXML
    private Button btnCreateUser;
    @FXML
    private Button btnStore;
    @FXML
    private Button btnAddItem;
    @FXML
    private Button btnLogout;
    @FXML
    private ComboBox<String> cmbCat1;
    @FXML
    private TableColumn<Items, String> colCategory;
    @FXML
    private TableColumn<Items, String> colName;
    @FXML
    private TableColumn<Items, String> colSize;
    @FXML
    private TableColumn<Items, String> colColor;
    @FXML
    private TableColumn<Items, String> colPrice;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtColor;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtSize;
    
    ZayinConnect connect;
    @FXML
    private TableView<Items> tblItems;
    
    ObservableList<Items> listItems;
    ResultSet rst;
    @FXML
    private TableColumn<Items, String> colId;
    @FXML
    private TextField txtId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        connect = new ZayinConnect();
        cmbCat1.getItems().addAll("Shoes","Sweat Wears","Slippers");
        getItems();
       
    }    

    @FXML
    private void btnCreateUserAction(ActionEvent event) throws IOException {
        BorderPane createUser = FXMLLoader.load(getClass().getResource("ZayinCreateUser.fxml"));
        adminDashBoard.getChildren().setAll(createUser);
    }

    @FXML
    private void btnStoreAction(ActionEvent event) throws IOException {
        BorderPane store = FXMLLoader.load(getClass().getResource("ZayinDashBoard.fxml"));
        adminDashBoard.getChildren().setAll(store);
    }

    @FXML
    private void btnAddItemAction(ActionEvent event) throws SQLException {
       String itemName = txtName.getText();
       String itemDesc = txtColor.getText();
       String itemCategory = cmbCat1.getValue();
       String itemPrice = txtPrice.getText();
       String itemSize = txtSize.getText();
       Items items = new Items(itemName,itemDesc,itemCategory,itemPrice,itemSize);
       try{
           String sql = "Insert into itemdetails(item_Name, item_Desc,item_Category,item_Price,item_Size) Values(?,?,?,?,?)";
           PreparedStatement pstmt;
           pstmt = connect.getConnection().prepareStatement(sql);
           pstmt.setString(1, items.getItemName());
           pstmt.setString(2, items.getItemDescription());
           pstmt.setString(3, items.getItemCategory());
           pstmt.setString(4, items.getItemPrice());
           pstmt.setString(5, items.getItemSize());
           pstmt.execute();
           JOptionPane.showMessageDialog(null, "RECORD UPDATED SUCCESSFULLY");
           pstmt.close();
    }catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e);
        }
        getItems();
        clearFields();
    }
    

    @FXML
    private void btnLogoutAction(ActionEvent event) {
        btnLogout.getScene().getWindow().hide();
        newscene("ZayinLoginFXML.fxml");
    }
    
     

    @FXML
    private void btnUpdateAction(ActionEvent event) {
        
    }

    @FXML
    private void btnDeleteAction(ActionEvent event) throws SQLException {
        try{ String del = txtId.getText(); 
         String sql = "Delete from itemdetails where id= ?";
         PreparedStatement pstmt;
         pstmt = connect.getConnection().prepareStatement(sql);
         pstmt.setString(1, txtId.getText());
         pstmt.executeUpdate();
         JOptionPane.showMessageDialog(null, "RECORD DELETED SUCCESSFULLY");
         pstmt.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e);
        }
         getItems();
    }
      @FXML
    private void cmb1CatAction(ActionEvent event) {
         String category = cmbCat1.getValue();
    }
    
    private ResultSet getItems(){
       listItems = FXCollections.observableArrayList();
        try {
             rst = connect.SelectItems();
             while(rst.next()){
       String id = rst.getString("id");     
       String itemCategory = rst.getString("Item_Category");
       String itemName = rst.getString("Item_Name");
       String itemDescription = rst.getString("Item_desc");
       String itemPrice = rst.getString("Item_Price");
       String itemSize = rst.getString("Item_Size");
          
             listItems.add(new Items(id,itemName,itemDescription,itemCategory,itemPrice,itemSize));
             }

        } catch (SQLException e) {
            System.err.println(e);
        }
        
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("itemCategory"));
        colName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("itemDescription"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        colSize.setCellValueFactory(new PropertyValueFactory<>("itemSize"));
        tblItems.setItems(listItems);
        return rst;
       
    }
    
     private void clearFields(){
       txtName.setText("");
       txtColor.setText("");
       cmbCat1.setValue("Select Category");
       txtPrice.setText("");
       txtSize.setText("");
     
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
