package sample.project.studentservice.project.service;

import org.springframework.web.bind.annotation.PathVariable;
import sample.project.studentservice.project.domain.Address;

import java.util.List;

public interface AddressService {

    public List<Address> getAllAddress();

    public void createAddress(Address address);

    public void deleteAddress(Long id);

    public Address updateById(@PathVariable Long id, Address address);
}
