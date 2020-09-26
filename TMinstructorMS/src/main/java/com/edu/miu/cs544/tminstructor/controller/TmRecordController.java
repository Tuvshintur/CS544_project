package com.edu.miu.cs544.tminstructor.controller;

import com.edu.miu.cs544.tminstructor.constants.Constants;
import com.edu.miu.cs544.tminstructor.dto.ErrorDTO;
import com.edu.miu.cs544.tminstructor.dto.ResponseDTO;
import com.edu.miu.cs544.tminstructor.model.TmInstructor;
import com.edu.miu.cs544.tminstructor.model.TmRecord;
import com.edu.miu.cs544.tminstructor.model.Student;
import com.edu.miu.cs544.tminstructor.repository.TmRecordRepository;
import com.edu.miu.cs544.tminstructor.service.TmInstructorService;
import com.edu.miu.cs544.tminstructor.service.TmRecordService;
import com.edu.miu.cs544.tminstructor.service.utility.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/tm-record")
public class TmRecordController {
    @Autowired
    private TmRecordService tmRecordService;

    @Autowired
    private TmInstructorService tmInstructorService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TmRecordRepository tmRecordRepository;

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

    @GetMapping("ui")
    public String main(Model model) {
        List<TmRecord> tmRecords = tmRecordRepository.findAll();
        model.addAttribute("tmrecords", tmRecords);
        return "list";
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

    @RequestMapping(value = "/appointment/{tmInstructorId}/{studentId}", method = RequestMethod.POST)
    public ResponseDTO enterAttendance(@PathVariable("tmInstructorId") int tmInstructorId, @PathVariable("studentId") int studentId) {
        TmRecord currentTmRecord = new TmRecord(studentId,tmInstructorId);
        currentTmRecord.setDateOfTmChecking(new Date());
        return tmRecordService.updateTmRecord(currentTmRecord);
    }
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
