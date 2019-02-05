/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.be;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Wezzy Laptop
 */
public class Teacher {

    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private StringProperty username = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    
    public Teacher(String firstName, String lastName, String username, String password) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.username.set(username);
        this.password.set(password);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public boolean getTeacher(String username, String password) {
        if (username.equals(this.username.getValue()) && password.equals(this.password.getValue())) {
            return true;
        } else {
            return false;
        }
    }

}
