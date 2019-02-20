/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.Student;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    }    

    @FXML
    private void HandleEdit(ActionEvent event)
    {
    }
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
//    public void setMainApp(MainApp mainApp) {
//        this.mainApp = mainApp;
//
//        // Add observable list data to the table
//        personTable.setItems(mainApp.getPersonData());
//    }
    public void setAttendanceTable(List<Student> alleStudenter)
    {
        
        for (Student allStudent : alleStudenter) {
            allStudents.add(allStudent);
        }
        
        
        attendanceTable.setItems(allStudents);
    }
}
