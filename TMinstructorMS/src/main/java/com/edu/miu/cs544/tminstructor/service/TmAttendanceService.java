package com.edu.miu.cs544.tminstructor.service;

import com.edu.miu.cs544.tminstructor.dto.ResponseDTO;
import com.edu.miu.cs544.tminstructor.model.TmAttendance;
import com.edu.miu.cs544.tminstructor.model.TmInstructor;

public interface TmAttendanceService {
    public ResponseDTO getAllTmAttendces();
    public ResponseDTO getTmAttendanceById(int id);
    public ResponseDTO addTmAttendance(TmAttendance tmAttendance);
    public ResponseDTO updateTmAttendance(TmAttendance tmAttendance);
    public ResponseDTO deleteTmAttendanceById(int id);
}
