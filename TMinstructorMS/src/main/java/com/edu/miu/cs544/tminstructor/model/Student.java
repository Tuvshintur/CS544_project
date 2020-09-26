package com.edu.miu.cs544.tminstructor.model;

import com.edu.miu.cs544.tminstructor.dto.IGeneralDTO;

import javax.persistence.OneToMany;
import java.util.List;

public class Student implements IGeneralDTO {

    private Integer id;

    private String name;

    private List<TmAttendance> attendances;

  //  @OneToMany(mappedBy = "student")
    private List<TmRecord> tmRecords;

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
