/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.bll;

import attendanceautomation.be.Attendance;
import attendanceautomation.be.Student;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mpoul
 */
public class AttendanceAutoFillDates {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    public void insertDatesToDb() throws SQLServerException, SQLException{
        String date;
        String attendance;
        int id;
        PassThroughLayer ptl = new PassThroughLayer();
        ptl.getAllStudents();
        
        try(Connection con = getConnection()){
        String sql = "INSERT INTO Attendance VALUES (?,?,?)";  
        PreparedStatement statement = con.prepareStatement(sql);
            for (Student student : ptl.getAllStudents()) {
                for (Attendance att : student.getAttendanceDates1()) {
                    statement.setInt(1, student.getId);
                }
                
            }
            
        }
        catch(){
                
                }
    }
    
    private static final String SERVER_NAME = "10.176.111.31";
    private static final String DB_NAME = "moviesrs";
    private static final String USER_NAME = "CS2018A_11";
    private static final String PASSWORD = "CS2018A_11";
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
