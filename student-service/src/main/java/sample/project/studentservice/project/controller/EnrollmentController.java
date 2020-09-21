package sample.project.studentservice.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.project.studentservice.project.domain.Enrollment;
import sample.project.studentservice.project.service.EnrollmentService;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/All")
    public List<Enrollment> getAllEnrolment(){
        return enrollmentService.getAllEnrollments();
    }


}
