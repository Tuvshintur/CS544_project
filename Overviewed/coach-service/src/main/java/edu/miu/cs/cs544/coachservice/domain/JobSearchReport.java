package edu.miu.cs.cs544.coachservice.domain;

import edu.miu.cs.cs544.coachservice.DTO.IGeneralDTO;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class JobSearchReport implements IGeneralDTO {
    @Id
    @GeneratedValue
    private int id;
    private boolean isJobSearching;
    @Column(length=1000)
    private String searchReport;
    private Date date;
    @OneToOne
    private Coach coach;
    private int student_id;

    public JobSearchReport() {
    }

    public JobSearchReport(boolean isJobSearching, Coach coach) {
        this.isJobSearching = isJobSearching;
        this.coach = coach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isJobSearching() {
        return isJobSearching;
    }

    public void setJobSearching(boolean jobSearching) {
        isJobSearching = jobSearching;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public String getSearchReport() {
        return searchReport;
    }

    public void setSearchReport(String searchReport) {
        this.searchReport = searchReport;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
}
