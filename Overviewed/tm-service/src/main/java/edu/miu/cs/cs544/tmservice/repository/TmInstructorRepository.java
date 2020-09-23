package edu.miu.cs.cs544.tmservice.repository;

import edu.miu.cs.cs544.tmservice.model.TmInstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TmInstructorRepository extends JpaRepository<TmInstructor, Integer> {

    List<TmInstructor> findAll();

    TmInstructor findById(int id);

    void deleteTmInstructorById(int id);
}
