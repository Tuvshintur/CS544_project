package sample.project.studentservice.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.project.studentservice.project.controller.CourseRegistered;
import sample.project.studentservice.project.domain.*;
import sample.project.studentservice.project.repository.CourseRepository;
import sample.project.studentservice.project.repository.EnrollmentRepository;
import sample.project.studentservice.project.repository.FacultyRepository;
import sample.project.studentservice.project.repository.StudentRepository;


import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Override
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    @Override
    public void deleteDelete(Long id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public List<Course> getAllCourseByFaculty(Long id) {
        Optional<Faculty> faculty = facultyRepository.findById(id);
        if (faculty.isPresent())
            return faculty.get().getCourses();
        return new ArrayList<>();
    }

    public List<Enrollment> getAllCourseByFaculty(Long facId,Integer courseId) {
        Optional<Course> courseOptional = getAllCourseByFaculty(facId).stream()
                .filter(course -> course.getId()==courseId)
                .findFirst();
        return courseOptional.get().getEnrollments();
    }

    @Override
    public List<Course> getAllCoursePast(Long facId) {
        List<Course> courses = getAllCourseByFaculty(facId);
        List<Course> coursesPast = new ArrayList<>();
        for (Course course : courses) {
            for (CoursesRegistered registered : course.getCoursesRegistereds()) {
                if (registered.getStartDate().isBefore(LocalDate.now())) {
                    coursesPast.add(course);
                }
            }
        }
        return coursesPast;
    }

    @Override
    public List<Course> getAllCourseFuture(Long facId) {
        List<Course> courses = getAllCourseByFaculty(facId);
        List<Course> coursesFuture = new ArrayList<>();
        for (Course course : courses) {
            for (CoursesRegistered registered : course.getCoursesRegistereds()) {
                if (registered.getStartDate().isAfter(LocalDate.now())) {
                    coursesFuture.add(course);
                }
            }
        }
        return coursesFuture;
    }

    @Override
    public void registerFacultyInDepartment(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    @Override
    public Faculty updateById(Long id, Faculty newFaculty) {
        Optional<Faculty> oldFacutlty = facultyRepository.findById(id);
        if(oldFacutlty.isPresent()) {
            newFaculty.setId(oldFacutlty.get().getId());
            return facultyRepository.save(newFaculty);
        } else {
            return facultyRepository.save(newFaculty);
        }
    }
    @Override
    public void assignTaForCourses(Integer stId) {
    Student st = studentRepository.findById(stId).orElse(null);
    List<Student>ta = new ArrayList<>();
    ta.add(st);
    List<CoursesRegistered> course = st.getCoursesRegisteredList();
    for(CoursesRegistered cr :course){
        if(LocalDate.now().isAfter(cr.getStartDate()) && LocalDate.now().isBefore(cr.getEndDate()));
        ta.add(st);
    }
   studentRepository.saveAll(ta);
    }
 }
