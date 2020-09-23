package sample.project.studentservice.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import sample.project.studentservice.project.domain.Address;
import sample.project.studentservice.project.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public void createAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Address updateAddressById(@PathVariable Long id, Address address){
        Optional<Address> oldAddress = addressRepository.findById(id);

        if (oldAddress.isPresent()) {
            // Update all properties except id
            address.setId(oldAddress.get().getId());
            return addressRepository.save(address);
        } else {
            //	Insert for new recored
            return addressRepository.save(address);
        }
    }

}
