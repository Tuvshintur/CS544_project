package edu.miu.cs.cs544.coachservice.service;

import edu.miu.cs.cs544.coachservice.DTO.ResponseDTO;
import edu.miu.cs.cs544.coachservice.domain.Coach;

public interface CoachService {

    ResponseDTO getAllCoaches();

    ResponseDTO getCoachById(int id);

    Coach getCoachByIdReturnCoach(int id);

    ResponseDTO addCoach(Coach coach);

    ResponseDTO updateCoach(Coach coach);

    ResponseDTO deleteCoachById(int id);
}
