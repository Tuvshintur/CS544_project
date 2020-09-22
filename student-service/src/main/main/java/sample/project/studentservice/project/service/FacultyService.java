package sample.project.studentservice.project.service;

import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.Faculty;

import java.util.List;

public interface FacultyService {
    public List<Faculty> getAllFaculty();

    public void saveFaculty(Faculty faculty);


    Faculty getFacultyById(Integer facultyId);

   Faculty putFaculty(Faculty faculty, Integer id);

    void deleteFacultyById(Integer facultyId);
}


