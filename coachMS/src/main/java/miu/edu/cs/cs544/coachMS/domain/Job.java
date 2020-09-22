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

    private int student_id;

    private int address_id;

    private Double salary;

    private Date startDate;

    public Job(int id, CptReport cptReport, int student_id, int address_id, Double salary, Date startDate) {
        this.id = id;
        this.cptReport = cptReport;
        this.student_id = student_id;
        this.address_id = address_id;
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

    public int getStudent() {
        return student_id;
    }

    public void setStudent(int student) {
        this.student_id = student_id;
    }

    public int getAddress() {
        return address_id;
    }

    public void setAddress(int address_id) {
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
