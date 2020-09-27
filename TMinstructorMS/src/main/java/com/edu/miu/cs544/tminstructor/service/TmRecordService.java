package com.edu.miu.cs544.tminstructor.service;

import com.edu.miu.cs544.tminstructor.dto.ResponseDTO;
import com.edu.miu.cs544.tminstructor.model.TmInstructor;
import com.edu.miu.cs544.tminstructor.model.TmRecord;

public interface TmRecordService {
    ResponseDTO getAllTmRecords();
    ResponseDTO getTmRecordById(int id);
    ResponseDTO addTmRecord(TmRecord tmRecord);
    ResponseDTO updateTmRecord(TmRecord tmRecord);
    ResponseDTO deleteTmRecordById(int id);
}
