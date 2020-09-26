package edu.miu.cs.cs544.MicroserviceProject.controller;

import edu.miu.cs.cs544.MicroserviceProject.domain.JobResearchReport;
import edu.miu.cs.cs544.MicroserviceProject.service.ICoachService;
import edu.miu.cs.cs544.MicroserviceProject.service.IJobResearchReportService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobresearchreport")
@Api(tags="JRR")
public class JobResearchReportController {


    IJobResearchReportService service;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public JobResearchReportController(IJobResearchReportService service) {
        this.service = service;
    }



}
