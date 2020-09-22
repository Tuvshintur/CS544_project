package com.edu.miu.cs544.tminstructor.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;

    @OneToMany(mappedBy = "course")
    private List<TmAttendance> attendances;

    public Course() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
