package miu.edu.cs.cs544.coachMS.service;

import miu.edu.cs.cs544.coachMS.DTO.ResponseDTO;
import miu.edu.cs.cs544.coachMS.domain.Job;

public interface IJobService {

    ResponseDTO getAllJobs();
    ResponseDTO getJobById(int id);
    Job getJobByIdReturnJob(int id);
    ResponseDTO addJob(Job job);
    ResponseDTO updateJob(Job job);
    ResponseDTO deleteJobById(int id);
}
