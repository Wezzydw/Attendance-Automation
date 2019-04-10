/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.bll;

import attendanceautomation.be.Attendance;
import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author andreas
 */
public interface IBLL {

    /**
     * returnerer alle students
     * @return
     */
    public List<Student> getAllStudents()throws SQLException;

    /**
     * returnerer alle teachers
     * @return
     */
    public List<Teacher> getAllTeachers()throws SQLException;

    /**
     * Videresender den nye attendance 
     * @param attendance
     * @param student
     */
    public void registerAttendance(Attendance attendance, Student student)throws SQLException;

    /**
     * Videresender den ændrede attendance og student.
     * 
     * @param attendance
     * @param student
     */
    public void editAttendance(Attendance attendance, Student student)throws SQLException;
}
