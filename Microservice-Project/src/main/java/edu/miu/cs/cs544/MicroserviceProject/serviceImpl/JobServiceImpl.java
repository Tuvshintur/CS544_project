package edu.miu.cs.cs544.MicroserviceProject.serviceImpl;

import edu.miu.cs.cs544.MicroserviceProject.DTO.ListDTO;
import edu.miu.cs.cs544.MicroserviceProject.DTO.ResponseDTO;
import edu.miu.cs.cs544.MicroserviceProject.domain.Coach;
import edu.miu.cs.cs544.MicroserviceProject.domain.Job;
import edu.miu.cs.cs544.MicroserviceProject.repository.IJobRepository;
import edu.miu.cs.cs544.MicroserviceProject.service.IJobService;
import edu.miu.cs.cs544.MicroserviceProject.service.utilities.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements IJobService {

    @Autowired
    private IJobRepository iJobRepository;

    @Override
    public ResponseDTO getAllJobs() {
        System.out.println(this.getClass().getName() + "[srvc][coach.get.all][ini]");
        try {
            List<Job> jobs = iJobRepository.findAll();
            System.out.println(this.getClass().getName() + "[srvc][coach.get.all][end]");
            return new ResponseService(HttpStatus.OK.value(), null, new ListDTO<>(jobs)).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.get.all][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public Optional<Job> getJobById(int id) {
        return iJobRepository.findById(id);
    }

    @Override
    public Job addJobs(Job job) {
        return iJobRepository.save(job);
    }
}
