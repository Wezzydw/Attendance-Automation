/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.Attendance;
import attendanceautomation.be.Student;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setStudent(Student student){
        lblUser.setText(student.getFirstName() + " " + student.getLastName());
        this.currentStudent = student;
        showTable();
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
        radio = "Present";
        
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
        radio = "Absent";
    }
    private void showTable()
    {
        columnC1.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        columnC2.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        tableTable.setItems(currentStudent.getAttendanceDates1());
        //Hvis det her skal bruges skal vi have lavet klasse "absense" som holder styr på alle datoer i stedet
        //Denne type kan kun tage en "property" fra hver i LISTEn af personer.
        //Når vi arbejder med typen "student" må vi kun smide en liste af "Students" ind, ikke andet som setItems.
        
    }

    @FXML
    private void onHandleEdit(ActionEvent event)
    {
        if (radio != null){
            for (Attendance attendance : currentStudent.getAttendanceDates1())
            {
                if (attendance.getDateAsDate().equals(LocalDate.now())){
                    if (!attendance.getAbsense().equals(radio))
                    {
                        //need these functions/methods
                        //attendance.setAbsense();
                        //model.editAttendance(currentStudent, radio);
                    }
                }
            }   
        }
    }
}
