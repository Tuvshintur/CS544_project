package edu.miu.cs.cs544.MicroserviceProject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Coach {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String responsibility;

    private Date hiringDate;
    private String office;

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Coach() {
    }

    public Coach(String name, String responsibility, Date hiringDate, String office) {
        this.name = name;
        this.responsibility = responsibility;
        this.hiringDate = hiringDate;
        this.office = office;
    }
}
