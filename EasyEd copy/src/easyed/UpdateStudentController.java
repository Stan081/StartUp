/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyed;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class UpdateStudentController implements Initializable {

    EasyEdConnect connect;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private ComboBox<String> cmbSSex;
    @FXML
    private ComboBox<String> cmbPSex;
    @FXML
    private TextField txtPON;
    @FXML
    private TextField txtPFName;
    @FXML
    private TextField txtPNation;
    @FXML
    private TextField txtSON;
    @FXML
    private TextField txtSFName;
    @FXML
    private TextField txtSNation;
    @FXML
    private DatePicker dpDOB;
    @FXML
    private TextField txtPSchool;
    @FXML
    private ComboBox<String> cmbPReligion;
    @FXML
    private TextArea txtDisability;
    @FXML
    private ComboBox<String> cmbPClass;
    @FXML
    private TextField txtPOccupation;
    @FXML
    private TextField txtPPhone;
    @FXML
    private TextField txtPEmail;
    @FXML
    private TextArea txtPOAddress;
    @FXML
    private TextArea txtPRAddress;
    @FXML
    private Button btnAddStudent;
    @FXML
    private Button clearFields;
    @FXML
    private DatePicker dpDOA;
    @FXML
    private ComboBox<MyStates> cmbSState;
    @FXML
    private ComboBox<MyStates> cmbPState;
    @FXML
    private ComboBox<String> cmbSLGA;
    @FXML
    private ComboBox<String> cmbPLGA;
    @FXML
    private Button btnUpdate;

    ObservableList<MyStates> myState;
    ResultSet rst;
    PreparedStatement pstmt;
     String id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        try {
//            getState();
//         
//            // TODO
//        } catch (SQLException ex) {
//            Logger.getLogger(UpdateStudentController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @FXML
    private void cmbSSexAction(ActionEvent event) {
        String sex = cmbSSex.getValue();
    }

    @FXML
    private void cmbPSexAction(ActionEvent event) {
    }

    @FXML
    private void cmbPReligionAction(ActionEvent event) {
    }

    @FXML
    private void cmbPClassAction(ActionEvent event) {
    }

    @FXML
    private void btnAddStudentAction(ActionEvent event) {
    }

    @FXML
    private void clearFieldsAction(ActionEvent event) {
    }

    @FXML
    private void cmSStateAction(ActionEvent event) {
    }

    @FXML
    private void cmPStateAction(ActionEvent event) {
    }

    @FXML
    private void cmSLGAAction(ActionEvent event) {
    }

    @FXML
    private void cmPLGAAction(ActionEvent event) {
    }

    @FXML
    private void btnUpdateAction(ActionEvent event) {
    }

    public void getState() throws SQLException {
        myState = FXCollections.observableArrayList();
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

            cmbSState.setConverter(new StringConverter<MyStates>() {
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

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public void getDetails(String id) throws SQLException {
         String sql = "SELECT * FROM `guardian_tbl` g JOIN `student_details` s on g.phone_num = s.guards_phone WHERE stud_id = '"+ id + "'";
        pstmt = connect.getConnection().prepareStatement(sql);
        rst = pstmt.executeQuery();
        while (rst.next()) {
             txtSFName.setText(rst.getString("s.first_name"));
             txtSON.setText(rst.getString("s.last_name"));
               cmbSSex.setValue(rst.getString("s.sex"));
//               dpDOB. (rst.getString("s.dob")).;
//                lblGName.setText(rst.getString("g.first_name") + " " + rst.getString("g.last_name"));
//                lblPhone.setText(rst.getString("g.phone_num"));
//                lblEmail.setText(rst.getString("g.email"));
//                lblReligion.setText(rst.getString("g.religion"));
//                lblOccupation.setText(rst.getString("g.occupation"));
//                lblAddress.setText(rst.getString("g.residential_add"));

        }
        pstmt.close();
        rst.close();
      
     
    }

    public void popDets() throws SQLException{
     
    }
}
