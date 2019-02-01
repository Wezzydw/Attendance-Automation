/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.dal;

import attendanceautomation.be.Student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wezzy Laptop
 */
public class MockData {
    
    private List<Student> students;
    
    public MockData()
    {
        students = new ArrayList();
        
        Student Tonny = new Student("Tonny", "Tonnesen", "tny123", "123");
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 29));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 2));
        students.add(Tonny);
        
        Student Anne = new Student("Anne", "Vestergaard", "Annepigen", "123");
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 29));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 4));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 5));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 6));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 7));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 8));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 9));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 10));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 11));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 12));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 13));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 14));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 15));
        students.add(Anne);
        
        Student Mads = new Student("Mads", "Larsen", "madsen666", "123");
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 29));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 5));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 6));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 7));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 10));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 11));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 14));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 15));
        students.add(Mads);
        
        Student Peter = new Student("Peter", "Stegger", "ptrstr", "123");
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 29));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 2));
        students.add(Tonny);
        
        Student Tonny = new Student("Tonny", "Tonnesen", "tny123", "spasserbus");
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 29));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 2));
        students.add(Tonny);
        
        Student Tonny = new Student("Tonny", "Tonnesen", "tny123", "spasserbus");
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 29));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 2));
        students.add(Tonny);
        
        Student Tonny = new Student("Tonny", "Tonnesen", "tny123", "spasserbus");
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 29));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 2));
        students.add(Tonny);
        
        Student Tonny = new Student("Tonny", "Tonnesen", "tny123", "spasserbus");
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 29));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 2));
        students.add(Tonny);
        
        Student Tonny = new Student("Tonny", "Tonnesen", "tny123", "spasserbus");
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 29));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 2));
        students.add(Tonny);
        
        Student Tonny = new Student("Tonny", "Tonnesen", "tny123", "spasserbus");
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 29));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 2));
        students.add(Tonny);
        
        Student Tonny = new Student("Tonny", "Tonnesen", "tny123", "spasserbus");
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 29));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 2));
        students.add(Tonny);
        
        
    }
    
    
    public List<Student> getAllStudents()
    {
        return students;
    }
    
    
    
    
}
