package sample.project.studentservice.unitTestForServicesIpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sample.project.studentservice.AbstractFacultyServiceTest;
import sample.project.studentservice.project.domain.Address;
import sample.project.studentservice.project.domain.Faculty;
import sample.project.studentservice.project.service.AddressService;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Transactional
public class AddressServiceImplTest extends AbstractFacultyServiceTest {

    @Autowired
    private AddressService addressService;

    @Before
    public void setUp() {
        logger.info("AddressServiceImplTest started");
    }

    @After
    public void tearDown() {
        logger.info("AddressServiceImplTest completed");
    }

    @Test
    public void getAllFacultyAllTest() {
        List<Address> list = addressService.getAllAddress();
        Assert.assertNotNull(list);
        Assert.assertNotEquals(0, list.size());
        logger.info("List data: " + Arrays.toString(list.toArray()));
    }

    @Test
    public void getFacultyByIdTest() {
        Optional<Address> address = addressService.getAddressyById(1L);
        Assert.assertNotNull(address);
        Assert.assertNotEquals(0, address);
        logger.info("List data: " + Arrays.toString(address.stream().toArray()));
    }

}
