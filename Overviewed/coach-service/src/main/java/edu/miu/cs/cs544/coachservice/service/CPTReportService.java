package edu.miu.cs.cs544.coachservice.service;

import edu.miu.cs.cs544.coachservice.DTO.ResponseDTO;
import edu.miu.cs.cs544.coachservice.domain.CPTReport;

public interface CPTReportService {

    ResponseDTO getAllCptReport();

    ResponseDTO getCPTReportById(int id);

    CPTReport getCPTReportByIdReturnCPTReport(int id);

    ResponseDTO updateCPTReport(CPTReport cptReport);

    ResponseDTO addCPTReport(CPTReport cptReport);

    ResponseDTO deleteCPTReportById(int id);

}
