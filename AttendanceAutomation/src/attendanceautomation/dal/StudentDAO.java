
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
    
    /**
     * Opretter forbindelse til databasen
     * @throws IOException 
     */
    public StudentDAO() throws IOException {
        try {
            conProvider = new DatabaseConnection();
        } catch (IOException ex) {
            throw new IOException("No database connection established " + ex);
        }
    }
    
    /**
     * Henter fornavn i fName, efternavn i lName, du gættede det - username i
     * username og password i password og tilføjer dem til listen.
     * Metoden henter også den enkelte students attendance.
     * @return en liste af students.
     * @throws SQLException 
     */
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
    
    /**
     * Opretter en ArrayList med attendance ud fra studentId, date og
     * status for attendance (absent/present)
     * @return en liste med attendance.
     * @throws SQLException 
     */
    private List<Attendance> getAttendance() throws SQLException {
        
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
    
    /**
     * Opdaterer attendance status ned i databasen.
     * @param student
     * @param attendance
     * @throws SQLException 
     */
    public void editAttendance(Student student, Attendance attendance) throws SQLException{
        try (Connection con = conProvider.getConnection()) {
            String a = "UPDATE Attendance SET present = ? WHERE (studentId = ? AND date = ?);";
            PreparedStatement prst = con.prepareStatement(a);
            
            prst.setString(1, attendance.getAbsense());
            prst.setInt(2, student.getId());
            prst.setString(3, attendance.getDate());
            prst.execute();
            
            prst.close();
        } catch(SQLException ex){
            throw new SQLException("Can't edit attendance " + ex);
        }
    }
    
    /**
     * Skriver attendance ned i databasen.
     * @param student
     * @param attendance 
     */
    public void regiserAttendance(Student student, Attendance attendance){
        try (Connection con = conProvider.getConnection()) {
            String a = "INSERT INTO Attendance (studentId, date, present) VALUES(?,?,?);";
            PreparedStatement prst = con.prepareStatement(a);
            prst.setInt(1, student.getId());
            prst.setString(2, attendance.getDate());
            prst.setString(3, attendance.getAbsense());
            prst.execute();
        } catch(SQLException ex){
            
        }
    }
}
