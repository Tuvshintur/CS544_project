package edu.miu.cs.cs544.MicroserviceProject.controller;

import edu.miu.cs.cs544.MicroserviceProject.DTO.ErrorDTO;
import edu.miu.cs.cs544.MicroserviceProject.DTO.ResponseDTO;
import edu.miu.cs.cs544.MicroserviceProject.constants.Constants;
import edu.miu.cs.cs544.MicroserviceProject.domain.Coach;
import edu.miu.cs.cs544.MicroserviceProject.domain.Job;
import edu.miu.cs.cs544.MicroserviceProject.domain.JobResearchReport;
import edu.miu.cs.cs544.MicroserviceProject.service.IJobService;
import edu.miu.cs.cs544.MicroserviceProject.service.utilities.ResponseService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
@Api(tags = "JOB")
public class JobController {

    IJobService service;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public JobController(IJobService service) {
        this.service = service;
    }

    @RequestMapping(value = "/alljobs", method = RequestMethod.GET)
    public ResponseDTO getJobs() {
        try {
            LOGGER.info("[ctrl][job][getJobs][ini]");
            ResponseDTO responseDTO = service.getAllJobs();
            LOGGER.info("[ctrl][job][getJobs][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][job][getJobs][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseDTO getJobById(@PathVariable("id") int id) {
        try {
            LOGGER.info("[ctrl][job][getJobById][ini]");
            ResponseDTO responseDTO = service.getJobById(id);
            LOGGER.info("[ctrl][job][getJobById][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][job][getJobById][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @RequestMapping(value = "/addjobs", method = RequestMethod.POST)
    public ResponseDTO addJob(@RequestBody Job job) {
        try {
            LOGGER.info(this.getClass().getName() + "[ctrl][job][addJob][ini]");
            ResponseDTO responseDTO = service.addJob(job);
            LOGGER.info(this.getClass().getName() + "[ctrl][job][addJob][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error(this.getClass().getName() + "[ctrl][job][addJob][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @RequestMapping(value = "/{jobId}", method = RequestMethod.PUT)
    public ResponseDTO updateJob(@PathVariable("jobId") int jobId, @RequestBody Coach coach) {
        try {
            LOGGER.info("[ctrl][job][updateJob][ini]");

            Job currentJob = service.getJobByIdReturnJob(jobId);

            coach.setId(currentJob.getId());
            ResponseDTO responseDTO = service.updateJob(currentJob);

            LOGGER.info("[ctrl][job][updateJob][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][job][updateJob][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @RequestMapping(value = "/{jobId}", method = RequestMethod.DELETE)
    public ResponseDTO deleteJob(@PathVariable("jobId") int jobId) {
        try {
            LOGGER.info("[ctrl][job][deleteJob][ini]");

            service.deleteJobById(jobId);

            LOGGER.info("[ctrl][job][deleteJob][end]");

            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();

        } catch (Exception ex) {
            LOGGER.error("[ctrl][job][deleteJob][unknown][ " + ex.getMessage() + "]");
            return new ResponseService(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, new ErrorDTO(null, ex.getMessage(), Constants.ErrorType.UNKNOWN)).getError();
        }
    }

    ////////// view all students ////////

//    @RequestMapping(value = "/viewallstudents", method = RequestMethod.GET)
//    public ResponseDTO viewAllStudents() {
//        try {
//            LOGGER.info("[ctrl][job][getJobs][ini]");
//            ResponseDTO responseDTO = service.getAllJobs();
//            LOGGER.info("[ctrl][job][getJobs][end]");
//
//            return responseDTO;
//        } catch (Exception ex) {
//            LOGGER.error("[ctrl][job][getJobs][unknown][ " + ex.getMessage() + "]");
//            throw ex;
//        }
//    }
//
//    //////// assign students to himself /////////////
//    @RequestMapping(value = "/alljobs", method = RequestMethod.GET)
//    public ResponseDTO addStudents() {
//        try {
//            LOGGER.info("[ctrl][job][getJobs][ini]");
//            ResponseDTO responseDTO = service.getAllJobs();
//            LOGGER.info("[ctrl][job][getJobs][end]");
//
//            return responseDTO;
//        } catch (Exception ex) {
//            LOGGER.error("[ctrl][job][getJobs][unknown][ " + ex.getMessage() + "]");
//            throw ex;
//        }
//    }

    ///////////////


    }



