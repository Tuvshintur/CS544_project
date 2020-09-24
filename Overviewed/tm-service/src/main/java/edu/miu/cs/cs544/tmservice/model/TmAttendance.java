package edu.miu.cs.cs544.tmservice.model;


import edu.miu.cs.cs544.tmservice.dto.IGeneralDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TmAttendance implements IGeneralDTO {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer student_id;

    private Integer course_id;

    private Date date;

    private boolean isAttended;

    public TmAttendance() {
    }

    public TmAttendance(Integer student_id, Integer course_id, Date date, boolean isAttended) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.date = date;
        this.isAttended = isAttended;
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

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
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
