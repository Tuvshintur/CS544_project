package edu.miu.cs.cs544.MicroserviceProject.repository;

import edu.miu.cs.cs544.MicroserviceProject.domain.Coach;
import edu.miu.cs.cs544.MicroserviceProject.domain.CptReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICptReportRepository extends JpaRepository<CptReport, Integer> {
}
