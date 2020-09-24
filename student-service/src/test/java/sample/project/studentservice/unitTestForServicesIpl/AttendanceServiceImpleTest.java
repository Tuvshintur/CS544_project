package sample.project.studentservice.unitTestForServicesIpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sample.project.studentservice.AbstractFacultyServiceTest;
import sample.project.studentservice.project.domain.Address;
import sample.project.studentservice.project.domain.Attendance;
import sample.project.studentservice.project.service.AttendanceService;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Transactional
public class AttendanceServiceImpleTest extends AbstractFacultyServiceTest {

    @Autowired
    private AttendanceService attendanceService;

    @Before
    public void setUp() {
        logger.info("AttendanceServiceImpleTest started");
    }

    @After
    public void tearDown() {
        logger.info("AttendanceServiceImpleTest completed");
    }

    @Test
    public void getAllFacultyAllTest() {
        List<Attendance> list = attendanceService.getAllAttendance();
        Assert.assertNotNull(list);
        Assert.assertNotEquals(0, list.size());
        logger.info("List data: " + Arrays.toString(list.toArray()));
    }

    @Test
    public void getFacultyByIdTest() {
        Optional<Attendance> attendance = attendanceService.getAttendanceBayId(1L);
        Assert.assertNotNull(attendance);
        Assert.assertNotEquals(0, attendance);
        logger.info("List data: " + Arrays.toString(attendance.stream().toArray()));
    }


}