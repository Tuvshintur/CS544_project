package edu.miu.cs.cs544.MicroserviceProject.service;

import edu.miu.cs.cs544.MicroserviceProject.DTO.ResponseDTO;
import edu.miu.cs.cs544.MicroserviceProject.domain.Job;

import java.util.List;
import java.util.Optional;

public interface IJobService {

    ResponseDTO getAllJobs();
    Optional<Job> getJobById(int id);
    Job addJobs(Job job);
}
