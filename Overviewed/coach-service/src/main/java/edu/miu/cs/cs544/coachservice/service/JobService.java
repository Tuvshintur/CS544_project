package edu.miu.cs.cs544.coachservice.service;

import edu.miu.cs.cs544.coachservice.DTO.ResponseDTO;
import edu.miu.cs.cs544.coachservice.domain.Job;

public interface JobService {

    ResponseDTO getAllJobs();

    ResponseDTO getJobById(int id);

    Job getJobByIdReturnJob(int id);

    ResponseDTO addJob(Job job);

    ResponseDTO updateJob(Job job);

    ResponseDTO deleteJobById(int id);

}
