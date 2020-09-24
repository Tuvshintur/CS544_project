package edu.miu.cs.cs544.studentservice.service;

import edu.miu.cs.cs544.studentservice.domain.Attendance;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AttendanceService {
    public List<Attendance> getAllAttendance();
    public void createAttendance(Attendance attendance);
    public void deleteAddress(Long id);
    public Attendance updateAttendanceById(@PathVariable Long id, Attendance attendance);
}
