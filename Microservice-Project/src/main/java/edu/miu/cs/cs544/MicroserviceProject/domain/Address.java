package edu.miu.cs.cs544.MicroserviceProject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "address")
    private Job job;
    public Address() {
    }
}
