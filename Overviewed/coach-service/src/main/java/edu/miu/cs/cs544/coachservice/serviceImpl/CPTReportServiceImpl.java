package edu.miu.cs.cs544.coachservice.serviceImpl;

import edu.miu.cs.cs544.coachservice.DTO.ListDTO;
import edu.miu.cs.cs544.coachservice.DTO.ResponseDTO;
import edu.miu.cs.cs544.coachservice.domain.CPTReport;
import edu.miu.cs.cs544.coachservice.repository.CPTReportRepository;
import edu.miu.cs.cs544.coachservice.service.CPTReportService;
import edu.miu.cs.cs544.coachservice.serviceImpl.utilities.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CPTReportServiceImpl implements CPTReportService {

    @Autowired
    CPTReportRepository cptReportRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public ResponseDTO getAllCptReport() {
        LOGGER.info("[srvc][cptReport][getAllCptReport][ini]");
        try {
            List<CPTReport> cptReports = cptReportRepository.findAll();
            LOGGER.info("[srvc][cptReport][getAllCptReport][end]");
            return new ResponseService(HttpStatus.OK.value(), null, new ListDTO<>(cptReports)).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][cptReport][getAllCptReport][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO getCPTReportById(int id) {
        LOGGER.info("[srvc][cptReport][getCPTReportById][ini]");
        try {
            CPTReport cptReport = cptReportRepository.findById(id);
            LOGGER.info("[srvc][cptReport][getCPTReportById][end]");
            return new ResponseService(HttpStatus.OK.value(), null, cptReport).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][cptReport][getCPTReportById][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public CPTReport getCPTReportByIdReturnCPTReport(int id) {
        return cptReportRepository.findById(id);
    }

    @Override
    public ResponseDTO addCPTReport(CPTReport cptReport) {
        LOGGER.info("[srvc][cptReport][addCPTReport][ini]");
        try {
            cptReportRepository.save(cptReport);
            LOGGER.info("[srvc][cptReport][addCPTReport][end]");
            return new ResponseService(HttpStatus.OK.value(), null, cptReport).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][cptReport][addCPTReport][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO updateCPTReport(CPTReport cptReport) {
        LOGGER.info("[srvc][cptReport][updateCPTReport][ini]");
        try {
            cptReportRepository.save(cptReport);
            LOGGER.info("[srvc][cptReport][updateCPTReport][end]");
            return new ResponseService(HttpStatus.OK.value(), null, cptReport).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][cptReport][updateCPTReport][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    @Transactional
    public ResponseDTO deleteCPTReportById(int id) {
        LOGGER.info("[srvc][cptReport][deleteCPTReportById][ini]");

        try {
            cptReportRepository.deleteCPTReportById(id);
            LOGGER.info("[srvc][cptReport][deleteCPTReportById][end]");
            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][cptReport][deleteCPTReportById][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }
}
