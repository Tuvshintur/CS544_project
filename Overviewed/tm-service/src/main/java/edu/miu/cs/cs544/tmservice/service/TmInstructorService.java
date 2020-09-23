package edu.miu.cs.cs544.tmservice.service;


import edu.miu.cs.cs544.tmservice.dto.ResponseDTO;
import edu.miu.cs.cs544.tmservice.model.TmInstructor;

public interface TmInstructorService {

    public ResponseDTO getAllTmInstructors();

    public ResponseDTO getTmInstructorById(int id);

    TmInstructor getTmInstructorByIdReturnTmInstructor(int id);

    public ResponseDTO addTmInstructor(TmInstructor tmInstructor);

    public ResponseDTO updateTmInstrcutor(TmInstructor tmInstructor);

    public ResponseDTO deleteTmInstructorById(int id);

}
