/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.bll;

import attendanceautomation.be.Attendance;
import attendanceautomation.be.Student;
import attendanceautomation.dal.GetData;
import java.io.IOException;
import java.time.LocalDate;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marce
 */
public class PassThroughLayerTest
{
    
    public PassThroughLayerTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }

    /**
     * Test of getAllStudents method, of class PassThroughLayer.
     */
    @Test
    public void testGetAllStudents() throws IOException
    {
        GetData data = new GetData();
         assertEquals(7, data.getAllStudents().size());
    }

    /**
     * Test of getAllTeachers method, of class PassThroughLayer.
     */
    @Test
    public void testGetAllTeachers() throws IOException
    {
         GetData data = new GetData();
         assertEquals(4, data.getAllTeachers().size());
    }

    /**
     * Test of registerAttendance method, of class PassThroughLayer.
     */
    @Test
    public void testRegisterAttendance() throws IOException
    {
        GetData data = new GetData();
        int i = data.getAllStudents().get(0).getAttendanceDates1().size();
        Student student = new Student(1, "Tonny", "Tonnesen", "tny123", "123"); 
        LocalDate localDate = LocalDate.of(2013, 1, 9);
        Attendance attendance = new Attendance(student.getId() ,localDate, "Absent");
        data.registerAttendance(attendance, student);
        assertNotEquals(i, data.getAllStudents().get(0).getAttendanceDates1().size());
        
    }

    /**
     * Test of editAttendance method, of class PassThroughLayer.
     */
    @Test
    public void testEditAttendance() throws IOException
    {
        GetData data = new GetData();
        String attendanceCheck = data.getAllStudents().get(0).getAttendanceDates1().get(5).getAbsense();
        Student student = new Student(1, "Tonny", "Tonnesen", "tny123", "123"); 
        LocalDate localDate = LocalDate.of(2019, 1, 8);
        LocalDate localDate1 = LocalDate.of(2013, 1, 1);
        Attendance attendance = new Attendance(student.getId() ,localDate, "Absent");     
        data.editAttendance(attendance, student);
        assertNotEquals(attendanceCheck, data.getAllStudents().get(0).getAttendanceDates1().get(5).getAbsense());
    }
    
}
