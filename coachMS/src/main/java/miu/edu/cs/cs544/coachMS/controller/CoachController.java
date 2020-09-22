package miu.edu.cs.cs544.coachMS.controller;

import io.swagger.annotations.Api;
import miu.edu.cs.cs544.coachMS.DTO.ErrorDTO;
import miu.edu.cs.cs544.coachMS.DTO.ListDTO;
import miu.edu.cs.cs544.coachMS.DTO.ResponseDTO;
import miu.edu.cs.cs544.coachMS.constants.Constants;
import miu.edu.cs.cs544.coachMS.domain.Coach;
import miu.edu.cs.cs544.coachMS.domain.Student;
import miu.edu.cs.cs544.coachMS.service.ICoachService;
import miu.edu.cs.cs544.coachMS.service.utilities.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/coach")
@Api(tags = "COACH")
public class CoachController {

    @Autowired
    ICoachService service;
    @Autowired
    RestTemplate restTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/students")
    public ResponseDTO getStudents() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        List<Student> studentResponse = restTemplate.exchange("http://student-service/students/All", HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {}).getBody();
        return new ResponseService(HttpStatus.OK.value(), null, new ListDTO<>(studentResponse)).getResponse();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseDTO getCoaches() {
        try {
            LOGGER.info("[ctrl][coach][getCoaches][ini]");
            ResponseDTO responseDTO = service.getAllCoaches();
            LOGGER.info("[ctrl][coach][getCoaches][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][getCoaches][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseDTO getCoachById(@PathVariable("id") int id) {
        try {
            LOGGER.info("[ctrl][coach][getCoachById][ini]");
            ResponseDTO responseDTO = service.getCoachById(id);
            LOGGER.info("[ctrl][coach][getCoachById][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][getCoachById][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseDTO addCoach(@RequestBody Coach coach) {
        try {
            LOGGER.info("[ctrl][coach][addCoach][ini]");
            ResponseDTO responseDTO = service.addCoach(coach);
            LOGGER.info("[ctrl][coach][addCoach][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][addCoach][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/assign/{coachId}/{studentId}", method = RequestMethod.POST)
    public ResponseDTO assignStudent(@PathVariable("coachId") int coachId, @PathVariable("studentId") int studentId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        Student student = restTemplate.exchange("http://student-service/students/student/assignCoach/"+ coachId+ "/" + studentId, HttpMethod.POST, null, Student.class).getBody();
        return new ResponseService(HttpStatus.OK.value(), null, student).getResponse();
    }

    @RequestMapping(value = "/{coachId}", method = RequestMethod.PUT)
    public ResponseDTO updateCoach(@PathVariable("coachId") int coachId, @RequestBody Coach coach) {
        try {
            LOGGER.info("[ctrl][coach][updateCoach][ini]");

            Coach currentCoach = service.getCoachByIdReturnCoach(coachId);

            coach.setId(currentCoach.getId());
            ResponseDTO responseDTO = service.updateCoach(currentCoach);

            LOGGER.info("[ctrl][coach][updateCoach][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][updateCoach][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/{coachId}", method = RequestMethod.DELETE)
    public ResponseDTO deleteCoach(@PathVariable("coachId") int coachId) {
        try {
            LOGGER.info("[ctrl][coach][deleteCoach][ini]");

            service.deleteCoachById(coachId);

            LOGGER.info("[ctrl][coach][deleteCoach][end]");

            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();

        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][deleteCoach][unknown][ " + ex.getMessage() + "]", ex);
            return new ResponseService(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, new ErrorDTO(null, ex.getMessage(), Constants.ErrorType.UNKNOWN)).getError();
        }
    }

}