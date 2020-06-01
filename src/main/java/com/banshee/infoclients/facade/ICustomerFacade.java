package com.banshee.infoclients.facade;

import com.banshee.infoclients.dto.CustomerDto;
import java.util.Map;
import org.springframework.data.domain.Page;

public interface ICustomerFacade {

    Page<CustomerDto> findAll(Map<String, String> params);

    CustomerDto findById(Long id);

    CustomerDto save(CustomerDto customerDto);

    Boolean deleteById(Long id);
}
