package edu.miu.cs.cs544.studentservice.service;

import edu.miu.cs.cs544.studentservice.domain.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourse();

    void saveCourse(Course course);

    Course getCourseById(Integer courseId);

    void deleteCourseById(Integer theId);

    Course putCourse(Course theCourse, Integer id);
}
