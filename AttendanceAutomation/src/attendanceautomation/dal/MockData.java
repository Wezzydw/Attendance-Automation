/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.dal;

import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Wezzy Laptop
 */
public class MockData {

    private ObservableList<Student> students;
    private List<Teacher> teachers;

    public MockData() {
        
        
        teachers = new ArrayList();
        students = FXCollections.observableArrayList();
        
        teachers.add(new Teacher("Jeppe", "M", "JM", "123"));

        Student Tonny = new Student("Tonny", "Tonnesen", "tny123", "123");
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 29));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 2));
        students.add(Tonny);

        Student Anne = new Student("Anne", "Vestergaard", "Annepigen", "123");
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 1));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 2));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 3));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 4));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 5));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 6));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 7));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 8));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 9));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 10));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 11));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 12));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 13));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 14));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 15));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 16));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 17));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 18));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 19));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 20));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 21));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 22));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 23));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 24));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 25));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 26));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 27));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 28));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 29));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 30));
        Anne.addAttendanceDate(LocalDate.of(2019, 1, 31));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 1));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 2));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 4));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 5));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 6));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 7));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 8));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 9));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 10));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 11));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 12));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 13));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 14));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 15));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 16));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 17));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 18));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 19));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 20));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 21));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 22));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 23));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 24));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 25));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 26));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 27));
        Anne.addAttendanceDate(LocalDate.of(2019, 2, 28));
        students.add(Anne);
    
        Student Mads = new Student("Mads", "Larsen", "madsen666", "123");
        Mads.addAttendanceDate(LocalDate.of(2019, 1, 29));
        Mads.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Mads.addAttendanceDate(LocalDate.of(2019, 2, 5));
        Mads.addAttendanceDate(LocalDate.of(2019, 2, 6));
        Mads.addAttendanceDate(LocalDate.of(2019, 2, 7));
        Mads.addAttendanceDate(LocalDate.of(2019, 2, 10));
        Mads.addAttendanceDate(LocalDate.of(2019, 2, 11));
        Mads.addAttendanceDate(LocalDate.of(2019, 2, 14));
        Mads.addAttendanceDate(LocalDate.of(2019, 2, 15));
        students.add(Mads);

        Student Peter = new Student("Peter", "Stegger", "ptrstr", "123");
        Peter.addAttendanceDate(LocalDate.of(2019, 1, 1));
        Peter.addAttendanceDate(LocalDate.of(2019, 1, 2));
        Peter.addAttendanceDate(LocalDate.of(2019, 1, 3));
        Peter.addAttendanceDate(LocalDate.of(2019, 1, 4));
        Peter.addAttendanceDate(LocalDate.of(2019, 1, 5));
        Peter.addAttendanceDate(LocalDate.of(2019, 1, 12));
        Peter.addAttendanceDate(LocalDate.of(2019, 1, 13));
        Peter.addAttendanceDate(LocalDate.of(2019, 1, 14));
        Peter.addAttendanceDate(LocalDate.of(2019, 1, 15));
        Peter.addAttendanceDate(LocalDate.of(2019, 1, 16));
        Peter.addAttendanceDate(LocalDate.of(2019, 1, 17));
        Peter.addAttendanceDate(LocalDate.of(2019, 1, 22));
        Peter.addAttendanceDate(LocalDate.of(2019, 1, 23));
        Peter.addAttendanceDate(LocalDate.of(2019, 1, 24));
        Peter.addAttendanceDate(LocalDate.of(2019, 1, 30));
        Peter.addAttendanceDate(LocalDate.of(2019, 1, 31));
        Peter.addAttendanceDate(LocalDate.of(2019, 2, 1));
        Peter.addAttendanceDate(LocalDate.of(2019, 2, 7));
        Peter.addAttendanceDate(LocalDate.of(2019, 2, 8));
        Peter.addAttendanceDate(LocalDate.of(2019, 2, 9));
        Peter.addAttendanceDate(LocalDate.of(2019, 2, 10));
        Peter.addAttendanceDate(LocalDate.of(2019, 2, 11));
        Peter.addAttendanceDate(LocalDate.of(2019, 2, 12));
        Peter.addAttendanceDate(LocalDate.of(2019, 2, 13));
        Peter.addAttendanceDate(LocalDate.of(2019, 2, 14));
        Peter.addAttendanceDate(LocalDate.of(2019, 2, 20));
        Peter.addAttendanceDate(LocalDate.of(2019, 2, 21));
        Peter.addAttendanceDate(LocalDate.of(2019, 2, 27));
        Peter.addAttendanceDate(LocalDate.of(2019, 2, 28));
        students.add(Peter);

        Student Trine = new Student("Trine", "Andersen", "trnA", "123");
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 1));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 2));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 5));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 6));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 7));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 8));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 10));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 11));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 12));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 13));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 14));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 15));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 16));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 21));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 22));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 26));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 29));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 30));
        Trine.addAttendanceDate(LocalDate.of(2019, 1, 31));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 1));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 2));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 4));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 5));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 6));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 7));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 8));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 9));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 10));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 11));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 12));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 13));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 14));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 15));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 16));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 17));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 18));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 19));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 23));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 24));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 25));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 26));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 27));
        Trine.addAttendanceDate(LocalDate.of(2019, 2, 28));
        students.add(Trine);

        Student Jack = new Student("Jack", "Black", "jckbck", "123");
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 1));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 2));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 3));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 4));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 5));

        Jack.addAttendanceDate(LocalDate.of(2019, 1, 7));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 8));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 9));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 10));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 11));

        Jack.addAttendanceDate(LocalDate.of(2019, 1, 13));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 14));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 15));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 16));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 17));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 18));

        Jack.addAttendanceDate(LocalDate.of(2019, 1, 20));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 21));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 22));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 23));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 24));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 25));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 26));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 27));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 28));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 29));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 30));
        Jack.addAttendanceDate(LocalDate.of(2019, 1, 31));

        Jack.addAttendanceDate(LocalDate.of(2019, 2, 2));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 4));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 5));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 6));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 7));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 8));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 9));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 10));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 11));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 12));

        Jack.addAttendanceDate(LocalDate.of(2019, 2, 14));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 15));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 16));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 17));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 18));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 19));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 20));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 21));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 22));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 23));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 24));
        Jack.addAttendanceDate(LocalDate.of(2019, 2, 25));

        Jack.addAttendanceDate(LocalDate.of(2019, 2, 28));
        students.add(Jack);

        Student Lise = new Student("Lise", "Meyrup", "LM", "123");
        Lise.addAttendanceDate(LocalDate.of(2019, 1, 1));
        Lise.addAttendanceDate(LocalDate.of(2019, 1, 2));
        Lise.addAttendanceDate(LocalDate.of(2019, 1, 3));
        Lise.addAttendanceDate(LocalDate.of(2019, 1, 6));
        Lise.addAttendanceDate(LocalDate.of(2019, 1, 7));

        Lise.addAttendanceDate(LocalDate.of(2019, 1, 10));
        Lise.addAttendanceDate(LocalDate.of(2019, 1, 11));

        Lise.addAttendanceDate(LocalDate.of(2019, 1, 14));
        Lise.addAttendanceDate(LocalDate.of(2019, 1, 15));
        Lise.addAttendanceDate(LocalDate.of(2019, 1, 16));
        Lise.addAttendanceDate(LocalDate.of(2019, 1, 17));

        Lise.addAttendanceDate(LocalDate.of(2019, 1, 20));
        Lise.addAttendanceDate(LocalDate.of(2019, 1, 21));
        Lise.addAttendanceDate(LocalDate.of(2019, 1, 22));
        Lise.addAttendanceDate(LocalDate.of(2019, 1, 25));
        Lise.addAttendanceDate(LocalDate.of(2019, 1, 28));
        Lise.addAttendanceDate(LocalDate.of(2019, 1, 31));
        Lise.addAttendanceDate(LocalDate.of(2019, 2, 1));
        Lise.addAttendanceDate(LocalDate.of(2019, 2, 2));
        Lise.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Lise.addAttendanceDate(LocalDate.of(2019, 2, 6));
        Lise.addAttendanceDate(LocalDate.of(2019, 2, 7));
        Lise.addAttendanceDate(LocalDate.of(2019, 2, 10));
        Lise.addAttendanceDate(LocalDate.of(2019, 2, 11));
        Lise.addAttendanceDate(LocalDate.of(2019, 2, 14));
        Lise.addAttendanceDate(LocalDate.of(2019, 2, 17));
        Lise.addAttendanceDate(LocalDate.of(2019, 2, 18));
        Lise.addAttendanceDate(LocalDate.of(2019, 2, 19));
        Lise.addAttendanceDate(LocalDate.of(2019, 2, 20));
        Lise.addAttendanceDate(LocalDate.of(2019, 2, 23));
        Lise.addAttendanceDate(LocalDate.of(2019, 2, 26));
        Lise.addAttendanceDate(LocalDate.of(2019, 2, 27));
        Lise.addAttendanceDate(LocalDate.of(2019, 2, 28));
        students.add(Lise);

    }

    public ObservableList<Student> getAllStudents() {
        return students;
    }
    
    public List<Teacher> getAllTeachers()
    {
        return teachers;
    }
    
    public Student getStudent(String name)
    {
        for (Student s : getAllStudents())
        {
            if (s.getFirstName().contains(name))
                return s;
        }
        return null;
    }

}
