package sample.project.studentservice.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.Student;
import sample.project.studentservice.project.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl  implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
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
    public Student putStudent(Student student, Integer id) {
        return null;
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);

    }
}
