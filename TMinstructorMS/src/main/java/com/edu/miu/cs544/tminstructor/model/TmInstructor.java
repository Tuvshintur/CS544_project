package com.edu.miu.cs544.tminstructor.model;

import com.edu.miu.cs544.tminstructor.dto.IGeneralDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class TmInstructor extends Employee implements IGeneralDTO {

    @OneToMany(mappedBy = "instructor")
    private List<Student> students;

    @OneToMany(mappedBy = "instructor")
    private List<TmRecord> tmRecords;

    public TmInstructor() {
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<TmRecord> getTmRecords() {
        return tmRecords;
    }

    public void setTmRecords(List<TmRecord> tmRecords) {
        this.tmRecords = tmRecords;
    }

    public void addStudent(Student student){
        students.add(student);
    }
}
