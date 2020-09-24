package edu.miu.cs.cs544.tmservice.controller;


import edu.miu.cs.cs544.tmservice.constants.Constants;
import edu.miu.cs.cs544.tmservice.dto.ErrorDTO;
import edu.miu.cs.cs544.tmservice.dto.ResponseDTO;
import edu.miu.cs.cs544.tmservice.model.TmAttendance;
import edu.miu.cs.cs544.tmservice.service.TmAttendanceService;
import edu.miu.cs.cs544.tmservice.service.utility.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("/tm-attendance")
public class TmAttendanceController {
    @Autowired
    private TmAttendanceService tmAttendanceService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseDTO getTmAttendances() {
        try {
            ResponseDTO responseDTO = tmAttendanceService.getAllTmAttendces();
            return responseDTO;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseDTO getTmAttendanceById(@PathVariable("id") int id) {
        try {
            ResponseDTO responseDTO = tmAttendanceService.getTmAttendanceById(id);
            return responseDTO;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseDTO addTmAttendance(@RequestBody TmAttendance tmAttendance) {
        try {
            ResponseDTO responseDTO = tmAttendanceService.addTmAttendance(tmAttendance);
            return responseDTO;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value = "/enter/{studentId}/{courseId}", method = RequestMethod.POST)
    public ResponseDTO enterAttendance(@PathVariable("studentId") int studentId, @PathVariable("courseId") int courseId) {
        TmAttendance tmAttendance = new TmAttendance();
        tmAttendance.setStudent_id(studentId);
        tmAttendance.setCourse_id(courseId);
        tmAttendance.setDate(new Date());
        tmAttendance.setAttended(true);

        tmAttendanceService.updateTmAttendance(tmAttendance);
        return new ResponseService(HttpStatus.OK.value(), null, tmAttendance).getResponse();

    }

    @RequestMapping(value = "/{tmAttendanceId}", method = RequestMethod.DELETE)
    public ResponseDTO deleteTmAttendance(@PathVariable("tmAttendanceId") int tmAttendanceId) {
        try {
            tmAttendanceService.deleteTmAttendanceById(tmAttendanceId);
            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();

        } catch (Exception ex) {
            return new ResponseService(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, new ErrorDTO(null, ex.getMessage(), Constants.ErrorType.UNKNOWN)).getError();
        }
    }

}
