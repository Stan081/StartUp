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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class ClassFXMLController implements Initializable {

    EasyEdConnect connect;
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
    private TableColumn<Students, String> colId;
    @FXML
    private TableColumn<Students, String> colFName;
    @FXML
    private TableColumn<Students, String> colONames;
    @FXML
    private TableColumn<Students, String> colGender;
    @FXML
    private TableColumn<Students, String> colPhone;
    @FXML
    private TableColumn<Students, String> colFees;
    @FXML
    private ComboBox<MySession> cmbSession;
    @FXML
    private ComboBox<MyTerm> cmbTerm;
    @FXML
    private ComboBox<MyClass> cmbClass;
    @FXML
    private Button btnSortFields;
    ResultSet rst;
    PreparedStatement pstmt;
    ObservableList<MyClass> myClass;
    ObservableList<MyTerm> myTerm;
    ObservableList<MySession> mySession;
    ObservableList<Students> listStudent;
    @FXML
    private TableColumn<Transactions, String> colFeeDate;
    @FXML
    private TableColumn<Transactions, String> colFeePrice;
    @FXML
    private TableColumn<Transactions, String> colUniformDesc;
    @FXML
    private TableColumn<Transactions, String> colBookDesc;
    @FXML
    private TableColumn<Transactions, String> colBookDate;
    @FXML
    private TableColumn<Transactions, String> colBookPrice;
    @FXML
    private TableView<Students> tblStudClass;
    @FXML
    private TableView<Transactions> tblStudFee;
    @FXML
    private TableView<Transactions> tblStudUniform;
    @FXML
    private TableView<Transactions> tblStudBooks;
    ObservableList trans;
    ObservableList trans1;
    ObservableList trans2;
    @FXML
    private TableColumn<Transactions, String> colFeeDesc;
    @FXML
    private TableColumn<Transactions, String> colUniformPrice;
    @FXML
    private TableColumn<Transactions, String> colUnifromDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connect = new EasyEdConnect();
        try {
            popClass();
//        
        } catch (SQLException ex) {
            Logger.getLogger(ClassFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    private void tbiStudentsSelectAction(MouseEvent event) {
        String id = tblStudClass.getSelectionModel().getSelectedItem().getId();
        String session = cmbSession.getValue().getSession_id();
        String term = cmbTerm.getValue().getTerm_id();
        String sClass = cmbClass.getValue().getClass_id();

        trans = FXCollections.observableArrayList();
         trans1 = FXCollections.observableArrayList();
          trans2 = FXCollections.observableArrayList();
        try {
            String sql = "SELECT `item_desc`,`price`,`trans_date`,`pay_id`  FROM transaction_tbl WHERE `class_stud_id`= " + id + " ";
            pstmt = connect.getConnection().prepareStatement(sql);
            rst = pstmt.executeQuery();
                while (rst.next()) {
                    if (Integer.parseInt(rst.getString("pay_id")) == 1) {
                    String itemDesc = rst.getString("item_desc");
                    String price = rst.getString("price");
                    String date = rst.getString("trans_date");
                    trans.add(new Transactions(itemDesc, price, date));
                }
                colFeeDesc.setCellValueFactory(new PropertyValueFactory<>("ItemDesc"));
                colFeePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
                colFeeDate.setCellValueFactory(new PropertyValueFactory<>("date"));
                tblStudFee.setItems(trans);
                
                 if (Integer.parseInt(rst.getString("pay_id")) == 2) {
                    String itemDesc = rst.getString("item_desc");
                    String price = rst.getString("price");
                    String date = rst.getString("trans_date");
                    trans1.add(new Transactions(itemDesc, price, date));
                }
                colBookDesc.setCellValueFactory(new PropertyValueFactory<>("ItemDesc"));
                colBookPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
                colBookDate.setCellValueFactory(new PropertyValueFactory<>("date"));
                tblStudBooks.setItems(trans1);
                
                 if (Integer.parseInt(rst.getString("pay_id")) == 3) {
                    String itemDesc = rst.getString("item_desc");
                    String price = rst.getString("price");
                    String date = rst.getString("trans_date");
                    trans2.add(new Transactions(itemDesc, price, date));
                }
                colUniformDesc.setCellValueFactory(new PropertyValueFactory<>("ItemDesc"));
                colUniformPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
                colUnifromDate.setCellValueFactory(new PropertyValueFactory<>("date"));
                tblStudUniform.setItems(trans2);
            }
            
            pstmt.close();
            rst.close();

        } catch (SQLException e) {

        }
    }

    @FXML
    private void cmbSessionAction(ActionEvent event) {
        cmbSession.valueProperty().addListener((obs, oldval, newval) -> {
            if (newval != null) {
                System.out.println(newval.getSession_id());
            }
        });

    }

    @FXML
    private void cmbTermAction(ActionEvent event) {
        cmbTerm.valueProperty().addListener((ObservableValue<? extends MyTerm> obs, MyTerm oldval, MyTerm newval) -> {
            if (newval != null) {
                System.out.println(newval.getTerm_id());
            }
        });
    }

    @FXML
    private void cmbClassAction(ActionEvent event) {
        cmbClass.valueProperty().addListener((obs, oldval, newval) -> {
            System.out.println("ID" + newval.getClass_id());
        });
    }

    @FXML
    private void btnSortFieldsAction(ActionEvent event) {
        getStudentDet();

    }

    public void popStateCombo() {
    }

    public void popClass() throws SQLException {
        myClass = FXCollections.observableArrayList();
        myTerm = FXCollections.observableArrayList();
        mySession = FXCollections.observableArrayList();
        try {
            rst = connect.selectMyClass();
            while (rst.next()) {
                String class_id = rst.getString("class_id");
                String class_name = rst.getString("class_name");
                myClass.addAll(new MyClass(class_id, class_name));
                cmbClass.setItems(myClass);
                cmbClass.setConverter(new StringConverter<MyClass>() {
                    @Override
                    public String toString(MyClass object) {
                        return object.getClass_name();
                    }

                    @Override
                    public MyClass fromString(String string) {
                        return cmbClass.getItems().stream().filter(ap -> ap.getClass_name().equals(string)).findFirst().orElse(null);
                    }

                });

            }

            rst = connect.getMyTerm();
            while (rst.next()) {
                String term_id = rst.getString("term_id");
                String term_desc = rst.getString("term_desc");
                myTerm.addAll(new MyTerm(term_id, term_desc));
                cmbTerm.setItems(myTerm);
                cmbTerm.setConverter(new StringConverter<MyTerm>() {
                    @Override
                    public String toString(MyTerm object) {
                        return object.getTerm_desc();
                    }

                    @Override
                    public MyTerm fromString(String string) {
                        return cmbTerm.getItems().stream().filter(ap -> ap.getTerm_desc().equals(string)).findFirst().orElse(null);
                    }

                });

            }
            rst = connect.getMySession();
            while (rst.next()) {
                String session_id = rst.getString("session_id");
                String session_desc = rst.getString("session_desc");
                mySession.addAll(new MySession(session_id, session_desc));
                cmbSession.setItems(mySession);
                cmbSession.setConverter(new StringConverter<MySession>() {
                    @Override
                    public String toString(MySession object) {
                        return object.getSession_desc();
                    }

                    @Override
                    public MySession fromString(String string) {
                        return cmbSession.getItems().stream().filter(ap -> ap.getSession_desc().equals(string)).findFirst().orElse(null);
                    }

                });

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
        }
    }

    private ResultSet getStudentDet() {
        listStudent = FXCollections.observableArrayList();
        String session = cmbSession.getValue().getSession_id();
        String term = cmbTerm.getValue().getTerm_id();
        String sClass = cmbClass.getValue().getClass_id();
        try {
            String sql = "SELECT * FROM `student_details` s  JOIN `class_stud` c on s.stud_id = c.stud_id WHERE session_id = '" + session + "' AND term_id ='" + term + "' AND class_id = '" + sClass + "'";
            pstmt = connect.getConnection().prepareStatement(sql);
            rst = pstmt.executeQuery();
            while (rst.next()) {
                String id = rst.getString("class_stud_id");
                String firstName = rst.getString("first_name");
                String otherNames = rst.getString("last_name");
                String sex = rst.getString("sex");
                String dateOfBirth = rst.getString("dob");
                String guardianPhone = rst.getString("guards_phone");

                listStudent.add(new Students(id, firstName, otherNames, sex, dateOfBirth, guardianPhone));

            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colONames.setCellValueFactory(new PropertyValueFactory<>("otherNames"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("sex"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("dateofBirth"));
        colFees.setCellValueFactory(new PropertyValueFactory<>("guardianPhone"));
        tblStudClass.setItems(listStudent);
        return rst;

    }

}
