package edu.miu.cs.cs544.studentservice.service;

import edu.miu.cs.cs544.studentservice.domain.CoursesRegistered;
import edu.miu.cs.cs544.studentservice.repository.CourseRegisteredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            editedcoursesRegistered.setId(attendanceOld.get().getId());
            return courseRegisteredRepository.save(editedcoursesRegistered);
        } else {
            return courseRegisteredRepository.save(editedcoursesRegistered);
        }
    }
}
