package com.edu.miu.cs544.tminstructor.model;

import com.edu.miu.cs544.tminstructor.dto.IGeneralDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TmRecord implements IGeneralDTO {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_id")
    private TmInstructor instructor;

    @Temporal(TemporalType.DATE)
    private Date dateOfTmChecking;

    public TmRecord() {
    }

    public TmRecord(Student student, TmInstructor tmInstructor, Date dateOfTmChecking) {
        this.student = student;
        this.instructor = tmInstructor;
        this.dateOfTmChecking = dateOfTmChecking;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

