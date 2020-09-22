package sample.project.studentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sample.project.studentservice.project.domain.*;
import sample.project.studentservice.project.repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
//@EnableDiscoveryClient

public class StudentServiceApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private CourseRegisteredRepository courseRegisteredRepository;
    @Autowired
    private FacultyRepository facultyRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //1.Addresses
        Address add1 = new Address("15117 Georgia ave", "Washington", "DC", 20011);
        Address add2 = new Address("46 Main ave", "Dullas", "TX", 57720);
        addressRepository.saveAll(Arrays.asList(add1, add2));

        //4.Creating attendance
        Attendance attendance1 = new Attendance(true, false, LocalDate.of(2020, 9, 15)); //, Faculty faculty)
        Attendance attendance2 = new Attendance(false, true, LocalDate.of(2020, 9, 16));
        Attendance attendance3 = new Attendance(true, true, LocalDate.of(2020, 9, 17));
        //3.Created Courses

        Course EA = new Course("EA", "cs544", "Drier", 12);
        Course BDT = new Course("BDT", "cs523", "Maclafen", 15);
        Course MPP = new Course("MPP", "cs401", "VerillHall", 39);
        courseRepository.saveAll(Arrays.asList(EA, BDT, MPP));
        List<Course> course500 = new ArrayList<>();
        course500.add(BDT);
        course500.add(EA);

        //4.Created Student

        Student st1 = new Student("Yohannes", 110871, LocalDate.of(2020, 2, 1),
                LocalDate.of(2021, 6, 15), 3.6, add1);

        Student st2 = new Student("Damitie", 550871, LocalDate.of(2019, 8, 14),
                LocalDate.of(2020, 8, 30), 3.8, add2);
        studentRepository.saveAll(Arrays.asList(st1, st2));

        //5.CourseRegistration
        CoursesRegistered cr1 = new CoursesRegistered(LocalDate.of(2020, 8, 24), LocalDate.of(2020, 9, 24), st1, EA);
        CoursesRegistered cr2 = new CoursesRegistered(LocalDate.of(2020, 8, 24), LocalDate.of(2020, 9, 24), st2, MPP);
        CoursesRegistered cr3 = new CoursesRegistered(LocalDate.of(2020, 9, 28), LocalDate.of(2020, 10, 20), st1, BDT);

    }
}

