/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.dal;

import attendanceautomation.be.Attendance;
import attendanceautomation.be.Student;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andreas
 */
public class StudentDAO {

    private DatabaseConnection conProvider;

    public StudentDAO() throws IOException {
        try {
            conProvider = new DatabaseConnection();
        } catch (IOException ex) {
            throw new IOException("No database connection established " + ex);
        }
    }

    public List<Student> getAllStudentsFromDB() throws SQLException {
        List<Student> allStudents = new ArrayList();

        try (Connection con = conProvider.getConnection()) {
            String a = "SELECT * FROM Student;";
            PreparedStatement prst = con.prepareStatement(a);
            ResultSet rs = prst.executeQuery();

            while (rs.next()) {
                String fName = rs.getString("fName");
                String lName = rs.getString("lName");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int id = rs.getInt("id");

                Student student = new Student(id, fName, lName, username, password);

                allStudents.add(student);
            }
        } catch (SQLException ex) {
            throw new SQLException("No data from getAllStudents" + ex);
        }
        List<Attendance> q = getAttendance();
        for (Attendance attendance : q) {
            for (Student s : allStudents) {
                if (attendance.getId() == s.getId()) {
                    s.addAttendanceDate(attendance.getDateAsDate(), attendance.getAbsense());
                }
            }
        }

        return allStudents;
    }

    private List<Attendance> getAttendance() throws SQLException {
        List<Student> allStudents = new ArrayList();
        List<Attendance> ad = new ArrayList();

        try (Connection con = conProvider.getConnection()) {
            String a = "SELECT * FROM Attendance;";
            PreparedStatement prst = con.prepareStatement(a);
            ResultSet rs = prst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("studentId");
                String date = rs.getString("date");
                String attendance = rs.getString("present");

                LocalDate ld = LocalDate.parse(date);
                ad.add(new Attendance(id, ld, attendance));
            }
        } catch (SQLException ex) {
            throw new SQLException("No data from getAllStudents" + ex);
        }
        return ad;
    }

}
