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

    public MockData() {
        students = new ArrayList();

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
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 16));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 17));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 18));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 19));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 23));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 24));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 25));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 26));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 27));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 28));
        students.add(Trine);

        Student Jack = new Student("Jack", "Black", "jckbck", "123");
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 1));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 2));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 3));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 4));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 5));

        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 7));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 8));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 9));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 10));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 11));

        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 13));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 14));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 15));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 16));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 17));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 18));

        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 20));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 21));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 22));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 23));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 24));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 25));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 26));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 27));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 28));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 29));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 30));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 31));

        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 2));
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

        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 14));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 15));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 16));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 17));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 18));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 19));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 20));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 21));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 22));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 23));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 24));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 25));

        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 28));
        students.add(Jack);

        Student Lise = new Student("Lise", "Meyrup", "LM", "123");
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 1));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 2));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 3));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 6));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 7));

        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 10));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 11));

        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 14));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 15));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 16));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 17));

        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 20));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 21));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 22));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 25));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 28));
        Tonny.addAttendanceDate(LocalDate.of(2019, 1, 31));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 1));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 2));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 3));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 6));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 7));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 10));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 11));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 14));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 17));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 18));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 19));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 20));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 23));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 26));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 27));
        Tonny.addAttendanceDate(LocalDate.of(2019, 2, 28));
        students.add(Lise);

    }

    public List<Student> getAllStudents() {
        return students;
    }

}
