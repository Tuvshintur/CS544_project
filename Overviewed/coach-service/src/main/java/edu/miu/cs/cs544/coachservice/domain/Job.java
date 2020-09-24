package edu.miu.cs.cs544.coachservice.domain;

import edu.miu.cs.cs544.coachservice.DTO.IGeneralDTO;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Job implements IGeneralDTO {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    @JoinColumn
    private CPTReport cptReport;
    private int student_id;
    private int address_id;
    private Double salary;
    private Date startDate;

    public Job() {
    }

    public Job( CPTReport cptReport, int student_id, int address_id, Double salary, Date startDate) {
        this.cptReport = cptReport;
        this.student_id = student_id;
        this.address_id = address_id;
        this.salary = salary;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CPTReport getCptReport() {
        return cptReport;
    }

    public void setCptReport(CPTReport cptReport) {
        this.cptReport = cptReport;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
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
