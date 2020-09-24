package edu.miu.cs.cs544.tmservice.service;

import edu.miu.cs.cs544.tmservice.dto.ListDTO;
import edu.miu.cs.cs544.tmservice.dto.ResponseDTO;
import edu.miu.cs.cs544.tmservice.model.TmAttendance;
import edu.miu.cs.cs544.tmservice.repository.TmAttendanceRepository;
import edu.miu.cs.cs544.tmservice.service.utility.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TmAttendanceServiceImpl implements TmAttendanceService {

    TmAttendanceRepository tmAttendanceRepository;

    @Autowired
    public TmAttendanceServiceImpl(TmAttendanceRepository tmAttendanceRepository) {
        this.tmAttendanceRepository = tmAttendanceRepository;
    }

    @Override
    public ResponseDTO getAllTmAttendces() {
        try {
            List<TmAttendance> tmAttendances = tmAttendanceRepository.findAll();
            return new ResponseService(HttpStatus.OK.value(), null, new ListDTO<>(tmAttendances)).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][tmattendance.get.all][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO getTmAttendanceById(int id) {
        try {
            TmAttendance tmAttendance = tmAttendanceRepository.findById(id);
            return new ResponseService(HttpStatus.OK.value(), null, tmAttendance).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.get.CoachById][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO addTmAttendance(TmAttendance tmAttendance) {
        try {
            tmAttendanceRepository.save(tmAttendance);
            return new ResponseService(HttpStatus.OK.value(), null, tmAttendance).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.save.addCoach][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO updateTmAttendance(TmAttendance tmAttendance) {
        try {
            tmAttendanceRepository.save(tmAttendance);
            return new ResponseService(HttpStatus.OK.value(), null, tmAttendance).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.update.updateCoach][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO deleteTmAttendanceById(int id) {
        try {
            tmAttendanceRepository.deleteTmAttendanceById(id);
            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.delete][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }
}
