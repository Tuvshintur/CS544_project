package sample.project.studentservice.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.project.studentservice.project.domain.*;
import sample.project.studentservice.project.repository.FacultyRepository;

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


    @Override
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
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

//        List<Student> students=new ArrayList<>();
//        for (Enrollment enrollment : courseOptional.get().getEnrollments()) {
//            students.add(enrollment.getStudent());
//        }

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
    public void deleteDelete(Long id) {
        facultyRepository.deleteById(id);

    }

    @Override
    public Faculty updateById(Long id, Faculty newFaculty) {
        Optional<Faculty> oldFacutlty = facultyRepository.findById(id);

        if (oldFacutlty.isPresent()) {
            // Update all properties except id
            newFaculty.setId(oldFacutlty.get().getId());
            return facultyRepository.save(newFaculty);
        } else {
            //	Insert for new recored
            return facultyRepository.save(newFaculty);

        }
    }
}
