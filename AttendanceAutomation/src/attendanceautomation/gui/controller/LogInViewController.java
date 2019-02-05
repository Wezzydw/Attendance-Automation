/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Wezzy Laptop
 */
public class LogInViewController implements Initializable {
    
    private Label label;
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;
    
    private Model model;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        model = new Model(); // giver en error i teacher classen
    }    

    @FXML
    private void handleLogIn(ActionEvent event)
    {
        for (Student student : model.getAllStudents())
        {
            
            if(student.getStudent(txtUser.getText(), txtPassword.getText()))
            {
                System.out.println(student.getFirstName() + " " + student.getLastName() + " has logged in");
            }
        }
        for (Teacher teacher : model.getAllTeachers())
        {
            if(teacher.getTeacher(txtUser.getText(), txtPassword.getText()))
            {
                System.out.println(teacher.getFirstName() + " " + teacher.getLastName() + " has logged in");
            }
        }
    }

    @FXML
    private void handleCancel(ActionEvent event)
    {
        Stage stage = (Stage) txtUser.getScene().getWindow();
        stage.close();
    }
    
}
