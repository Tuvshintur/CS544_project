package sample.project.studentservice.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sample.project.studentservice.project.domain.Course;

import sample.project.studentservice.project.domain.Student;
import sample.project.studentservice.project.service.CourseService;
import sample.project.studentservice.project.service.StudentService;


import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    CourseService courseService;

    //@Autowired
//CoursesRegisteredService coursesRegisteredService;
    @GetMapping("/All")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/save")
    public void saveStudents(@RequestBody Student students) {
        studentService.saveStudents(students);
    }

    @GetMapping("/get/{studentId}")
    public Student getCStudentByID(@PathVariable Integer studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            throw new RuntimeException("Student id not found-" + studentId);
        }
        return student;
    }

    //    @PostMapping("/Add")
//    public Student addStudent(@RequestBody Student theStudent){
//        theSudent.setId(0);
//        studentService.saveCourse(theStudent);
//        return theStudent;
//    }
    @PutMapping("/Update/{id}")
    public Student updateCourse(@RequestBody Student student, @PathVariable Integer id) {

        return studentService.putStudent(student, id);
    }

    @DeleteMapping("/delete/{studentId}")
    public String deleteStudentByID(@PathVariable Integer studentId) {
        Student tempStudent = studentService.getStudentById(studentId);
        if (tempStudent == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }
        studentService.deleteStudentById(studentId);
        return "Delete student id - " + studentId;
    }

    @GetMapping("/student/")
    public List<Course> getRegisteredCourse(@RequestParam Integer studentId) {
        return studentService.getAllStudentCourses(studentId);
    }
}
