package sample.project.studentservice.project.domain;

import javax.persistence.*;

import java.lang.management.GarbageCollectorMXBean;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

@Entity
public class Faculty {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private LocalDate hiringDate;
    private int room;


    @ManyToMany(mappedBy = "faculties",cascade = CascadeType.ALL)
    private List<Course> courses ;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Faculty() {
    }

    public Faculty(String name, LocalDate hiringDate, int room, Address address) {
        this.name = name;
        this.hiringDate = hiringDate;
        this.room = room;
        this.address = address;
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

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
