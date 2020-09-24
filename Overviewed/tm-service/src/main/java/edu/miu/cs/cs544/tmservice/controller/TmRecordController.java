package edu.miu.cs.cs544.tmservice.controller;

import edu.miu.cs.cs544.tmservice.constants.Constants;
import edu.miu.cs.cs544.tmservice.dto.ErrorDTO;
import edu.miu.cs.cs544.tmservice.dto.ResponseDTO;
import edu.miu.cs.cs544.tmservice.model.TmInstructor;
import edu.miu.cs.cs544.tmservice.model.TmRecord;
import edu.miu.cs.cs544.tmservice.service.TmInstructorService;
import edu.miu.cs.cs544.tmservice.service.TmRecordService;
import edu.miu.cs.cs544.tmservice.service.utility.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("/tm-record")
public class TmRecordController {
    @Autowired
    private TmRecordService tmRecordService;

    @Autowired
    private TmInstructorService tmInstructorService;

    @Autowired
    private RestTemplate restTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseDTO getTmRecords() {
        try {
            LOGGER.info("[ctrl][tmInstructor][getTmInstructor][ini]");
            ResponseDTO responseDTO = tmRecordService.getAllTmRecords();
            LOGGER.info("[ctrl][coach][getCoaches][end]");
            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][getCoaches][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseDTO getTmRecordById(@PathVariable("id") int id) {
        try {
            LOGGER.info("[ctrl][coach][getById][ini]");
            ResponseDTO responseDTO = tmRecordService.getTmRecordById(id);
            LOGGER.info("[ctrl][coach][getId][end]");
            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][Id][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseDTO addTmRecord(@RequestBody TmRecord tmRecord) {
        try {
            LOGGER.info("[ctrl][coach][addCoach][ini]");
            ResponseDTO responseDTO = tmRecordService.addTmRecord(tmRecord);
            LOGGER.info("[ctrl][coach][addCoach][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][addCoach][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }


    @RequestMapping(value = "/tmappointment/{tmInstructorId}/{studentId}/{checkDate}", method = RequestMethod.POST)
    public ResponseDTO enterAttendance(@PathVariable("tmInstructorId") int tmInstructorId, @PathVariable("studentId") int studentId,
                                       @PathVariable Date checkDate) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<>(headers);

//        Student student = restTemplate.exchange("http://student-service/students/student/" + studentId, HttpMethod.GET, null, Student.class).getBody();
        TmInstructor tmInstructor = tmInstructorService.getTmInstructorByIdReturnTmInstructor(tmInstructorId);
        TmRecord currentTmRecord = new TmRecord(studentId, tmInstructor, checkDate);

        return tmRecordService.updateTmRecord(currentTmRecord);
    }

//    @RequestMapping(value = "/{tmInstructorId}", method = RequestMethod.PUT)
//    public ResponseDTO updateCoach(@PathVariable("tmInstructorId") int tmInstructorId, @RequestBody TmInstructor tmInstructor) {
//        try {
//            LOGGER.info("[ctrl][coach][updateCoach][ini]");
//
//            TmInstructor currentTmInstructor = tmInstructorService.getTmInstructorByIdReturnTmInstructor(tmInstructorId);
//
//            tmInstructor.setId(currentTmInstructor.getId());
//            ResponseDTO responseDTO = tmInstructorService.updateTmInstrcutor(currentTmInstructor);
//
//            LOGGER.info("[ctrl][coach][updateCoach][end]");
//
//            return responseDTO;
//        } catch (Exception ex) {
//            LOGGER.error("[ctrl][coach][updateCoach][unknown][ " + ex.getMessage() + "]", ex);
//            throw ex;
//        }
//    }

    @RequestMapping(value = "/{tmRecordId}", method = RequestMethod.DELETE)
    public ResponseDTO deleteCoach(@PathVariable("tmRecordId") int tmRecordId) {
        try {
            LOGGER.info("[ctrl][coach][deleteCoach][ini]");

            tmRecordService.deleteTmRecordById(tmRecordId);

            LOGGER.info("[ctrl][coach][deleteCoach][end]");

            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();

        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][deleteCoach][unknown][ " + ex.getMessage() + "]", ex);
            return new ResponseService(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, new ErrorDTO(null, ex.getMessage(), Constants.ErrorType.UNKNOWN)).getError();
        }
    }

}
