package edu.miu.cs.cs544.tmservice.controller;

import edu.miu.cs.cs544.tmservice.dto.ResponseDTO;
import edu.miu.cs.cs544.tmservice.model.Student;
import edu.miu.cs.cs544.tmservice.model.TmInstructor;
import edu.miu.cs.cs544.tmservice.service.TmInstructorService;
import edu.miu.cs.cs544.tmservice.service.utility.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Collections;

@RestController
@RequestMapping("/tm-instructor")

public class TmInstructorController {
    @Autowired
    private TmInstructorService tmInstructorService;

    @Autowired
    private RestTemplate restTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/students")
    public String getAllTmInstructors() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://student-service/students/All", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseDTO getTmInstructors() {
        try {
            LOGGER.info("[ctrl][tmInstructor][getTmInstructor][ini]");
            ResponseDTO responseDTO = tmInstructorService.getAllTmInstructors();
            LOGGER.info("[ctrl][coach][getCoaches][end]");
            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][getCoaches][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseDTO getTmInstructorById(@PathVariable("id") int id) {
        try {
            LOGGER.info("[ctrl][coach][getById][ini]");
            ResponseDTO responseDTO = tmInstructorService.getTmInstructorById(id);
            LOGGER.info("[ctrl][coach][getId][end]");
            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][Id][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseDTO addTmInstructor(@RequestBody TmInstructor tmInstructor) {
        try {
            LOGGER.info("[ctrl][coach][addCoach][ini]");
            ResponseDTO responseDTO = tmInstructorService.addTmInstructor(tmInstructor);
            LOGGER.info("[ctrl][coach][addCoach][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][addCoach][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/assign/{tmInstructorId}/{studentId}", method = RequestMethod.POST)
    public ResponseDTO assignStudent(@PathVariable("tmInstructorId") int tmInstructorId, @PathVariable("studentId") int studentId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        TmInstructor currentTmInstructor = tmInstructorService.getTmInstructorByIdReturnTmInstructor(tmInstructorId);

        Student student = restTemplate.exchange("http://student-service/students/student/" + studentId, HttpMethod.GET, null, Student.class).getBody();
//        currentTmInstructor.addStudent(student);

        return tmInstructorService.updateTmInstrcutor(currentTmInstructor);
    }

    @RequestMapping(value = "/{tmInstructorId}", method = RequestMethod.PUT)
    public ResponseDTO updateCoach(@PathVariable("tmInstructorId") int tmInstructorId, @RequestBody TmInstructor tmInstructor) {
        try {
            LOGGER.info("[ctrl][coach][updateCoach][ini]");

            TmInstructor currentTmInstructor = tmInstructorService.getTmInstructorByIdReturnTmInstructor(tmInstructorId);

            tmInstructor.setId(currentTmInstructor.getId());
            ResponseDTO responseDTO = tmInstructorService.updateTmInstrcutor(currentTmInstructor);

            LOGGER.info("[ctrl][coach][updateCoach][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][updateCoach][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    //    @Override
    @Transactional
    public ResponseDTO deleteTmInstructorById(int id) {
        System.out.println(this.getClass().getName() + "[srvc][coach.delete][ini]");
        try {
            tmInstructorService.deleteTmInstructorById(id);
            System.out.println(this.getClass().getName() + "[srvc][coach.delete][end]");
            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.delete][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

}
