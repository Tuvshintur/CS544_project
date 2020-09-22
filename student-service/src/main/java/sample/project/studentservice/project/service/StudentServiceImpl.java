package sample.project.studentservice.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.project.studentservice.project.domain.Course;

import sample.project.studentservice.project.domain.Enrollment;
import sample.project.studentservice.project.domain.Student;
import sample.project.studentservice.project.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    @Autowired
    StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Course> getAllStudentCourses(int studentId) {
        Student student = studentRepository.findById(studentId);

        if(student != null) {
            return student.getEnrollments().stream().map(Enrollment::getCourse).collect(Collectors.toList());
        }else {
            return new ArrayList<>();
        }

    }

    @Override
    public void saveStudents(Student students) {
        studentRepository.save(students);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return null;
    }

    @Override
    public Student putStudent(Student student, Integer id) {
        return null;
    }

    @Override
    public void deleteStudentById(Integer studentId) {

    }



    @Override
    public Student assignCoach(int coachId, int studentId) {
        Student student = studentRepository.findById(studentId);
        if(student != null) {
            student.setCoach_id(coachId);
            return studentRepository.save(student);
        }

        return null;
    }

}
