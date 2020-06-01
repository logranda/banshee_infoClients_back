package com.banshee.infoclients.controller;

import com.banshee.infoclients.dto.CustomerDto;
import com.banshee.infoclients.facade.ICustomerFacade;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerFacade customerFacade;

    @PostMapping(value = "/all")
    public Object findAll(Map<String, String> params) {
        return customerFacade.findAll(params);
    }

    @GetMapping(value = "/{id}")
    public Object findById(@PathVariable("id") Long id) {
        return customerFacade.findById(id);
    }

    @PostMapping(value = "/")
    public Object save(@RequestBody CustomerDto customerDto) {
        return customerFacade.save(customerDto);
    }

    @DeleteMapping(value = "{id}")
    public Object deleteById(@PathVariable("id") Long id) {
        return customerFacade.deleteById(id);
    }

}
