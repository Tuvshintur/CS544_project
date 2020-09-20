package edu.miu.cs.cs544.MicroserviceProject.repository;

import edu.miu.cs.cs544.MicroserviceProject.domain.CptReport;
import edu.miu.cs.cs544.MicroserviceProject.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobRepository extends JpaRepository<Job, Integer> {
}
