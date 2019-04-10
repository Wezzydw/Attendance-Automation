/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.Attendance;
import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import attendanceautomation.bll.IBLL;
import attendanceautomation.bll.PassThroughLayer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author andreas
 */
public class Model
{
    private IBLL ptl;

    public Model() throws IOException
    {
        ptl = new PassThroughLayer();
    }
    
    /**
     * 
     * @return en liste af alle students
     */
    public List<Student> getAllStudents()throws SQLException
    {
        return ptl.getAllStudents();
    }
    
    /**
     * 
     * @return en listte af alle teachers
     */
    public List<Teacher> getAllTeachers()throws SQLException
    {
        return ptl.getAllTeachers();
    }
    
    /**
     * Sender et student object samt attendance object ned til registerAttendance.
     * @param attendance
     * @param student 
     */
    public void registerAttendance(Attendance attendance, Student student)throws SQLException{
        ptl.registerAttendance(attendance, student);
    }
    
    /**
     * Sender et student object samt attendance object ned til edit attendance.
     * @param attendance
     * @param student 
     */
    public void editAttendance(Attendance attendance, Student student)throws SQLException{
        ptl.editAttendance(attendance, student);
    }
    
    /**
     * @param student
     * @param day
     * @return Attendance i procenter.
     */
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
    
    /**
     * Får alle students attendance
     * @param day
     * @return et gennemsnit af alle students attendance.
     */
     public double getPercentDaysForAllStudents(String day) throws SQLException
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
