package miu.edu.cs.cs544.coachMS.serviceImpl;

import miu.edu.cs.cs544.coachMS.DTO.ListDTO;
import miu.edu.cs.cs544.coachMS.DTO.ResponseDTO;
import miu.edu.cs.cs544.coachMS.domain.JobResearchReport;
import miu.edu.cs.cs544.coachMS.repository.IJobResearchReport;
import miu.edu.cs.cs544.coachMS.service.IJobResearchReportService;
import miu.edu.cs.cs544.coachMS.service.utilities.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobResearchReportImpl implements IJobResearchReportService {

    IJobResearchReport iJobResearchReport;

    @Autowired
    public JobResearchReportImpl(IJobResearchReport iJobResearchReport) {
        this.iJobResearchReport = iJobResearchReport;
    }


    @Override
    public ResponseDTO createJRR(JobResearchReport jobResearchReport) {
        System.out.println(this.getClass().getName() + "[srvc][coach.save.addCoach][ini]");
        try {
            iJobResearchReport.save(jobResearchReport);
            System.out.println(this.getClass().getName() + "[srvc][coach.save.addCoach][end]");
            return new ResponseService(HttpStatus.OK.value(), null, jobResearchReport).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.save.addCoach][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO getAllJrr() {
        System.out.println(this.getClass().getName() + "[srvc][coach.get.all][ini]");
        try {
            List<JobResearchReport> jrrs = iJobResearchReport.findAll();
            System.out.println(this.getClass().getName() + "[srvc][coach.get.all][end]");
            return new ResponseService(HttpStatus.OK.value(), null, new ListDTO<>(jrrs)).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.get.all][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public Optional<JobResearchReport> getJrrById(int id) {
//        System.out.println(this.getClass().getName() + "[srvc][jrr.get.JrrById][ini]");
//        try {
//
//           // JobResearchReport jobResearchReport = iJobResearchReport.findById(id);
//            return iJobResearchReport.findById(id);
//            System.out.println(this.getClass().getName() + "[srvc][jrr.get.JrrById][end]");
//            return new ResponseService(HttpStatus.OK.value(), null, jobResearchReport).getResponse();
//        } catch (Exception ex) {
//            System.out.println(this.getClass().getName() + "[srvc][jrr.get.JrrById][unknown][ " + ex.getMessage() + "]");
//            throw ex;
//        }
        return  null;
    }
}
