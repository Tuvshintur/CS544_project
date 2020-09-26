package sample.project.studentservice.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.Enrollment;
import sample.project.studentservice.project.domain.Faculty;
import sample.project.studentservice.project.service.CourseService;
import sample.project.studentservice.project.service.EnrollmentService;
import sample.project.studentservice.project.service.FacultyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    FacultyService facultyService;
    @Autowired
    CourseService courseService;
    @Autowired
    EnrollmentService enrollmentService;

    @GetMapping("/all")
    public List<Faculty> getAllFaculty() {
        return facultyService.getAllFaculty();
    }

    @GetMapping("/get/{id}")
    public Optional<Faculty> getFacultyById(@PathVariable Long id){
        return facultyService.getFacultyById(id);


    }

    @PostMapping("/create")
    public void registerFacultyInDepartment(@RequestBody Faculty faculty) {
        facultyService.registerFacultyInDepartment(faculty);
    }

    @DeleteMapping("/delete/{facId}")
    public void deleteDelete(@PathVariable Long facId) {
        facultyService.deleteDelete(facId);
    }

    @PutMapping("/update/{facId}")
    public void updateById(@PathVariable Long facId, @RequestBody Faculty faculty) {
        facultyService.updateById(facId, faculty);
    }


    //uses cases
    @GetMapping("/all/{id}")
    public List<Course> getAllCourseByFaculty(@PathVariable("id") Long facId) {
        return facultyService.getAllCourseByFaculty(facId);
    }

    @GetMapping("/past/{facId}")
    public List<Course> getAllCoursePast(@PathVariable Long facId) {
        return facultyService.getAllCourseByFaculty(facId);
    }

    @GetMapping("/future/{facId}")
    public List<Course> getAllCourseFuture(@PathVariable Long facId) {
        return facultyService.getAllCourseByFaculty(facId);
    }

     @PostMapping("/create/ta/{stId}")
    public void assignTaForCourses(Integer stId){
        facultyService.assignTaForCourses(stId);
    }


    @PostMapping("/postgrade")
    public void createEnrollmentAndPostGrade(@RequestBody Enrollment enrollment){
        enrollmentService.createEnrollment(enrollment);

    }


}
