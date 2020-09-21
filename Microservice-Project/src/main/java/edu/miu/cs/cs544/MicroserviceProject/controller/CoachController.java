package edu.miu.cs.cs544.MicroserviceProject.controller;

import edu.miu.cs.cs544.MicroserviceProject.DTO.ErrorDTO;
import edu.miu.cs.cs544.MicroserviceProject.DTO.ResponseDTO;
import edu.miu.cs.cs544.MicroserviceProject.constants.Constants;
import edu.miu.cs.cs544.MicroserviceProject.domain.Coach;
import edu.miu.cs.cs544.MicroserviceProject.service.ICoachService;
import edu.miu.cs.cs544.MicroserviceProject.service.utilities.ResponseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coach")
@Api(tags="COACH")
public class CoachController {
    ICoachService service;

    @Autowired
    public CoachController(ICoachService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseDTO getCoachById(@PathVariable("id") int id) {
        try {
            System.out.println(this.getClass().getName() + "[ctrl][coach][getCoachById][ini]");
            ResponseDTO responseDTO = service.getCoachById(id);
            System.out.println(this.getClass().getName() + "[ctrl][coach][getCoachById][end]");

            return responseDTO;
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[ctrl][coach][getCoachById][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseDTO addCoach(@RequestBody Coach coach) {
        try {
            System.out.println(this.getClass().getName() + "[ctrl][coach][addCoach][ini]");
            ResponseDTO responseDTO = service.addCoach(coach);
            System.out.println(this.getClass().getName() + "[ctrl][coach][addCoach][end]");

            return responseDTO;
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[ctrl][coach][addCoach][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @RequestMapping(value = "/{coachId}", method = RequestMethod.PUT)
    public ResponseDTO updateCoach(@PathVariable("coachId") int coachId, @RequestBody Coach coach) {
        try {
            System.out.println(this.getClass().getName() + "[ctrl][coach][updateCoach][ini]");

            Coach currentCoach = service.getCoachByIdReturnCoach(coachId);

            coach.setId(currentCoach.getId());
            ResponseDTO responseDTO = service.updateCoach(currentCoach);

            System.out.println(this.getClass().getName() + "[ctrl][coach][updateCoach][end]");

            return responseDTO;
        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[ctrl][coach][updateCoach][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @RequestMapping(value = "/{coachId}", method = RequestMethod.DELETE)
    public ResponseDTO deleteProject(@PathVariable("coachId") int coachId) {
        try {
            System.out.println(this.getClass().getName() + "[ctrl][project][deleteProject][ini]");

            service.deleteCoachById(coachId);

            System.out.println(this.getClass().getName() + "[ctrl][project][deleteProject][end]");

            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();

        } catch (Exception ex) {
            System.out.println(this.getClass().getName() + "[ctrl][project][deleteProject][unknown][ " + ex.getMessage() + "]");
            return new ResponseService(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, new ErrorDTO(null, ex.getMessage(), Constants.ErrorType.UNKNOWN)).getError();
        }
    }

}