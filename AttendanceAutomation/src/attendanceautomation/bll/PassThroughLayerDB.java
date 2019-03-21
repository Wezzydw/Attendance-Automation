/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.bll;

import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import attendanceautomation.dal.StudentDAO;
import attendanceautomation.dal.TeacherDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andreas
 */
public class PassThroughLayerDB implements IBLL {

    private StudentDAO studentdata;
    private TeacherDAO teacherdata;

//    public PassThroughLayer(IGetData getData)
    public PassThroughLayerDB() throws IOException {
        studentdata = new StudentDAO();
        teacherdata = new TeacherDAO();

    }

    public List<Student> getAllStudents() {
        try {
            return studentdata.getAllStudentsFromDB();
        } catch (SQLException ex) {
            Logger.getLogger(PassThroughLayerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Teacher> getAllTeachers() {
        try {
            return teacherdata.getAllTeachersFromDB();
        } catch (SQLException ex) {
            Logger.getLogger(PassThroughLayerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
