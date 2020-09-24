package edu.miu.cs.cs544.coachservice.repository;

import edu.miu.cs.cs544.coachservice.domain.CPTReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CPTReportRepository extends JpaRepository<CPTReport, Integer> {

    List<CPTReport> findAll();

    CPTReport findById(int id);

    void deleteCPTReportById(int id);
}
