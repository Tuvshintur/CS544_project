package edu.miu.cs.cs544.MicroserviceProject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "student")
    private Job job;
    public Student() {
    }
}
