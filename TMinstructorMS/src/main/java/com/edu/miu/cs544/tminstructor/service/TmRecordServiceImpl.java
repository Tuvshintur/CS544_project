package com.edu.miu.cs544.tminstructor.service;

import com.edu.miu.cs544.tminstructor.dto.ListDTO;
import com.edu.miu.cs544.tminstructor.dto.ResponseDTO;
import com.edu.miu.cs544.tminstructor.model.TmInstructor;
import com.edu.miu.cs544.tminstructor.model.TmRecord;
import com.edu.miu.cs544.tminstructor.repository.TmRecordRepository;
import com.edu.miu.cs544.tminstructor.service.utility.ResponseService;
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
            List<TmRecord> tmRecords =  tmRecordRepository.findAll();
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
//
//    @Override
//    public TmInstructor getTmInstructorByIdReturnTmInstructor(int id) {
//        return tmInstructorRepository.findById(id);
//    }

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
