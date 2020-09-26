package sample.project.studentservice.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.project.studentservice.project.domain.Address;
import sample.project.studentservice.project.service.AddressService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/all")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }

    @GetMapping("/get/{id}")
    public Optional<Address> getAddressyById(@PathVariable Long id) {
        return  addressService.getAddressyById(id);
    }

    @PostMapping("/create")
    public void createAddress(@RequestBody Address address) {
        addressService.createAddress(address);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable Long id) {

        addressService.deleteAddress(id);
    }

    @PutMapping("/update/{id}")
    public void updateAddressById(@PathVariable Long id, @RequestBody  Address address){
        addressService.updateAddressById(id, address);
    }
}
