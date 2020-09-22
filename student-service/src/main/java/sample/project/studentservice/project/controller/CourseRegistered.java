package sample.project.studentservice.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.project.studentservice.project.domain.CoursesRegistered;
import sample.project.studentservice.project.service.CourseRegisteredService;

import java.util.List;

@RestController
@RequestMapping("/registered")
public class CourseRegistered {
    @Autowired
    CourseRegisteredService courseRegisteredService;

//    public void registerForCourse(Re Lond courseid, Long studentId)

    @GetMapping("/all")
    public List<CoursesRegistered> getAllCourseRegistered() {
        return courseRegisteredService.getAllCourseRegistered();
    }

    @PostMapping("/create")
    public void createCoursesRegistered(@RequestBody CoursesRegistered coursesRegistered) {

        courseRegisteredService.createCoursesRegistered(coursesRegistered);

    }

    @DeleteMapping("delete")
    public void deleteCoursesRegistered(Long id) {
        courseRegisteredService.deleteCoursesRegistered(id);

    }

    @PutMapping("/Update")
    public void updateById(@PathVariable Long id, @RequestBody CoursesRegistered coursesRegistered) {
        courseRegisteredService.updateById(id, coursesRegistered);

    }
}
