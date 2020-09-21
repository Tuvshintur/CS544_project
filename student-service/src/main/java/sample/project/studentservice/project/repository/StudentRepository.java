package sample.project.studentservice.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.project.studentservice.project.domain.Enrollment;
import sample.project.studentservice.project.domain.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Enrollment> getAllByEnrollments(Integer studentId);
}
