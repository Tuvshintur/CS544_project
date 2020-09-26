package sample.project.studentservice.project.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isPresent;
    private boolean isRemote;
    private LocalDate classDate;
    @ManyToOne
    @JoinColumn
    private Course course;


    @OneToMany
    @JoinColumn
    private List<Student> students;

    @OneToOne//(cascade = CascadeType.ALL)
    private Faculty faculty;

    public Attendance() {
    }

    public Attendance(boolean isPresent, boolean isRemote, LocalDate classDate) {
        this.isPresent = isPresent;
        this.isRemote = isRemote;
        this.classDate = classDate;
    }


    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean remote) {
        isRemote = remote;
    }

    public LocalDate getClassDate() {
        return classDate;
    }

    public void setClassDate(LocalDate classDate) {
        this.classDate = classDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
