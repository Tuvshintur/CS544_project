package sample.project.studentservice.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import sample.project.studentservice.project.domain.Course;
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

@PostMapping("/create")
    public void createEnrollment(Enrollment enrollment){
        enrollmentService.createEnrollment(enrollment);

    }

    @DeleteMapping("/delete/{enId}")
    public void deleteEnrollment(@PathVariable  Long enId){
        enrollmentService.deleteEnrollment(enId);

    }

    @PutMapping("/update/{enId}")
    public void updateById(@PathVariable Long enId, Enrollment enrollment){
        enrollmentService.updateById(enId,enrollment);
    }

//    //View All courses for studentd
//    public List<Course>getAllCoursesByStudentId(Long id){
//
//    }
}
