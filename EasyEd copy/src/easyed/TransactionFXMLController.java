/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyed;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class TransactionFXMLController implements Initializable {

    EasyEdConnect connect;
    ResultSet rst;
    PreparedStatement pstmt;
    ObservableList<Transactions> trans;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button btnStaffDashboard;
    @FXML
    private Button btnStudReg;
    @FXML
    private Button btnStudDet;
    @FXML
    private Button btnPaymentDashboard;
    @FXML
    private Button btnclassDashboard;
    @FXML
    private Button btnInventoryDashboard;
    @FXML
    private Button btnDashboard;
    @FXML
    private TableColumn<Transactions, String> colId;
    @FXML
    private Button btnAllTrans;
    @FXML
    private Button btnFees;
    @FXML
    private Button btnUniforms;
    @FXML
    private Button btnBooks;
    @FXML
    private TableColumn<Transactions, String> colSName;
    @FXML
    private TableColumn<Transactions, String> colClass;
    @FXML
    private TableColumn<Transactions, String> colPayType;
    @FXML
    private TableColumn<Transactions, String> colDesc;
    @FXML
    private TableColumn<Transactions, String> colQty;
    @FXML
    private TableColumn<Transactions, String> colPrice;
    @FXML
    private TableColumn<Transactions, String> colDate;
    @FXML
    private TableView<Transactions> tblTrans;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connect = new EasyEdConnect();
        getTrans();
        // TODO
    }

    @FXML
    private void btnStaffDashboardAction(ActionEvent event) throws IOException {
         AnchorPane staffs = FXMLLoader.load(getClass().getResource("staffsFXML.fxml"));
        rootPane.getChildren().setAll(staffs);
    }

    @FXML
    private void btnStudRegAction(ActionEvent event) throws IOException {
          AnchorPane studReg = FXMLLoader.load(getClass().getResource("studRegFXML.fxml"));
        rootPane.getChildren().setAll(studReg);
    }

    @FXML
    private void btnStudDetAction(ActionEvent event) throws IOException {
        AnchorPane studDet = FXMLLoader.load(getClass().getResource("studDetailsFXML.fxml"));
        rootPane.getChildren().setAll(studDet);
    }

    @FXML
    private void btnPaymentDashboardAction(ActionEvent event) throws IOException {
          AnchorPane payPane = FXMLLoader.load(getClass().getResource("paymentsFXML.fxml"));
        rootPane.getChildren().setAll(payPane);
    }

    @FXML
    private void btnClassDashboardAction(ActionEvent event) throws IOException {
          AnchorPane payPane = FXMLLoader.load(getClass().getResource("classFXML.fxml"));
        rootPane.getChildren().setAll(payPane);
    }

    @FXML
    private void btnInventoryDashboardAction(ActionEvent event) throws IOException {
         AnchorPane payPane = FXMLLoader.load(getClass().getResource("transactionFXML.fxml"));
        rootPane.getChildren().setAll(payPane);
    }

    @FXML
    private void btnDashboardAction(ActionEvent event) throws IOException {
         AnchorPane payPane = FXMLLoader.load(getClass().getResource("dashBoardFXML.fxml"));
        rootPane.getChildren().setAll(payPane);
    }

    @FXML
    private void tblStudDetsSelectAction(MouseEvent event) {
    }

    @FXML
    private void btnAllTransAction(ActionEvent event) {
        getTrans();
    }

    @FXML
    private void btnFeesAction(ActionEvent event) {
        sortTrans(1);   
    }

    @FXML
    private void btnUniformsAction(ActionEvent event) {
        sortTrans(3);
    }

    @FXML
    private void btnBooksAction(ActionEvent event) {
    }

    private ResultSet getTrans() {
        trans = FXCollections.observableArrayList();
        try {
            rst = connect.getMyTransaction();
            while (rst.next()) {
                String transId = rst.getString("trans_id");
                String name = rst.getString("first_name") + "  " + rst.getString("last_name");
                String stud_class = rst.getString("class_name");
                String itemDesc = rst.getString("item_desc");
                String payType = "Cash";
                String quantity = rst.getString("quantity");
                String price = rst.getString("price");
                String date = rst.getString("trans_date");

                trans.add(new Transactions(transId, name, stud_class, payType, itemDesc, quantity, price, date));

            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("transId"));
        colSName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colClass.setCellValueFactory(new PropertyValueFactory<>("stud_class"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("ItemDesc"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colPayType.setCellValueFactory(new PropertyValueFactory<>("payType"));
        tblTrans.setItems(trans);
        return rst;

    }

  public void sortTrans(int id){
       trans = FXCollections.observableArrayList();
        try {
            String sql1 = "SELECT `first_name`,`last_name`,`class_name`,`item_desc`,`price`,`trans_date`,`quantity`,`trans_id` FROM student_details s JOIN class_stud c ON s.stud_id = c.stud_id JOIN transaction_tbl t ON c.class_stud_id = t.class_stud_id JOIN class_details cd ON cd.class_id = c.class_id WHERE `pay_id`= '"+id+"'";
            pstmt = connect.getConnection().prepareStatement(sql1);
            rst = pstmt.executeQuery(sql1);
            while (rst.next()) {
                String transId = rst.getString("trans_id");
                String name = rst.getString("first_name") + "  " + rst.getString("last_name");
                String stud_class = rst.getString("class_name");
                String itemDesc = rst.getString("item_desc");
                String payType = "Cash";
                String quantity = rst.getString("quantity");
                String price = rst.getString("price");
                String date = rst.getString("trans_date");

                trans.add(new Transactions(transId, name, stud_class, payType, itemDesc, quantity, price, date));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
        }
        colId.setCellValueFactory(new PropertyValueFactory<>("transId"));
        colSName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colClass.setCellValueFactory(new PropertyValueFactory<>("stud_class"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("ItemDesc"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colPayType.setCellValueFactory(new PropertyValueFactory<>("payType"));
        tblTrans.setItems(trans);
  }

}
