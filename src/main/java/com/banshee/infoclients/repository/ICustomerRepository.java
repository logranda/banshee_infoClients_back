package com.banshee.infoclients.repository;

import com.banshee.infoclients.domain.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findByUsername(String username);
}
