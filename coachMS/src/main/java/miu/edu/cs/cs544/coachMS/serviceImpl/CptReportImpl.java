package miu.edu.cs.cs544.coachMS.serviceImpl;


import miu.edu.cs.cs544.coachMS.DTO.ListDTO;
import miu.edu.cs.cs544.coachMS.DTO.ResponseDTO;
import miu.edu.cs.cs544.coachMS.domain.CptReport;
import miu.edu.cs.cs544.coachMS.repository.ICptReportRepository;
import miu.edu.cs.cs544.coachMS.service.ICptReportService;
import miu.edu.cs.cs544.coachMS.service.utilities.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CptReportImpl implements ICptReportService {


    ICptReportRepository iCptReportRepository;

    @Autowired
    public CptReportImpl(ICptReportRepository iCptReportRepository) {
        this.iCptReportRepository = iCptReportRepository;
    }


    @Override
    public ResponseDTO getAllCptReport() {
        System.out.println(this.getClass().getName() + "[srvc][cpt.get.all][ini]");
        try {
            List<CptReport> cpts = iCptReportRepository.findAll();
            System.out.println(this.getClass().getName() + "[srvc][cpt.get.all][end]");
            return new ResponseService(HttpStatus.OK.value(), null, new ListDTO<>(cpts)).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][cpt.get.all][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO getCptById(int id) {
//        System.out.println(this.getClass().getName() + "[srvc][coach.get.CoachById][ini]");
//        try {
//            Optional<CptReport> cptReport = iCptReportRepository.findById(id);
//            System.out.println(this.getClass().getName() + "[srvc][coach.get.CoachById][end]");
//            return new ResponseService(HttpStatus.OK.value(), null, cptReport).getResponse();
//        } catch (Exception ex) {
//            System.out.println(this.getClass().getName() + "[srvc][coach.get.CoachById][unknown][ " + ex.getMessage() + "]");
//            throw ex;
//        }
        return null;
    }

    @Override
    public ResponseDTO addCptReport(CptReport cptReport) {
        System.out.println(this.getClass().getName() + "[srvc][coach.save.addCoach][ini]");
        try {
            iCptReportRepository.save(cptReport);
            System.out.println(this.getClass().getName() + "[srvc][coach.save.addCoach][end]");
            return new ResponseService(HttpStatus.OK.value(), null, cptReport).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.save.addCoach][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO updateCptReport(CptReport cptReport) {
        System.out.println(this.getClass().getName() + "[srvc][coach.update.updateCoach][ini]");
        try {
            iCptReportRepository.save(cptReport);
            System.out.println(this.getClass().getName() + "[srvc][coach.update.updateCoach][end]");
            return new ResponseService(HttpStatus.OK.value(), null, cptReport).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.update.updateCoach][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public Optional<CptReport> getCptByIdReturnCoach(int id) {
        return iCptReportRepository.findById(id);
    }

    @Override
    @Transactional
    public ResponseDTO deleteCptReportById(int id) {
        System.out.println(this.getClass().getName() + "[srvc][coach.delete][ini]");

        try {
            iCptReportRepository.deleteCoachById(id);
            System.out.println(this.getClass().getName() + "[srvc][coach.delete][end]");
            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.delete][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }
}
