package com.edu.miu.cs544.tminstructor.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    @Temporal(TemporalType.DATE)
    private Date hiringDate;
    private String office;
    private String responsability;

    @OneToMany(mappedBy = "employee")
    private List<Address> addresses;

    public Employee() {
    }
    public Employee(String name, Date hiringDate, String office, String responsability) {
        this.name = name;
        this.hiringDate = hiringDate;
        this.office = office;
        this.responsability = responsability;
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

    public Date getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getResponsability() {
        return responsability;
    }

    public void setResponsability(String responsability) {
        this.responsability = responsability;
    }
}
