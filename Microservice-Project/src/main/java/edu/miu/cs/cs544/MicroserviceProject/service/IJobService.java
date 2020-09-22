package edu.miu.cs.cs544.MicroserviceProject.service;

import edu.miu.cs.cs544.MicroserviceProject.DTO.ResponseDTO;
import edu.miu.cs.cs544.MicroserviceProject.domain.Job;
import edu.miu.cs.cs544.MicroserviceProject.domain.JobResearchReport;

import java.util.List;
import java.util.Optional;

public interface IJobService {

    ResponseDTO getAllJobs();
    ResponseDTO getJobById(int id);
    Job getJobByIdReturnJob(int id);
    ResponseDTO addJob(Job job);
    ResponseDTO updateJob(Job job);
    ResponseDTO deleteJobById(int id);

//    ResponseDTO createJRR(JobResearchReport jobResearchReport);
}
