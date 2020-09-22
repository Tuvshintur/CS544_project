package sample.project.studentservice.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.project.studentservice.project.domain.CoursesRegistered;

@Repository
public interface CourseRegisteredRepository extends JpaRepository<CoursesRegistered, Long> {
}
