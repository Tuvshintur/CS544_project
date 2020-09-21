package sample.project.studentservice.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.Student;
import sample.project.studentservice.project.repository.CourseRepository;
import sample.project.studentservice.project.repository.EnrollmentRepository;
import sample.project.studentservice.project.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    public CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }


}
