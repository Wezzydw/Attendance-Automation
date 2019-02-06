/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author mpoul
 */
public class StudentViewController implements Initializable {

    @FXML
    private ComboBox<?> cBox;
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
    @FXML
    private AnchorPane middleAnchor;

    private Student student;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void handleRegister(ActionEvent event) {
        
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
}
