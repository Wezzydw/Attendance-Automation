/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.dal;

import attendanceautomation.be.Attendance;
import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Andreas Svendsen
 */
public class GetData implements IGetData{

    StudentDAO sdao;
    TeacherDAO tdao;
  
    public GetData() throws IOException {
        sdao = new StudentDAO();
        tdao = new TeacherDAO();
    }
    
    /**
     * Henter alle students fra DB
     * @return 
     */
    @Override
    public List<Student> getAllStudents() {
      
        try {
            return sdao.getAllStudentsFromDB();
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Henter alle teachers fra DB
     * @return 
     */
    @Override
    public List<Teacher> getAllTeachers() {
        try {
            return tdao.getAllTeachersFromDB();
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Student getStudent(String name) {
        return null;
    }

    /**
     * Sender attendance ned til DB
     * @param attendance
     * @param student 
     */
    @Override
    public void registerAttendance(Attendance attendance, Student student)
    {
        sdao.regiserAttendance(student, attendance);
    }
    
    /**
     * Opdaterer attendance i DB
     * @param attendance
     * @param student 
     */
    @Override
    public void editAttendance(Attendance attendance, Student student)
    {
        try
        {
            sdao.editAttendance(student, attendance);
        } catch (SQLException ex)
        {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
