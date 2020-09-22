package sample.project.studentservice.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.project.studentservice.project.domain.Attendance;
import sample.project.studentservice.project.domain.CoursesRegistered;
import sample.project.studentservice.project.repository.CourseRegisteredRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseRegisteredServiceImple implements CourseRegisteredService {

    @Autowired
    CourseRegisteredRepository courseRegisteredRepository;


    @Override
    public List<CoursesRegistered> getAllCourseRegistered() {
        return courseRegisteredRepository.findAll();
    }

    @Override
    public void createCoursesRegistered(CoursesRegistered coursesRegistered) {
        courseRegisteredRepository.save(coursesRegistered);
    }

    @Override
    public void deleteCoursesRegistered(Long id) {
        courseRegisteredRepository.deleteById(id);

    }

    @Override
    public CoursesRegistered updateById(Long id, CoursesRegistered editedcoursesRegistered) {


        Optional<CoursesRegistered> attendanceOld = courseRegisteredRepository.findById(id);
        if (attendanceOld.isPresent()) {
            // Update all properties except id
            editedcoursesRegistered.setId(attendanceOld.get().getId());
            return courseRegisteredRepository.save(editedcoursesRegistered);
        } else {
            //	Insert for new recored
            return courseRegisteredRepository.save(editedcoursesRegistered);


        }
    }

//        CoursesRegistered coursesRegistered1 = courseRegisteredRepository.findById(id).orElse(coursesRegistered);
//        coursesRegistered1.setStudent(coursesRegistered.getStudent());
//        coursesRegistered1.setCourse(coursesRegistered.getCourse());
//        coursesRegistered1.setStartDate(coursesRegistered.getStartDate());
//        coursesRegistered1.setEndDate(coursesRegistered.getEndDate());
//        courseRegisteredRepository.save(coursesRegistered1);
//
//    }
}
