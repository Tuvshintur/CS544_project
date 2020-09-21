package miu.edu.cs.cs544.coachMS.domain;

import miu.edu.cs.cs544.coachMS.DTO.IGeneralDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Job implements IGeneralDTO {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JoinColumn
    private CptReport cptReport;

    @OneToOne
    @JoinColumn
    private Student student;

    @OneToOne
    @JoinColumn
    private Address address;

    private Double salary;

    private Date startDate;

    public Job(int id, CptReport cptReport, Student student, Address address, Double salary, Date startDate) {
        this.id = id;
        this.cptReport = cptReport;
        this.student = student;
        this.address = address;
        this.salary = salary;
        this.startDate = startDate;
    }

    public Job() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CptReport getCptReport() {
        return cptReport;
    }

    public void setCptReport(CptReport cptReport) {
        this.cptReport = cptReport;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
