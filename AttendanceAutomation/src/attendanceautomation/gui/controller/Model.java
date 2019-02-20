/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.Attendance;
import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import bll.PassThroughLayer;
import java.util.List;

/**
 *
 * @author andreas
 */
public class Model
{
    private PassThroughLayer ptl;

    public Model()
    {
        ptl = new PassThroughLayer();
    }
    
    public List<Student> getAllStudents()
    {
        return ptl.getAllStudents();
    }
    
    public List<Teacher> getAllTeachers()
    {
        return ptl.getAllTeachers();
    }
    
    public double getPercentDaysForStudent(Student student, String day)
    {
        double count1 = 0;
        double count2 = 0;
        
        for (Attendance a : student.getAttendanceDates1())
        {
            if (a.getDateAsDate().getDayOfWeek().toString().equals(day))
            {
                count1++;
                if (a.getAbsense().equals("Present"))
                {
                    count2++;
                }
            }
        }
        double att = (count2/count1)*100;
        
        return att;
    }
    
     public double getPercentDaysForAllStudents(String day)
    {
        double count1 = 0;
        double count2 = 0;
        
        for (Student a : getAllStudents())
        {
            for (Attendance b : a.getAttendanceDates1())
            {
                
            if (b.getDateAsDate().getDayOfWeek().toString().equals(day))
            {
                count1++;
                if (b.getAbsense().equals("Present"))
                {
                    count2++;
                }
            }
        }
        }
        double att = (count2/count1)*100;
        
        return att;
    }
    
}
