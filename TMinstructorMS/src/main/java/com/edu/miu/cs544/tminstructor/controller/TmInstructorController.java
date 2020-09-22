package com.edu.miu.cs544.tminstructor.controller;

import com.edu.miu.cs544.tminstructor.model.TmInstructor;
import com.edu.miu.cs544.tminstructor.service.TmInstructorService;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/tm-instructor")

public class TmInstructorController {
    @Autowired
    private TmInstructorService tmInstructorService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/students")
    public String getAllTmInstructors(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON) );
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://student-service/students/All", HttpMethod.GET, entity, String.class).getBody();
    }

    
}
