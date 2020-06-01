package com.banshee.infoclients.service.imp;

import com.banshee.infoclients.domain.CustomerEntity;
import com.banshee.infoclients.repository.ICustomerRepository;
import com.banshee.infoclients.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomerServiceImp implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<CustomerEntity> findAll(PageRequest pageRequest) {
        return customerRepository.findAll(pageRequest);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerEntity findByid(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public CustomerEntity save(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Boolean deleteById(Long id) {
        customerRepository.deleteById(id);
        return !customerRepository.existsById(id);
    }

    @Override
    @Transactional
    public CustomerEntity findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

}
