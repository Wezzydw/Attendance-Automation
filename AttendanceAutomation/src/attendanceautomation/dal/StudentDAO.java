/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.dal;

import attendanceautomation.be.Student;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andreas
 */
public class StudentDAO
{
    private DatabaseConnection conProvider;

    public StudentDAO() throws IOException
    {
        try {
            conProvider = new DatabaseConnection();
        } catch (IOException ex) {
            throw new IOException("No database connection established " + ex);
        }
    }
    
    public List<Student> getAllStudentFromDB() throws SQLException {
        List<Student> allStudents = new ArrayList();

        try (Connection con = conProvider.getConnection()) {
            String a = "SELECT * FROM Student;";
            PreparedStatement prst = con.prepareStatement(a);
            ResultSet rs = prst.executeQuery();

            while (rs.next()) {
                List<String> categori = new ArrayList();
                String fName = rs.getString("fName");
                String lName = rs.getString("lName");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int id = rs.getInt("id");
                
                Student student = new Student(fName, lName, username, password);
                
                allStudents.add(student);
                
            }
        } catch (SQLException ex) {
            throw new SQLException("No data from getAllMovies" + ex);
        }
        return allStudents;
    }
    
}
