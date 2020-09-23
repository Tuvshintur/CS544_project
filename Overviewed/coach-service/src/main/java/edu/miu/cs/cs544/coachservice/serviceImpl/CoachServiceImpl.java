package edu.miu.cs.cs544.coachservice.serviceImpl;

import edu.miu.cs.cs544.coachservice.DTO.ListDTO;
import edu.miu.cs.cs544.coachservice.DTO.ResponseDTO;
import edu.miu.cs.cs544.coachservice.domain.Coach;
import edu.miu.cs.cs544.coachservice.repository.CoachRepository;
import edu.miu.cs.cs544.coachservice.service.CoachService;
import edu.miu.cs.cs544.coachservice.serviceImpl.utilities.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {

    @Autowired
    CoachRepository coachRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public ResponseDTO getAllCoaches() {
        LOGGER.info("[srvc][coach.get.all][ini]");
        try {
            List<Coach> coaches = coachRepository.findAll();
            LOGGER.info("[srvc][coach.get.all][end]");
            return new ResponseService(HttpStatus.OK.value(), null, new ListDTO<>(coaches)).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][coach.get.all][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO getCoachById(int id) {
        LOGGER.info("[srvc][coach.get.CoachById][ini]");
        try {
            Coach coach = coachRepository.findById(id);
            LOGGER.info("[srvc][coach.get.CoachById][end]");
            return new ResponseService(HttpStatus.OK.value(), null, coach).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][coach.get.CoachById][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public Coach getCoachByIdReturnCoach(int id) {
        return coachRepository.findById(id);
    }

    @Override
    public ResponseDTO addCoach(Coach coach) {
        LOGGER.info("[srvc][coach.save.addCoach][ini]");
        try {
            coachRepository.save(coach);
            LOGGER.info("[srvc][coach.save.addCoach][end]");
            return new ResponseService(HttpStatus.OK.value(), null, coach).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][coach.save.addCoach][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO updateCoach(Coach coach) {
        LOGGER.info("[srvc][coach.update.updateCoach][ini]");
        try {
            coachRepository.save(coach);
            LOGGER.info("[srvc][coach.update.updateCoach][end]");
            return new ResponseService(HttpStatus.OK.value(), null, coach).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][coach.update.updateCoach][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    @Transactional
    public ResponseDTO deleteCoachById(int id) {
        LOGGER.info("[srvc][coach.delete][ini]");
        try {
            coachRepository.deleteCoachById(id);
            LOGGER.info("[srvc][coach.delete][end]");
            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();
        } catch (Exception ex) {
            LOGGER.error("[srvc][coach.delete][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }
}
