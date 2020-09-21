package edu.miu.cs.cs544.MicroserviceProject.controller;

import edu.miu.cs.cs544.MicroserviceProject.DTO.ResponseDTO;
import edu.miu.cs.cs544.MicroserviceProject.domain.Coach;
import edu.miu.cs.cs544.MicroserviceProject.domain.Job;
import edu.miu.cs.cs544.MicroserviceProject.service.ICoachService;
import edu.miu.cs.cs544.MicroserviceProject.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    IJobService service;

    public JobController(IJobService service) {
        this.service = service;
    }



    @PostMapping("/addjobs")
    public void addjobs(@RequestBody Job job){
        service.addJobs(job);
    }
    @RequestMapping(value = "/getjobs", method = RequestMethod.GET)
    public ResponseDTO getAllJobs() {
        try {
            System.out.println(this.getClass().getName() + "[ctrl][coach][getCoaches][ini]");
            ResponseDTO responseDTO = service.getAllJobs();
            System.out.println(this.getClass().getName() + "[ctrl][coach][getCoaches][end]");

            return responseDTO;
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[ctrl][coach][getCoaches][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @GetMapping("/{id}")
    public Optional<Job> getJob(@PathVariable int id) throws Exception {
        return service.getJobById(id);
    }
}


