package com.edu.miu.cs544.tminstructor.model;

import com.edu.miu.cs544.tminstructor.dto.IGeneralDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class TmAttendance implements IGeneralDTO {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private Date date;
    private boolean isAttended;

    public TmAttendance() {
    }

    public TmAttendance(Student student, Course course, Date date, boolean isAttended) {
        this.student = student;
        this.course = course;
        this.date = date;
        this.isAttended = isAttended;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isAttended() {
        return isAttended;
    }

    public void setAttended(boolean attended) {
        isAttended = attended;
    }
}
