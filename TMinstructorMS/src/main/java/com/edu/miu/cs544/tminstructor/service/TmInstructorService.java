package com.edu.miu.cs544.tminstructor.service;

import com.edu.miu.cs544.tminstructor.dto.ResponseDTO;
import com.edu.miu.cs544.tminstructor.model.TmInstructor;

public interface TmInstructorService {

    ResponseDTO getAllTmInstructors();
    ResponseDTO getTmInstructorById(int id);
    TmInstructor getTmInstructorByIdReturnTmInstructor(int id);
    ResponseDTO addTmInstructor(TmInstructor tmInstructor);
    ResponseDTO updateTmInstrcutor(TmInstructor tmInstructor);
    ResponseDTO deleteTmInstructorById(int id);

}
