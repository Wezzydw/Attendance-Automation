/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.dal;

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
                String studentID = rs.getString("lName");
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
