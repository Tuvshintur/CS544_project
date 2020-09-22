package sample.project.studentservice.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.Enrollment;

import java.util.List;


@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    @Query("select e.course from Enrollment e where e.student.id=  :id ")
    List<Course> getAllCourseByStudentId(@Param("id") int id);
}

