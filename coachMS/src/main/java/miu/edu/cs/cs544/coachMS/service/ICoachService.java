package miu.edu.cs.cs544.coachMS.service;

import miu.edu.cs.cs544.coachMS.DTO.ResponseDTO;
import miu.edu.cs.cs544.coachMS.domain.Coach;
import miu.edu.cs.cs544.coachMS.domain.CptReport;
import miu.edu.cs.cs544.coachMS.domain.Job;

public interface ICoachService {
    ResponseDTO getAllCoaches();

    ResponseDTO getCoachById(int id);

    Coach getCoachByIdReturnCoach(int id);

    ResponseDTO addCoach(Coach coach);

    ResponseDTO updateCoach(Coach coach);

    ResponseDTO deleteCoachById(int id);

//    ResponseDTO addJob(Job job);

}
