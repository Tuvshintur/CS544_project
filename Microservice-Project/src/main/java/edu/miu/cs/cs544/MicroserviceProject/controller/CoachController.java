package edu.miu.cs.cs544.MicroserviceProject.controller;

import edu.miu.cs.cs544.MicroserviceProject.DTO.ResponseDTO;
import edu.miu.cs.cs544.MicroserviceProject.service.ICoachService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coach")
@Api(tags="COACH")
public class CoachController {
    ICoachService service;

    @Autowired
    public CoachController(ICoachService service) {
        this.service = service;
    }

    @RequestMapping(value = "/getCoaches", method = RequestMethod.GET)
//    @PreAuthorize("hasRole('ROLE_CLIENT') or  hasRole('ROLE_ADMIN')")
    public ResponseDTO getCoaches() {
        try {
            System.out.println(this.getClass().getName() + "[ctrl][coach][getCoaches][ini]");
            ResponseDTO responseDTO = service.getAllCoaches();
            System.out.println(this.getClass().getName() + "[ctrl][coach][getCoaches][end]");

            return responseDTO;
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[ctrl][coach][getCoaches][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }
}

