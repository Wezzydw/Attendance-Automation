/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.bll;

import attendanceautomation.be.Attendance;
import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import java.util.List;

/**
 *
 * @author andreas
 */
public interface IBLL
{
    public List<Student> getAllStudents();

    public List<Teacher> getAllTeachers() ;

    public void registerAttendance(Attendance attendance, Student student);
    
    public void editAttendance(Attendance attendance, Student student);
}
