package edu.miu.cs.cs544.studentservice.service;

import edu.miu.cs.cs544.studentservice.domain.Course;
import edu.miu.cs.cs544.studentservice.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();

    void saveStudents(Student student);

    Student getStudentById(int studentId);

    Student putStudent(Student student, int id);

    void deleteStudentById(int studentId);

    List<Course> getAllStudentCourses(int studentId);

    Student assignCoach(int coach_id, int student_id);

    List<Course> getAllCourseByStudentId(int studentId);

    List<Course> getRegisteredByStudentId(int studentId);

    List<Student> availableForJob();

}
