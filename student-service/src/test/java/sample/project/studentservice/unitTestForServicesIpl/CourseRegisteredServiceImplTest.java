package sample.project.studentservice.unitTestForServicesIpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sample.project.studentservice.AbstractFacultyServiceTest;
import sample.project.studentservice.project.domain.CoursesRegistered;
import sample.project.studentservice.project.service.CourseRegisteredService;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
public class CourseRegisteredServiceImplTest extends AbstractFacultyServiceTest {

    @Autowired
    private CourseRegisteredService courseRegisteredService;

    @Before
    public void setUp() {
        logger.info("CourseRegisteredServiceImplTest started");
    }

    @After
    public void tearDown() {
        logger.info("CourseRegisteredServiceImplTest completed");
    }

    @Test
    public void getAllFacultyAllTest() {
        List<CoursesRegistered> list = courseRegisteredService.getAllCourseRegistered();
        Assert.assertNotNull(list);
        Assert.assertNotEquals(0, list.size());
        logger.info("List data: " + Arrays.toString(list.toArray()));
    }



}