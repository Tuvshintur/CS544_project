package edu.miu.cs.cs544.coachservice.service;

import edu.miu.cs.cs544.coachservice.domain.JobSearchReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSearchReportRepository extends JpaRepository<JobSearchReport, Integer> {

    List<JobSearchReport> findAll();

    JobSearchReport findById(int id);

    void deleteCPTReportById(int id);
}
