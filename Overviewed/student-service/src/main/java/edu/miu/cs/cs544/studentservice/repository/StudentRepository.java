package edu.miu.cs.cs544.studentservice.repository;

import edu.miu.cs.cs544.studentservice.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findById(int studentId);
}
