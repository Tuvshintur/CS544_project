package edu.miu.cs.cs544.MicroserviceProject.controller;

import edu.miu.cs.cs544.MicroserviceProject.DTO.ErrorDTO;
import edu.miu.cs.cs544.MicroserviceProject.DTO.ResponseDTO;
import edu.miu.cs.cs544.MicroserviceProject.constants.Constants;
import edu.miu.cs.cs544.MicroserviceProject.domain.Coach;
import edu.miu.cs.cs544.MicroserviceProject.domain.Job;
import edu.miu.cs.cs544.MicroserviceProject.service.IJobService;
import edu.miu.cs.cs544.MicroserviceProject.service.utilities.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {

    IJobService service;

    @Autowired
    public JobController(IJobService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseDTO getJobs() {
        try {
            System.out.println(this.getClass().getName() + "[ctrl][job][getJobs][ini]");
            ResponseDTO responseDTO = service.getAllJobs();
            System.out.println(this.getClass().getName() + "[ctrl][job][getJobs][end]");

            return responseDTO;
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[ctrl][job][getJobs][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseDTO getJobById(@PathVariable("id") int id) {
        try {
            System.out.println(this.getClass().getName() + "[ctrl][job][getJobById][ini]");
            ResponseDTO responseDTO = service.getJobById(id);
            System.out.println(this.getClass().getName() + "[ctrl][job][getJobById][end]");

            return responseDTO;
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[ctrl][job][getJobById][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseDTO addJob(@RequestBody Job job) {
        try {
            System.out.println(this.getClass().getName() + "[ctrl][job][addJob][ini]");
            ResponseDTO responseDTO = service.addJob(job);
            System.out.println(this.getClass().getName() + "[ctrl][job][addJob][end]");

            return responseDTO;
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[ctrl][job][addJob][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @RequestMapping(value = "/{jobId}", method = RequestMethod.PUT)
    public ResponseDTO updateJob(@PathVariable("jobId") int jobId, @RequestBody Coach coach) {
        try {
            System.out.println(this.getClass().getName() + "[ctrl][job][updateJob][ini]");

            Job currentJob = service.getJobByIdReturnJob(jobId);

            coach.setId(currentJob.getId());
            ResponseDTO responseDTO = service.updateJob(currentJob);

            System.out.println(this.getClass().getName() + "[ctrl][job][updateJob][end]");

            return responseDTO;
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[ctrl][job][updateJob][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @RequestMapping(value = "/{jobId}", method = RequestMethod.DELETE)
    public ResponseDTO deleteJob(@PathVariable("jobId") int jobId) {
        try {
            System.out.println(this.getClass().getName() + "[ctrl][job][deleteJob][ini]");

            service.deleteJobById(jobId);

            System.out.println(this.getClass().getName() + "[ctrl][job][deleteJob][end]");

            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();

        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[ctrl][job][deleteJob][unknown][ " + ex.getMessage() + "]");
            return new ResponseService(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, new ErrorDTO(null, ex.getMessage(), Constants.ErrorType.UNKNOWN)).getError();
        }
    }
}


