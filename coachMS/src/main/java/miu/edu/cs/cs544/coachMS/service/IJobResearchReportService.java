package miu.edu.cs.cs544.coachMS.service;



import miu.edu.cs.cs544.coachMS.DTO.ResponseDTO;
import miu.edu.cs.cs544.coachMS.domain.JobResearchReport;

public interface IJobResearchReportService {

    ResponseDTO createJRR(JobResearchReport jobResearchReport);
    ResponseDTO getAllJrr();
    ResponseDTO getJrrById(int id);

}
