package edu.miu.cs.cs544.MicroserviceProject.domain;

import javax.persistence.ManyToOne;
import javax.xml.crypto.Data;

public class CptReport {

    private int id;
    private Data date;
    private String report;

    private Job job;

    @ManyToOne()
    private Coach coach;
}
