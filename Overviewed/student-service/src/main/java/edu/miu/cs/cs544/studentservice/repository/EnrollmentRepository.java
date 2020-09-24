package edu.miu.cs.cs544.studentservice.repository;

import edu.miu.cs.cs544.studentservice.domain.Course;
import edu.miu.cs.cs544.studentservice.domain.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    @Query("select e.course from Enrollment e where e.student.id=  :id ")
    List<Course> getAllCourseByStudentId(@Param("id") int id);
}
