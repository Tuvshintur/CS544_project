package sample.project.studentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import sample.project.studentservice.project.domain.*;
import sample.project.studentservice.project.repository.*;


import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
//
@SpringBootApplication
@EnableEurekaClient

@EnableDiscoveryClient

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

   //2.Created Courses

       Course EA =  new Course("EA", "cs544", "Drier", 12);
        Course BDT =  new Course("BDT", "cs523", "Maclafen", 15);
        Course MPP =  new Course("MPP", "cs401", "VerillHall", 39);
        courseRepository.saveAll(Arrays.asList(EA, BDT, MPP));
        List<Course> course500 = new ArrayList<>();
        course500.add(BDT);
        course500.add(EA);

        //3. create Student
       Student st1= new  Student("Yohannes", 110871, LocalDate.of(2020, 2, 1),
               LocalDate.of(2021, 6,15), 3.6, add1);

        Student st2= new  Student("Damitie", 550871, LocalDate.of(2019, 8, 14),
                LocalDate.of(2020, 8,30), 3.8, add2);
             studentRepository.saveAll(Arrays.asList(st1, st2));

        //4.CourseRegistration
        CoursesRegistered cr1 =  new CoursesRegistered(LocalDate.of(2020,10,24),LocalDate.of(2020,11,24), st1, EA);
        CoursesRegistered cr2 =  new CoursesRegistered(LocalDate.of(2020,8,24),LocalDate.of(2020,9,30), st2, MPP);
        CoursesRegistered cr3 =  new CoursesRegistered(LocalDate.of(2020,9,28),LocalDate.of(2020,10,20), st1, BDT);

       courseRegisteredRepository.saveAll(Arrays.asList(cr1, cr2, cr2));

       //5. Create Enrollment
        Enrollment enrollment = new  Enrollment('A', st1, BDT);
        Enrollment enrollment2 = new  Enrollment('B', st2, MPP);
      Enrollment enrollment3 = new  Enrollment('B', st2, EA);
        enrollmentRepository.saveAll(Arrays.asList(enrollment, enrollment2,enrollment3));

        //6. Create Faculty

        Faculty faculty1 = new Faculty("Pro George", LocalDate.of(1980, 4, 15), 12,   add1);
        Faculty faculty2 = new Faculty("Pro John", LocalDate.of(1995, 6, 30), 15,   add2);
        facultyRepository.saveAll(Arrays.asList(faculty1, faculty2));

        //7.Creating attendance
        Attendance attendance1 = new Attendance(true, false, LocalDate.of(2020,9,15)); //, Faculty faculty)
        Attendance attendance2 = new Attendance(false, true, LocalDate.of(2020,9,16));
        Attendance attendance3 = new Attendance(true, true, LocalDate.of(2020,9,17));
        //Assign course
        attendance1.setCourse(EA);
        attendance2.setCourse(BDT);
        attendance3.setCourse(MPP);
        //assign faculty
        attendance1.setFaculty(faculty1);
        attendance2.setFaculty(faculty2);
        attendance3.setFaculty(faculty1);

        attendanceRepository.saveAll(Arrays.asList(attendance1, attendance2,attendance3));
    }
}
