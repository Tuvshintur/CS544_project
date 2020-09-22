package sample.project.studentservice.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.project.studentservice.project.domain.Faculty;
import sample.project.studentservice.project.exception.ResourceNotFoundException;
import sample.project.studentservice.project.repository.FacultyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    public FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    @Override
    public void saveFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    @Override
    public Faculty getFacultyById(Integer facultyId) {
        Optional<Faculty> result = facultyRepository.findById(facultyId);

        Faculty theFaculty = null;
        if(result.isPresent()){
            theFaculty = result.get();
        }
        else{
            throw new RuntimeException("did not find faculty id - " + facultyId);
        }
        return theFaculty;
    }

    @Override
    public Faculty putFaculty(Faculty faculty, Integer id) {
        Faculty theFaculty = facultyRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
        theFaculty.setAddress(faculty.getAddress());
        theFaculty.setCourses(faculty.getCourses());
        theFaculty.setHiringDate(faculty.getHiringDate());
        theFaculty.setName(faculty.getName());
        theFaculty.setRoom(faculty.getRoom());

        facultyRepository.save(faculty);
        return theFaculty ;
    }

    @Override
    public void deleteFacultyById(Integer facultyId) {
        facultyRepository.deleteById(facultyId);
    }

}
