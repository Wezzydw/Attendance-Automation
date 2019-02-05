/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

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
    
}
