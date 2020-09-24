package edu.miu.cs.cs544.studentservice.controller;

import edu.miu.cs.cs544.studentservice.domain.Attendance;
import edu.miu.cs.cs544.studentservice.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @GetMapping("/all")
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    @PostMapping("/create")
    public void createAttendance(@RequestBody Attendance attendance) {
        attendanceService.createAttendance(attendance);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable Long id) {
        attendanceService.deleteAddress(id);
    }

    @PutMapping("/update/{id}")
    public void updateById(@PathVariable Long id, @RequestBody Attendance attendance) {
        attendanceService.updateAttendanceById(id, attendance);
    }
}
