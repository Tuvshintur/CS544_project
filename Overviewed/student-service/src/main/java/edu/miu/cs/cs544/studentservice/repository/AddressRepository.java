package edu.miu.cs.cs544.studentservice.repository;

import edu.miu.cs.cs544.studentservice.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
