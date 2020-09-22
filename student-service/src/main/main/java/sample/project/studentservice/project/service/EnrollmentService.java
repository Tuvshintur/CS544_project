package sample.project.studentservice.project.service;

import org.springframework.web.bind.annotation.PathVariable;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.Enrollment;

import java.util.List;

public interface EnrollmentService {

    public List<Enrollment> getAllEnrollments();

    public void createAttendance(Enrollment enrollment);
    public void deleteAddress(Long id);
    public void updateById(@PathVariable Long id, Enrollment enrollment);

    //View All courses for studentd
    public List<Course>getAllCoursesByStudentId(Long id);
}
