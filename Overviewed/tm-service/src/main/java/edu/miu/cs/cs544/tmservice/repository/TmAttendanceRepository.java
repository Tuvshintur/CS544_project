package edu.miu.cs.cs544.tmservice.repository;

import edu.miu.cs.cs544.tmservice.model.TmAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TmAttendanceRepository extends JpaRepository<TmAttendance, Integer> {

    List<TmAttendance> findAll();

    TmAttendance findById(int id);

    void deleteTmAttendanceById(int id);

}
