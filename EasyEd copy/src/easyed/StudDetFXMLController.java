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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class StudDetFXMLController implements Initializable {

    @FXML
    private Button btnStudReg;
    @FXML
    private Button btnStudDet;
    @FXML
    private TableView<Students> tblStudDets;
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
    private Button btnEditStudent;
    EasyEdConnect connect;
    ResultSet rst;
    ObservableList<Students> listStudents;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button btnStaffDashboard;
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
    private Label lblGender;
    @FXML
    private Label lblGName;
    @FXML
    private Label lblDOB;
    @FXML
    private Button btnUpdateStudent;
     PreparedStatement pstmt;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connect = new EasyEdConnect();
        getStudentDet();
    }

    @FXML
    private void btnStudRegAction(ActionEvent event) throws IOException {
        AnchorPane createUser = FXMLLoader.load(getClass().getResource("studRegFXML.fxml"));
        rootPane.getChildren().setAll(createUser);
    }

    @FXML
    private void btnStudDetAction(ActionEvent event) throws IOException {

    }

    @FXML
    private void btnStaffDashboardAction(ActionEvent event) throws IOException {
        AnchorPane createUser = FXMLLoader.load(getClass().getResource("staffsFXML.fxml"));
        rootPane.getChildren().setAll(createUser);
    }

    @FXML
    private void btnPaymentDashboardAction(ActionEvent event) throws IOException {
        AnchorPane createUser = FXMLLoader.load(getClass().getResource("paymentsFXML.fxml"));
        rootPane.getChildren().setAll(createUser);
    }

    @FXML
    private void btnClassDashboardAction(ActionEvent event) throws IOException {
        AnchorPane createUser = FXMLLoader.load(getClass().getResource("classFXML.fxml"));
        rootPane.getChildren().setAll(createUser);
    }

    @FXML
    private void btnInventoryDashboardAction(ActionEvent event) {
    }

    @FXML
    private void btnDashboardAction(ActionEvent event) throws IOException {
        AnchorPane createUser = FXMLLoader.load(getClass().getResource("dashBoardFXML.fxml"));
        rootPane.getChildren().setAll(createUser);
    }

    private void btnEditStudentAction(ActionEvent event) {
        btnEditStudent.getScene().getWindow();
        newscene("updateStudentFXML.fxml");
    }

    private ResultSet getStudentDet() {
        listStudents = FXCollections.observableArrayList();
        try {
            rst = connect.selectStudents();
            while (rst.next()) {
                String id = rst.getString("stud_id");
                String firstName = rst.getString("first_name");
                String otherNames = rst.getString("last_name");
                String sex = rst.getString("sex");
                String dateOfBirth = rst.getString("dob");
                String guardianPhone = rst.getString("guards_phone");

                listStudents.add(new Students(id, firstName, otherNames, dateOfBirth, sex, guardianPhone));

            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colONames.setCellValueFactory(new PropertyValueFactory<>("otherNames"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("sex"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("guardianPhone"));
        tblStudDets.setItems(listStudents);
        return rst;

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
    private void tblStudDetsSelectAction(MouseEvent event) throws SQLException {
        int row = 0;
        String id = tblStudDets.getSelectionModel().getSelectedItem().getId();

        try {
            String sql = "SELECT * FROM `guardian_tbl` g JOIN `student_details` s on g.phone_num = s.guards_phone WHERE stud_id = ?";
            pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setString(1, id);
            rst = pstmt.executeQuery();

            while (rst.next()) {
                lblName.setText(rst.getString("s.first_name") + " " + rst.getString("s.last_name"));
                lblGender.setText(rst.getString("s.sex"));
                lblDOB.setText(rst.getString("s.dob"));
                lblGName.setText(rst.getString("g.first_name") + " " + rst.getString("g.last_name"));
                lblPhone.setText(rst.getString("g.phone_num"));
                lblEmail.setText(rst.getString("g.email"));
                lblReligion.setText(rst.getString("g.religion"));
                lblOccupation.setText(rst.getString("g.occupation"));
                lblAddress.setText(rst.getString("g.residential_add"));

            }
            pstmt.close();
            rst.close();

        } catch (SQLException e) {

        }
    }

    @FXML
    private void btnUpdateStudentAction(ActionEvent event) throws IOException, SQLException {
        String id = tblStudDets.getSelectionModel().getSelectedItem().getId();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("updateStudent.fxml"));
        try{
        loader.load();
       }catch(IOException ex){
             Logger.getLogger(DashBoardFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        UpdateStudentController update = loader.getController();
            update.getDetails(id);
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.showAndWait();
//        AnchorPane createUser = FXMLLoader.load(getClass().getResource("updateStudent.fxml"));
//        rootPane.getChildren().setAll(createUser);
    }

}
