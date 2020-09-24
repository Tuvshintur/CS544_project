package edu.miu.cs.cs544.tmservice.model;

import edu.miu.cs.cs544.tmservice.dto.IGeneralDTO;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class TmInstructor extends Employee implements IGeneralDTO {

    @OneToMany(mappedBy = "instructor")
    private List<TmRecord> tmRecords;

    public TmInstructor() {
    }


    public List<TmRecord> getTmRecords() {
        return tmRecords;
    }

    public void setTmRecords(List<TmRecord> tmRecords) {
        this.tmRecords = tmRecords;
    }

}
