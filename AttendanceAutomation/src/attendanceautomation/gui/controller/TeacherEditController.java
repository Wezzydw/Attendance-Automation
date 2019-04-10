/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.Attendance;
import attendanceautomation.be.Student;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Andreas Svendsen
 */
public class TeacherEditController implements Initializable {

    @FXML
    private TableView<Attendance> tableTable;
    @FXML
    private TableColumn<Attendance, String> columnC1;
    @FXML
    private TableColumn<Attendance, String> columnC2;
    @FXML
    private RadioButton radioPresent;
    @FXML
    private RadioButton radioAbsent;
    @FXML
    private Label lblUser;

    private Student currentStudent;
    private String radio = null;
    private Model model;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            model = new Model();
        } catch (IOException ex) {
            Logger.getLogger(TeacherEditController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Sætter den vlagte student til student og sætter labelet til students navn
     * Derefter viser den tabelen med alle studens attendances
     * @param student 
     */
    public void setStudent(Student student) {
        lblUser.setText(student.getFirstName() + " " + student.getLastName());
        this.currentStudent = student;
        showTable();
    }
    /**
     * Ændre radioButtonPresent til at være checket af hvis man trykker på den,
     * hvis Absent allerede er checket af vil den blive ikke checket af.
     * Til sidst sætter den strengen radio til Present.
     * @param event 
     */
    @FXML
    private void rPresent(ActionEvent event) {
        if (radioAbsent.selectedProperty().getValue()) {
            radioAbsent.selectedProperty().setValue(Boolean.FALSE);
            radioPresent.selectedProperty().setValue(Boolean.TRUE);
        } else if (!radioPresent.selectedProperty().getValue()) {
            radioPresent.selectedProperty().setValue(Boolean.TRUE);
        }
        radio = "Present";

    }
    
    /**
     * Ændre radioButtonAbsent til at være checket af hvis man trykker på den,
     * hvis Present allerede er checket af vil den blive ikke checket af.
     * Til sidst sætter den strengen radio til Absent.
     * @param event 
     */
    @FXML
    private void rAbsent(ActionEvent event) {
        if (radioPresent.selectedProperty().getValue()) {
            radioPresent.selectedProperty().setValue(Boolean.FALSE);
            radioAbsent.selectedProperty().setValue(Boolean.TRUE);
        } else if (!radioAbsent.selectedProperty().getValue()) {
            radioAbsent.selectedProperty().setValue(Boolean.TRUE);
        }
        radio = "Absent";
    }
    
    /**
     * Sætter tableViewets værdier ind på første og anden kolonne ud fra 
     * students attendance.
     */
    private void showTable() {
        columnC1.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        columnC2.setCellValueFactory(cellData -> cellData.getValue().absenseProperty());
        tableTable.setItems(currentStudent.getAttendanceDates1());
    }
    
    /**
     * Når man trykker på edit knappen, ændre man om studenten var til stede 
     * på dagen man har valgt.
     * @param event 
     */
    @FXML
    private void onHandleEdit(ActionEvent event) {
        if (radio != null) {
            tableTable.getSelectionModel().getSelectedItem().setAbsense(radio);
            Attendance a1 = tableTable.getSelectionModel().getSelectedItem();
            try
            {
                model.editAttendance(a1, currentStudent);
            } catch (SQLException ex)
            {
                System.out.println("Error edit attendace in teacher for : " + currentStudent.getFirstName() + " " + currentStudent.getLastName() + " " + ex);
            }
        }
    }
}

