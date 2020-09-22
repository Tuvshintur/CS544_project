package miu.edu.cs.cs544.coachMS.repository;

import miu.edu.cs.cs544.coachMS.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobRepository extends JpaRepository<Job, Integer> {

    Job findById(int id);

    void deleteJobById(int id);
}
