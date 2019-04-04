/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.dal;

import attendanceautomation.be.Teacher;
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
public class TeacherDAO
{
    private DatabaseConnection conProvider;

    public TeacherDAO() throws IOException
    {
        try {
            conProvider = new DatabaseConnection();
        } catch (IOException ex) {
            throw new IOException("No database connection established " + ex);
        }
    }
    
    /**
     * Opretter et teacher object, med navn, efternavn, username og password
     * og tilføjer til listen.
     * @return en liste af Teachers
     * @throws SQLException 
     */
    public List<Teacher> getAllTeachersFromDB() throws SQLException {
        List<Teacher> allTeachers = new ArrayList();

        try (Connection con = conProvider.getConnection()) {
            String a = "SELECT * FROM Teacher;";
            PreparedStatement prst = con.prepareStatement(a);
            ResultSet rs = prst.executeQuery();

            while (rs.next()) {
                
                String fName = rs.getString("fName");
                String lName = rs.getString("lName");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int id = rs.getInt("id");
                
                Teacher teacher = new Teacher(fName, lName, username, password);
                
                allTeachers.add(teacher);
                
            }
        } catch (SQLException ex) {
            throw new SQLException("No data from getAllMovies" + ex);
        }
        return allTeachers;
    }
}
