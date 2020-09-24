package edu.miu.cs.cs544.coachservice.domain;

import edu.miu.cs.cs544.coachservice.DTO.IGeneralDTO;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class CPTReport implements IGeneralDTO {

    @Id
    @GeneratedValue
    private int id;
    private Date date;
    private String report;

    @OneToOne(mappedBy = "cptReport")
    private Job job;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Coach coach;

    public CPTReport() {
    }

    public CPTReport(Date date, String report, Job job, Coach coach) {
        this.date = date;
        this.report = report;
        this.job = job;
        this.coach = coach;
    }

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
}
