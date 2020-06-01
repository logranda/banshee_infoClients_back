package com.banshee.infoclients.mapper;

import com.banshee.infoclients.domain.CustomerEntity;
import com.banshee.infoclients.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerEntity convertCustomerEntityFromCustomerDto(CustomerDto customerDto);

    CustomerDto convertCustomerDtoFromCustomerEntity(CustomerEntity customerEntity);
}

