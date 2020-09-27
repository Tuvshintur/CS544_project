package com.edu.miu.cs544.tminstructor.service;

import com.edu.miu.cs544.tminstructor.dto.ResponseDTO;
import com.edu.miu.cs544.tminstructor.model.TmAttendance;
import com.edu.miu.cs544.tminstructor.model.TmInstructor;

public interface TmAttendanceService {
    ResponseDTO getAllTmAttendces();
    ResponseDTO getTmAttendanceById(int id);
    ResponseDTO addTmAttendance(TmAttendance tmAttendance);
    ResponseDTO updateTmAttendance(TmAttendance tmAttendance);
    ResponseDTO deleteTmAttendanceById(int id);
}
