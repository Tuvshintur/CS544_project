package com.edu.miu.cs544.tminstructor.service;

import com.edu.miu.cs544.tminstructor.dto.ResponseDTO;
import com.edu.miu.cs544.tminstructor.model.TmInstructor;

public interface TmInstructorService {

    public ResponseDTO getAllTmInstructors();
    public ResponseDTO getTmInstructorById(int id);
    TmInstructor getTmInstructorByIdReturnTmInstructor(int id);
    public ResponseDTO addTmInstructor(TmInstructor tmInstructor);
    public ResponseDTO updateTmInstrcutor(TmInstructor tmInstructor);
    public ResponseDTO deleteTmInstructorById(int id);

}
