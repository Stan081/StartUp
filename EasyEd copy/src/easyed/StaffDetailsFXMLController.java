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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class StaffDetailsFXMLController implements Initializable {
    private Button btnEditStudent;
    EasyEdConnect connect;
    ResultSet rst;
    
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
    private Label lblName;
    @FXML
    private Label lblAddress;
    @FXML
    private Label lblOccupation;
    @FXML
    private Label lblPhone;
    @FXML
    private Label lblReligion;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblDOB;
    @FXML
    private Label lblGName;
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
    private TableColumn<MyStaffs, String> colPhone;
    @FXML
    private TableView<MyStaffs> tblStaffDets;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        connect = new EasyEdConnect();

    }    

    @FXML
    private void btnStaffDashboardAction(ActionEvent event) {
    }

    @FXML
    private void btnStudRegAction(ActionEvent event) {
    }

    @FXML
    private void btnStudDetAction(ActionEvent event) {
    }

    @FXML
    private void btnPaymentDashboardAction(ActionEvent event) {
    }

    @FXML
    private void btnClassDashboardAction(ActionEvent event) {
    }

    @FXML
    private void btnInventoryDashboardAction(ActionEvent event) {
    }

    @FXML
    private void btnDashboardAction(ActionEvent event) {
    }

    @FXML
    private void btnUpdateStudentAction(ActionEvent event) {
    }

    @FXML
    private void tblStudDetsSelectAction(MouseEvent event) {
    }
    
    
     
}
