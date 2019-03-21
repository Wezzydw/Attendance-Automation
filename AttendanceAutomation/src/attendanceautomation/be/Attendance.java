/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.be;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.converter.LocalDateStringConverter;

/**
 *
 * @author Wezzy Laptop
 */
public class Attendance {
    
    private StringProperty date;
    private StringProperty absense;
    private LocalDate ldate;

    
    
    public Attendance(LocalDate date, String absense)
    {        
        ldate = date;
        this.date = new SimpleStringProperty(ldate.toString());
        this.absense = new SimpleStringProperty(absense);
    }
    
    public String getDate()
    {
        return date.get();
    }
    
    public LocalDate getDateAsDate()
    {
        return ldate;
    }
    
    public String getAbsense()
    {
        return absense.get();
    }
    
    public StringProperty firstNameProperty()
    {
        return date;
    }
    
    public StringProperty lastNameProperty()
    {
        return absense;
    }
    
    public String dayFromDate(LocalDate date)
    {
        return date.getDayOfWeek().toString();
    }
}
