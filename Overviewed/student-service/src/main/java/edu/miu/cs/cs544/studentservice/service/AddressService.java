package edu.miu.cs.cs544.studentservice.service;

import edu.miu.cs.cs544.studentservice.domain.Address;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AddressService {

    public List<Address> getAllAddress();

    public void createAddress(Address address);

    public void deleteAddress(Long id);

    public Address updateAddressById(@PathVariable Long id, Address address);
}
