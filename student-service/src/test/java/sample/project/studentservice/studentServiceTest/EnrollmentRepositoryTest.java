package sample.project.studentservice.studentServiceTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.repository.EnrollmentRepository;

import javax.transaction.Transactional;


@Transactional
public class EnrollmentRepositoryTest extends AbstractStudentServiceTest{


    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Before
    public void setUp() {
        logger.info( "StudentServiceImplTest started");
    }
    @After
    public void tearDown() {
        logger.info("StudentServiceImplTest completed");
    }
    @Test
    public void getStudentByIdTest(Long id) {
        Course course = (Course) enrollmentRepository.getAllCourseByStudentId(Math.toIntExact(id));
        Assert.assertNotNull(course);
        Assert.assertNotEquals(0, course);
        logger.info("List data: " + course);
    }
}