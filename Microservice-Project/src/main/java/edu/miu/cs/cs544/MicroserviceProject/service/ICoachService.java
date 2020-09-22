package edu.miu.cs.cs544.MicroserviceProject.service;

import edu.miu.cs.cs544.MicroserviceProject.DTO.ResponseDTO;
import edu.miu.cs.cs544.MicroserviceProject.domain.Coach;

public interface ICoachService {
    ResponseDTO getAllCoaches();

    ResponseDTO getCoachById(int id);

    Coach getCoachByIdReturnCoach(int id);

    ResponseDTO addCoach(Coach coach);

    ResponseDTO updateCoach(Coach coach);

    ResponseDTO deleteCoachById(int id);
}
