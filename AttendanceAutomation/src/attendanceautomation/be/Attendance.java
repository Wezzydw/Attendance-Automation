/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.be;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Wezzy Laptop
 */
public class Attendance {

    private StringProperty date;
    private StringProperty absense;
    private LocalDate ldate;
    private int id;
    
    
    
    /**
     * Constructor til attendance
     * @param id
     * @param date
     * @param absense 
     */
    public Attendance(int id, LocalDate date, String absense) {
        this.id = id;
        ldate = date;
        this.date = new SimpleStringProperty(ldate.toString());
        this.absense = new SimpleStringProperty(absense);
    }
    
    public String getDate() {
        return date.get();
    }
    
    public LocalDate getDateAsDate() {
        return ldate;
    }
    
    public String getAbsense() {
        return absense.get();
    }
    
    public void setAbsense(String absense){
        this.absense.set(absense);
    }
    
    public StringProperty dateProperty() {
        return date;
    }

    public StringProperty absenseProperty() {
        return absense;
    }

    public String dayFromDate(LocalDate date) {
        return date.getDayOfWeek().toString();
    }

    public int getId() {
        return id;
    }
}
