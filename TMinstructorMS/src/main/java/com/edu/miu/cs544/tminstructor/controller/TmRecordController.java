package com.edu.miu.cs544.tminstructor.controller;

import com.edu.miu.cs544.tminstructor.dto.ResponseDTO;
import com.edu.miu.cs544.tminstructor.model.TmInstructor;
import com.edu.miu.cs544.tminstructor.model.TmRecord;
import com.edu.miu.cs544.tminstructor.service.TmInstructorService;
import com.edu.miu.cs544.tminstructor.service.TmRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/tm-instructor")
public class TmRecordController {
    @Autowired
    private TmRecordService tmRecordService;

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

//    @Override
//    @Transactional
//    public ResponseDTO deleteCoachById(int id) {
//        System.out.println(this.getClass().getName() + "[srvc][coach.delete][ini]");
//
//        try {
//            coachRepository.deleteCoachById(id);
//            System.out.println(this.getClass().getName() + "[srvc][coach.delete][end]");
//            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();
//        } catch (Exception ex) {
//            System.out.println(this.getClass().getName() + "[srvc][coach.delete][unknown][ " + ex.getMessage() + "]");
//            throw ex;
//        }
//    }

}
