package edu.miu.cs.cs544.studentservice.repository;

import edu.miu.cs.cs544.studentservice.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
