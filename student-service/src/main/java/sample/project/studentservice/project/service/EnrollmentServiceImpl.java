package sample.project.studentservice.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.Enrollment;
import sample.project.studentservice.project.repository.EnrollmentRepository;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements  EnrollmentService{

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public void createEnrollment(Enrollment enrollment) {
        enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteEnrollment(Long id) {
       enrollmentRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, Enrollment enrollment) {

    }

    @Override
    public List<Course> getAllCoursesByStudentId(Long id) {
        return null;
    }

    @Override
    public void createEnrollment(Enrollment enrollment) {
        enrollmentRepository.save(enrollment);
    }
}
