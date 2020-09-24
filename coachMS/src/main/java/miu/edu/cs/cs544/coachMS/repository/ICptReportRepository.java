package miu.edu.cs.cs544.coachMS.repository;



import miu.edu.cs.cs544.coachMS.DTO.ResponseDTO;
import miu.edu.cs.cs544.coachMS.domain.CptReport;
import miu.edu.cs.cs544.coachMS.domain.JobResearchReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICptReportRepository extends JpaRepository<CptReport, Integer> {
    ResponseDTO deleteCoachById(int id);
//    ResponseDTO findById(int id);
//
//    CptReport getCptByIdReturnCoach(int id);
}
