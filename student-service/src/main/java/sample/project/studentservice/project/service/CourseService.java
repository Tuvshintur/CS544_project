package sample.project.studentservice.project.service;

import sample.project.studentservice.project.domain.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourse();

    void saveCourse(Course course);

    Course getCourseById(Integer courseId);

    void deleteCourseById(Integer theId);

    Course putCourse(Course theCourse, Integer id);


}
