package com.edu.miu.cs544.tminstructor.model;

import com.edu.miu.cs544.tminstructor.dto.IGeneralDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TmRecord implements IGeneralDTO {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer student;

    private Integer instructor;

    @Temporal(TemporalType.DATE)
    private Date dateOfTmChecking;

    public TmRecord() {
    }

    public TmRecord(Integer student, Integer instructor) {
        this.student = student;
        this.instructor = instructor;
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public Integer getInstructor() {
        return instructor;
    }

    public void setInstructor(Integer instructor) {
        this.instructor = instructor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfTmChecking() {
        return dateOfTmChecking;
    }

    public void setDateOfTmChecking(Date dateOfTmChecking) {
        this.dateOfTmChecking = dateOfTmChecking;
    }

}

