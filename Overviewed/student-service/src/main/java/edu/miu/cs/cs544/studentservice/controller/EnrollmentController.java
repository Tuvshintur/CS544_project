package edu.miu.cs.cs544.studentservice.controller;

import edu.miu.cs.cs544.studentservice.domain.Enrollment;
import edu.miu.cs.cs544.studentservice.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/All")
    public List<Enrollment> getAllEnrolment() {
        return enrollmentService.getAllEnrollments();
    }

    @PostMapping("/create")
    public void createEnrollment(Enrollment enrollment) {
        enrollmentService.createEnrollment(enrollment);
    }

    @DeleteMapping("/delete/{enId}")
    public void deleteEnrollment(@PathVariable Long enId) {
        enrollmentService.deleteEnrollment(enId);
    }

    @PutMapping("/update/{enId}")
    public void updateById(@PathVariable Long enId, Enrollment enrollment) {
        enrollmentService.updateById(enId, enrollment);
    }
}
