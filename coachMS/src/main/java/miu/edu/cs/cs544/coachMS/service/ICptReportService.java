package miu.edu.cs.cs544.coachMS.service;



import miu.edu.cs.cs544.coachMS.DTO.ResponseDTO;
import miu.edu.cs.cs544.coachMS.domain.CptReport;

import java.util.Optional;

public interface ICptReportService {

     ResponseDTO getAllCptReport();
     ResponseDTO getCptById(int id);
     ResponseDTO deleteCptReportById(int id);
     ResponseDTO updateCptReport(CptReport cptReport);
     ResponseDTO addCptReport(CptReport cptReport);
     Optional<CptReport> getCptByIdReturnCoach(int id);
}
