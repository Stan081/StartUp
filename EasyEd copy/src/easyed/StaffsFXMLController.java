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
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class StaffsFXMLController implements Initializable {
    EasyEdConnect connect;
    ResultSet rst;
    PreparedStatement pstmt;
    @FXML
    private BorderPane StudentReg;
    @FXML
    private Button btnDashboardStudDet;
    @FXML
    private Button btnDashboardStaff;
    @FXML
    private Button btnDashboardPaySec;
    @FXML
    private Button btnDashboardClass;
    @FXML
    private Button btnDashboardInv;
    @FXML
    private Button btnDashboardStudReg;
    @FXML
    private Button btnDashbosrd;
    @FXML
    private TextField txtSON;
    @FXML
    private TextField txtSFName;
    @FXML
    private TextField txtSNation;
    @FXML
    private Button studentEdit;
    @FXML
    private DatePicker dpDOB;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label lblName;
    @FXML
    private Label lblPhone;
    @FXML
    private Label lblReligion;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblDOB;
    @FXML
    private Label lblGender;
    @FXML
    private Button btnUpdateStudent;
    @FXML
    private TableColumn<MyStaffs, String> colId;
    @FXML
    private TableColumn<MyStaffs, String> colFName;
    @FXML
    private TableColumn<MyStaffs, String> colONames;
    @FXML
    private TableColumn<MyStaffs, String> colGender;
    @FXML
    private TableColumn<MyStaffs , String> colPhone;
    @FXML
    private ComboBox<String> cmbQuali;
    @FXML
    private ComboBox<String> cmbReligion;
    @FXML
    private ComboBox<MyStates> cmbSState;
    @FXML
    private TextField txtSPhone;
    @FXML
    private ComboBox<String> cmbCMStatus;
    @FXML
    private TextArea txtRAddress;
    @FXML
    private ComboBox<String> cmbSSex;
    @FXML
    private ComboBox<String> cmbSLGA;
    @FXML
    private TextField txtSEmail;
    @FXML
    private DatePicker dpDOE;
    @FXML
    private TextArea txtOAddress;
    @FXML
    private TabPane tpStaffs;
    @FXML
    private Tab tpSDets;
    @FXML
    private Tab tpSReg;
    ObservableList myState;
    @FXML
    private Button btnAddStaff;
    @FXML
    private ComboBox<String> cmbRole;
    @FXML
    private TableView<MyStaffs> tblStaffDets;
    ObservableList<MyStaffs> listStaffs;
    @FXML
    private Label lblMStatus;
    @FXML
    private Label lblNation;
    @FXML
    private Label lblState;
    @FXML
    private Label lblLga;
    @FXML
    private Label lblQuali;
    @FXML
    private Label lblAddress1;
    @FXML
    private Label lblAddress11;
    @FXML
    private Label lblRole;
    @FXML
    private Label lblDOE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connect = new EasyEdConnect();
         cmbCMStatus.getItems().addAll("Single", "Married", "Divorced");
        cmbSSex.getItems().addAll("Male", "Female", "Others");
        cmbReligion.getItems().addAll("Christianity", "Islam", "Others");
        cmbRole.getItems().addAll("Teacher", "Cleaner", "Lab Attendant");
        try {
            getState();
            getStaffDet();
        } catch (SQLException ex) {
            Logger.getLogger(StaffsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void btnDashboardStudDetAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("studDetailsFXML.fxml"));
        Scene scene = new Scene(parent, 500, 200);
        stage.setScene(scene);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        //set Stage boundaries to visible bounds of the main screen
        stage.setX(primaryScreenBounds.getMinX());
        stage.setY(primaryScreenBounds.getMinY());
        stage.setWidth(primaryScreenBounds.getWidth());
        stage.setHeight(primaryScreenBounds.getHeight());
        stage.show();;
    }

    @FXML
    private void btnDashboardStaffAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("staffsFXML.fxml"));
        Scene scene = new Scene(parent, 500, 200);
        stage.setScene(scene);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        //set Stage boundaries to visible bounds of the main screen
        stage.setX(primaryScreenBounds.getMinX());
        stage.setY(primaryScreenBounds.getMinY());
        stage.setWidth(primaryScreenBounds.getWidth());
        stage.setHeight(primaryScreenBounds.getHeight());
        stage.show();
    }

    @FXML
    private void btnDashboardPaySecAction(ActionEvent event) throws IOException {
         AnchorPane createUser = FXMLLoader.load(getClass().getResource("paymentsFXML.fxml"));
       rootPane.getChildren().setAll(createUser);
    }

    @FXML
    private void btnDashboardClassAction(ActionEvent event) throws IOException {
        AnchorPane createUser = FXMLLoader.load(getClass().getResource("classFXML.fxml"));
       rootPane.getChildren().setAll(createUser);
    }

    @FXML
    private void btnDashboardInvAction(ActionEvent event) {
        
    }

    @FXML
    private void btnDashboardStudRegAction(ActionEvent event) throws IOException {
        AnchorPane createUser = FXMLLoader.load(getClass().getResource("studRegFXML.fxml"));
       rootPane.getChildren().setAll(createUser);
    }

    @FXML
    private void btnDashboardAction(ActionEvent event) throws IOException {
         AnchorPane createUser = FXMLLoader.load(getClass().getResource("dashBoardFXML.fxml"));
       rootPane.getChildren().setAll(createUser);
    }

    @FXML
    private void cmbClassAction(ActionEvent event) {
    }


    @FXML
    private void studentEditAction(ActionEvent event) {
    }

    @FXML
    private void btnUpdateStudentAction(ActionEvent event) {
    }

    
        public void getState() throws SQLException {
         myState  = FXCollections.observableArrayList();
        rst = connect.getMyStates();
        while (rst.next()) {
                String stateId = rst.getString("state_id");
                String stateName = rst.getString("name");
                myState.addAll(new MyStates(stateId, stateName));
                cmbSState.setItems(myState);
                
                cmbSState.setConverter(new StringConverter<MyStates>(){
                    @Override
                    public String toString(MyStates object) {
                        return object.getName();
                    }

                    @Override
                    public MyStates fromString(String string) {
                        return cmbSState.getItems().stream().filter(ap -> ap.getName().equals(string)).findFirst().orElse(null);
                    }
                    
                });

            }
    }

    @FXML
    private void cmbSStateAction(ActionEvent event) {
         cmbSLGA.getItems().clear();
     String state = cmbSState.getValue().getState_id();
                 
        try {
            String sql1 = "SELECT * FROM `locals` WHERE `state_id`= '" + state + "'";
             pstmt = connect.getConnection().prepareStatement(sql1);
            rst = pstmt.executeQuery(sql1);
            while(rst.next()){
                cmbSLGA.getItems().addAll(rst.getString("local_name"));
               
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
        }
    }

    @FXML
    private void btnAddStaffAction(ActionEvent event) throws SQLException {
        String firstName = txtSFName.getText();
                String otherNames = txtSON.getText();
                String dateOfBirth = dpDOB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String sex = cmbSSex.getValue();
                String nationality = txtSNation.getText();
                String stateOfOrigin = cmbSState.getValue().getName();
                String lga = cmbSLGA.getValue();
                String dateOfEmp = dpDOE.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String qualification = cmbQuali.getValue();
                String maritalStatus = cmbCMStatus.getValue();
                String resAddress = txtRAddress.getText();
                String oAddress = txtOAddress.getText();
                String email = txtSEmail.getText();
                String Phone = txtSPhone.getText();
                String role = cmbRole.getValue();
                String religion = cmbReligion.getValue();
                
                MyStaffs staffs = new MyStaffs(firstName,otherNames,dateOfBirth,sex,nationality,stateOfOrigin,lga,qualification,dateOfEmp,resAddress,oAddress,maritalStatus,email,Phone,role,religion);

                String sql = "INSERT INTO `staff_tbl`(`first_name`, `last_name`, `phone_num`, `dob`, `sex`, `nationality`, `state`, `lga`, `doe`, `qualification`, `marital_status`, `resAddress`, `oAddress`, `email`, `religion`, `role`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                pstmt = connect.getConnection().prepareStatement(sql);
                pstmt.setString(1, staffs.getFirstName());
                pstmt.setString(2, staffs.getOtherNames());
                pstmt.setString(3, staffs.getPhone());
                pstmt.setString(4, staffs.getDateOfBirth());
                pstmt.setString(5, staffs.getSex());
                pstmt.setString(6, staffs.getNationality());
                pstmt.setString(7, staffs.getStateOfOrigin());
                pstmt.setString(8, staffs.getLga());
                pstmt.setString(9, staffs.getDateOfEmp());
                pstmt.setString(10, staffs.getQualification());
                pstmt.setString(11, staffs.getMaritalStatus());
                pstmt.setString(12, staffs.getResAddress());
                pstmt.setString(13, staffs.getoAddress());
                pstmt.setString(14, staffs.getEmail());
                pstmt.setString(15, staffs.getReligion());
                pstmt.setString(16, staffs.getRole());
                pstmt.execute();
                JOptionPane.showMessageDialog(null, "RECORD INSERTED SUCCESSFULLY");
                pstmt.close();
    }

    @FXML
    private void cmbRoleAction(ActionEvent event) {
    }

   private ResultSet getStaffDet() {
        listStaffs = FXCollections.observableArrayList();
        try {
            rst = connect.getStaffs();
            while (rst.next()) {
                String id = rst.getString("staff_id");
                String firstName = rst.getString("first_name");
                String otherNames = rst.getString("last_name");
                String sex = rst.getString("sex");
                String dateOfBirth = rst.getString("dob");
                String Phone = rst.getString("phone_num");

                listStaffs.add(new MyStaffs(id, firstName, otherNames, dateOfBirth, sex, Phone));

            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colONames.setCellValueFactory(new PropertyValueFactory<>("otherNames"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("sex"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        tblStaffDets.setItems(listStaffs);
        return rst;

    }            

    @FXML
    private void tblStaffDetsSelectAction(MouseEvent event) {
         int row = 0;
        String id = tblStaffDets.getSelectionModel().getSelectedItem().getId();

        try {
            String sql = "SELECT * FROM `staff_tbl`s WHERE staff_id = ?";
            pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setString(1, id);
            rst = pstmt.executeQuery();

            while (rst.next()) {
                lblName.setText(rst.getString("s.first_name") + " " + rst.getString("s.last_name"));
                lblGender.setText(rst.getString("s.sex"));
                lblDOB.setText(rst.getString("s.dob"));
                lblDOE.setText(rst.getString("s.doe"));
                lblPhone.setText(rst.getString("s.phone_num"));
                lblEmail.setText(rst.getString("s.email"));
                lblReligion.setText(rst.getString("s.religion"));
                lblRole.setText(rst.getString("s.role"));
                lblAddress1.setText(rst.getString("s.resAddress"));
                lblAddress11.setText(rst.getString("s.oAddress"));
                lblQuali.setText(rst.getString("s.qualification"));
                lblNation.setText(rst.getString("s.nationality"));
                lblState.setText(rst.getString("s.state"));
                lblLga.setText(rst.getString("s.lga"));
                lblMStatus.setText(rst.getString("s.marital_status"));

            }
            pstmt.close();
            rst.close();

        } catch (SQLException e) {

        }
    }

    @FXML
    private void tpSDetsAction(Event event) {
        getStaffDet();
    }

}
