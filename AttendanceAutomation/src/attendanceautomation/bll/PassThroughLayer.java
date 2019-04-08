/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.bll;

import attendanceautomation.be.Attendance;
import attendanceautomation.be.Student;
import attendanceautomation.be.Teacher;
import attendanceautomation.dal.GetData;
import attendanceautomation.dal.IGetData;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author andreas
 */
public class PassThroughLayer implements IBLL {

    private IGetData data;

    public PassThroughLayer() throws IOException {
        data = new GetData();
    }

    /**
     *
     * @return alle students fra DB
     */
    public List<Student> getAllStudents() {
        return data.getAllStudents();
    }

    /**
     *
     * @return alle teachers fra DB
     */
    public List<Teacher> getAllTeachers() {
        return data.getAllTeachers();
    }

    /**
     * Videresender den nye attendance
     * samt checker for validitet
     * @param attendance
     * @param student
     */

    public void registerAttendance(Attendance attendance, Student student){
        boolean alreadyExist = false;
        for (Attendance attendance1 : student.getAttendanceDates1())
        {
            if(attendance1.getDateAsDate().equals(LocalDate.now())){
                if(!attendance1.getAbsense().equals(attendance.getAbsense())){
                    data.editAttendance(new Attendance(student.getId(), LocalDate.now(), attendance.getAbsense()), student);
                    //attendance.set eller attendance.edit
                    alreadyExist = true;
                }
                else if(attendance.getAbsense().equals(attendance.getAbsense())){
                    //do nothing
                    alreadyExist = true;
                }
            }
        }
        if (!alreadyExist){
            //model.registerAttendance
            Attendance a1 = new Attendance(student.getId(), LocalDate.now(), attendance.getAbsense());
            data.registerAttendance(a1, student);
            student.addAttendanceDate(LocalDate.now(), attendance.getAbsense());
        }
    }

    /**
     * Videresender den ændrede attendance og student.
     *
     * @param attendance
     * @param student
     */
    public void editAttendance(Attendance attendance, Student student) {
        data.editAttendance(attendance, student);
        for (Attendance attendance1 : student.getAttendanceDates1()) {
            if (!attendance1.getAbsense().equals(attendance.getAbsense())) {
                
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        data.editAttendance(attendance, student);
                    }
                });
                t.start();
            }
        }
    }
}
