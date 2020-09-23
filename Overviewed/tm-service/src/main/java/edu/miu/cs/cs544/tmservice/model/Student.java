package edu.miu.cs.cs544.tmservice.model;


import edu.miu.cs.cs544.tmservice.dto.IGeneralDTO;

import java.util.List;

public class Student implements IGeneralDTO {

    private Integer id;

    private String name;

    private List<TmAttendance> attendances;

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
