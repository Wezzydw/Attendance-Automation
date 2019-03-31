/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.dal;

import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author andreas
 */
public interface IGetData
{
    
    List<Student> getAllStudents();
    
    List<Teacher> getAllTeachers();
  
    Student getStudent(String name);
    
}
