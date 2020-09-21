package sample.project.studentservice.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.domain.Faculty;
import sample.project.studentservice.project.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
    @Autowired
    FacultyService facultyService;

    @GetMapping("/All")
    public List<Faculty> getFaculty() {
        return facultyService.getAllFaculty();
    }

    @PostMapping("/save")
    public void saveCourse(@RequestBody Faculty faculty) {
        facultyService.saveFaculty(faculty);
    }

    @GetMapping("/get/{facultyId}")
    public Faculty getFacultyByID(@PathVariable Integer facultyId) {
        Faculty faculty = facultyService.getFacultyById(facultyId);
        if (faculty == null) {
            throw new RuntimeException("Faculty id not found-" + facultyId);
        }
        return faculty;
    }

    @PutMapping("/Update/{id}")
    public Faculty updateFaculty(@RequestBody Faculty faculty, @PathVariable Integer id) {
        try {
            return facultyService.putFaculty(faculty, id);
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @DeleteMapping("/delete/{facultyId}")
    public String deleteFacultyByiD(@PathVariable Integer facultyId) {
        Faculty faculty = facultyService.getFacultyById(facultyId);
        if (faculty == null) {
            throw new RuntimeException("Faculty id not found - " + facultyId);
        }
        facultyService.deleteFacultyById(facultyId);
        return "Delete faculty id - " + facultyId;
    }
}
