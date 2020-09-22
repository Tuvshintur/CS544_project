package sample.project.studentservice.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sample.project.studentservice.project.domain.Attendance;
import sample.project.studentservice.project.service.AttendanceService;

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
    public void createAttendance(@RequestBody Attendance attendance){
        attendanceService.createAttendance(attendance);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable Long id){
        attendanceService.deleteAddress(id);
    }

    @PutMapping("/update/{id}")
    public void updateById(@PathVariable Long id, @RequestBody Attendance attendance){
        attendanceService.updateAttendanceById(id, attendance);
    }
}
