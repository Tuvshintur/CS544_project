
package sample.project.studentservice.project.domain;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CoursesRegistered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;

    public CoursesRegistered() {

    }

    public CoursesRegistered(LocalDate startDate, LocalDate endDate, Student student, Course course) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.student = student;
        this.course = course;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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
