package edu.miu.cs.cs544.tmservice.service;


import edu.miu.cs.cs544.tmservice.dto.ResponseDTO;
import edu.miu.cs.cs544.tmservice.model.TmAttendance;

public interface TmAttendanceService {

    public ResponseDTO getAllTmAttendces();

    public ResponseDTO getTmAttendanceById(int id);

    public ResponseDTO addTmAttendance(TmAttendance tmAttendance);

    public ResponseDTO updateTmAttendance(TmAttendance tmAttendance);

    public ResponseDTO deleteTmAttendanceById(int id);
}
