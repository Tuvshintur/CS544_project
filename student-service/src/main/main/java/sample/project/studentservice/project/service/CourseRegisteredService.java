package sample.project.studentservice.project.service;

import org.springframework.web.bind.annotation.PathVariable;
import sample.project.studentservice.project.domain.CoursesRegistered;

import java.util.List;

public interface CourseRegisteredService {

    public List<CoursesRegistered> getAllCourseRegistered();
    public void createCoursesRegistered(CoursesRegistered coursesRegistered);
    public void deleteCoursesRegistered(Long id);
   public CoursesRegistered updateById(@PathVariable Long id, CoursesRegistered coursesRegistered);
}
