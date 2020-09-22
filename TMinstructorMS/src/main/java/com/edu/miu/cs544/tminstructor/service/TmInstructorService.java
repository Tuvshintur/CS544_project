package com.edu.miu.cs544.tminstructor.service;

import com.edu.miu.cs544.tminstructor.dto.ResponseDTO;
import com.edu.miu.cs544.tminstructor.model.Student;
import com.edu.miu.cs544.tminstructor.model.TmInstructor;
import com.edu.miu.cs544.tminstructor.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface TmInstructorService {

    public ResponseDTO getAllTmInstructors();
    public ResponseDTO getTmInstructorById(int id);
    public ResponseDTO addTmInstructor(TmInstructor tmInstructor);
    public ResponseDTO updateTmInstrcutor(TmInstructor tmInstructor);
    public ResponseDTO deleteTmInstructorById(int id);

}
