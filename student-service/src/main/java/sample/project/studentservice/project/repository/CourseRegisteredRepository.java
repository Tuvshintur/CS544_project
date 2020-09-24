package sample.project.studentservice.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.CoursesRegistered;

import java.util.List;

@Repository
public interface CourseRegisteredRepository extends JpaRepository<CoursesRegistered, Long> {
    @Query("select e.course from CoursesRegistered e where e.student.id=  :id ")
    List<Course> getRegisteredByStudentId(int id);
}
