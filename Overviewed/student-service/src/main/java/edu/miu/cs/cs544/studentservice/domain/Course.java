package edu.miu.cs.cs544.studentservice.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String courseCode;
    private String building;
    private int roomNumber;

    @ManyToMany
    private List<Faculty> faculties;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "course")
    private List<CoursesRegistered> coursesRegistereds;

    public Course() {
    }

    public Course(String title, String courseCode, String building, int roomNumber) {
        this.title = title;
        this.courseCode = courseCode;
        this.building = building;
        this.roomNumber = roomNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }


    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }


    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<CoursesRegistered> getCoursesRegistereds() {
        return coursesRegistereds;
    }

    public void setCoursesRegistereds(List<CoursesRegistered> coursesRegistereds) {
        this.coursesRegistereds = coursesRegistereds;
    }
}
