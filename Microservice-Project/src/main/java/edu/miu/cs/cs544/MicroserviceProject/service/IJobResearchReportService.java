package edu.miu.cs.cs544.MicroserviceProject.service;

import edu.miu.cs.cs544.MicroserviceProject.DTO.ResponseDTO;
import edu.miu.cs.cs544.MicroserviceProject.domain.JobResearchReport;

public interface IJobResearchReportService {

    ResponseDTO createjrr(JobResearchReport jobResearchReport);



}
