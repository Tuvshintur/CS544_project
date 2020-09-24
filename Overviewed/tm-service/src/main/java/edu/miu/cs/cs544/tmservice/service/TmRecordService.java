package edu.miu.cs.cs544.tmservice.service;


import edu.miu.cs.cs544.tmservice.dto.ResponseDTO;
import edu.miu.cs.cs544.tmservice.model.TmRecord;

public interface TmRecordService {

    public ResponseDTO getAllTmRecords();

    public ResponseDTO getTmRecordById(int id);

    public ResponseDTO addTmRecord(TmRecord tmRecord);

    public ResponseDTO updateTmRecord(TmRecord tmRecord);

    public ResponseDTO deleteTmRecordById(int id);
}
