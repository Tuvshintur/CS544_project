package com.edu.miu.cs544.tminstructor.controller;


import com.edu.miu.cs544.tminstructor.constants.Constants;
import com.edu.miu.cs544.tminstructor.dto.ErrorDTO;
import com.edu.miu.cs544.tminstructor.dto.ResponseDTO;
import com.edu.miu.cs544.tminstructor.model.Student;
import com.edu.miu.cs544.tminstructor.model.TmAttendance;
import com.edu.miu.cs544.tminstructor.model.TmInstructor;
import com.edu.miu.cs544.tminstructor.model.TmRecord;
import com.edu.miu.cs544.tminstructor.service.TmAttendanceService;
import com.edu.miu.cs544.tminstructor.service.TmRecordService;
import com.edu.miu.cs544.tminstructor.service.utility.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<>(headers);

//        Student student = restTemplate.exchange("http://student-service/students/student/" + studentId, HttpMethod.GET, null, Student.class).getBody();
//        ResponseDTO tmp = new ResponseService(HttpStatus.OK.value(), null,student).getResponse();
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
