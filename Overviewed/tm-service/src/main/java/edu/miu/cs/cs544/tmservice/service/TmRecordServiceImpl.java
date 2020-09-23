package edu.miu.cs.cs544.tmservice.service;

import edu.miu.cs.cs544.tmservice.dto.ListDTO;
import edu.miu.cs.cs544.tmservice.dto.ResponseDTO;
import edu.miu.cs.cs544.tmservice.model.TmRecord;
import edu.miu.cs.cs544.tmservice.repository.TmRecordRepository;
import edu.miu.cs.cs544.tmservice.service.utility.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TmRecordServiceImpl implements TmRecordService {
    private TmRecordRepository tmRecordRepository;

    @Autowired
    public TmRecordServiceImpl(TmRecordRepository tmRecordRepository) {
        this.tmRecordRepository = tmRecordRepository;
    }

    @Override
    public ResponseDTO getAllTmRecords() {
        try {
            List<TmRecord> tmRecords = tmRecordRepository.findAll();
            return new ResponseService(HttpStatus.OK.value(), null, new ListDTO<>(tmRecords)).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.get.all][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO getTmRecordById(int id) {
        try {
            TmRecord tmRecord = tmRecordRepository.findById(id);
            return new ResponseService(HttpStatus.OK.value(), null, tmRecord).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.get.CoachById][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO addTmRecord(TmRecord tmRecord) {
        try {
            tmRecordRepository.save(tmRecord);
            return new ResponseService(HttpStatus.OK.value(), null, tmRecord).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.save.addCoach][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO updateTmRecord(TmRecord tmRecord) {
        try {
            tmRecordRepository.save(tmRecord);
            return new ResponseService(HttpStatus.OK.value(), null, tmRecord).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.update.updateCoach][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO deleteTmRecordById(int id) {
        try {
            tmRecordRepository.deleteTmRecordById(id);
            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.delete][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }
}
