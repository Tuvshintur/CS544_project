package miu.edu.cs.cs544.coachMS.domain;

import miu.edu.cs.cs544.coachMS.DTO.IGeneralDTO;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "jobResearchReport")
public class JobResearchReport implements IGeneralDTO {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private boolean isJobSearching;

    private String student_id;

    @OneToOne
    private Coach coach;


    public JobResearchReport(int id, String name, Date date, boolean isJobSearching, String student_id, Coach coach) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.isJobSearching = isJobSearching;
        this.student_id = student_id;
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
