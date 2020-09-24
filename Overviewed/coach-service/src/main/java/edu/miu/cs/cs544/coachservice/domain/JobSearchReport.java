package edu.miu.cs.cs544.coachservice.domain;

import edu.miu.cs.cs544.coachservice.DTO.IGeneralDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class JobSearchReport implements IGeneralDTO {
    @Id
    @GeneratedValue
    private int id;
    private boolean isJobSearching;
    @OneToOne
    private Coach coach;

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
}
