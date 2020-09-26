package sample.project.studentservice.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int studentId;
    private LocalDate enrollmentDate;
    private LocalDate graduationDate;
    private double GPA;
    private int coach_id;
    private Boolean isTa;
    private int instructor_id;
    @OneToOne
    @JsonIgnore
    private Address address;
    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Enrollment> enrollments;
    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<CoursesRegistered> coursesRegisteredList;

    public Student() {
    }

    public Student(String name, int studentId, LocalDate enrollmentDate, LocalDate graduationDate, double GPA) {
        this.name = name;
        this.studentId = studentId;
        this.enrollmentDate = enrollmentDate;
        this.graduationDate = graduationDate;
        this.GPA = GPA;
//        this.address = address;
    }

    public Student(String name, int studentId, LocalDate enrollmentDate, int coach_id, LocalDate graduationDate, Address address) {
        this.name = name;
        this.studentId = studentId;
        this.coach_id = coach_id;
        this.enrollmentDate = enrollmentDate;
        this.graduationDate = graduationDate;
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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }

    public void setInstructor_id(int instructor_id){
        this.instructor_id=instructor_id;
    }

    public Boolean getTa() {
        return isTa;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public List<CoursesRegistered> getCoursesRegisteredList() {
        return coursesRegisteredList;
    }

    public void setCoursesRegisteredList(List<CoursesRegistered> coursesRegisteredList) {
        this.coursesRegisteredList = coursesRegisteredList;
    }

    public void setTa(Boolean ta) {
        isTa = ta;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}