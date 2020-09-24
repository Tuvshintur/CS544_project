package sample.project.studentservice.project.service;

import org.springframework.stereotype.Service;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.Student;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();
    void saveStudents(Student student);
    Student getStudentById(int studentId);
    Student putStudent(Student student, int id);
    void deleteStudentById(int studentId);
    List<Course> getAllStudentCourses(int studentId);
    Student assignInstructor(int instructor_id, int student_id);
    Student assignCoach(int coach_id, int student_id);
    List<Course> getAllCourseByStudentId(int studentId);
    List<Course> getRegisteredByStudentId(int studentId);

    List<Student> availableForJob();

}
