package sample.project.studentservice.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.Faculty;
import sample.project.studentservice.project.service.CourseService;
import sample.project.studentservice.project.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    FacultyService facultyService;
    @Autowired
    CourseService courseService;

    @GetMapping("/all")
    public List<Faculty> getAllFaculty() {
        return facultyService.getAllFaculty();
    }

    @GetMapping("/all/{id}")
    public List<Course> getAllCourseByFaculty(@PathVariable("id") Long facId) {
        return facultyService.getAllCourseByFaculty(facId);
    }

    @GetMapping("/past/{facId}")
    public List<Course> getAllCoursePast(@PathVariable Long facId) {
        return facultyService.getAllCourseByFaculty(facId);
    }

    @GetMapping("/future/{facId}")
    public List<Course> getAllCourseFuture(Long facId) {
        return facultyService.getAllCourseByFaculty(facId);
    }

    @PostMapping("/create")
    public void registerFacultyInDepartment(Faculty faculty) {
        facultyService.registerFacultyInDepartment(faculty);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDelete(Long id) {
        facultyService.deleteDelete(id);
    }

    @PutMapping("/update")
    public void updateById(@PathVariable Long id, Faculty faculty) {
        facultyService.updateById(id, faculty);
    }

}
