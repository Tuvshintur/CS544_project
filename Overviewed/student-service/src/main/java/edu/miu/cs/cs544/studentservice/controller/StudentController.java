package edu.miu.cs.cs544.studentservice.controller;

import edu.miu.cs.cs544.studentservice.domain.Course;
import edu.miu.cs.cs544.studentservice.domain.Student;
import edu.miu.cs.cs544.studentservice.service.CourseService;
import edu.miu.cs.cs544.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    CourseService courseService;

    @GetMapping("/All")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/save")
    public void saveStudents(@RequestBody Student students) {
        studentService.saveStudents(students);
    }

    @GetMapping("/get/{studentId}")
    public Student getCStudentByID(@PathVariable int studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student == null) {

            throw new RuntimeException("Student id not found-" + studentId);
        }
        return student;
    }

    @PutMapping("/Update/{id}")
    public Student updateCourse(@RequestBody Student student, @PathVariable int id) {
        return studentService.putStudent(student, id);
    }

    @DeleteMapping("/delete/{studentId}")
    public String deleteStudentByID(@PathVariable int studentId) {
        Student tempStudent = studentService.getStudentById(studentId);
        if (tempStudent == null) {

            throw new RuntimeException("Student id not found - " + studentId);
        }
        studentService.deleteStudentById(studentId);
        return "Delete student id - " + studentId;
    }

    @GetMapping("/student/{studentId}")
    public List<Course> getTakenCourseById(@PathVariable int studentId) {

        return studentService.getAllCourseByStudentId(studentId);
    }

    @GetMapping("/courseRegistered/{studentId}")
    public List<Course> getRegisteredCourseByStudentId(@PathVariable int studentId) {

        return studentService.getRegisteredByStudentId(studentId);
    }

    @PostMapping("/student/assignCoach/{coachId}/{studentId}")
    public Student assignCoach(@PathVariable("coachId") int coachId, @PathVariable("studentId") int studentId) {
        return studentService.assignCoach(coachId, studentId);
    }

    @PostMapping("/student/availableForJob")
    public List<Student> availableForJob() {
        return studentService.availableForJob();
    }

    @GetMapping("/jobId/{jobId}")
    public Student getStudentsWithJob(@PathVariable("jobId") int jobId) {
        return studentService.getStudentByJobId(jobId);
    }

    @GetMapping("/notice/{studentId}")
    public String noticeCPT(@PathVariable("studentId") int studentId) {
        System.out.println("please enter CPT report"+ studentId);
        return "notified";
    }

    @GetMapping("/noticeJob/{studentId}")
    public String noticeJobSearch(@PathVariable("studentId") int studentId) {
        System.out.println("please enter Job search report"+ studentId);
        return "notified";
    }

}
