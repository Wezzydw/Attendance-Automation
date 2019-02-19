/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.Student;
import attendanceautomation.dal.MockData;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mpoul
 */
public class StudentViewController implements Initializable {

    @FXML
    private ComboBox<String> cBox;
    @FXML
    private TableView<Student> tView;
    @FXML
    private TableColumn<Student, String> tViewColOne;
    @FXML
    private TableColumn<Student, String> tViewColTwo;
    @FXML
    private RadioButton radioPresent;
    @FXML
    private RadioButton radioAbsent;
    @FXML
    private Label lblUserName;

    private Student student;
    private LogInViewController logInView;
    @FXML
    private BorderPane middlePane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        cBox.setItems(days, courses);
        handleShowLineChart();
        showTable();
    }    
    

    @FXML
    private void handleRegister(ActionEvent event) {
        if (radioPresent.selectedProperty().getValue())
        {
            // add date to attendance list
        }
        else if (radioAbsent.selectedProperty().getValue())
        {
            //remove date from attendance list
        }
    }
    
    public void setStudent(Student student)
    {
        this.student = student;
        lblUserName.setText(student.getFirstName() + " " + student.getLastName());
    }

    @FXML
    private void rPresent(ActionEvent event)
    {
        if (radioAbsent.selectedProperty().getValue())
        {
            radioAbsent.selectedProperty().setValue(Boolean.FALSE);
            radioPresent.selectedProperty().setValue(Boolean.TRUE);
        }
        else if (!radioPresent.selectedProperty().getValue())
        {
            radioPresent.selectedProperty().setValue(Boolean.TRUE);
        }
        
    }

    @FXML
    private void rAbsent(ActionEvent event)
    {
        if (radioPresent.selectedProperty().getValue())
        {
            radioPresent.selectedProperty().setValue(Boolean.FALSE);
            radioAbsent.selectedProperty().setValue(Boolean.TRUE);
        }
        else if (!radioAbsent.selectedProperty().getValue())
        {
            radioAbsent.selectedProperty().setValue(Boolean.TRUE);
        }
    }

    @FXML
    private void handleLogOut(ActionEvent event)
    {
        showLogInScreen();
    }
    
    private void showLogInScreen()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/attendanceautomation/gui/view/LogInView.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            System.out.println("Error" + ex);
        }
        LogInViewController display = loader.getController();
        
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        Stage stage1 = (Stage) lblUserName.getScene().getWindow();
        stage1.close();
        stage.show();
    }
    private LineChart buildLineChart()//chart instead of void bar or line chart
    {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Week day");
        yAxis.setLabel("Absense %");
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Attendance");
        XYChart.Series series = new XYChart.Series();
        series.setName("Student name");
        series.getData().add(new XYChart.Data<>("Mandag", 69));
        series.getData().add(new XYChart.Data<>("Tirsdag", 12));
        series.getData().add(new XYChart.Data<>("Onsdag", 19));
        series.getData().add(new XYChart.Data<>("Torsdag", 23));
        series.getData().add(new XYChart.Data<>("Fredag", 92));
        
        lineChart.getData().add(series);
        
        return lineChart;
    }
    private void handleShowLineChart()
    {
        middlePane.setCenter(buildLineChart());
    }
    private void showChartInMiddle()
    {
        
    }
    
    private void showTable()
    {
        MockData m = new MockData();
        tViewColOne.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        tViewColTwo.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        tView.setItems(m.getAllStudents());
        
    }
}
