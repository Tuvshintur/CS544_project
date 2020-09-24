package sample.project.studentservice.project.domain;

import javax.persistence.*;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private char grade;
    @ManyToOne
    private Student student;
    @ManyToOne
    @JoinColumn
    private Course course;

    public Enrollment() {
    }

    public Enrollment(char grade, Student student, Course course) {
        this.grade = grade;
        this.student = student;
        this.course = course;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
