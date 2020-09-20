package edu.miu.cs.cs544.MicroserviceProject.service;

import edu.miu.cs.cs544.MicroserviceProject.DTO.ResponseDTO;

public interface ICoachService {
    ResponseDTO getAllCoaches();

    ResponseDTO getCoachById(int id);
}
