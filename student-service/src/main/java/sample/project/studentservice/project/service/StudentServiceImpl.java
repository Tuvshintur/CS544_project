//package sample.project.studentservice.project.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import sample.project.studentservice.project.domain.Course;
//import sample.project.studentservice.project.domain.Student;
//import sample.project.studentservice.project.repository.StudentRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class StudentServiceImpl  implements StudentService{
//    @Autowired
//    StudentRepository studentRepository;
//
//    @Override
//    public List<Student> getAllStudents() {
//        return studentRepository.findAll();
//    }
//
//    @Override
//    public void saveStudents(Student students) {
//        studentRepository.save( students);
//    }
//
//    @Override
//    public Student getStudentById(Integer studentId) {
//        Optional<Student> result = studentRepository.findById(studentId);
//
//        Student theStudent = null;
//        if(result.isPresent()){
//            theStudent = result.get();
//        }
//        else{
//            throw new RuntimeException("did not find student id - " + studentId);
//        }
//        return theStudent;
//    }
//
//    @Override
//    public Student putStudent(Student student, Integer id) {
//        return null;
//    }
//
//    @Override
//    public void deleteStudentById(Integer studentId) {
//        studentRepository.deleteById(studentId);
//
//    }
//}
package sample.project.studentservice.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.Enrollment;
import sample.project.studentservice.project.domain.Student;
import sample.project.studentservice.project.repository.CourseRegisteredRepository;
import sample.project.studentservice.project.repository.EnrollmentRepository;
import sample.project.studentservice.project.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    EnrollmentRepository enrollmentRepository;
    CourseRegisteredRepository courseRegisteredRepository;

    @Autowired
    StudentServiceImpl(StudentRepository studentRepository, EnrollmentRepository enrollmentRepository, CourseRegisteredRepository courseRegisteredRepository) {
        this.studentRepository = studentRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.courseRegisteredRepository = courseRegisteredRepository;
    }

    @Override
    public List<Course> getAllCoursebyStdentId(int id) {
        return enrollmentRepository.getAllCourseByStudentId(id);
    }

    @Override
    public List<Course> getRegisteredByStudentId(int id) {
        return courseRegisteredRepository.getRegisteredByStudentId(id);
    }

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
        student.setGPA(theStudent.getGPA());
        student.setGraduationDate(theStudent.getGraduationDate());
        student.setName(theStudent.getName());
        student.setStudentId(theStudent.getStudentId());

        studentRepository.save(student);
        return new Student();
    }

    @Override
    public void deleteStudentById(int studentId) {
        studentRepository.deleteById(studentId);

    }
}

