/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.bll;

import attendanceautomation.be.Student;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class DateManager {

   
    /**
     * Looks at all dates from 1/1/2019, and sorts away saturday and sunday, 
     * and returns a list without these
     * @return
     */
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
