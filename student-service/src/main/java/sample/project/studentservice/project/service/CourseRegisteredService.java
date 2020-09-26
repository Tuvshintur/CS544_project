package sample.project.studentservice.project.service;

import org.springframework.web.bind.annotation.PathVariable;
import sample.project.studentservice.project.domain.CoursesRegistered;

import java.util.List;

public interface CourseRegisteredService {

    List<CoursesRegistered> getAllCourseRegistered();
    void createCoursesRegistered(CoursesRegistered coursesRegistered);
    void deleteCoursesRegistered(Long id);
    CoursesRegistered updateById(@PathVariable Long id, CoursesRegistered coursesRegistered);
}
