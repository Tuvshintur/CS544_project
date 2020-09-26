package sample.project.studentservice.project.service;

import org.springframework.web.bind.annotation.PathVariable;
import sample.project.studentservice.project.domain.Attendance;

import java.util.List;
import java.util.Optional;

public interface AttendanceService {
    List<Attendance> getAllAttendance();
    void createAttendance(Attendance attendance);
    void deleteAddress(Long id);
    Attendance updateAttendanceById(@PathVariable Long id, Attendance attendance);
    public Optional<Attendance> getAttendanceBayId(Long id);
}
