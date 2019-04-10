/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.dal;

import attendanceautomation.be.Attendance;
import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author andreas
 */
public interface IGetData
{

    List<Student> getAllStudents() throws SQLException;

    List<Teacher> getAllTeachers() throws SQLException;

    Student getStudent(String name);

    void registerAttendance(Attendance attendance, Student student) throws SQLException;

    void editAttendance(Attendance attendance, Student student) throws SQLException;
}
