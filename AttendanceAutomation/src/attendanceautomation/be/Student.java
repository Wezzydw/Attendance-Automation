/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.be;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Wezzy Laptop
 */
public class Student {
    
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty username;
    private StringProperty password;
    private StringProperty date;
    private ObservableList<LocalDate> attendanceList;
    
    
    public Student(String firstName, String lastName, String username, String password)
    {
        attendanceList = FXCollections.observableArrayList();
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        date = new SimpleStringProperty();
    }
    
    public String getFirstName()
    {
        return firstName.get();
    }
    
    public String getLastName()
    {
        return lastName.get();
    }
    
    public boolean getStudent(String username, String password)
    {   
        if (username.equals(this.username.getValue()) && password.equals(this.password.getValue()))
            return true;
        else 
            return false;
    }
    
    public ObservableList<LocalDate> getAttendanceDates()
    {
        return attendanceList;
    }
    
    public void addAttendanceDate(LocalDate date)
    {
        attendanceList.add(date);
    }
    
    public void deleteAttendanceDate(LocalDate date)
    {
        attendanceList.remove(date);
    }
    
    public StringProperty firstNameProperty()
    {
        return firstName;
    }
    
    public StringProperty lastNameProperty()
    {
        return lastName;
    }
    
    public StringProperty dateProperty()
    {
        return lastName;
    }
    
    public String dayFromDate(LocalDate date)
    {
        return date.getDayOfWeek().toString();
    }
}
