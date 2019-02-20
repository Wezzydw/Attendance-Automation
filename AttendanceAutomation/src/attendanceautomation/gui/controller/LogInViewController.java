/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
        model = new Model();
    }    

    @FXML
    private void handleLogIn(ActionEvent event)
    {
        checkUser();
    }
    
    private void checkUser()
    {
        for (Student student : model.getAllStudents())
        {
            
            if(student.getStudent(txtUser.getText(), txtPassword.getText()))
            {
                System.out.println(student.getFirstName() + " " + student.getLastName() + " has logged in");
                showStudentLogIn(student);
            }
        }
        for (Teacher teacher : model.getAllTeachers())
        {
            if(teacher.getTeacher(txtUser.getText(), txtPassword.getText()))
            {
                System.out.println(teacher.getFirstName() + " " + teacher.getLastName() + " has logged in");
                showTeacherLogIn(teacher);
            }
        }
    }
    
    private void showStudentLogIn(Student student)
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/attendanceautomation/gui/view/StudentView.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            System.out.println("Error" + ex);
        }
        StudentViewController display = loader.getController();
        display.setStudent(student);
        
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        Stage stage1 = (Stage) txtUser.getScene().getWindow();
        stage1.close();
        stage.showAndWait();
    }
    
    private void showTeacherLogIn(Teacher teacher)
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/attendanceautomation/gui/view/FXMLTeacherView.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            System.out.println("Error" + ex);
        }
        FXMLTeacherViewController display = loader.getController();
        display.setAttendanceTable(model.getAllStudents());

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        Stage stage1 = (Stage) txtUser.getScene().getWindow();
        stage1.close();
        stage.showAndWait();
        
    }
    @FXML
    private void handleCancel(ActionEvent event)
    {
        Stage stage = (Stage) txtUser.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleEnterPressed(KeyEvent event)
    {
        if(event.getCode().toString().equals("ENTER"))
        {
            checkUser();
        }
    }
    
}
