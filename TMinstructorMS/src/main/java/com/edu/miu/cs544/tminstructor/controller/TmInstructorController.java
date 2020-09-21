package com.edu.miu.cs544.tminstructor.controller;

import com.edu.miu.cs544.tminstructor.model.TmInstructor;
import com.edu.miu.cs544.tminstructor.service.TmInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tm-instructor")
public class TmInstructorController {
    @Autowired
    private TmInstructorService tmInstructorService;

//    @GetMapping("/all")
//    public List<TmInstructor> getAllTmInstructors(){
//        return tmInstructorService.getTmInstructors();
//    }
}
