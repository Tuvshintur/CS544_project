package com.edu.miu.cs544.tminstructor.controller;

import com.edu.miu.cs544.tminstructor.constants.Constants;
import com.edu.miu.cs544.tminstructor.dto.ErrorDTO;
import com.edu.miu.cs544.tminstructor.dto.ResponseDTO;
import com.edu.miu.cs544.tminstructor.model.Student;
import com.edu.miu.cs544.tminstructor.model.TmAttendance;
import com.edu.miu.cs544.tminstructor.model.TmInstructor;
import com.edu.miu.cs544.tminstructor.model.TmRecord;
import com.edu.miu.cs544.tminstructor.service.TmAttendanceService;
import com.edu.miu.cs544.tminstructor.service.TmInstructorService;
import com.edu.miu.cs544.tminstructor.service.TmRecordService;
import com.edu.miu.cs544.tminstructor.service.utility.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Date;

@RestController
@RequestMapping("/tm-attendance")
public class TmAttendanceController {
    @Autowired
    private TmAttendanceService tmAttendanceService;
    @Autowired
    private TmInstructorService tmInstructorService;
    
    private TmRecordService tmRecordService;
    @Autowired
    private RestTemplate restTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseDTO getTmAttendances() {
        try {
            LOGGER.info("[ctrl][tmInstructor][getTmInstructor][ini]");
            ResponseDTO responseDTO = tmAttendanceService.getAllTmAttendces();
            LOGGER.info("[ctrl][coach][getCoaches][end]");
            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][getCoaches][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseDTO getTmAttendanceById(@PathVariable("id") int id) {
        try {
            LOGGER.info("[ctrl][coach][getById][ini]");
            ResponseDTO responseDTO = tmAttendanceService.getTmAttendanceById(id);
            LOGGER.info("[ctrl][coach][getId][end]");
            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][Id][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseDTO addTmAttendance(@RequestBody TmAttendance tmAttendance) {
        try {
            LOGGER.info("[ctrl][coach][addCoach][ini]");
            ResponseDTO responseDTO = tmAttendanceService.addTmAttendance(tmAttendance);
            LOGGER.info("[ctrl][coach][addCoach][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][addCoach][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/tmattendance/", method = RequestMethod.POST)
    public ResponseDTO enterAttendance(@RequestBody TmAttendance tmAttendance) {
        /*
        *  TmAttendance entity json body-g request-r irne
        *
        *     private Integer id;

            private Integer student_id;

            private Integer course_id;

            private Date date;

            private boolean isAttended;
        *
        *
        * */
        TmInstructor tmInstructor = tmInstructorService.getTmInstructorByIdReturnTmInstructor(tmInstructorId);
        TmRecord currentTmRecord = new TmRecord(student,tmInstructor,checkDate);

        ResponseDTO responseDTO = tmRecordService.updateTmRecord(currentTmRecord);
        return new ResponseService(HttpStatus.OK.value(), null, currentTmRecord).getResponse();
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


    @RequestMapping(value = "/{tmAttendanceId}", method = RequestMethod.DELETE)
    public ResponseDTO deleteCoach(@PathVariable("tmAttendanceId") int tmAttendanceId) {
        try {
            LOGGER.info("[ctrl][coach][deleteCoach][ini]");

            tmAttendanceService.deleteTmAttendanceById(tmAttendanceId);
            LOGGER.info("[ctrl][coach][deleteCoach][end]");

            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();

        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][deleteCoach][unknown][ " + ex.getMessage() + "]", ex);
            return new ResponseService(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, new ErrorDTO(null, ex.getMessage(), Constants.ErrorType.UNKNOWN)).getError();
        }
    }

}
