package edu.miu.cs.cs544.MicroserviceProject.domain;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "coach")
public class Coach {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String responsibility;
    private Date hiringDate;
    private String office;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    public Coach() {
    }

    public Coach(String name, String responsibility, Date hiringDate, String office) {
        this.name = name;
        this.responsibility = responsibility;
        this.hiringDate = hiringDate;
        this.office = office;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public Date getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
