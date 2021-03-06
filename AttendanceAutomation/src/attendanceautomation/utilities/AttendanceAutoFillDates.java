/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.utilities;

import attendanceautomation.be.Attendance;
import attendanceautomation.be.Student;
import attendanceautomation.bll.PassThroughLayer;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mpoul
 */
public class AttendanceAutoFillDates {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLServerException, IOException {
        AttendanceAutoFillDates bla = new AttendanceAutoFillDates();
        
        try {
            bla.insertDatesToDb();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceAutoFillDates.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertDatesToDb() throws SQLServerException, SQLException, IOException{
        MockData m = new MockData();
        try(Connection con = getConnection()){
        String sql = "INSERT INTO Attendance VALUES (?,?,?)";  
        int count = 0;
        PreparedStatement statement = con.prepareStatement(sql);
            for (int i = 0; i < 7; i++){
                for (Attendance att : m.getAllStudents().get(i).getAttendanceDates1()) {
                    System.out.println(count);
                    statement.setInt(1, i+1);
                    statement.setString(2, att.getDate());
                    statement.setString(3, att.getAbsense());
                    statement.executeUpdate();
                    count++;
                }
            }
        }
        
    }
    
    private static final String SERVER_NAME = "10.176.111.31";
    private static final String DB_NAME = "Attendance_Automation";
    private static final String USER_NAME = "CS2018A_20";
    private static final String PASSWORD = "CS2018A_20";
    SQLServerDataSource ds;
    
        
    
    public Connection getConnection() throws SQLServerException {
        ds = new SQLServerDataSource();
        ds.setServerName(SERVER_NAME);
        ds.setDatabaseName(DB_NAME);
        ds.setUser(USER_NAME);
        ds.setPassword(PASSWORD);
        Connection con = ds.getConnection();
        return con;
    }
    
}
