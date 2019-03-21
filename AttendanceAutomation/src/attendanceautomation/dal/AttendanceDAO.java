/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.dal;

import attendanceautomation.be.Attendance;
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
public class AttendanceDAO
{
    private DatabaseConnection conProvider;

    public AttendanceDAO() throws IOException
    {
        try {
            conProvider = new DatabaseConnection();
        } catch (IOException ex) {
            throw new IOException("No database connection established " + ex);
        }
    }
    
    public List<Attendance> getAllAttendancesFromDB() throws SQLException {
        List<Attendance> allAttendances = new ArrayList();

        try (Connection con = conProvider.getConnection()) {
            String a = "SELECT * FROM Attendance;";
            PreparedStatement prst = con.prepareStatement(a);
            ResultSet rs = prst.executeQuery();

            while (rs.next()) {
                String date = rs.getString("date");
                int studentID = rs.getInt("studentId");
                String present = rs.getString("present");
                LocalDate l = LocalDate.parse(date);
                
                //Attendance attendance = new Attendance(l, present);
                // der mangler noget med student id, dette mangler i BE laget
                
                //allAttendances.add(attendance);
                
                
                
            }
        } catch (SQLException ex) {
            throw new SQLException("No data from getAllAttendances" + ex);
        }
        return allAttendances;
    }
}
