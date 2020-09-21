package sample.project.studentservice.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.project.studentservice.StudentServiceApplication;
import sample.project.studentservice.project.domain.Student;
import sample.project.studentservice.project.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/All")
    public List<Student> getAllStudents(){
    return  studentService.getAllStudents();
}


        @PostMapping("/save")
     public void saveStudents(@RequestBody Student students){
    studentService.saveStudents(students);
}

}
