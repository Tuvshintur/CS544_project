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

import javax.transaction.Transactional;
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
        System.out.println(this.getClass().getName() + "[srvc][coach.get.CoachById][ini]");
        try {
            Coach coach = coachRepository.findById(id);
            System.out.println(this.getClass().getName() + "[srvc][coach.get.CoachById][end]");
            return new ResponseService(HttpStatus.OK.value(), null, coach).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.get.CoachById][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public Coach getCoachByIdReturnCoach(int id) {
        return coachRepository.findById(id);
    }

    @Override
    public ResponseDTO addCoach(Coach coach) {
        System.out.println(this.getClass().getName() + "[srvc][coach.save.addCoach][ini]");
        try {
            coachRepository.save(coach);
            System.out.println(this.getClass().getName() + "[srvc][coach.save.addCoach][end]");
            return new ResponseService(HttpStatus.OK.value(), null, coach).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.save.addCoach][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO updateCoach(Coach coach) {
        System.out.println(this.getClass().getName() + "[srvc][coach.update.updateCoach][ini]");
        try {
            coachRepository.save(coach);
            System.out.println(this.getClass().getName() + "[srvc][coach.update.updateCoach][end]");
            return new ResponseService(HttpStatus.OK.value(), null, coach).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.update.updateCoach][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    @Transactional
    public ResponseDTO deleteCoachById(int id) {
        System.out.println(this.getClass().getName() + "[srvc][coach.delete][ini]");

        try {
            coachRepository.deleteCoachById(id);
            System.out.println(this.getClass().getName() + "[srvc][coach.delete][end]");
            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.delete][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

}
