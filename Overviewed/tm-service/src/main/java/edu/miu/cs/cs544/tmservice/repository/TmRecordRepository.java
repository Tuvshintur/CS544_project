package edu.miu.cs.cs544.tmservice.repository;

import edu.miu.cs.cs544.tmservice.model.TmRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TmRecordRepository extends JpaRepository<TmRecord, Integer> {

    List<TmRecord> findAll();

    TmRecord findById(int id);

    void deleteTmRecordById(int id);
}
