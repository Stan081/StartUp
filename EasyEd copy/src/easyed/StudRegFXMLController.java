/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyed;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class StudRegFXMLController implements Initializable {

    EasyEdConnect connect;
    @FXML
    private Button btnStudDet;
    @FXML
    private Button btnDashbosrd;
    private Button btnClass;
    @FXML
    private ComboBox<MyClass> cmbClass;
    @FXML
    private ComboBox<String> cmbSSex;
    @FXML
    private ComboBox<String> cmbPSex;
    private TextField txtPLga;
    @FXML
    private Button btnAddStudent;
    @FXML
    private DatePicker dpDOA;
    private TextField txtSState;
    @FXML
    private TextField txtPSchool;
    @FXML
    private TextField txtPEmail;
    @FXML
    private TextField txtPOccupation;
    @FXML
    private TextField txtPPhone;
    @FXML
    private TextField txtPON;
    @FXML
    private TextField txtPFName;
    @FXML
    private TextField txtSNation;
    private TextField txtSLGA;
    private TextField txtDOB;
    @FXML
    private TextField txtSON;
    @FXML
    private TextField txtSFName;
    @FXML
    private ComboBox<String> cmbPClass;
    @FXML
    private TextArea txtDisability;
    @FXML
    private ComboBox<String> cmbPReligion;
    @FXML
    private TextArea txtPOAddress;
    @FXML
    private TextArea txtPRAddress;
    @FXML
    private TextField txtPNation;
    private BorderPane StudentReg;
    @FXML
    private Button btnPaySec;
    @FXML
    private Button btnInv;
    @FXML
    private Button btnStudReg;
    @FXML
    private ComboBox<MySession> cmbSession;
    @FXML
    private ComboBox<MyTerm> cmbTerm;
    @FXML
    private DatePicker dpDOB;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button clearFields;
    @FXML
    private Button btnStaffDashbosrd;
    @FXML
    private Button btnClassDashBoard;
    @FXML
    private ComboBox<MyStates> cmbSState;
    @FXML
    private ComboBox<MyStates> cmbPState;
    ResultSet rst;
    PreparedStatement pstmt;
    @FXML
    private ComboBox<String> cmbSLGA;
    @FXML
    private ComboBox<String> cmbPLGA;
    @FXML
    private Button btnAddStudent1;
    ObservableList<MyClass> myClass;
    ObservableList<MyStates> myState;
    ObservableList<MyTerm> myTerm;
    ObservableList<MySession> mySession;
    @FXML
    private RadioButton chkBNewG;
    @FXML
    private RadioButton chkBRetG;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connect = new EasyEdConnect();
        cmbPSex.getItems().addAll("Male", "Female", "Others");
        cmbSSex.getItems().addAll("Male", "Female", "Others");
        cmbPReligion.getItems().addAll("Christianity", "Islam", "Others");

        try {
            getState();
            popClass();
//        
            rst = connect.selectMyClass();
            while (rst.next()) {
                cmbPClass.getItems().addAll(rst.getString("class_name"));
            }
//           
////        getMyLocals();
//        
        } catch (SQLException ex) {
            Logger.getLogger(StudRegFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnStudDetAction(ActionEvent event) throws IOException {
        AnchorPane createUser = FXMLLoader.load(getClass().getResource("studDetailsFXML.fxml"));
        rootPane.getChildren().setAll(createUser);
    }

    @FXML
    private void btnDashboardAction(ActionEvent event) throws IOException {
        AnchorPane createUser = FXMLLoader.load(getClass().getResource("dashBoardFXML.fxml"));
        rootPane.getChildren().setAll(createUser);
    }

    @FXML
    private void btnPaySecAction(ActionEvent event) throws IOException {
        AnchorPane createUser = FXMLLoader.load(getClass().getResource("paymentsFXML.fxml"));
        rootPane.getChildren().setAll(createUser);
    }

    @FXML
    private void btnStudRegAction(ActionEvent event) throws IOException {
           AnchorPane payPane = FXMLLoader.load(getClass().getResource("studRegFXML.fxml"));
        rootPane.getChildren().setAll(payPane);

    }

    @FXML
    private void btnStaffDashboardAction(ActionEvent event) throws IOException {
        AnchorPane createUser = FXMLLoader.load(getClass().getResource("staffsFXML.fxml"));
        rootPane.getChildren().setAll(createUser);
    }

    @FXML
    private void btnClassDashboardAction(ActionEvent event) throws IOException {
        AnchorPane createUser = FXMLLoader.load(getClass().getResource("classFXML.fxml"));
        rootPane.getChildren().setAll(createUser);
    }

    @FXML
    private void cmbClassAction(ActionEvent event) throws IOException {
        cmbClass.valueProperty().addListener((obs, oldval, newval) -> {
            System.out.println("ID" + newval.getClass_id());
        });

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
    private void cmbPClassAction(ActionEvent event) {
        String preClass = cmbPClass.getValue();
    }

    @FXML
    private void clearFieldsAction(ActionEvent event) {
    }

    @FXML
    private void btnAddStudentAction(ActionEvent event) throws SQLException, IOException {
        //Creates and adds a new atudent and guardian to the database.

        if (chkBNewG.isSelected()) {
            try {
                String pFirstName = txtPFName.getText();
                String pOtherNames = txtPON.getText();
                String pNationality = txtPNation.getText();
                String pStateOfOrigin =  cmbPState.getValue().getName();
                String pLga =  cmbPLGA.getValue();
                String pSex = cmbPSex.getValue();
                String occupation = txtPOccupation.getText();
                String email = txtPEmail.getText();
                String religion = cmbPReligion.getValue();
                String guardianPhone = txtPPhone.getText();
                String rAddress = txtPSchool.getText();
                String oAddress = txtDisability.getText();

                Guardians guardian = new Guardians(pFirstName, pOtherNames, pNationality, pStateOfOrigin, pLga, pSex, occupation, email, religion, guardianPhone, rAddress, oAddress);

                String sql1;
                sql1 = "INSERT INTO `guardian_tbl`(`first_name`, `last_name`, `occupation`, `religion`, `sex`, `phone_num`, `email`, `residential_add`, `official_add`, `state`, `nationality`) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pstmt;
                pstmt = connect.getConnection().prepareStatement(sql1);
                pstmt.setString(1, guardian.getpFirstName());
                pstmt.setString(2, guardian.getpOtherNames());
                pstmt.setString(3, guardian.getOccupation());
                pstmt.setString(4, guardian.getReligion());
                pstmt.setString(5, guardian.getpSex());
                pstmt.setString(6, guardian.getGuardianPhone());
                pstmt.setString(7, guardian.getEmail());
                pstmt.setString(8, guardian.getrAddress());
                pstmt.setString(9, guardian.getoAddress());
                pstmt.setString(10, guardian.getPstateOfOrigin());
                pstmt.setString(11, guardian.getPNationality());
                pstmt.execute();
//            JOptionPane.showMessageDialog(null, "RECORD INSERTED SUCCESSFULLY");
//            pstmt.close();

                String firstName = txtSFName.getText();
                String otherNames = txtSON.getText();
                String dateOfBirth = dpDOB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String sex = cmbSSex.getValue();
                String nationality = txtSNation.getText();
                String stateOfOrigin = cmbSState.getValue().toString();
                String lga = cmbSLGA.getValue();
                String dateOfAdmis = dpDOA.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String pClass = cmbPClass.getValue();
                String pSchool = txtPSchool.getText();
                String disability = txtDisability.getText();
                Students students = new Students(firstName, otherNames, dateOfBirth, sex, nationality, stateOfOrigin, lga, dateOfAdmis, pClass, pSchool, disability, guardianPhone);

                String sql;
                sql = "INSERT INTO `student_details`(`first_name`,`last_name`,`dob`,`sex`,`dor`,`nationality`,`s_o_o`,`prev_sch`,`disability`,`lga_vill`,`guards_phone`,`pre_class`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                pstmt = connect.getConnection().prepareStatement(sql);
                pstmt.setString(1, students.getFirstName());
                pstmt.setString(2, students.getOtherNames());
                pstmt.setString(3, students.getDateOfBirth());
                pstmt.setString(4, students.getSex());
                pstmt.setString(5, students.getDateOfAdmis());
                pstmt.setString(6, students.getNationality());
                pstmt.setString(7, students.getStateOfOrigin());
                pstmt.setString(8, students.getpSchool());
                pstmt.setString(9, students.getDisability());
                pstmt.setString(10, students.getLga());
                pstmt.setString(11, students.getGuardianPhone());
                pstmt.setString(12, students.getpClass());
                pstmt.execute();
                JOptionPane.showMessageDialog(null, "RECORD INSERTED SUCCESSFULLY");
                pstmt.close();
                
                addToClass();

                AnchorPane createUser = FXMLLoader.load(getClass().getResource("paymentsFXML_1.fxml"));
                rootPane.getChildren().setAll(createUser);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, e);
            }

        } else if (chkBRetG.isSelected()) {
            String firstName = txtSFName.getText();
            String otherNames = txtSON.getText();
            String dateOfBirth = dpDOB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String sex = cmbSSex.getValue();
            String nationality = txtSNation.getText();
            String stateOfOrigin = cmbSState.getValue().getName() ;
            String lga = cmbSLGA.getValue();
            String dateOfAdmis = dpDOA.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String pClass = cmbPClass.getValue();
            String pSchool = txtPSchool.getText();
            String disability = txtDisability.getText();
            String guardianPhone = txtPPhone.getText();
            Students students = new Students(firstName, otherNames, dateOfBirth, sex, nationality, stateOfOrigin, lga, dateOfAdmis, pClass, pSchool, disability, guardianPhone);

            String sql;
            sql = "INSERT INTO `student_details`(`first_name`,`last_name`,`dob`,`sex`,`dor`,`nationality`,`s_o_o`,`prev_sch`,`disability`,`lga_vill`,`guards_phone`,`pre_class`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setString(1, students.getFirstName());
            pstmt.setString(2, students.getOtherNames());
            pstmt.setString(3, students.getDateOfBirth());
            pstmt.setString(4, students.getSex());
            pstmt.setString(5, students.getDateOfAdmis());
            pstmt.setString(6, students.getNationality());
            pstmt.setString(7, students.getStateOfOrigin());
            pstmt.setString(8, students.getpSchool());
            pstmt.setString(9, students.getDisability());
            pstmt.setString(10, students.getLga());
            pstmt.setString(11, students.getGuardianPhone());
            pstmt.setString(12, students.getpClass());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "RECORD INSERTED SUCCESSFULLY");
            pstmt.close();
            
            addToClass();
            
            AnchorPane createUser = FXMLLoader.load(getClass().getResource("paymentsFXML_1.fxml"));
               rootPane.getChildren().setAll(createUser);


        } else {
            JOptionPane.showMessageDialog(null, "SELECT GUARDIAN STATUS");

        }
    }

    private void newscene(String url) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    @FXML
    private void cmbSSexAction(ActionEvent event) {
        String sex = cmbSSex.getValue();

    }

    @FXML
    private void cmbPSexAction(ActionEvent event) {
        String sex = cmbPSex.getValue();

    }

    @FXML
    private void cmbPReligionAction(ActionEvent event) {
        String religion = cmbPReligion.getValue();

    }

    public void getState() throws SQLException {
         myState  = FXCollections.observableArrayList();
        rst = connect.getMyStates();
        while (rst.next()) {
                String stateId = rst.getString("state_id");
                String stateName = rst.getString("name");
                myState.addAll(new MyStates(stateId, stateName));
                cmbPState.setItems(myState);
                cmbSState.setItems(myState);
                cmbPState.setConverter(new StringConverter<MyStates>() {
                    @Override
                    public String toString(MyStates object) {
                        return object.getName();
                    }

                    @Override
                    public MyStates fromString(String string) {
                        return cmbPState.getItems().stream().filter(ap -> ap.getName().equals(string)).findFirst().orElse(null);
                    }
                   

                });
                
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
//
   
//    public void getMyLocals() throws SQLException {
//         rst = connect.selectMyClass();
//            while (rst.next()) {
//                String class_id = rst.getString("class_id");
//                String class_name = rst.getString("class_name");
//                myClass.addAll(new MyClass(class_id, class_name));
//                cmbClass.setItems(myClass);
//                cmbClass.setConverter(new StringConverter<MyClass>() {
//                    @Override
//                    public String toString(MyClass object) {
//                        return object.getClass_name();
//                    }
//
//                    @Override
//                    public MyClass fromString(String string) {
//                        return cmbClass.getItems().stream().filter(ap -> ap.getClass_name().equals(string)).findFirst().orElse(null);
//                    }
//
//                });
//    }
//    }

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

    public void addToClass() throws SQLException {
        try{
            String sql1 = "SELECT MAX(stud_id) FROM `student_details`";
        pstmt = connect.getConnection().prepareStatement(sql1);
        rst = pstmt.executeQuery();
         String stud_id = null;
        while (rst.next()) {
        stud_id = rst.getString("MAX(stud_id)");
        break;}
        pstmt.close();
        rst.close();
        String session = cmbSession.getValue().getSession_id();
        String term = cmbTerm.getValue().getTerm_id();
        String sClass = cmbClass.getValue().getClass_id();
        MyClassStud classStud = new MyClassStud(stud_id, session, term, sClass);

        String sql = "INSERT INTO `class_stud`(`stud_id`,`session_id`,`term_id`,`class_id`) VALUES(?,?,?,?)";
        pstmt = connect.getConnection().prepareStatement(sql);
        pstmt.setString(1, classStud.getStud_id());
        pstmt.setString(2, classStud.getSession_id());
        pstmt.setString(3, classStud.getTerm_id());
        pstmt.setString(4, classStud.getClass_id());
        
        pstmt.execute();
        JOptionPane.showMessageDialog(null, "RECORD INSERTED SUCCESSFULLY");
        pstmt.close();
            System.out.println(stud_id);
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
        }
    }

    @FXML
    private void cmbSStateAction(ActionEvent event) throws SQLException {
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
    private void cmbPStateAction(ActionEvent event) {
           cmbPLGA.getItems().clear();
     String state = cmbPState.getValue().getState_id();
                 
        try {
            String sql1 = "SELECT * FROM `locals` WHERE `state_id`= '" + state + "'";
             pstmt = connect.getConnection().prepareStatement(sql1);
            rst = pstmt.executeQuery(sql1);
            while(rst.next()){
                cmbPLGA.getItems().addAll(rst.getString("local_name"));
               
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SELECT ALL USER ERROR: + e");
        }
        
     
    }

    @FXML
    private void cmbSLGAAction(ActionEvent event) throws SQLException {
        cmbSLGA.getValue();
       
    }

    @FXML
    private void cmbPLGAAction(ActionEvent event) {
    }
}
