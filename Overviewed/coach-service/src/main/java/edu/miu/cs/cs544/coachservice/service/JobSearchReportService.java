package edu.miu.cs.cs544.coachservice.service;

import edu.miu.cs.cs544.coachservice.DTO.ResponseDTO;
import edu.miu.cs.cs544.coachservice.domain.JobSearchReport;

import java.util.List;

public interface JobSearchReportService {

    ResponseDTO getAllJobSearchReports();

    ResponseDTO getJobSearchReportById(int id);

    JobSearchReport getJobSearchReportByIdReturnJobSearchReport(int id);

    ResponseDTO updateJobSearchReport(JobSearchReport jobSearchReport);

    ResponseDTO addJobSearchReport(JobSearchReport jobSearchReport);

    ResponseDTO deleteJobSearchReportById(int id);

    List<JobSearchReport> getAllJobSearchReportEntity();
}
