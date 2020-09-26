package sample.project.studentservice.project.service;

import org.springframework.web.bind.annotation.PathVariable;
import sample.project.studentservice.project.domain.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    public List<Address> getAllAddress();
    public Optional<Address> getAddressyById(Long id);
    public void createAddress(Address address);
    public void deleteAddress(Long id);
    public Address updateAddressById(@PathVariable Long id, Address address);
}
