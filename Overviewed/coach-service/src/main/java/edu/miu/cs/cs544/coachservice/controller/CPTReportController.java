package edu.miu.cs.cs544.coachservice.controller;

import edu.miu.cs.cs544.coachservice.DTO.ErrorDTO;
import edu.miu.cs.cs544.coachservice.DTO.ResponseDTO;
import edu.miu.cs.cs544.coachservice.constants.Constants;
import edu.miu.cs.cs544.coachservice.domain.CPTReport;
import edu.miu.cs.cs544.coachservice.service.CPTReportService;
import edu.miu.cs.cs544.coachservice.serviceImpl.utilities.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cptReport")
public class CPTReportController {

    @Autowired
    CPTReportService service;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseDTO getCPTReports() {
        try {
            LOGGER.info("[ctrl][cptReport][getCPTReports][ini]");
            ResponseDTO responseDTO = service.getAllCptReport();
            LOGGER.info("[ctrl][cptReport][getCPTReports][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][cptReport][getCPTReports][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseDTO getCPTReportById(@PathVariable("id") int id) {
        try {
            LOGGER.info("[ctrl][cptReport][getCPTReportById][ini]");
            ResponseDTO responseDTO = service.getCPTReportById(id);
            LOGGER.info("[ctrl][cptReport][getCPTReportById][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][cptReport][getCPTReportById][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseDTO addCPTReport(@RequestBody CPTReport cptReport) {
        try {
            LOGGER.info("[ctrl][cptReport][addCPTReport][ini]");
            ResponseDTO responseDTO = service.addCPTReport(cptReport);
            LOGGER.info("[ctrl][cptReport][addCPTReport][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][cptReport][addCPTReport][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/{cptReportId}", method = RequestMethod.PUT)
    public ResponseDTO updateCPTReport(@PathVariable("cptReportId") int cptReportId, @RequestBody CPTReport cptReport) {
        try {
            LOGGER.info("[ctrl][cptReport][updateCPTReport][ini]");

            CPTReport currentCPTReport = service.getCPTReportByIdReturnCPTReport(cptReportId);

            cptReport.setId(currentCPTReport.getId());
            ResponseDTO responseDTO = service.updateCPTReport(cptReport);

            LOGGER.info("[ctrl][cptReport][updateCPTReport][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][cptReport][updateCPTReport][unknown][ " + ex.getMessage() + "]", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/{cptReportId}", method = RequestMethod.DELETE)
    public ResponseDTO deleteCPTReport(@PathVariable("cptReportId") int cptReportId) {
        try {
            LOGGER.info("[ctrl][cptReport][deleteCPTReport][ini]");

            service.deleteCPTReportById(cptReportId);

            LOGGER.info("[ctrl][cptReport][deleteCPTReport][end]");

            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();

        } catch (Exception ex) {
            LOGGER.error("[ctrl][cptReport][deleteCPTReport][unknown][ " + ex.getMessage() + "]", ex);
            return new ResponseService(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, new ErrorDTO(null, ex.getMessage(), Constants.ErrorType.UNKNOWN)).getError();
        }
    }

}
