package edu.miu.cs.cs544.coachservice.serviceImpl;

import edu.miu.cs.cs544.coachservice.DTO.ListDTO;
import edu.miu.cs.cs544.coachservice.DTO.ResponseDTO;
import edu.miu.cs.cs544.coachservice.domain.JobSearchReport;
import edu.miu.cs.cs544.coachservice.service.JobSearchReportRepository;
import edu.miu.cs.cs544.coachservice.service.JobSearchReportService;
import edu.miu.cs.cs544.coachservice.serviceImpl.utilities.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class JobSearchReportServiceImpl implements JobSearchReportService {

    @Autowired
    JobSearchReportRepository jobSearchReportRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public ResponseDTO getAllJobSearchReports() {
        LOGGER.info("[srvc][jobSearchReport][getAllJobSearchReports][ini]");
        try {
            List<JobSearchReport> jobSearchReports = jobSearchReportRepository.findAll();
            LOGGER.info("[srvc][jobSearchReport][getAllJobSearchReports][end]");
            return new ResponseService(HttpStatus.OK.value(), null, new ListDTO<>(jobSearchReports)).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][jobSearchReport][getAllJobSearchReports][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO getJobSearchReportById(int id) {
        LOGGER.info("[srvc][jobSearchReport][getJobSearchReportById][ini]");
        try {
            JobSearchReport jobSearchReport = jobSearchReportRepository.findById(id);
            LOGGER.info("[srvc][jobSearchReport][getJobSearchReportById][end]");
            return new ResponseService(HttpStatus.OK.value(), null, jobSearchReport).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][jobSearchReport][getJobSearchReportById][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public JobSearchReport getJobSearchReportByIdReturnJobSearchReport(int id) {
        return jobSearchReportRepository.findById(id);
    }

    @Override
    public ResponseDTO addJobSearchReport(JobSearchReport jobSearchReport) {
        LOGGER.info("[srvc][jobSearchReport][addCPTReport][ini]");
        try {
            jobSearchReportRepository.save(jobSearchReport);
            LOGGER.info("[srvc][jobSearchReport][addCPTReport][end]");
            return new ResponseService(HttpStatus.OK.value(), null, jobSearchReport).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][jobSearchReport][addCPTReport][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO updateJobSearchReport(JobSearchReport jobSearchReport) {
        LOGGER.info("[srvc][jobSearchReport][updateCPTReport][ini]");
        try {
            jobSearchReportRepository.save(jobSearchReport);
            LOGGER.info("[srvc][jobSearchReport][updateCPTReport][end]");
            return new ResponseService(HttpStatus.OK.value(), null, jobSearchReport).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][jobSearchReport][updateCPTReport][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    @Transactional
    public ResponseDTO deleteJobSearchReportById(int id) {
        LOGGER.info("[srvc][jobSearchReport][deleteCPTReportById][ini]");

        try {
            jobSearchReportRepository.deleteCPTReportById(id);
            LOGGER.info("[srvc][jobSearchReport][deleteCPTReportById][end]");
            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][jobSearchReport][deleteCPTReportById][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }
}
