package edu.miu.cs.cs544.MicroserviceProject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Job {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private CptReport cptReport;


    public Job() {

    }
}
