/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import attendanceautomation.be.Student;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class DateManager {

    public List<String> presentOrAbsent(Student student) {

        List<String> erHer = new ArrayList();

        for (LocalDate tonny : totalDays()) {
            int counter = 0;
            for (LocalDate irene : student.getAttendanceDates()) {

                if (irene.isEqual(tonny)) {
                    String present = "Present";
                    erHer.add(present);
                    break;

                } else if (counter == student.getAttendanceDates().size()-1) {
                    String absent = "Absent";
                    erHer.add(absent);
                }
                counter++;
            }
        }

        return erHer;
    }

    //total days in semester
    public List<LocalDate> totalDays() {

        List<LocalDate> lld = new ArrayList();

        LocalDate ldstart = LocalDate.of(2019, Month.JANUARY, 1);
        LocalDate ldend = LocalDate.now();

        while (ldstart.isBefore(ldend)) {
            if (ldstart.getDayOfWeek().toString() != "SATURDAY" && ldstart.getDayOfWeek().toString() != "SUNDAY") {
                lld.add(ldend);
                ldstart = ldstart.plusDays(1);
            }
        }

        return lld;
    }
}
