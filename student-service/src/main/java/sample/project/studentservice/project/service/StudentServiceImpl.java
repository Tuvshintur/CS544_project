package sample.project.studentservice.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sample.project.studentservice.project.domain.Course;

import sample.project.studentservice.project.domain.Enrollment;
import sample.project.studentservice.project.domain.Student;
import sample.project.studentservice.project.repository.CourseRegisteredRepository;
import sample.project.studentservice.project.repository.EnrollmentRepository;
import sample.project.studentservice.project.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;
    EnrollmentRepository enrollmentRepository;
    CourseRegisteredRepository courseRegisteredRepository;


    public StudentServiceImpl() {
    }

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
        this.enrollmentRepository = enrollmentRepository;
        this.courseRegisteredRepository = courseRegisteredRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
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
        return students.stream().filter(student -> student.getCoursesRegisteredList().size()>=5).collect(Collectors.toList());
    }



}

