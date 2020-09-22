package com.edu.miu.cs544.tminstructor.repository;

import com.edu.miu.cs544.tminstructor.model.TmAttendance;
import com.edu.miu.cs544.tminstructor.model.TmInstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TmAttendanceRepository extends JpaRepository<TmAttendance,Integer > {
    List<TmAttendance> findAll();
    TmAttendance findById(int id);
    void deleteTmAttendanceById(int id);

}
