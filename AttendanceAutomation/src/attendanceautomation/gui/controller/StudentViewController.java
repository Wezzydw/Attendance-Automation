/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.Attendance;
import attendanceautomation.be.Student;
import attendanceautomation.utilities.MockData;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private TableView<Attendance> tView;
    @FXML
    private TableColumn<Attendance, String> tViewColOne;
    @FXML
    private TableColumn<Attendance, String> tViewColTwo;
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
    private Model model;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
//        cBox.setItems(days, courses);

//showTable();
model = new Model();
//        handleShowLineChart();
        } catch (IOException ex) {
            Logger.getLogger(StudentViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    

    @FXML
    private void handleRegister(ActionEvent event) {
        String radio = null;
//        boolean alreadyExist = false;
        if (radioPresent.selectedProperty().getValue())
        {
            radio = "Present";
        }
        else if (radioAbsent.selectedProperty().getValue())
        {
            radio = "Absent";
        }
        if (radio != null){
            Attendance a1 = new Attendance(student.getId(), LocalDate.now(), radio);
            model.registerAttendance(a1, student);
        }
        
    }
    
    public void setStudent(Student student)
    {
        this.student = student;
        lblUserName.setText(student.getFirstName() + " " + student.getLastName());
        showTable();
        handleShowLineChart(student);
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
    private LineChart buildLineChart(Student student)//chart instead of void bar or line chart
    {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Week day");
        yAxis.setLabel("Absense %");
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Attendance");
        XYChart.Series series = new XYChart.Series();
        series.setName(student.getFirstName() + " " + student.getLastName());
        series.getData().add(new XYChart.Data<>("Mandag", model.getPercentDaysForStudent(student, "MONDAY")));
        series.getData().add(new XYChart.Data<>("Tirsdag", model.getPercentDaysForStudent(student, "TUESDAY")));
        series.getData().add(new XYChart.Data<>("Onsdag", model.getPercentDaysForStudent(student, "WEDNESDAY")));
        series.getData().add(new XYChart.Data<>("Torsdag", model.getPercentDaysForStudent(student, "THURSDAY")));
        series.getData().add(new XYChart.Data<>("Fredag", model.getPercentDaysForStudent(student, "FRIDAY")));
        
        lineChart.getData().add(series);
        
        return lineChart;
    }
    private void handleShowLineChart(Student student)
    {
        middlePane.setCenter(buildLineChart(student));
    }
    private void showChartInMiddle()
    {
        
    }
    
    private void showTable()
    {
        tViewColOne.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        tViewColTwo.setCellValueFactory(cellData -> cellData.getValue().absenseProperty());
        tView.setItems(student.getAttendanceDates1());
        //Hvis det her skal bruges skal vi have lavet klasse "absense" som holder styr på alle datoer i stedet
        //Denne type kan kun tage en "property" fra hver i LISTEn af personer.
        //Når vi arbejder med typen "student" må vi kun smide en liste af "Students" ind, ikke andet som setItems.
        
    }
}