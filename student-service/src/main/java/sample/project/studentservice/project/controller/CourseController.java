package sample.project.studentservice.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    public CourseService courseService;

    @GetMapping("/All")
    public List<Course> getAllCourse() {

        return courseService.getAllCourse();
    }

    @PostMapping("/save")
    public void saveCourse(@RequestBody Course courses) {
        courseService.saveCourse(courses);
    }

    @GetMapping("/get/{courseId}")
    public Course getCourseByID(@PathVariable Integer courseId) {
        Course course = courseService.getCourseById(courseId);
        if (course == null) {
            throw new RuntimeException("Course id not found-" + courseId);
        }
        return course;
    }

    @PutMapping("/Update/{id}")
    public Course updateCourse(@RequestBody Course course, @RequestParam Integer id) {
        return courseService.putCourse(course, id);
    }

    @DeleteMapping("/delete/{employeeId}")
    public String deleteCourseByiD(@PathVariable Integer courseId) {
        Course tempEmployee = courseService.getCourseById(courseId);
        if (tempEmployee == null) {
            throw new RuntimeException("course id not found - " + courseId);
        }
        courseService.deleteCourseById(courseId);
        return "Delete employee id - " + courseId;
    }

}
