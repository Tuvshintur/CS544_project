package sample.project.studentservice.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.Student;
import sample.project.studentservice.project.exception.ResourceNotFoundException;
import sample.project.studentservice.project.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl  implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public List<Course> getAllStudentCourses(Integer studentId) {
      return studentRepository.getAllByEnrollments(studentId)
                .stream()
                .map(t->t.getCourse())
                .collect(Collectors.toList());
    }

    @Override
    public void saveStudents(Student students) {
        studentRepository.save( students);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        Optional<Student> result = studentRepository.findById(studentId);

        Student theStudent = null;
        if(result.isPresent()){
            theStudent = result.get();
        }
        else{
            throw new RuntimeException("did not find student id - " + studentId);
        }
        return theStudent;
    }

    @Override
    public Student putStudent(Student theStudent, Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
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
