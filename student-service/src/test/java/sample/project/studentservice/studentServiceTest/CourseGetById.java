package sample.project.studentservice.studentServiceTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.service.CourseService;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
public class CourseGetById extends AbstractStudentServiceTest{

    @Autowired
    private CourseService courseService;
    @Before
    public void setUp() {
        logger.info( "StudentServiceImplTest started");
    }
    @After
    public void tearDown() {
        logger.info("StudentServiceImplTest completed");
    }
    @Test
    public void getStudentByIdTest() {
        List<Course> list = courseService.getAllCourse();
        Assert.assertNotNull(list);
        Assert.assertNotEquals(0, list.size());
        logger.info("List of courses: " + Arrays.toString(list.toArray()));
    }
}
