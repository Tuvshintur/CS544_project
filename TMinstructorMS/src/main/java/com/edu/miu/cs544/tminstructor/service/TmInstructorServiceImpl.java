package com.edu.miu.cs544.tminstructor.service;

import com.edu.miu.cs544.tminstructor.dto.IGeneralDTO;
import com.edu.miu.cs544.tminstructor.dto.ListDTO;
import com.edu.miu.cs544.tminstructor.dto.ResponseDTO;
import com.edu.miu.cs544.tminstructor.model.Student;
import com.edu.miu.cs544.tminstructor.model.TmInstructor;
import com.edu.miu.cs544.tminstructor.repository.TmInstructorRepository;
import com.edu.miu.cs544.tminstructor.service.utility.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TmInstructorServiceImpl implements TmInstructorService {

    TmInstructorRepository tmInstructorRepository;

    @Autowired
    public void TmInstructorerviceImpl(TmInstructorRepository tmInstructorRepository) {
        this.tmInstructorRepository = tmInstructorRepository;
    }

    @Override
    public ResponseDTO getAllTmInstructors() {
        try {
            List<TmInstructor> tmInstructors =  tmInstructorRepository.findAll();
            return new ResponseService(HttpStatus.OK.value(), null, new ListDTO<>(tmInstructors)).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.get.all][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO getTmInstructorById(int id) {
        try {
            TmInstructor tmInstructor = tmInstructorRepository.findById(id);
            return new ResponseService(HttpStatus.OK.value(), null, tmInstructor).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.get.CoachById][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public TmInstructor getTmInstructorByIdReturnTmInstructor(int id) {
        return tmInstructorRepository.findById(id);
    }

    @Override
    public ResponseDTO addTmInstructor(TmInstructor tmInstructor) {
        try {
            tmInstructorRepository.save(tmInstructor);
            return new ResponseService(HttpStatus.OK.value(), null, tmInstructor).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.save.addCoach][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @Override
    public ResponseDTO updateTmInstrcutor(TmInstructor tmInstructor) {
        try {
            tmInstructorRepository.save(tmInstructor);
            return new ResponseService(HttpStatus.OK.value(), null, tmInstructor).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.update.updateCoach][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }
    @Override
    public ResponseDTO deleteTmInstructorById(int id) {
        try {
            tmInstructorRepository.deleteCoachById(id);
            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[srvc][coach.delete][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }
}
