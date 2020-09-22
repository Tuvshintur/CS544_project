package com.edu.miu.cs544.tminstructor.model;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn
    private Employee employee;

    public Address() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
