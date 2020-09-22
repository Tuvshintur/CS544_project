package sample.project.studentservice.project.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Student {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

   
    private Integer id;
    private Boolean isTA;
    private int coach_id;
    private  String name;
    private int studentId;
    private LocalDate enrollmentDate;
    private LocalDate graduationDate;

    private double GPA;

    @OneToOne

    private Address address;


    @ManyToMany
    private List<Student> ta ;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "student")
    private List<CoursesRegistered> coursesRegisteredList;

    public Student() {
    }


    public Student(String name, int studentId, LocalDate enrollmentDate, int coach_id, LocalDate graduationDate, Boolean isTA, Address address) {
        this.name = name;
        this.studentId = studentId;
        this.coach_id = coach_id;
        this.enrollmentDate = enrollmentDate;
        this.graduationDate = graduationDate;
        this.isTA = isTA;
        this.address = address;
    }

    public Student(String name, int studentId, LocalDate enrollmentDate, LocalDate graduationDate, double GPA, Address address) {
        this.name = name;
        this.studentId = studentId;
        this.enrollmentDate = enrollmentDate;
        this.graduationDate = graduationDate;
        this.GPA = GPA;
        this.address = address;
    }

    public Boolean getTA() {
        return isTA;
    }

    public void setTA(Boolean TA) {
        isTA = TA;
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


    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
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


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



    public List<Student> getTa() {
        return ta;
    }

    public void setTa(List<Student> ta) {
        this.ta = ta;
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
}
