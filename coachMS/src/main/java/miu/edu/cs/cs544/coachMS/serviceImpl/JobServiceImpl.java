package miu.edu.cs.cs544.coachMS.serviceImpl;

import miu.edu.cs.cs544.coachMS.DTO.ListDTO;
import miu.edu.cs.cs544.coachMS.DTO.ResponseDTO;
import miu.edu.cs.cs544.coachMS.domain.Job;
import miu.edu.cs.cs544.coachMS.repository.IJobRepository;
import miu.edu.cs.cs544.coachMS.service.IJobService;
import miu.edu.cs.cs544.coachMS.service.utilities.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class JobServiceImpl implements IJobService {

    IJobRepository jobRepository;

    @Autowired
    public JobServiceImpl(IJobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public ResponseDTO getAllJobs() {
        System.out.println(this.getClass().getName() + "[srvc][job.get.all][ini]");
        try {
            List<Job> jobs = jobRepository.findAll();
            System.out.println(this.getClass().getName() + "[srvc][job.get.all][end]");
            return new ResponseService(HttpStatus.OK.value(), null, new ListDTO<>(jobs)).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][job.get.all][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO getJobById(int id) {
        System.out.println(this.getClass().getName() + "[srvc][job.get.jobById][ini]");
        try {
            Job job = jobRepository.findById(id);
            System.out.println(this.getClass().getName() + "[srvc][job.get.jobById][end]");
            return new ResponseService(HttpStatus.OK.value(), null, job).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][job.get.jobById][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public Job getJobByIdReturnJob(int id) {
        return jobRepository.findById(id);
    }

    @Override
    public ResponseDTO addJob(Job job) {
        System.out.println(this.getClass().getName() + "[srvc][job.save.addJob][ini]");
        try {
            jobRepository.save(job);
            System.out.println(this.getClass().getName() + "[srvc][job.save.addJob][end]");
            return new ResponseService(HttpStatus.OK.value(), null, job).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][job.save.addJob][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO updateJob(Job job) {
        System.out.println(this.getClass().getName() + "[srvc][job.update.updateJob][ini]");
        try {
            jobRepository.save(job);
            System.out.println(this.getClass().getName() + "[srvc][job.update.updateJob][end]");
            return new ResponseService(HttpStatus.OK.value(), null, job).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][job.update.updateJob][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    @Transactional
    public ResponseDTO deleteJobById(int id) {
        System.out.println(this.getClass().getName() + "[srvc][job.delete][ini]");

        try {
            jobRepository.deleteJobById(id);
            System.out.println(this.getClass().getName() + "[srvc][job.delete][end]");
            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][job.delete][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

}
