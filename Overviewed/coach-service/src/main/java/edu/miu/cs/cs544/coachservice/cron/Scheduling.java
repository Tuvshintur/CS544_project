package edu.miu.cs.cs544.coachservice.cron;

import edu.miu.cs.cs544.coachservice.domain.Job;
import edu.miu.cs.cs544.coachservice.domain.JobSearchReport;
import edu.miu.cs.cs544.coachservice.domain.Student;
import edu.miu.cs.cs544.coachservice.service.JobSearchReportService;
import edu.miu.cs.cs544.coachservice.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Component
@EnableScheduling
public class Scheduling {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JobService jobService;

    @Autowired
    JobSearchReportService jobSearchReportService;

    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<>(headers);

    @Scheduled(cron = "0 0 */12 ? * *")
    public void scheduleTaskCPTReport() {
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        List<Job> jobList = jobService.getAllJobsEntity();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, -2);

        if(jobList!=null && jobList.size() > 0) {
            for (Job job : jobList) {
                if(job.getCptReport().getReport() ==null && job.getCptReport().getDate().before(calendar.getTime())) {
                    restTemplate.exchange("http://student-service/notice/" + job.getStudent_id(), HttpMethod.GET, null, Student.class).getBody();
                }
            }
        }
    }

    @Scheduled(cron = "0 0 */12 ? * *")
    public void scheduleTaskUsingJobSearchReport() {
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        List<JobSearchReport> jobSearchReports = jobSearchReportService.getAllJobSearchReportEntity();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -3);

        if(jobSearchReports!=null && jobSearchReports.size() > 0) {
            for (JobSearchReport jobSearchReport : jobSearchReports) {
                if(jobSearchReport.isJobSearching() && jobSearchReport.getDate().before(calendar.getTime())) {
                    restTemplate.exchange("http://student-service/noticeJob/" + jobSearchReport.getStudent_id(), HttpMethod.GET, null, Student.class).getBody();
                }
            }
        }
    }

}
