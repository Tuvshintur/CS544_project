package sample.project.studentservice.studentServiceTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sample.project.studentservice.project.domain.Student;
import sample.project.studentservice.project.service.StudentService;

import javax.transaction.Transactional;

@Transactional
public class StudentServiceImplTest extends AbstractStudentServiceTest {
    @Autowired
    private StudentService studentService;
    @Before
    public void setUp() {
        logger.info( "StudentServiceImplTest started");
    }
    @After
    public void tearDown() {
        logger.info("StudentServiceImplTest completed");
    }
    @Test
    public void getStudentByIdTest(Integer id) {
        Student student = studentService.getStudentById(id);
        Assert.assertNotNull(student);
        Assert.assertNotEquals(0, student);
        logger.info("List data: " + student);
    }
}


