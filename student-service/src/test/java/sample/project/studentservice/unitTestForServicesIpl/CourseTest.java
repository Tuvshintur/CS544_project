package sample.project.studentservice.unitTestForServicesIpl;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sample.project.studentservice.AbstractFacultyServiceTest;
import sample.project.studentservice.project.domain.Course;
import sample.project.studentservice.project.service.CourseService;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;


public class CourseTest extends AbstractFacultyServiceTest {


    @Transactional
    public class StudentServiceImplTest extends AbstractFacultyServiceTest {

        @Autowired
        private CourseService courseService;

        @Before
        public void setUp() {
            logger.info(" started");
        }

        @After
        public void tearDown() {
            logger.info(" completed");
        }

        @Test
        public void getAllStudentAllTest() {
            List<Course> list = courseService.getAllCourse();
            Assert.assertNotNull(list);
            Assert.assertNotEquals(0, list.size());
            logger.info("List data: " + Arrays.toString(list.toArray()));
        }

        @Test
        public void getStudentByIdTest(int id) {
            Course course = courseService.getCourseById(id);
            Assert.assertNotNull(course);
            Assert.assertNotEquals(0, course);
            logger.info("List data: " + course);
        }
    }
}
