package sample.project.studentservice.project.service;



import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.Enrollment;
import sample.project.studentservice.project.domain.Faculty;
import sample.project.studentservice.project.domain.Student;

import java.time.LocalDate;
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
