package miu.edu.cs.cs544.coachMS.repository;

import miu.edu.cs.cs544.coachMS.domain.JobResearchReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobResearchReport extends JpaRepository<JobResearchReport, Integer> {
}
