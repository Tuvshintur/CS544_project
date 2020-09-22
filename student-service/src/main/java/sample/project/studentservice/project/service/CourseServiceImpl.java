package sample.project.studentservice.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.Student;
import sample.project.studentservice.project.exception.ResourceNotFoundException;
import sample.project.studentservice.project.repository.CourseRepository;
import sample.project.studentservice.project.repository.EnrollmentRepository;
import sample.project.studentservice.project.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    public CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }
    @Override

    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Integer courseId) {
        Optional<Course> result = courseRepository.findById(courseId);
        Course theCourse = null;
        if (result.isPresent()) {
            theCourse = result.get();
        } else {
            throw new RuntimeException("did not find course id - " + courseId);
        }
        return theCourse;
    }
    @Override
    public void deleteCourseById(Integer theId) {
        courseRepository.deleteById(theId);
    }
    @Override
    public Course putCourse(Course theCourse, Integer theId) {
        Course course = courseRepository.findById(theId).orElseThrow(() -> new ResourceNotFoundException(theId));
        course.setTitle(theCourse.getTitle());
        course.setRoomNumber(theCourse.getRoomNumber());
        course.setEnrollments(theCourse.getEnrollments());
        course.setCoursesRegistereds(theCourse.getCoursesRegistereds());
        course.setCourseCode(theCourse.getCourseCode());
        course.setBuilding(theCourse.getBuilding());
        course.setFaculties(theCourse.getFaculties());
        courseRepository.save(course);
        return new Course();
    }
}
