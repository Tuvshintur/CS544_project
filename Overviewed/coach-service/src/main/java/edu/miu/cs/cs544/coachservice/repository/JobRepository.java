package edu.miu.cs.cs544.coachservice.repository;

import edu.miu.cs.cs544.coachservice.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    List<Job> findAll();

    Job findById(int id);

    void deleteJobById(int id);
}
