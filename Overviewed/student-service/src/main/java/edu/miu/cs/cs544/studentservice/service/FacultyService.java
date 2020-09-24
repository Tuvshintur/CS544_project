package edu.miu.cs.cs544.studentservice.service;


import edu.miu.cs.cs544.studentservice.domain.Course;
import edu.miu.cs.cs544.studentservice.domain.Faculty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public interface FacultyService {
    public List<Faculty> getAllFaculty();

    public void registerFacultyInDepartment(Faculty faculty);

    public void deleteDelete(Long id);

    public Faculty updateById(@PathVariable Long id, Faculty faculty);

    public List<Course> getAllCourseByFaculty(Long id);

    public List<Course> getAllCoursePast(Long facId);

    public List<Course> getAllCourseFuture(Long facId);

    public void assignTaForCourses(Integer stId);
}
