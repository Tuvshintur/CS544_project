package edu.miu.cs.cs544.coachservice.controller;

import edu.miu.cs.cs544.coachservice.DTO.ErrorDTO;
import edu.miu.cs.cs544.coachservice.DTO.ResponseDTO;
import edu.miu.cs.cs544.coachservice.constants.Constants;
import edu.miu.cs.cs544.coachservice.domain.JobSearchReport;
import edu.miu.cs.cs544.coachservice.service.JobSearchReportService;
import edu.miu.cs.cs544.coachservice.serviceImpl.utilities.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobSearchReport")
public class JobSearchReportController {

    @Autowired
    JobSearchReportService service;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseDTO getJobSearchReports() {
        try {
            LOGGER.info("[ctrl][jobSearchReport][getJobSearchReports][ini]");
            ResponseDTO responseDTO = service.getAllJobSearchReports();
            LOGGER.info("[ctrl][jobSearchReport][getJobSearchReports][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][jobSearchReport][getJobSearchReports][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseDTO getJobSearchReportById(@PathVariable("id") int id) {
        try {
            LOGGER.info("[ctrl][jobSearchReport][getJobSearchReportById][ini]");
            ResponseDTO responseDTO = service.getJobSearchReportById(id);
            LOGGER.info("[ctrl][jobSearchReport][getJobSearchReportById][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][jobSearchReport][getJobSearchReportById][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseDTO addJobSearchReport(@RequestBody JobSearchReport jobSearchReport) {
        try {
            LOGGER.info("[ctrl][jobSearchReport][addJobSearchReport][ini]");
            ResponseDTO responseDTO = service.addJobSearchReport(jobSearchReport);
            LOGGER.info("[ctrl][jobSearchReport][addJobSearchReport][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][jobSearchReport][addJobSearchReport][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/{jobSearchReportId}", method = RequestMethod.PUT)
    public ResponseDTO updateJobSearchReport(@PathVariable("jobSearchReportId") int jobId, @RequestBody JobSearchReport jobSearchReport) {
        try {
            LOGGER.info("[ctrl][jobSearchReport][updateJobSearchReport][ini]");

            JobSearchReport currentJobSearchReport = service.getJobSearchReportByIdReturnJobSearchReport(jobId);

            jobSearchReport.setId(currentJobSearchReport.getId());
            ResponseDTO responseDTO = service.updateJobSearchReport(jobSearchReport);

            LOGGER.info("[ctrl][jobSearchReport][updateJobSearchReport][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][jobSearchReport][updateJobSearchReport][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/{jobSearchReportId}", method = RequestMethod.DELETE)
    public ResponseDTO deleteJobSearchReport(@PathVariable("jobSearchReportId") int jobSearchReportId) {
        try {
            LOGGER.info("[ctrl][job][deleteJobSearchReport][ini]");

            service.deleteJobSearchReportById(jobSearchReportId);

            LOGGER.info("[ctrl][job][deleteJobSearchReport][end]");

            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();

        } catch (Exception ex) {
            LOGGER.error("[ctrl][job][deleteJobSearchReport][unknown][ " + ex.getMessage() + "]", ex);
            return new ResponseService(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, new ErrorDTO(null, ex.getMessage(), Constants.ErrorType.UNKNOWN)).getError();
        }
    }
}
