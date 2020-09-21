package miu.edu.cs.cs544.coachMS.service;



import miu.edu.cs.cs544.coachMS.DTO.ResponseDTO;
import miu.edu.cs.cs544.coachMS.domain.JobResearchReport;

import java.util.Optional;

public interface IJobResearchReportService {

    ResponseDTO createJRR(JobResearchReport jobResearchReport);
    ResponseDTO getAllJrr();
    Optional<JobResearchReport> getJrrById(int id);



}
