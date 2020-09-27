package sample.project.studentservice.unitTestForServicesIpl;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sample.project.studentservice.AbstractFacultyServiceTest;
import sample.project.studentservice.project.domain.Address;
import sample.project.studentservice.project.domain.Student;
import sample.project.studentservice.project.service.AddressService;
import sample.project.studentservice.project.service.StudentService;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StudentTest extends AbstractFacultyServiceTest {


    @Transactional
    public class StudentServiceImplTest extends AbstractFacultyServiceTest {

        @Autowired
        private StudentService studentService;

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
            List<Student> list = studentService.getAllStudents();
            Assert.assertNotNull(list);
            Assert.assertNotEquals(0, list.size());
            logger.info("List data: " + Arrays.toString(list.toArray()));
        }

        @Test
        public void getStudentByIdTest(int id) {
            Student student = studentService.getStudentById(id);
            Assert.assertNotNull(student);
            Assert.assertNotEquals(0, student);
            logger.info("List data: " + student);
        }
    }
}
