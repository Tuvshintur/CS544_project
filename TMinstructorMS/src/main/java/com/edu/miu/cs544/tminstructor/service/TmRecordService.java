package com.edu.miu.cs544.tminstructor.service;

import com.edu.miu.cs544.tminstructor.dto.ResponseDTO;
import com.edu.miu.cs544.tminstructor.model.TmInstructor;
import com.edu.miu.cs544.tminstructor.model.TmRecord;

public interface TmRecordService {
    public ResponseDTO getAllTmRecords();
    public ResponseDTO getTmRecordById(int id);
    public ResponseDTO addTmRecord(TmRecord tmRecord);
    public ResponseDTO updateTmRecord(TmRecord tmRecord);
    public ResponseDTO deleteTmRecordById(int id);
}
