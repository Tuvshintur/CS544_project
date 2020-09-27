package com.edu.miu.cs544.tminstructor.repository;

import com.edu.miu.cs544.tminstructor.model.TmInstructor;
import com.edu.miu.cs544.tminstructor.model.TmRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TmRecordRepository extends JpaRepository<TmRecord, Integer> {
    //List<TmRecord> findAll();
    TmRecord findById(int id);
    void deleteTmRecordById(int id);
}
