package com.edu.miu.cs544.tminstructor.repository;

import com.edu.miu.cs544.tminstructor.model.TmInstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TmInstructorRepository extends JpaRepository<TmInstructor,Integer> {

    List<TmInstructor> findAll();
    TmInstructor findById(int id);
    void deleteCoachById(int id);
}
