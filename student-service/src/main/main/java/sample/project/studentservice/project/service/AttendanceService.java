package sample.project.studentservice.project.service;

import org.springframework.web.bind.annotation.PathVariable;
import sample.project.studentservice.project.domain.Attendance;

import java.util.List;

public interface AttendanceService {
    public List<Attendance> getAllAttendance();
    public void createAttendance(Attendance attendance);
    public void deleteAddress(Long id);
    public Attendance updateById(@PathVariable Long id, Attendance attendance);
}
