/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import attendanceautomation.dal.MockData;
import java.util.List;

/**
 *
 * @author andreas
 */
public class PassThroughLayer
{
    private MockData data;

    public PassThroughLayer()
    {
        data = new MockData();
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
