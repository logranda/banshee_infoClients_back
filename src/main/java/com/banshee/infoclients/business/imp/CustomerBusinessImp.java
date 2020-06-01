package com.banshee.infoclients.business.imp;

import com.banshee.infoclients.business.ICustomerBusiness;
import com.banshee.infoclients.domain.CustomerEntity;
import com.banshee.infoclients.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerBusinessImp implements ICustomerBusiness {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public CustomerEntity findByid(Long id) {
        return customerService.findByid(id);
    }

    @Override
    public CustomerEntity save(CustomerEntity customer) {
        customer.setNit(passwordEncoder.encode(customer.getNit()));
        if (customer.getPassword() != null)
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerService.save(customer);
    }

    @Override
    public Page<CustomerEntity> findAll(PageRequest pageRequest) {
        return customerService.findAll(pageRequest);
    }

    @Override
    public Boolean deleteById(Long id) {
        return customerService.deleteById(id);
    }

    @Override
    public CustomerEntity findByUsername(String username) {
        return customerService.findByUsername(username);
    }
}
