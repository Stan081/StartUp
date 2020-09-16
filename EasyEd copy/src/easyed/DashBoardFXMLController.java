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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class DashBoardFXMLController implements Initializable {

    EasyEdConnect connect;
    ResultSet rs;
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
    private Label lblStudNo;
    @FXML
    private Label lblStaffNo;
    @FXML
    private Label lblGuardianNo;
    @FXML
    private BarChart<?, ?> feesChart;
    @FXML
    private Label lblMale;
    @FXML
    private Label lblFemale;
    @FXML
    private PieChart pieChSGender;
    @FXML
    private AnchorPane piePane;
    PreparedStatement pstmt;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connect = new EasyEdConnect();
//         String price = getChartPrice().toString();
//     Integer intObj = new Integer(price);
//     Number numObj = (Number)intObj;
     XYChart.Series series1 = new XYChart.Series();
     series1.getData().add(new XYChart.Data("January",3000));
     series1.getData().add(new XYChart.Data("Febuaury",5000)); 
     series1.getData().add(new XYChart.Data("March",3000));
     series1.getData().add(new XYChart.Data("April",4000));
      series1.getData().add(new XYChart.Data("May",3000));
     series1.getData().add(new XYChart.Data("June",2000));
      series1.getData().add(new XYChart.Data("July",3000));
     series1.getData().add(new XYChart.Data("August",15000));
      series1.getData().add(new XYChart.Data("September",3000));
     series1.getData().add(new XYChart.Data("October",6000));
      series1.getData().add(new XYChart.Data("November",3000));
     series1.getData().add(new XYChart.Data("december",7000));
     feesChart.getData().addAll(series1);
        
        try {
            getNumberStats();
            getCharts();
//            popChart();
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(DashBoardFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnStaffDashboardAction(ActionEvent event) throws IOException {
        AnchorPane createUser = FXMLLoader.load(getClass().getResource("staffsFXML.fxml"));
        rootPane.getChildren().setAll(createUser);
    }

    @FXML
    private void btnStudRegAction(ActionEvent event) throws IOException {
        AnchorPane createUser = FXMLLoader.load(getClass().getResource("studRegFXML.fxml"));
        rootPane.getChildren().setAll(createUser);
    }

    @FXML
    private void btnStudDetAction(ActionEvent event) throws IOException {
        AnchorPane createUser = FXMLLoader.load(getClass().getResource("studDetailsFXML.fxml"));
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
    private void btnDashboardAction(ActionEvent event) {
    }

    //code to generate population for students (male and female), staffs and parents
    public void getNumberStats() throws SQLException {
        String male;
        String female;
        String sql1;
        sql1 = "SELECT COUNT(*) FROM `student_details`";
        PreparedStatement pstmt;
        pstmt = connect.getConnection().prepareStatement(sql1);                       //students general
        rs = pstmt.executeQuery();

        while (rs.next()) {
            lblStudNo.setText(rs.getString("COUNT(*)"));
        }

        String sql2;
        sql2 = "SELECT COUNT(*) FROM `student_details` WHERE `sex`= \"male\" ";
        pstmt = connect.getConnection().prepareStatement(sql2);                       //studen male
        rs = pstmt.executeQuery();

        while (rs.next()) {
            male = rs.getString("COUNT(*)");
            lblMale.setText(male);
        }

        String sql3;
        sql3 = "SELECT COUNT(*) FROM `student_details` WHERE `sex`= \"female\" ";
        pstmt = connect.getConnection().prepareStatement(sql3);                       //studen female
        rs = pstmt.executeQuery();

        while (rs.next()) {
            female = rs.getString("COUNT(*)");
            lblFemale.setText(female);

        }

        String sql4;
        sql4 = "SELECT COUNT(*) FROM `guardian_tbl`";
        pstmt = connect.getConnection().prepareStatement(sql4);                       //guardians
        rs = pstmt.executeQuery();

        while (rs.next()) {
            lblGuardianNo.setText(rs.getString("COUNT(*)"));
        }


    }
    
public void getCharts(){
    //STudent gender no chart
     ObservableList pieChartData = FXCollections.observableArrayList();
         pieChSGender.setTitle("Student Gender");
         pieChartData.add(new PieChart.Data("Male",Integer.parseInt(lblMale.getText())));
         pieChartData.add(new PieChart.Data("Female",Integer.parseInt(lblFemale.getText())));
         pieChSGender.setData(pieChartData);
    
         
}

// public void popChart(){
//
//    
//     
//
//      }
 
// public ResultSet getChartPrice(){
//       String sql = "SELECT SUM(`price`) as sum FROM transaction_tbl WHERE YEAR(`trans_date`) =2019 AND MONTH(`trans_date`) = 12";
//                try {
//          pstmt = connect.getConnection().prepareStatement(sql);
//          rs = pstmt.executeQuery();
//          while(rs.next()){
//              String sum = rs.getString("sum");
//              
//          }       
//      } catch (SQLException e) {
//          JOptionPane.showMessageDialog(null, "Date format error: " + e);
//      }
//                return rs;
// }

    @FXML
    private void fromDateAction(ActionEvent event) {
    }

    @FXML
    private void toDateAction(ActionEvent event) {
    }

}
