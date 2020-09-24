package edu.miu.cs.cs544.studentservice.service;

import edu.miu.cs.cs544.studentservice.domain.Course;
import edu.miu.cs.cs544.studentservice.domain.Enrollment;
import edu.miu.cs.cs544.studentservice.domain.Student;
import edu.miu.cs.cs544.studentservice.repository.CourseRegisteredRepository;
import edu.miu.cs.cs544.studentservice.repository.EnrollmentRepository;
import edu.miu.cs.cs544.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    EnrollmentRepository enrollmentRepository;
    @Autowired
    CourseRegisteredRepository courseRegisteredRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Course> getAllStudentCourses(int studentId) {
        Student student = studentRepository.findById(studentId);
        if (student != null) {
            return student.getEnrollments().stream().map(Enrollment::getCourse).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public void saveStudents(Student students) {
        studentRepository.save(students);
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Student putStudent(Student theStudent, int id) {
        Student student = studentRepository.findById(id);
        student.setAddress(theStudent.getAddress());
        student.setEnrollmentDate(theStudent.getEnrollmentDate());
        student.setEnrollments(theStudent.getEnrollments());
        student.setGraduationDate(theStudent.getGraduationDate());
        student.setName(theStudent.getName());
        student.setStudentId(theStudent.getStudentId());
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(int studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student assignCoach(int coachId, int studentId) {
        Student student = studentRepository.findById(studentId);
        if (student != null) {
            student.setCoach_id(coachId);
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public List<Course> getAllCourseByStudentId(int studentId) {
        return enrollmentRepository.getAllCourseByStudentId(studentId);
    }

    @Override
    public List<Course> getRegisteredByStudentId(int studentId) {
        return courseRegisteredRepository.getRegisteredByStudentId(studentId);
    }

    public List<Student> availableForJob() {
        List<Student> students = studentRepository.findAll();
        return students.stream().filter(student -> student.getCoursesRegisteredList().size() >= 5).collect(Collectors.toList());
    }

}