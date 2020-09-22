package sample.project.studentservice.project.service;

import org.springframework.stereotype.Service;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.Student;

import java.util.List;

@Service
public interface StudentService {

    public List<Student> getAllStudents();

    public void saveStudents(Student student);

    Student getStudentById(Integer studentId);

    Student putStudent(Student student, Integer id);

    void deleteStudentById(Integer studentId);

    List<Course> getAllStudentCourses(int studentId);

}
