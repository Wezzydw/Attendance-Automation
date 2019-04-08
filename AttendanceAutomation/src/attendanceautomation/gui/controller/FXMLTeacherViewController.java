/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import attendanceautomation.gui.controller.TeacherEditController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

        try {
            model = new Model();
        } catch (IOException ex) {
            Logger.getLogger(FXMLTeacherViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Når man trykker på edit knappen, åbnes et vindue over alle skoledage
     * og teacher har mulighed for at rette til absent eller present.
     * @param event 
     */
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
        display.setStudent(attendanceTable.getSelectionModel().getSelectedItem());

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }

    /**
     * indlæser listen over alle students i tableview.
     * @param alleStudenter 
     */
    public void setAttendanceTable(List<Student> alleStudenter)
    {

        for (Student allStudent : alleStudenter)
        {
            allStudents.add(allStudent);
        }

        attendanceTable.setItems(allStudents);
        handleShowAllStudentLineChart(alleStudenter);
    }

    /**
     * Sætter labelet til den teacher som er logget ind.
     * @param teacher 
     */
    public void setTeacher(Teacher teacher)
    {
        lblUser.setText(teacher.getFirstName() + " " + teacher.getLastName());
    }

    /**
     * Indlæser attendance for alle students når teacher er logget ind. Når der
     * vælges en student, indlæses den valgte students attendance, og tilføjes
     * tableviewet.
     * @param student
     * @return linechart
     */
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
        series.getData().add(new XYChart.Data<>("Mandag", model.getPercentDaysForStudent(student, "MONDAY")));
        series.getData().add(new XYChart.Data<>("Tirsdag", model.getPercentDaysForStudent(student, "TUESDAY")));
        series.getData().add(new XYChart.Data<>("Onsdag", model.getPercentDaysForStudent(student, "WEDNESDAY")));
        series.getData().add(new XYChart.Data<>("Torsdag", model.getPercentDaysForStudent(student, "THURSDAY")));
        series.getData().add(new XYChart.Data<>("Fredag", model.getPercentDaysForStudent(student, "FRIDAY")));

        lineChart.getData().add(series);

        return lineChart;
    }

    /**
     * Indlæser linechart for alle students gennemsnitlig attendance
     * @param allStudents
     * @return 
     */
    private LineChart buildAllStudentLineChart(List<Student> allStudents)
    {

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Week day");
        yAxis.setLabel("Attendance %");
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Attendance");

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
    

    /**
     * sætter linechartet for den enkelte elev ind i midten af viewet
     * @param student 
     */
    private void handleShowStudentLineChart(Student student)
    {
        middlePane.setCenter(buildStudentLineChart(student));
    }

    /**
     * sætter linechartet for gennemsnitsattendance på alle elever ind i midten
     * @param allStudents 
     */
    private void handleShowAllStudentLineChart(List<Student> allStudents)
    {
        middlePane.setCenter(buildAllStudentLineChart(allStudents));
    }
}
