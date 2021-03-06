package miu.edu.cs.cs544.coachMS.controller;


import io.swagger.annotations.Api;
import miu.edu.cs.cs544.coachMS.DTO.IGeneralDTO;
import miu.edu.cs.cs544.coachMS.DTO.ResponseDTO;
import miu.edu.cs.cs544.coachMS.domain.JobResearchReport;
import miu.edu.cs.cs544.coachMS.service.IJobResearchReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobresearchreport")
@Api(tags="JRR")
public class JobSearchReportController implements IGeneralDTO {


    IJobResearchReportService service;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public JobSearchReportController(IJobResearchReportService service) {
        this.service = service;
    }


    @RequestMapping(value = "/addjrr", method = RequestMethod.POST)
    public ResponseDTO createJRR(@RequestBody JobResearchReport jobResearchReport) {
        try {
            LOGGER.info("[ctrl][coach][addCoach][ini]");
            ResponseDTO responseDTO = service.createJRR(jobResearchReport);
            LOGGER.info("[ctrl][coach][addCoach][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][addCoach][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @RequestMapping(value = "/alljobresearchreport", method = RequestMethod.GET)
    public ResponseDTO getAllJrr() {
        try {
            LOGGER.info("[ctrl][coach][getCoaches][ini]");
            ResponseDTO responseDTO = service.getAllJrr();
            LOGGER.info("[ctrl][coach][getCoaches][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][getCoaches][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseDTO getJrrById(@PathVariable("id") int id) {
        try {
            LOGGER.info("[ctrl][coach][getCoachById][ini]");
            ResponseDTO responseDTO = service.getJrrById(id);
            LOGGER.info("[ctrl][coach][getCoachById][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][getCoachById][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }
}
