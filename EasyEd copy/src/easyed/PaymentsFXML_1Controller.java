/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyed;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class PaymentsFXML_1Controller implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private BorderPane payPane;
    @FXML
    private MenuButton cmbOption;
    @FXML
    private Button btnStudDetails;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnPayment;
    @FXML
    private Button btnclass;
    @FXML
    private Button btnInventory;
    @FXML
    private Button btnStudReg;
    @FXML
    private Button btnInventory1;
    @FXML
    private Button btnHome1;
    @FXML
    private ComboBox<?> cmbSession;
    @FXML
    private ComboBox<?> cmbTerm;
    @FXML
    private ComboBox<?> cmbClass;
    @FXML
    private ComboBox<?> cmbClass1;
    @FXML
    private ComboBox<?> cmbClass11;
    @FXML
    private DatePicker dp_doa;
    @FXML
    private ListView<MyBooks> listBooks;
    ObservableList<MyBooks> myBooks;
    ResultSet rst;
    EasyEdConnect connect;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            getBooks();
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(PaymentsFXML_1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void cmbOptionAction(ActionEvent event) {
    }

    @FXML
    private void btnStudDetailsAction(ActionEvent event) {
    }

    @FXML
    private void btnHomeAction(ActionEvent event) {
    }

    @FXML
    private void btnPaymentAction(ActionEvent event) {
    }

    @FXML
    private void btnClassAction(ActionEvent event) {
    }

    @FXML
    private void btnInventoryAction(ActionEvent event) {
    }

    @FXML
    private void btnStudRegAction(ActionEvent event) {
    }

    @FXML
    private void cmbSessionAction(ActionEvent event) {
    }

    @FXML
    private void cmbTermAction(ActionEvent event) {
    }

    @FXML
    private void cmbClassAction(ActionEvent event) {
    }
    
    
    public void getBooks() throws SQLException{
         myBooks = FXCollections.observableArrayList();
        rst = connect.getMyBooks("5");
        while (rst.next()) {
            String id = rst.getString("book_id");
            String books = rst.getString("book_desc");
            String price = rst.getString("price");
            myBooks.addAll(new MyBooks(id, books, price));
            listBooks.setItems(myBooks);
//            listBooks.setConverter(new StringConverter<MyBooks>() {
//                @Override
//                public String toString(MyBooks object) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
//                @Override
//                public MyBooks fromString(String string) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//               
//
//            });

        }
       
    }
}
