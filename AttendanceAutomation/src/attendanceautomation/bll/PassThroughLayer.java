/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.bll;

import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import attendanceautomation.dal.IGetData;
import attendanceautomation.dal.MockData;
import java.util.List;

/**
 *
 * @author andreas
 */
public class PassThroughLayer
{
    private MockData data;

//    public PassThroughLayer(IGetData getData)
    public PassThroughLayer()
    {
        data = new MockData();
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
}
