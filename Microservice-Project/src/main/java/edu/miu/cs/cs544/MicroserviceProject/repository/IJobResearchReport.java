package edu.miu.cs.cs544.MicroserviceProject.repository;

import edu.miu.cs.cs544.MicroserviceProject.domain.CptReport;
import edu.miu.cs.cs544.MicroserviceProject.domain.JobResearchReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobResearchReport extends JpaRepository<JobResearchReport, Integer> {
}
