package edu.miu.cs.cs544.studentservice.repository;


import edu.miu.cs.cs544.studentservice.domain.Course;
import edu.miu.cs.cs544.studentservice.domain.CoursesRegistered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRegisteredRepository extends JpaRepository<CoursesRegistered, Long> {

    @Query("select e.course from CoursesRegistered e where e.student.id=  :id ")
    List<Course> getRegisteredByStudentId(int id);
}
