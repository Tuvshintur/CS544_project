package miu.edu.cs.cs544.coachMS.repository;

import miu.edu.cs.cs544.coachMS.domain.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICoachRepository extends JpaRepository<Coach, Integer> {
    List<Coach> findAll();

    Coach findById(int id);

    void deleteCoachById(int id);

    
}
