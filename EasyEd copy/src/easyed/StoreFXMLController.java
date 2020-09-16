/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyed;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class StoreFXMLController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnSearch;
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
    private TableView<?> tblStudDets;
    @FXML
    private TableColumn<?, ?> colId;
    @FXML
    private TableColumn<?, ?> colFName;
    @FXML
    private TableColumn<?, ?> colONames;
    @FXML
    private TableColumn<?, ?> colGender;
    @FXML
    private TableColumn<?, ?> colPhone;
    @FXML
    private TableColumn<?, ?> colPhone1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void tbiStudentsSelectAction(MouseEvent event) {
    }
    
}
