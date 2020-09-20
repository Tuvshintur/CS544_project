package edu.miu.cs.cs544.MicroserviceProject.serviceImpl;

import edu.miu.cs.cs544.MicroserviceProject.DTO.ListDTO;
import edu.miu.cs.cs544.MicroserviceProject.DTO.ResponseDTO;
import edu.miu.cs.cs544.MicroserviceProject.domain.Coach;
import edu.miu.cs.cs544.MicroserviceProject.repository.ICoachRepository;
import edu.miu.cs.cs544.MicroserviceProject.service.ICoachService;
import edu.miu.cs.cs544.MicroserviceProject.service.utilities.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CoachServiceImpl implements ICoachService {

    ICoachRepository coachRepository;

    @Autowired
    public CoachServiceImpl(ICoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public ResponseDTO getAllCoaches() {
        System.out.println(this.getClass().getName() + "[srvc][coach.get.all][ini]");
        try {
            List<Coach> coaches = coachRepository.findAll();
            System.out.println(this.getClass().getName() + "[srvc][coach.get.all][end]");
            return new ResponseService(HttpStatus.OK.value(), null, new ListDTO<>(coaches)).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.get.all][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO getCoachById(int id) {
        return null;
    }
}
