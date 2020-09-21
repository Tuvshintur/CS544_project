package sample.project.studentservice.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.Enrollment;
import sample.project.studentservice.project.domain.Student;
import sample.project.studentservice.project.repository.StudentRepository;

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
    public List<Course> getAllStudentCourses(Integer studentId) {
        Student student = studentRepository.findById(studentId);

        return student.getEnrollments().stream().map(Enrollment::getCourse).collect(Collectors.toList());
    }

    @Override
    public void saveStudents(Student students) {
        studentRepository.save(students);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Student putStudent(Student theStudent, Integer id) {
        Student student = studentRepository.findById(id);
        student.setAddress(theStudent.getAddress());
        student.setEnrollmentDate(theStudent.getEnrollmentDate());
        student.setEnrollments(theStudent.getEnrollments());
        //student.setGPA(theStudent.getGPA());
        student.setGraduationDate(theStudent.getGraduationDate());
        student.setName(theStudent.getName());
        student.setStudentId(theStudent.getStudentId());
        student.setTA(theStudent.getTA());

        studentRepository.save(student);
        return new Student();
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);

    }
}
