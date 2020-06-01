package com.banshee.infoclients.mapper;

import com.banshee.infoclients.domain.CustomerEntity;
import com.banshee.infoclients.dto.CustomerDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-31T10:56:54-0500",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.5 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerEntity convertCustomerEntityFromCustomerDto(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId( customerDto.getId() );
        customerEntity.setNit( customerDto.getNit() );
        customerEntity.setFullName( customerDto.getFullName() );
        customerEntity.setAddress( customerDto.getAddress() );
        customerEntity.setPhone( customerDto.getPhone() );
        customerEntity.setCreditLimit( customerDto.getCreditLimit() );
        customerEntity.setUsername( customerDto.getUsername() );
        customerEntity.setPassword( customerDto.getPassword() );

        return customerEntity;
    }

    @Override
    public CustomerDto convertCustomerDtoFromCustomerEntity(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( customerEntity.getId() );
        customerDto.setNit( customerEntity.getNit() );
        customerDto.setFullName( customerEntity.getFullName() );
        customerDto.setAddress( customerEntity.getAddress() );
        customerDto.setPhone( customerEntity.getPhone() );
        customerDto.setCreditLimit( customerEntity.getCreditLimit() );
        customerDto.setUsername( customerEntity.getUsername() );
        customerDto.setPassword( customerEntity.getPassword() );

        return customerDto;
    }
}
