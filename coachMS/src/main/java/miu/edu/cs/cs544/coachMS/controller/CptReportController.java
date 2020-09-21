package miu.edu.cs.cs544.coachMS.controller;


import io.swagger.annotations.Api;
import miu.edu.cs.cs544.coachMS.DTO.ErrorDTO;
import miu.edu.cs.cs544.coachMS.DTO.ResponseDTO;
import miu.edu.cs.cs544.coachMS.constants.Constants;
import miu.edu.cs.cs544.coachMS.domain.CptReport;
import miu.edu.cs.cs544.coachMS.service.ICptReportService;
import miu.edu.cs.cs544.coachMS.service.utilities.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cpt")
@Api(tags="CPT")
public class CptReportController {

    ICptReportService iCptReportService;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CptReportController(ICptReportService iCptReportService) {
        this.iCptReportService = iCptReportService;
    }


    @RequestMapping(value = "/allcpts", method = RequestMethod.GET)
    public ResponseDTO getCpts() {
        try {
            LOGGER.info("[ctrl][coach][getCoaches][ini]");
            ResponseDTO responseDTO = iCptReportService.getAllCptReport();
            LOGGER.info("[ctrl][coach][getCoaches][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][getCoaches][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseDTO getCptById(@PathVariable("id") int id) {
        try {
            LOGGER.info("[ctrl][coach][getCoachById][ini]");
            ResponseDTO responseDTO = iCptReportService.getCptById(id);
            LOGGER.info("[ctrl][cpt][getCptById][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][cpt][getCptById][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseDTO addCoach(@RequestBody CptReport cptReport) {
        try {
            LOGGER.info("[ctrl][coach][addCoach][ini]");
            ResponseDTO responseDTO = iCptReportService.addCptReport(cptReport);
            LOGGER.info("[ctrl][coach][addCoach][end]");

            return responseDTO;
        } catch (Exception ex) {
            LOGGER.error("[ctrl][coach][addCoach][unknown][ " + ex.getMessage() + "]");
            throw ex;
        }
    }

    @RequestMapping(value = "/{cptId}", method = RequestMethod.PUT)
    public ResponseDTO updateCoach(@PathVariable("cptId") int cptId, @RequestBody CptReport cptReport) {
//        try {
//            LOGGER.info("[ctrl][coach][updateCoach][ini]");
//
//            CptReport currentCpt = iCptReportService.getCptByIdReturnCoach(cptId);
//
//            currentCpt.setId(currentCpt.getId());
//            ResponseDTO responseDTO = iCptReportService.updateCptReport(currentCpt);
//
//            LOGGER.info("[ctrl][coach][updateCoach][end]");
//
//            return responseDTO;
//        } catch (Exception ex) {
//            LOGGER.error("[ctrl][coach][updateCoach][unknown][ " + ex.getMessage() + "]");
//            throw ex;
//        }

        return null;
    }

    @RequestMapping(value = "/{cptId}", method = RequestMethod.DELETE)
    public ResponseDTO deleteProject(@PathVariable("cptId") int cptId) {
        try {
            LOGGER.info("[ctrl][project][deleteProject][ini]");

            iCptReportService.deleteCptReportById(cptId);

            LOGGER.info("[ctrl][project][deleteProject][end]");

            return new ResponseService(HttpStatus.OK.value(), null, null).getResponse();

        } catch (Exception ex) {
            LOGGER.error("[ctrl][project][deleteProject][unknown][ " + ex.getMessage() + "]");
            return new ResponseService(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, new ErrorDTO(null, ex.getMessage(), Constants.ErrorType.UNKNOWN)).getError();
        }

    }


}
