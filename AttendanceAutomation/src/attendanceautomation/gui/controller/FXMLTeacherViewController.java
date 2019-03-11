/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import attendanceautomation.gui.view.TeacherEditController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
        studentNameColumn.setCellValueFactory(cellData -> cellData.getValue().fullNameProperty());
        attendancePercentageColumn.setCellValueFactory(cellData -> cellData.getValue().attendancePersentageProperty());
        
        attendanceTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> handleShowStudentLineChart(newValue));

        model = new Model();
    }

    @FXML
    private void HandleEdit(ActionEvent event)
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/attendanceautomation/gui/view/TeacherEdit.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            System.out.println("Error" + ex);
        }
        TeacherEditController display = loader.getController();
//        display.setStudent(attendancePercentageColumn.getTableView().getItems().);

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }

    public void setAttendanceTable(List<Student> alleStudenter)
    {

        for (Student allStudent : alleStudenter)
        {
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

    private LineChart buildStudentLineChart(Student student)
    {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Week day");
        yAxis.setLabel("Attendance %");
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Attendance");
        XYChart.Series series = new XYChart.Series();
        series.setName(student.getFirstName() + " " + student.getLastName());
        //11 skal skiftes ud med et eller andet fra student.getMondayAttendance eller sådan noget
        series.getData().add(new XYChart.Data<>("Mandag", model.getPercentDaysForStudent(student, "MONDAY")));//for monday student.attendancePersentageMondayProperty() eller noget i den stil
        series.getData().add(new XYChart.Data<>("Tirsdag", model.getPercentDaysForStudent(student, "TUESDAY")));//for tuesday
        series.getData().add(new XYChart.Data<>("Onsdag", model.getPercentDaysForStudent(student, "WEDNESDAY")));//for wednesday
        series.getData().add(new XYChart.Data<>("Torsdag", model.getPercentDaysForStudent(student, "THURSDAY")));//for thursday
        series.getData().add(new XYChart.Data<>("Fredag", model.getPercentDaysForStudent(student, "FRIDAY")));//for friday

        lineChart.getData().add(series);

        return lineChart;
    }

    //Denne skal visses inden man har trykket på en elev, efter det skulle den skifte over til functionen oven over
    private LineChart buildAllStudentLineChart(List<Student> allStudents)
    {

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Week day");
        yAxis.setLabel("Attendance %");
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Attendance");
// der er ike behov for 'forloop' da vi har getPercentDaysForAllStudents
        for (Student allStudent : allStudents)
        {
            XYChart.Series series = new XYChart.Series();
            series.setName(allStudent.getFirstName() + " " + allStudent.getLastName());
            series.getData().add(new XYChart.Data<>("Mandag", model.getPercentDaysForAllStudents("MONDAY")));//for monday student.attendancePersentageMondayProperty() eller noget i den stil
            series.getData().add(new XYChart.Data<>("Tirsdag", model.getPercentDaysForAllStudents("TUESDAY")));//for tuesday
            series.getData().add(new XYChart.Data<>("Onsdag", model.getPercentDaysForAllStudents("WEDNESDAY")));//for wednesday
            series.getData().add(new XYChart.Data<>("Torsdag", model.getPercentDaysForAllStudents("THURSDAY")));//for thursday
            series.getData().add(new XYChart.Data<>("Fredag", model.getPercentDaysForAllStudents("FRIDAY")));//for friday

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
