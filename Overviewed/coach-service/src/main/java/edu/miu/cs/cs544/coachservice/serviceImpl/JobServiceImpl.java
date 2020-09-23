package edu.miu.cs.cs544.coachservice.serviceImpl;

import edu.miu.cs.cs544.coachservice.DTO.ListDTO;
import edu.miu.cs.cs544.coachservice.DTO.ResponseDTO;
import edu.miu.cs.cs544.coachservice.domain.Job;
import edu.miu.cs.cs544.coachservice.repository.JobRepository;
import edu.miu.cs.cs544.coachservice.service.JobService;
import edu.miu.cs.cs544.coachservice.serviceImpl.utilities.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobRepository jobRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public ResponseDTO getAllJobs() {
        LOGGER.info("[srvc][job][getAllJobs][ini]");
        try {
            List<Job> jobs = jobRepository.findAll();
            LOGGER.info("[srvc][job][getAllJobs][end]");
            return new ResponseService(HttpStatus.OK.value(), null, new ListDTO<>(jobs)).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][job][getAllJobs][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO getJobById(int id) {
        LOGGER.info("[srvc][job][getJobById][ini]");
        try {
            Job job = jobRepository.findById(id);
            LOGGER.info("[srvc][job][getJobById][end]");
            return new ResponseService(HttpStatus.OK.value(), null, job).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][job][getJobById][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public Job getJobByIdReturnJob(int id) {
        return jobRepository.findById(id);
    }

    @Override
    public ResponseDTO addJob(Job job) {
        LOGGER.info("[srvc][job][addJob][ini]");
        try {
            jobRepository.save(job);
            LOGGER.info("[srvc][job][addJob][end]");
            return new ResponseService(HttpStatus.OK.value(), null, job).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][job][addJob][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO updateJob(Job job) {
        LOGGER.info("[srvc][job][updateJob][ini]");
        try {
            jobRepository.save(job);
            LOGGER.info("[srvc][job][updateJob][end]");
            return new ResponseService(HttpStatus.OK.value(), null, job).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][job][updateJob][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    @Transactional
    public ResponseDTO deleteJobById(int id) {
        LOGGER.info("[srvc][job][deleteJobById][ini]");

        try {
            jobRepository.deleteJobById(id);
            LOGGER.info("[srvc][job][deleteJobById][end]");
            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][job][deleteJobById][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }
}
