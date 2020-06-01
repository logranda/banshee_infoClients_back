package com.banshee.infoclients.facade.imp;

import com.banshee.infoclients.business.ICustomerBusiness;
import com.banshee.infoclients.business.IVisitBusiness;
import com.banshee.infoclients.domain.CustomerEntity;
import com.banshee.infoclients.dto.CustomerDto;
import com.banshee.infoclients.facade.ICustomerFacade;
import com.banshee.infoclients.mapper.CustomerMapper;
import com.banshee.infoclients.utility.PageableUtility;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerFacadeImp implements ICustomerFacade {

    @Autowired
    private ICustomerBusiness customerBusiness;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private IVisitBusiness visitBusiness;

    @Override
    public Page<CustomerDto> findAll(Map<String, String> params) {
        PageRequest pageRequest = PageableUtility.newPage(params);

        Page<CustomerEntity> customerPage = customerBusiness.findAll(pageRequest);
        return new PageImpl<>(customerPage.getContent().stream().map(this::mapper)
            .collect(Collectors.toList()), pageRequest, customerPage.getTotalElements());
    }

    @Override
    public CustomerDto findById(Long id) {
        CustomerEntity customer = customerBusiness.findByid(id);
        Long countVisits = visitBusiness.countByCustomerId(id);
        customer.setVisitsPercentage((countVisits*100)/customer.getCreditLimit());
        customer.setAvailableCredit(customer.getCreditLimit()-countVisits);
        return customerMapper.convertCustomerDtoFromCustomerEntity(customer);
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return customerMapper.convertCustomerDtoFromCustomerEntity(customerBusiness.save(mapper(customerDto)));
    }

    @Override
    public Boolean deleteById(Long id) {
        return customerBusiness.deleteById(id);
    }

    private CustomerDto mapper(CustomerEntity customerEntity) {
        return customerMapper.convertCustomerDtoFromCustomerEntity(customerEntity);
    }

    private CustomerEntity mapper(CustomerDto customerDto) {
        return customerMapper.convertCustomerEntityFromCustomerDto(customerDto);
    }
}
