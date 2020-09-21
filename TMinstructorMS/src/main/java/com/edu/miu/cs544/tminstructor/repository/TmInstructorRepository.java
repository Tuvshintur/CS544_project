package com.edu.miu.cs544.tminstructor.repository;

import com.edu.miu.cs544.tminstructor.model.TmInstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TmInstructorRepository extends JpaRepository<TmInstructor,Integer> {

}
