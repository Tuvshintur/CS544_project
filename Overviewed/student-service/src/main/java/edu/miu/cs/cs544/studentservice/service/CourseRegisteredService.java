package edu.miu.cs.cs544.studentservice.service;

import edu.miu.cs.cs544.studentservice.domain.CoursesRegistered;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CourseRegisteredService {

    public List<CoursesRegistered> getAllCourseRegistered();

    public void createCoursesRegistered(CoursesRegistered coursesRegistered);

    public void deleteCoursesRegistered(Long id);

    public CoursesRegistered updateById(@PathVariable Long id, CoursesRegistered coursesRegistered);
}
