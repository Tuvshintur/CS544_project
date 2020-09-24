package sample.project.studentservice.unitTestForServicesIpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sample.project.studentservice.AbstractFacultyServiceTest;
import sample.project.studentservice.project.domain.Enrollment;
import sample.project.studentservice.project.service.EnrollmentService;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
public class EnrollmentServiceImpTest extends AbstractFacultyServiceTest {

    @Autowired
    private EnrollmentService enrollmentService;

    @Before
    public void setUp() {
        logger.info("EnrollmentServiceImpTest started");
    }

    @After
    public void tearDown() {
        logger.info("EnrollmentServiceImpTest completed");
    }

    @Test
    public void getAllFacultyAllTest() {
        List<Enrollment> list = enrollmentService.getAllEnrollments();
        Assert.assertNotNull(list);
        Assert.assertNotEquals(0, list.size());
        logger.info("List data: " + Arrays.toString(list.toArray()));
    }



}