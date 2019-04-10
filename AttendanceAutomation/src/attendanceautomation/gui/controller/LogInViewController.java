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
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author Wezzy Laptop
 */
public class LogInViewController implements Initializable
{

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;

    private Model model;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try
        {
            model = new Model();
        } catch (IOException ex)
        {
            Logger.getLogger(LogInViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Kalder checkUer metoden ved tryk på log-in knappen
     *
     * @param event
     */
    @FXML
    private void handleLogIn(ActionEvent event)
    {
        try
        {
            checkUser();
        } catch (SQLException ex)
        {
            System.out.println("Error Checking user " + ex);
        }
    }

    /**
     * Tjekker om en student eller teacher har logget ind. Kontrollerer
     * brugernavn og password for student eller teacher.
     */
    private void checkUser() throws SQLException
    {
        for (Student student : model.getAllStudents())
        {

            if (student.getStudent(txtUser.getText(), txtPassword.getText()))
            {
                showStudentLogIn(student);
            }
        }
        for (Teacher teacher : model.getAllTeachers())
        {
            if (teacher.getTeacher(txtUser.getText(), txtPassword.getText()))
            {
                showTeacherLogIn(teacher);
            }
        }
    }

    /**
     * Viser viewet for students, når en student har logget ind.
     *
     * @param student
     */
    private void showStudentLogIn(Student student)
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/attendanceautomation/gui/view/StudentView.fxml"));
        try
        {
            loader.load();
        } catch (IOException ex)
        {
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

    /**
     * Viser viewet for en teacher, når en teacher har logget ind.
     *
     * @param teacher
     */
    private void showTeacherLogIn(Teacher teacher)
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/attendanceautomation/gui/view/FXMLTeacherView.fxml"));
        try
        {
            loader.load();
            FXMLTeacherViewController display = loader.getController();
            display.setAttendanceTable(model.getAllStudents());
            display.setTeacher(teacher);
        } catch (IOException ex)
        {
            System.out.println("Error" + ex);
        } catch (SQLException ex)
        {
            System.out.println("Error getting all students " + ex);
        }

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        Stage stage1 = (Stage) txtUser.getScene().getWindow();
        stage1.close();
        stage.show();

    }

    /**
     * Lukker programmet ved tryk på cancel
     *
     * @param event
     */
    @FXML
    private void handleCancel(ActionEvent event)
    {
        Stage stage = (Stage) txtUser.getScene().getWindow();
        stage.close();
    }

    /**
     * Håndterer tryk på enter, som tryk på log-in knappen.
     *
     * @param event
     */
    @FXML
    private void handleEnterPressed(KeyEvent event)
    {
        if (event.getCode().toString().equals("ENTER"))
        {
            try
            {
                checkUser();
            } catch (SQLException ex)
            {
                System.out.println("Error checking user " + ex);
            }
        }
    }

}
