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
import java.time.format.DateTimeFormatter;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class PaymentsFXMLController implements Initializable {

    EasyEdConnect connect;
    ResultSet rst;
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
    private ComboBox<MySession> cmbSession;
    @FXML
    private ComboBox<MyTerm> cmbTerm;
    @FXML
    private ComboBox<MyClass> cmbClass;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button btnHome1;
    ObservableList<MyTerm> myTerm;
    ObservableList<MySession> mySession;
    ObservableList<MyClass> myClass;
    @FXML
    private ComboBox<?> cmbStudCat;
    @FXML
    private ComboBox<String> cmbClassGroup;

    @FXML
    private Button btnPay;
    @FXML
    private Button btnClear;
    @FXML
    private CheckBox chkBSFee;
    @FXML
    private CheckBox chkBRegFee;
    @FXML
    private CheckBox chkBPTA;
    @FXML
    private CheckBox chkBExamFee;
    @FXML
    private CheckBox chkBUtil;
    @FXML
    private CheckBox chkBReport;
    @FXML
    private CheckBox chkBPEUniform;
    @FXML
    private CheckBox chkBCardigan;
    @FXML
    private TextField txtClassStudId;
    @FXML
    private TextField lblPE;
    @FXML
    private TextField lblSc;
    @FXML
    private TableColumn<Transactions, String> colDesc;
    @FXML
    private TableColumn<Transactions, Integer> colQty;
    @FXML
    private TableColumn<Transactions, String> colPrice;
    @FXML
    private TableView<Transactions> tblTrans;
    ObservableList<Transactions> listTrans;
    ObservableList<Transactions> listTrans1;
    ObservableList<MyBooks> myBooks;
    Dictionary myUniforms = new Hashtable();
    Dictionary myFees = new Hashtable();
    @FXML
    private TableColumn<Transactions, String> colId;
    @FXML
    private TextField lblSFee;
    @FXML
    private TextField lblRegFee;
    @FXML
    private TextField lblPTA;
    @FXML
    private TextField lblExamFee;
    @FXML
    private TextField lblUtil;
    @FXML
    private TextField lblReport;
    @FXML
    private Button btnAddSelected;
    @FXML
    private TextField txtQS;
    @FXML
    private TextField txtQP;
    @FXML
    private Label lblTotal;
    @FXML
    private ComboBox<MyBooks> cmbBooks;
    PreparedStatement pstmt;
    @FXML
    private DatePicker dp_dop;
    @FXML
    private CheckBox chkBSchoolUniformB;
    @FXML
    private TextField txtQSB;
    @FXML
    private TextField lblSUR;
    @FXML
    private TextField lblSUB;
    @FXML
    private TextField txtQSc;
    @FXML
    private CheckBox chkBSchoolUniformR;
    @FXML
    private Label lblBookPrice;
    @FXML
    private Button btnAddBook;
    @FXML
    private Label lblPrice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        connect = new EasyEdConnect();
        cmbClassGroup.getItems().addAll("Nursery", "Primary");
        cmbClassGroup.setValue("Primary");

        try {
            popUni();
            popClass();
            popFees();
        } catch (SQLException ex) {
            Logger.getLogger(PaymentsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void cmbOptionAction(ActionEvent event) {
    }

    @FXML
    private void btnStudDetailsAction(ActionEvent event) throws IOException {
        AnchorPane studDet = FXMLLoader.load(getClass().getResource("studDetailsFXML.fxml"));
        rootPane.getChildren().setAll(studDet);
    }

    @FXML
    private void btnHomeAction(ActionEvent event) throws IOException {
           AnchorPane payPane = FXMLLoader.load(getClass().getResource("dashBoardFXML.fxml"));
        rootPane.getChildren().setAll(payPane);
    }

    @FXML
    private void btnPaymentAction(ActionEvent event) {
    }

    @FXML
    private void btnClassAction(ActionEvent event) throws IOException {
        AnchorPane classDash = FXMLLoader.load(getClass().getResource("classFXML.fxml"));
        rootPane.getChildren().setAll(classDash);
    }

    @FXML
    private void btnInventoryAction(ActionEvent event) throws IOException {
        AnchorPane studDet = FXMLLoader.load(getClass().getResource("transactionFXML.fxml"));
        rootPane.getChildren().setAll(studDet);
    }

    @FXML
    private void btnStudRegAction(ActionEvent event) throws IOException {
        AnchorPane studReg = FXMLLoader.load(getClass().getResource("studRegFXML.fxml"));
        rootPane.getChildren().setAll(studReg);
    }

    @FXML
    private void cmbSessionAction(ActionEvent event) {
    }

    @FXML
    private void cmbTermAction(ActionEvent event) {
    }

    @FXML
    private void cmbClassAction(ActionEvent event) throws SQLException {
        String sClass = cmbClass.getValue().getClass_id();
        myBooks = FXCollections.observableArrayList();
        rst = connect.getMyBooks(sClass);
        while (rst.next()) {
            String id = rst.getString("book_id");
            String books = rst.getString("book_desc");
            String price = rst.getString("price");
            myBooks.addAll(new MyBooks(id, books, price));
            cmbBooks.setItems(myBooks);
            cmbBooks.setConverter(new StringConverter<MyBooks>() {
                @Override
                public String toString(MyBooks object) {
                    return object.getBook_desc();
                }

                @Override
                public MyBooks fromString(String string) {
                    return cmbBooks.getItems().stream().filter(ap -> ap.getBook_desc().equals(string)).findFirst().orElse(null);
                }

            });

        }

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

    public void popFees() throws SQLException {
        rst = connect.getMyFees();

        if (cmbClassGroup.getValue().equals("Nursery")) {
            while (rst.next()) {
                String desc = rst.getString("fee_id");
                String price = rst.getString("amount_nur");
                myFees.put(desc, price);

            }
            String sFees = myFees.get("1").toString();
            String regFees = myFees.get("2").toString();
            String ptaFees = myFees.get("3").toString();
            String utilFees = myFees.get("4").toString();
            String examFees = myFees.get("5").toString();
            String reportFees = myFees.get("6").toString();

            chkBSFee.setText(sFees);
            chkBRegFee.setText(regFees);
            chkBPTA.setText(ptaFees);
            chkBExamFee.setText(utilFees);
            chkBUtil.setText(examFees);
            chkBReport.setText(reportFees);
        } else {
            while (rst.next()) {
                String desc = rst.getString("fee_id");
                String price = rst.getString("amount_pri");
                myFees.put(desc, price);

            }
            String sFees = myFees.get("1").toString();
            String regFees = myFees.get("2").toString();
            String ptaFees = myFees.get("3").toString();
            String utilFees = myFees.get("4").toString();
            String examFees = myFees.get("5").toString();
            String reportFees = myFees.get("6").toString();
            System.out.println(myFees.elements());

            chkBSFee.setText(sFees);
            chkBRegFee.setText(regFees);
            chkBPTA.setText(ptaFees);
            chkBExamFee.setText(utilFees);
            chkBUtil.setText(examFees);
            chkBReport.setText(reportFees);

        }
    }

    public void popUni() throws SQLException {
        rst = connect.getMyUniforms();
        while (rst.next()) {
            String desc = rst.getString("u_id");
            String price = rst.getString("price");
            myUniforms.put(desc, price);
        }
        String sUniR = myUniforms.get("1").toString();
        String sUniB = myUniforms.get("4").toString();
        String peUni = myUniforms.get("2").toString();
        String cardi = myUniforms.get("3").toString();
        chkBSchoolUniformR.setText(sUniR);
        chkBSchoolUniformB.setText(sUniB);
        chkBPEUniform.setText(peUni);
        chkBCardigan.setText(cardi);

    }

    @FXML
    private void cmbStudCatAction(ActionEvent event) {
    }

    @FXML
    private void cmbClassGroupAction(ActionEvent event) throws SQLException {
        popFees();

    }

    @FXML
    private void btnPayAction(ActionEvent event) throws SQLException {
        if (chkBSchoolUniformB.isSelected()) {
            String classStudId = txtClassStudId.getText();
            String payId = "3";
            String itemId = "1";
            String itemDesc = lblSUB.getText();
            int price = Integer.parseInt(chkBSchoolUniformB.getText());
            int quantity1 = Integer.parseInt(txtQS.getText());
            String quantity = txtQSB.getText();
            int totPrice = price * quantity1;
            String tot = String.valueOf(totPrice);
            String date = dp_dop.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Transactions listTrans = new Transactions(classStudId, payId, itemId, itemDesc, quantity, tot, date);
            String sql = "INSERT INTO `transaction_tbl`(`class_stud_id`,`pay_id`,`item_id`,`item_desc`,`quantity`,`price`,`trans_date`) VALUES(?,?,?,?,?,?,?)";
            pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setString(1, listTrans.getClassStudId());
            pstmt.setString(2, listTrans.getPayId());
            pstmt.setString(3, listTrans.getItemId());
            pstmt.setString(4, listTrans.getItemDesc());
            pstmt.setString(5, listTrans.getQuantity());
            pstmt.setString(6, listTrans.getPrice());
            pstmt.setString(7, listTrans.getDate());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "RECORD INSERTED SUCCESSFULLY");
            pstmt.close();

        }
        if (chkBSchoolUniformR.isSelected()) {
            String classStudId = txtClassStudId.getText();
            String payId = "3";
            String itemId = "1";
            String itemDesc = lblSUB.getText();
            int price = Integer.parseInt(chkBSchoolUniformR.getText());
            int quantity1 = Integer.parseInt(txtQS.getText());
            String quantity = txtQSB.getText();
            int totPrice = price * quantity1;
            String tot = String.valueOf(totPrice);
            String date = dp_dop.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Transactions listTrans = new Transactions(classStudId, payId, itemId, itemDesc, quantity, tot, date);
            String sql = "INSERT INTO `transaction_tbl`(`class_stud_id`,`pay_id`,`item_id`,`item_desc`,`quantity`,`price`,`trans_date`) VALUES(?,?,?,?,?,?,?)";
            pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setString(1, listTrans.getClassStudId());
            pstmt.setString(2, listTrans.getPayId());
            pstmt.setString(3, listTrans.getItemId());
            pstmt.setString(4, listTrans.getItemDesc());
            pstmt.setString(5, listTrans.getQuantity());
            pstmt.setString(6, listTrans.getPrice());
            pstmt.setString(7, listTrans.getDate());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "RECORD INSERTED SUCCESSFULLY");
            pstmt.close();

        }
        if (chkBPEUniform.isSelected()) {
            String classStudId = txtClassStudId.getText();
            String payId = "3";
            String itemId = "2";
            String itemDesc = lblPE.getText();
            int price = Integer.parseInt(chkBPEUniform.getText());
            int quantity1 = Integer.parseInt(txtQP.getText());
            String quantity = txtQP.getText();
            int totPrice = price * quantity1;
            String tot = String.valueOf(totPrice);
            String date = dp_dop.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Transactions listTrans = new Transactions(classStudId, payId, itemId, itemDesc, quantity, tot, date);
            String sql = "INSERT INTO `transaction_tbl`(`class_stud_id`,`pay_id`,`item_id`,`item_desc`,`quantity`,`price`,`trans_date`) VALUES(?,?,?,?,?,?,?)";
            pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setString(1, listTrans.getClassStudId());
            pstmt.setString(2, listTrans.getPayId());
            pstmt.setString(3, listTrans.getItemId());
            pstmt.setString(4, listTrans.getItemDesc());
            pstmt.setString(5, listTrans.getQuantity());
            pstmt.setString(6, listTrans.getPrice());
            pstmt.setString(7, listTrans.getDate());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "RECORD INSERTED SUCCESSFULLY");
            pstmt.close();

        }

        if (chkBCardigan.isSelected()) {
            String classStudId = txtClassStudId.getText();
            String payId = "3";
            String itemId = "3";
            String itemDesc = lblSc.getText();
            int price = Integer.parseInt(chkBCardigan.getText());
            int quantity1 = Integer.parseInt(txtQSc.getText());
            String quantity = txtQSc.getText();
            int totPrice = price * quantity1;
            String tot = String.valueOf(totPrice);
            String date = dp_dop.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Transactions listTrans = new Transactions(classStudId, payId, itemId, itemDesc, quantity, tot, date);
            String sql = "INSERT INTO `transaction_tbl`(`class_stud_id`,`pay_id`,`item_id`,`item_desc`,`quantity`,`price`,`trans_date`) VALUES(?,?,?,?,?,?,?)";
            pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setString(1, listTrans.getClassStudId());
            pstmt.setString(2, listTrans.getPayId());
            pstmt.setString(3, listTrans.getItemId());
            pstmt.setString(4, listTrans.getItemDesc());
            pstmt.setString(5, listTrans.getQuantity());
            pstmt.setString(6, listTrans.getPrice());
            pstmt.setString(7, listTrans.getDate());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "RECORD INSERTED SUCCESSFULLY");
            pstmt.close();
        }
//
        //for selecting fees to be payed.
        if (chkBSFee.isSelected()) {
            String classStudId = txtClassStudId.getText();
            String payId = "1";
            String itemId = "1";
            String itemDesc = lblSFee.getText();
            String quantity = "1";
            int price = Integer.parseInt(chkBSFee.getText());
            int quantity1 = 1;
            int totPrice = price * quantity1;
            String tot = String.valueOf(totPrice);
            String date = dp_dop.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Transactions listTrans = new Transactions(classStudId, payId, itemId, itemDesc, quantity, tot, date);
            String sql = "INSERT INTO `transaction_tbl`(`class_stud_id`,`pay_id`,`item_id`,`item_desc`,`quantity`,`price`,`trans_date`) VALUES(?,?,?,?,?,?,?)";
            pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setString(1, listTrans.getClassStudId());
            pstmt.setString(2, listTrans.getPayId());
            pstmt.setString(3, listTrans.getItemId());
            pstmt.setString(4, listTrans.getItemDesc());
            pstmt.setString(5, listTrans.getQuantity());
            pstmt.setString(6, listTrans.getPrice());
            pstmt.setString(7, listTrans.getDate());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "RECORD INSERTED SUCCESSFULLY");
            pstmt.close();
        }
        if (chkBRegFee.isSelected()) {
            String classStudId = txtClassStudId.getText();
            String payId = "1";
            String itemId = "2";
            String itemDesc = lblRegFee.getText();
            int price = Integer.parseInt(chkBRegFee.getText());
            String quantity = "1";
            int quantity1 = 1;
            int totPrice = price * quantity1;
            String tot = String.valueOf(totPrice);
            String date = dp_dop.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Transactions listTrans = new Transactions(classStudId, payId, itemId, itemDesc, quantity, tot, date);
            String sql = "INSERT INTO `transaction_tbl`(`class_stud_id`,`pay_id`,`item_id`,`item_desc`,`quantity`,`price`,`trans_date`) VALUES(?,?,?,?,?,?,?)";
            pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setString(1, listTrans.getClassStudId());
            pstmt.setString(2, listTrans.getPayId());
            pstmt.setString(3, listTrans.getItemId());
            pstmt.setString(4, listTrans.getItemDesc());
            pstmt.setString(5, listTrans.getQuantity());
            pstmt.setString(6, listTrans.getPrice());
            pstmt.setString(7, listTrans.getDate());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "RECORD INSERTED SUCCESSFULLY");
            pstmt.close();
        }
//
        if (chkBPTA.isSelected()) {
            String classStudId = txtClassStudId.getText();
            String payId = "1";
            String itemId = "3";
            String itemDesc = lblPTA.getText();
            int price = Integer.parseInt(chkBPTA.getText());
            String quantity = "1";
            int quantity1 = 1;
            int totPrice = price * quantity1;
            String tot = String.valueOf(totPrice);
            String date = dp_dop.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Transactions listTrans = new Transactions(classStudId, payId, itemId, itemDesc, quantity, tot, date);
            String sql = "INSERT INTO `transaction_tbl`(`class_stud_id`,`pay_id`,`item_id`,`item_desc`,`quantity`,`price`,`trans_date`) VALUES(?,?,?,?,?,?,?)";
            pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setString(1, listTrans.getClassStudId());
            pstmt.setString(2, listTrans.getPayId());
            pstmt.setString(3, listTrans.getItemId());
            pstmt.setString(4, listTrans.getItemDesc());
            pstmt.setString(5, listTrans.getQuantity());
            pstmt.setString(6, listTrans.getPrice());
            pstmt.setString(7, listTrans.getDate());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "RECORD INSERTED SUCCESSFULLY");
            pstmt.close();
        }
//
        if (chkBExamFee.isSelected()) {
            String classStudId = txtClassStudId.getText();
            String payId = "1";
            String itemId = "4";
            String itemDesc = lblExamFee.getText();
            int price = Integer.parseInt(chkBExamFee.getText());
            String quantity = "1";
            int quantity1 = 1;
            int totPrice = price * quantity1;
            String tot = String.valueOf(totPrice);
            String date = dp_dop.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Transactions listTrans = new Transactions(classStudId, payId, itemId, itemDesc, quantity, tot, date);
            String sql = "INSERT INTO `transaction_tbl`(`class_stud_id`,`pay_id`,`item_id`,`item_desc`,`quantity`,`price`,`trans_date`) VALUES(?,?,?,?,?,?,?)";
            pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setString(1, listTrans.getClassStudId());
            pstmt.setString(2, listTrans.getPayId());
            pstmt.setString(3, listTrans.getItemId());
            pstmt.setString(4, listTrans.getItemDesc());
            pstmt.setString(5, listTrans.getQuantity());
            pstmt.setString(6, listTrans.getPrice());
            pstmt.setString(7, listTrans.getDate());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "RECORD INSERTED SUCCESSFULLY");
            pstmt.close();
        }
//
        if (chkBUtil.isSelected()) {
            String classStudId = txtClassStudId.getText();
            String payId = "1";
            String itemId = "5";
            String itemDesc = lblUtil.getText();
            int price = Integer.parseInt(chkBUtil.getText());
            String quantity = "1";
            int quantity1 = 1;
            int totPrice = price * quantity1;
            String tot = String.valueOf(totPrice);
            String date = dp_dop.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Transactions listTrans = new Transactions(classStudId, payId, itemId, itemDesc, quantity, tot, date);
            String sql = "INSERT INTO `transaction_tbl`(`class_stud_id`,`pay_id`,`item_id`,`item_desc`,`quantity`,`price`,`trans_date`) VALUES(?,?,?,?,?,?,?)";
            pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setString(1, listTrans.getClassStudId());
            pstmt.setString(2, listTrans.getPayId());
            pstmt.setString(3, listTrans.getItemId());
            pstmt.setString(4, listTrans.getItemDesc());
            pstmt.setString(5, listTrans.getQuantity());
            pstmt.setString(6, listTrans.getPrice());
            pstmt.setString(7, listTrans.getDate());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "RECORD INSERTED SUCCESSFULLY");
            pstmt.close();
        }
//
        if (chkBReport.isSelected()) {
            String classStudId = txtClassStudId.getText();
            String payId = "1";
            String itemId = "6";
            String itemDesc = lblReport.getText();
            int price = Integer.parseInt(chkBReport.getText());
            String quantity = "1";
            int quantity1 = 1;
            int totPrice = price * quantity1;
            String tot = String.valueOf(totPrice);
            String date = dp_dop.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Transactions listTrans = new Transactions(classStudId, payId, itemId, itemDesc, quantity, tot, date);
            String sql = "INSERT INTO `transaction_tbl`(`class_stud_id`,`pay_id`,`item_id`,`item_desc`,`quantity`,`price`,`trans_date`) VALUES(?,?,?,?,?,?,?)";
            pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setString(1, listTrans.getClassStudId());
            pstmt.setString(2, listTrans.getPayId());
            pstmt.setString(3, listTrans.getItemId());
            pstmt.setString(4, listTrans.getItemDesc());
            pstmt.setString(5, listTrans.getQuantity());
            pstmt.setString(6, listTrans.getPrice());
            pstmt.setString(7, listTrans.getDate());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "RECORD INSERTED SUCCESSFULLY");
            pstmt.close();
        }

        chkBSFee.setSelected(false);
        chkBRegFee.setSelected(false);
        chkBPTA.setSelected(false);
        chkBExamFee.setSelected(false);
        chkBUtil.setSelected(false);
        chkBReport.setSelected(false);
        chkBSchoolUniformB.setSelected(false);
        chkBPEUniform.setSelected(false);
        chkBCardigan.setSelected(false);
        tblTrans.getItems().clear();
        lblTotal.setText("0");
        txtQS.setText("");
        txtQSc.setText("");
        txtQP.setText("");
//
    }

    @FXML
    private void btnClearAction(ActionEvent event) {
        chkBSFee.setSelected(false);
        chkBRegFee.setSelected(false);
        chkBPTA.setSelected(false);
        chkBExamFee.setSelected(false);
        chkBUtil.setSelected(false);
        chkBReport.setSelected(false);
        chkBSchoolUniformB.setSelected(false);
        chkBSchoolUniformR.setSelected(false);
        chkBPEUniform.setSelected(false);
        chkBCardigan.setSelected(false);
        tblTrans.getItems().clear();
        lblTotal.setText("0");
        txtQS.setText("");
        txtQSc.setText("");
        txtQP.setText("");
    }

    @FXML
    private void chkBSFeeAction(ActionEvent event) {

    }

    @FXML
    private void chkBRegFeeAction(ActionEvent event) {
    }

    @FXML
    private void chkBPTAAction(ActionEvent event) {
    }

    @FXML
    private void chkBExamFeeAction(ActionEvent event) {
    }

    @FXML
    private void chkBUtilaction(ActionEvent event) {
    }

    @FXML
    private void chkBReportAction(ActionEvent event) {
    }

    @FXML
    private void chkBPEUniformAction(ActionEvent event) {

    }

    @FXML
    private void chkBCardiganAction(ActionEvent event) {
    }

    @FXML
    private void btnUniGoAction(ActionEvent event) {
        checkSelections();
        colId.setCellValueFactory(new PropertyValueFactory<>("payId"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("itemDesc"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tblTrans.setItems(listTrans);

        int total = 0;
        for (int i = 0; i < tblTrans.getItems().size(); i++) {
            total = total + Integer.parseInt(colPrice.getCellObservableValue(i).getValue());
        }

        lblTotal.setText(String.valueOf(total));

    }

    public void checkSelections() {
        try {
            listTrans = FXCollections.observableArrayList();
            if (chkBSchoolUniformB.isSelected()) {
                String classStudId = txtClassStudId.getText();
                String payId = "3";
                String itemId = "1";
                String itemDesc = lblSUB.getText();
                int price = Integer.parseInt(chkBSchoolUniformB.getText());
                int quantity1 = Integer.parseInt(txtQSB.getText());
                String quantity = txtQSB.getText();
                int totPrice = price * quantity1;
                String tot = String.valueOf(totPrice);
                listTrans.add(new Transactions(payId, itemDesc, quantity, tot));
            }
            if (chkBSchoolUniformR.isSelected()) {
                String classStudId = txtClassStudId.getText();
                String payId = "3";
                String itemId = "4";
                String itemDesc = lblSUR.getText();
                int price = Integer.parseInt(chkBSchoolUniformR.getText());
                int quantity1 = Integer.parseInt(txtQS.getText());
                String quantity = txtQS.getText();
                int totPrice = price * quantity1;
                String tot = String.valueOf(totPrice);
                listTrans.add(new Transactions(payId, itemDesc, quantity, tot));
            }
            if (chkBPEUniform.isSelected()) {
                String classStudId = txtClassStudId.getText();
                String payId = "3";
                String itemId = "2";
                String itemDesc = lblPE.getText();
                int price = Integer.parseInt(chkBPEUniform.getText());
                String quantity = txtQP.getText();
                int quantity1 = Integer.parseInt(txtQP.getText());;
                int totPrice = price * quantity1;
                String tot = String.valueOf(totPrice);
                listTrans.add(new Transactions(payId, itemDesc, quantity, tot));

            }

            if (chkBCardigan.isSelected()) {
                String classStudId = txtClassStudId.getText();
                String payId = "3";
                String itemId = "3";
                String itemDesc = lblSc.getText();
                int price = Integer.parseInt(chkBCardigan.getText());
                String quantity = txtQS.getText();
                int quantity1 = Integer.parseInt(txtQSc.getText());;
                int totPrice = price * quantity1;
                String tot = String.valueOf(totPrice);
                listTrans.add(new Transactions(payId, itemDesc, quantity, tot));

            }

            //for selecting fees to be payed.
            if (chkBSFee.isSelected()) {
                String classStudId = txtClassStudId.getText();
                String payId = "1";
                String itemId = "1";
                String itemDesc = lblSFee.getText();
                int price = Integer.parseInt(chkBSFee.getText());
                String quantity = "1";
                String tot = String.valueOf(price);
                listTrans.add(new Transactions(payId, itemDesc, quantity, tot));

            }
            if (chkBRegFee.isSelected()) {
                String classStudId = txtClassStudId.getText();
                String payId = "1";
                String itemId = "2";
                String itemDesc = lblRegFee.getText();
                int price = Integer.parseInt(chkBRegFee.getText());
                String quantity = "1";
                String tot = String.valueOf(price);
                listTrans.add(new Transactions(payId, itemDesc, quantity, tot));

            }

            if (chkBPTA.isSelected()) {
                String classStudId = txtClassStudId.getText();
                String payId = "1";
                String itemId = "3";
                String itemDesc = lblPTA.getText();
                int price = Integer.parseInt(chkBPTA.getText());
                String quantity = "1";
                String tot = String.valueOf(price);
                listTrans.add(new Transactions(payId, itemDesc, quantity, tot));

            }

            if (chkBExamFee.isSelected()) {
                String classStudId = txtClassStudId.getText();
                String payId = "1";
                String itemId = "3";
                String itemDesc = lblExamFee.getText();
                int price = Integer.parseInt(chkBExamFee.getText());
                String quantity = "1";
                String tot = String.valueOf(price);
                listTrans.add(new Transactions(payId, itemDesc, quantity, tot));

            }

            if (chkBUtil.isSelected()) {
                String classStudId = txtClassStudId.getText();
                String payId = "1";
                String itemId = "3";
                String itemDesc = lblUtil.getText();
                int price = Integer.parseInt(chkBUtil.getText());
                String quantity = "1";
                String tot = String.valueOf(price);
                listTrans.add(new Transactions(payId, itemDesc, quantity, tot));

            }

            if (chkBReport.isSelected()) {
                String classStudId = txtClassStudId.getText();
                String payId = "1";
                String itemId = "3";
                String itemDesc = lblReport.getText();
                int price = Integer.parseInt(chkBReport.getText());
                String quantity = "1";
                String tot = String.valueOf(price);
                listTrans.add(new Transactions(payId, itemDesc, quantity, tot));
                
            }
            
           
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Enter Desired Quantity");
        }
    }

    @FXML
    private void chkBSchoolUniformBAction(ActionEvent event) {
    }

    @FXML
    private void chkBSchoolUniformRAction(ActionEvent event) {
    }

    @FXML
    private void btnAddBookAction(ActionEvent event) {
        addBooks();
        colId.setCellValueFactory(new PropertyValueFactory<>("payId"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("itemDesc"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tblTrans.setItems(listTrans);

        int total = 0;
        for (int i = 0; i < tblTrans.getItems().size(); i++) {
            total = total + Integer.parseInt(colPrice.getCellObservableValue(i).getValue());
        }

        lblTotal.setText(String.valueOf(total));
 
        

       
        
    }

    @FXML
    private void cmbBooksAction(ActionEvent event) throws SQLException {
        cmbBooks.valueProperty().addListener((obs, oldval, newval) -> {
            if (newval != null) {
                System.out.println(newval.getBook_id());
            }
        });
        String price = cmbBooks.getValue().getBook_price();
        lblPrice.setText(price);
    }
    
    public void addBooks(){
         listTrans = FXCollections.observableArrayList();
        try {
            String classStudId = txtClassStudId.getText();
            String payId = "2";
            String itemId = cmbBooks.getValue().getBook_id();
            String itemDesc = cmbBooks.getValue().getBook_desc();
            String quantity = "1";
            String tot = lblPrice.getText();
            listTrans.add(new Transactions(payId, itemDesc, quantity, tot));
        } catch (NullPointerException e) {
            System.out.println("dont know what the issue is tho");
            cmbBooks.getSelectionModel();
        }
    }
}
