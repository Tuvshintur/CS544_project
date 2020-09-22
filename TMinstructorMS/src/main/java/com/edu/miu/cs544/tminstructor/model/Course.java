package com.edu.miu.cs544.tminstructor.model;

import java.util.List;

public class Course {

    private Integer id;

    private String title;

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
