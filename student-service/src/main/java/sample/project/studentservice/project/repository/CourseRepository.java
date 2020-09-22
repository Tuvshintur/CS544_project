package sample.project.studentservice.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.project.studentservice.project.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
