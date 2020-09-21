package sample.project.studentservice.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.repository.CourseRepository;
import sample.project.studentservice.project.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    public CourseService courseService;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/All")
    public List<Course> getAllCourse(){

        return  courseRepository.findAll();
        //courseService.getAllCourse();
    }

}
