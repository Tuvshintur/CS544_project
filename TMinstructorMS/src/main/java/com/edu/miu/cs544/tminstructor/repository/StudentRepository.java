package com.edu.miu.cs544.tminstructor.repository;

import com.edu.miu.cs544.tminstructor.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
