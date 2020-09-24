package edu.miu.cs.cs544.coachservice.repository;

import edu.miu.cs.cs544.coachservice.domain.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoachRepository extends JpaRepository<Coach,Integer> {

    List<Coach> findAll();

    Coach findById(int id);

    void deleteCoachById(int id);
}
