package com.edu.miu.cs544.tminstructor.model;

import com.edu.miu.cs544.tminstructor.dto.IGeneralDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Student implements IGeneralDTO {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "student")
    private List<TmAttendance> attendances;

    @OneToMany(mappedBy = "student")
    private List<TmRecord> tmRecords;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private TmInstructor instructor;

    public Student() {
    }
    public Student(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
