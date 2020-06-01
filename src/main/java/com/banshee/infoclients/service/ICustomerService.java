package com.banshee.infoclients.service;

import com.banshee.infoclients.domain.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ICustomerService {

    CustomerEntity findByid(Long id);

    CustomerEntity save(CustomerEntity customer);

    Page<CustomerEntity> findAll(PageRequest pageRequest);

    Boolean deleteById(Long id);

    CustomerEntity findByUsername(String username);

}
