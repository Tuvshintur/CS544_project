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

    @OneToMany(mappedBy = "employee")
    private List<Address> addresses;

    public Employee() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
