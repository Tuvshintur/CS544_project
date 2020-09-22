package com.edu.miu.cs544.tminstructor.model;

import com.edu.miu.cs544.tminstructor.dto.IGeneralDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TmRecord implements IGeneralDTO {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer student_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_id")
    private TmInstructor instructor;

    @Temporal(TemporalType.DATE)
    private Date dateOfTmChecking;

    public TmRecord() {
    }

    public TmRecord(Integer student, TmInstructor tmInstructor, Date dateOfTmChecking) {
        this.student_id = student_id;
        this.instructor = tmInstructor;
        this.dateOfTmChecking = dateOfTmChecking;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public TmInstructor getInstructor() {
        return instructor;
    }

    public void setInstructor(TmInstructor instructor) {
        this.instructor = instructor;
    }

    public TmInstructor getTmInstructor() {
        return instructor;
    }

    public void setTmInstructor(TmInstructor tmInstructor) {
        this.instructor = tmInstructor;
    }

    public Date getDateOfTmChecking() {
        return dateOfTmChecking;
    }

    public void setDateOfTmChecking(Date dateOfTmChecking) {
        this.dateOfTmChecking = dateOfTmChecking;
    }

}

