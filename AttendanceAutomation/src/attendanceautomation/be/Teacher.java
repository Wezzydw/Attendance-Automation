/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Wezzy Laptop
 */
public class Teacher {

    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty username;
    private StringProperty password;
    
    public Teacher(String firstName, String lastName, String username, String password) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
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
