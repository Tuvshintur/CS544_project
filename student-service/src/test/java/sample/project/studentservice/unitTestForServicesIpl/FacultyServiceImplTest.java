package sample.project.studentservice.unitTestForServicesIpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import sample.project.studentservice.AbstractFacultyServiceTest;
import sample.project.studentservice.project.domain.Faculty;
import sample.project.studentservice.project.service.FacultyService;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Transactional
public class FacultyServiceImplTest extends AbstractFacultyServiceTest {

    @Autowired
    private FacultyService facultyService;

    @Before
    public void setUp() {
        logger.info("started");
    }

    @After
    public void tearDown() {
        logger.info("completed");
    }

    @Test
    public void getAllFacultyAllTest() {
        List<Faculty> list = facultyService.getAllFaculty();
        Assert.assertNotNull(list);
        Assert.assertNotEquals(0, list.size());
        logger.info("List data: " + Arrays.toString(list.toArray()));
    }

    @Test
    public void getFacultyByIdTest() {
        Optional<Faculty>faculty = facultyService.getFacultyById(1L);
        Assert.assertNotNull(faculty);
        Assert.assertNotEquals(0, faculty);
        logger.info("List data: " + Arrays.toString(faculty.stream().toArray()));
    }


}