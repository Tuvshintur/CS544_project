package sample.project.studentservice.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.Student;
import sample.project.studentservice.project.repository.StudentRepository;

import java.util.List;

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


}
