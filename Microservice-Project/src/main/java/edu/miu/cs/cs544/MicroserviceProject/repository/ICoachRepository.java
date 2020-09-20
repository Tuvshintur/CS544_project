package edu.miu.cs.cs544.MicroserviceProject.repository;

import edu.miu.cs.cs544.MicroserviceProject.domain.Coach;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICoachRepository extends JpaRepository<Coach, Integer> {
    List<Coach> findAll();
}
