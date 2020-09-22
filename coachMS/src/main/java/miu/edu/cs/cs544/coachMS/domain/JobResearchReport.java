package miu.edu.cs.cs544.coachMS.domain;


import miu.edu.cs.cs544.coachMS.DTO.IGeneralDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "jobResearchReport")
public class JobResearchReport implements IGeneralDTO {

    @Id
    @GeneratedValue
    private int id;

    private boolean isJobSearching;

    @OneToOne
    private Coach coach;

    public JobResearchReport(int id, boolean isJobSearching, Coach coach) {
        this.id = id;
        this.isJobSearching = isJobSearching;
        this.coach = coach;
    }

    public JobResearchReport() {
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
