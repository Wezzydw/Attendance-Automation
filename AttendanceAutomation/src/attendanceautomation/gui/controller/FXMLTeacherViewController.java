/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author andreas
 */
public class FXMLTeacherViewController implements Initializable
{

    @FXML
    private TableView<Student> attendanceTable;
    @FXML
    private TableColumn<Student, String> studentNameColumn;
    @FXML
    private TableColumn<Student, Number> attendancePercentageColumn;
    @FXML
    private Label lblUser;
    
    private Model model;
    
    private Teacher teacher;
    private ObservableList<Student> allStudents = FXCollections.observableArrayList();
    private List<Student> allStudentssss = new ArrayList();
    @FXML
    private BorderPane middlePane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
        // TODO
//        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
//        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        studentNameColumn.setCellValueFactory(cellData -> cellData.getValue().fullNameProperty());
        attendancePercentageColumn.setCellValueFactory(cellData -> cellData.getValue().attendancePersentageProperty());
//        handleShowLineChart();
//        handleShowAllStudentLineChart(allStudentssss);
//        
        attendanceTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> handleShowStudentLineChart(newValue));
        
        
    }    

    @FXML
    private void HandleEdit(ActionEvent event)
    {
    }

    public void setAttendanceTable(List<Student> alleStudenter)
    {
        
        for (Student allStudent : alleStudenter) {
            allStudents.add(allStudent);
        }
        
//        allStudentssss.addAll(alleStudenter);
        
        attendanceTable.setItems(allStudents);
        handleShowAllStudentLineChart(alleStudenter);
    }
    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
        lblUser.setText(teacher.getFirstName() + " " + teacher.getLastName());
    }
    
    private LineChart buildLineChart()
    {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Week day");
        yAxis.setLabel("Absense %");
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Attendance");
        XYChart.Series series = new XYChart.Series();
        series.setName("Student name");
        series.getData().add(new XYChart.Data<>("Mandag", 69.123));
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
    
    private LineChart buildStudentLineChart(Student student)
    {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Week day");
        yAxis.setLabel("Absense %");
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Attendance");
        XYChart.Series series = new XYChart.Series();
        series.setName(student.getFirstName() + " " + student.getLastName());
        //11 skal skiftes ud med et eller andet fra student.getMondayAttendance eller sådan noget
        series.getData().add(new XYChart.Data<>("Mandag", Math.random()*100));//for monday student.attendancePersentageMondayProperty() eller noget i den stil
        series.getData().add(new XYChart.Data<>("Tirsdag", Math.random()*100));//for tuesday
        series.getData().add(new XYChart.Data<>("Onsdag", Math.random()*100));//for wednesday
        series.getData().add(new XYChart.Data<>("Torsdag", Math.random()*100));//for thursday
        series.getData().add(new XYChart.Data<>("Fredag", Math.random()*100));//for friday
        
        lineChart.getData().add(series);
        
        return lineChart;
    }
    
    //Denne skal visses inden man har trykket på en elev, efter det skulle den skifte over til functionen oven over
    private LineChart buildAllStudentLineChart(List<Student> allStudents)
    {
        
        System.out.println(allStudentssss.size());
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Week day");
        yAxis.setLabel("Absense %");
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Attendance");
        
        for (Student allStudent : allStudents) {
            XYChart.Series series = new XYChart.Series();
            series.setName(allStudent.getFirstName() + " " + allStudent.getLastName());
            series.getData().add(new XYChart.Data<>("Mandag", Math.random()*100));//for monday student.attendancePersentageMondayProperty() eller noget i den stil
            series.getData().add(new XYChart.Data<>("Tirsdag", Math.random()*100));//for tuesday
            series.getData().add(new XYChart.Data<>("Onsdag", Math.random()*100));//for wednesday
            series.getData().add(new XYChart.Data<>("Torsdag", Math.random()*100));//for thursday
            series.getData().add(new XYChart.Data<>("Fredag", Math.random()*100));//for friday

            lineChart.getData().add(series);
        }


        return lineChart;
    }
    private void handleShowStudentLineChart(Student student)
    {
        middlePane.setCenter(buildStudentLineChart(student));
    }
    private void handleShowAllStudentLineChart(List<Student> allStudents)
    {
        middlePane.setCenter(buildAllStudentLineChart(allStudents));
    }
}
