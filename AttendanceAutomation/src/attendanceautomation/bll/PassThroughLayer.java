/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.bll;

import attendanceautomation.be.Attendance;
import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import attendanceautomation.dal.GetData;
import attendanceautomation.dal.IGetData;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author andreas
 */
public class PassThroughLayer implements IBLL
{
    private IGetData data;
    
    public PassThroughLayer() throws IOException
    {
        data = new GetData();   
    }
    
    
    /**
     * 
     * @return alle students fra DB
     */
    public List<Student> getAllStudents()
    {
        return data.getAllStudents();
    }
    
    /**
     * 
     * @return alle teachers fra DB
     */
    public List<Teacher> getAllTeachers() 
    {
        return data.getAllTeachers();
    }
    
    /**
     * Laver en ny attendance i DB
     * @param attendance 
     * @param student 
     */
    public void registerAttendance(Attendance attendance, Student student){
        data.registerAttendance(attendance, student);
    }
    
    /**
     * Ændrer attendance i DB
     * @param attendance
     * @param student 
     */
    public void editAttendance(Attendance attendance, Student student){
        data.editAttendance(attendance, student);
    }
}
