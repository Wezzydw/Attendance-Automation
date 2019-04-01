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
public class PassThroughLayer
{
    private IGetData data;

//    public PassThroughLayer(IGetData getData)
    public PassThroughLayer() throws IOException
    {
        data = new GetData();
//        data = getData;
        
        
    }
    
    
    
    public List<Student> getAllStudents()
    {
        return data.getAllStudents();
    }
    
    public List<Teacher> getAllTeachers() 
    {
        return data.getAllTeachers();
    }
    
    public void registerAttendance(Attendance attendance, Student student){
        data.registerAttendance(attendance, student);
    }
    
    public void editAttendance(List<Attendance> attendance, Student student){
        data.editAttendance(attendance, student);
    }
}
