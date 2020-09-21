package sample.project.studentservice.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.project.studentservice.project.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findById(int studentId);
}
