package miu.edu.cs.cs544.coachMS.domain;

import miu.edu.cs.cs544.coachMS.DTO.IGeneralDTO;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "cptReport")
public class CptReport implements IGeneralDTO {

    @Id
    @GeneratedValue
    private int id;
    private Date date;


    private String report;

    @OneToOne(mappedBy = "cptReport")
    private Job job;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public CptReport() {
    }

    public CptReport(Date date, String report, Job job, Coach coach) {
        this.date = date;
        this.report = report;
        this.job = job;
        this.coach = coach;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Coach coach;


}
