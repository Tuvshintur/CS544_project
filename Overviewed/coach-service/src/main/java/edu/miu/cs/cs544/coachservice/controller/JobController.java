package edu.miu.cs.cs544.coachservice.controller;

import edu.miu.cs.cs544.coachservice.DTO.ErrorDTO;
import edu.miu.cs.cs544.coachservice.DTO.ResponseDTO;
import edu.miu.cs.cs544.coachservice.constants.Constants;
import edu.miu.cs.cs544.coachservice.domain.Job;
import edu.miu.cs.cs544.coachservice.service.JobService;
import edu.miu.cs.cs544.coachservice.serviceImpl.utilities.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobService service;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseDTO getJobs() {
        try {
            LOGGER.info("[ctrl][job][getJobs][ini]");
            ResponseDTO responseDTO = service.getAllJobs();
            LOGGER.info("[ctrl][job][getJobs][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][job][getJobs][unknown][ " + ex.getMessage() + "]", ex);
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
            LOGGER.error("[ctrl][job][getJobById][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseDTO addJob(@RequestBody Job job) {
        try {
            LOGGER.info("[ctrl][job][addJob][ini]");
            ResponseDTO responseDTO = service.addJob(job);
            LOGGER.info("[ctrl][job][addJob][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][job][addJob][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/{jobId}", method = RequestMethod.PUT)
    public ResponseDTO updateJob(@PathVariable("jobId") int jobId, @RequestBody Job job) {
        try {
            LOGGER.info("[ctrl][job][updateJob][ini]");

            Job currentJob = service.getJobByIdReturnJob(jobId);

            job.setId(currentJob.getId());
            ResponseDTO responseDTO = service.updateJob(job);

            LOGGER.info("[ctrl][job][updateJob][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][job][updateJob][unknown][ " + ex.getMessage() + "]", ex);
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
            LOGGER.error("[ctrl][job][deleteJob][unknown][ " + ex.getMessage() + "]", ex);
            return new ResponseService(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, new ErrorDTO(null, ex.getMessage(), Constants.ErrorType.UNKNOWN)).getError();
        }
    }

}
