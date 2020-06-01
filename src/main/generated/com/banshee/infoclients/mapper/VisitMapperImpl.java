package com.banshee.infoclients.mapper;

import com.banshee.infoclients.domain.CityEntity;
import com.banshee.infoclients.domain.CountryEntity;
import com.banshee.infoclients.domain.CustomerEntity;
import com.banshee.infoclients.domain.SaleRepresentativeEntity;
import com.banshee.infoclients.domain.StateEntity;
import com.banshee.infoclients.domain.VisitEntity;
import com.banshee.infoclients.dto.CityDto;
import com.banshee.infoclients.dto.CityDto.CityDtoBuilder;
import com.banshee.infoclients.dto.CountryDto;
import com.banshee.infoclients.dto.CountryDto.CountryDtoBuilder;
import com.banshee.infoclients.dto.CustomerDto;
import com.banshee.infoclients.dto.CustomerDto.CustomerDtoBuilder;
import com.banshee.infoclients.dto.SaleRepresentativeDto;
import com.banshee.infoclients.dto.SaleRepresentativeDto.SaleRepresentativeDtoBuilder;
import com.banshee.infoclients.dto.StateDto;
import com.banshee.infoclients.dto.StateDto.StateDtoBuilder;
import com.banshee.infoclients.dto.VisitDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-31T22:48:52-0500",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.5 (Oracle Corporation)"
)
@Component
public class VisitMapperImpl implements VisitMapper {

    @Override
    public VisitEntity convertVisitEntityFromVisitDto(VisitDto VisitDto) {
        if ( VisitDto == null ) {
            return null;
        }

        VisitEntity visitEntity = new VisitEntity();

        visitEntity.setId( VisitDto.getId() );
        visitEntity.setDateVisit( VisitDto.getDateVisit() );
        visitEntity.setNet( VisitDto.getNet() );
        visitEntity.setTotal( VisitDto.getTotal() );
        visitEntity.setDescription( VisitDto.getDescription() );
        visitEntity.setSaleRepresentative( saleRepresentativeDtoToSaleRepresentativeEntity( VisitDto.getSaleRepresentative() ) );
        visitEntity.setCity( cityDtoToCityEntity( VisitDto.getCity() ) );
        visitEntity.setCustomer( customerDtoToCustomerEntity( VisitDto.getCustomer() ) );

        return visitEntity;
    }

    @Override
    public VisitDto convertVisitDtoFromVisitEntity(VisitEntity VisitEntity) {
        if ( VisitEntity == null ) {
            return null;
        }

        VisitDto visitDto = new VisitDto();

        visitDto.setId( VisitEntity.getId() );
        visitDto.setDateVisit( VisitEntity.getDateVisit() );
        visitDto.setNet( VisitEntity.getNet() );
        visitDto.setTotal( VisitEntity.getTotal() );
        visitDto.setDescription( VisitEntity.getDescription() );
        visitDto.setSaleRepresentative( saleRepresentativeEntityToSaleRepresentativeDto( VisitEntity.getSaleRepresentative() ) );
        visitDto.setCity( cityEntityToCityDto( VisitEntity.getCity() ) );
        visitDto.setCustomer( customerEntityToCustomerDto( VisitEntity.getCustomer() ) );

        return visitDto;
    }

    protected SaleRepresentativeEntity saleRepresentativeDtoToSaleRepresentativeEntity(SaleRepresentativeDto saleRepresentativeDto) {
        if ( saleRepresentativeDto == null ) {
            return null;
        }

        SaleRepresentativeEntity saleRepresentativeEntity = new SaleRepresentativeEntity();

        saleRepresentativeEntity.setId( saleRepresentativeDto.getId() );
        saleRepresentativeEntity.setName( saleRepresentativeDto.getName() );

        return saleRepresentativeEntity;
    }

    protected CountryEntity countryDtoToCountryEntity(CountryDto countryDto) {
        if ( countryDto == null ) {
            return null;
        }

        CountryEntity countryEntity = new CountryEntity();

        countryEntity.setCode( countryDto.getCode() );
        countryEntity.setName( countryDto.getName() );

        return countryEntity;
    }

    protected StateEntity stateDtoToStateEntity(StateDto stateDto) {
        if ( stateDto == null ) {
            return null;
        }

        StateEntity stateEntity = new StateEntity();

        stateEntity.setCode( stateDto.getCode() );
        stateEntity.setName( stateDto.getName() );
        stateEntity.setCountry( countryDtoToCountryEntity( stateDto.getCountry() ) );

        return stateEntity;
    }

    protected CityEntity cityDtoToCityEntity(CityDto cityDto) {
        if ( cityDto == null ) {
            return null;
        }

        CityEntity cityEntity = new CityEntity();

        cityEntity.setCode( cityDto.getCode() );
        cityEntity.setName( cityDto.getName() );
        cityEntity.setState( stateDtoToStateEntity( cityDto.getState() ) );

        return cityEntity;
    }

    protected CustomerEntity customerDtoToCustomerEntity(CustomerDto customerDto) {
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
        customerEntity.setVisitsPercentage( customerDto.getVisitsPercentage() );
        customerEntity.setAvailableCredit( customerDto.getAvailableCredit() );

        return customerEntity;
    }

    protected SaleRepresentativeDto saleRepresentativeEntityToSaleRepresentativeDto(SaleRepresentativeEntity saleRepresentativeEntity) {
        if ( saleRepresentativeEntity == null ) {
            return null;
        }

        SaleRepresentativeDtoBuilder saleRepresentativeDto = SaleRepresentativeDto.builder();

        saleRepresentativeDto.id( saleRepresentativeEntity.getId() );
        saleRepresentativeDto.name( saleRepresentativeEntity.getName() );

        return saleRepresentativeDto.build();
    }

    protected CountryDto countryEntityToCountryDto(CountryEntity countryEntity) {
        if ( countryEntity == null ) {
            return null;
        }

        CountryDtoBuilder countryDto = CountryDto.builder();

        countryDto.code( countryEntity.getCode() );
        countryDto.name( countryEntity.getName() );

        return countryDto.build();
    }

    protected StateDto stateEntityToStateDto(StateEntity stateEntity) {
        if ( stateEntity == null ) {
            return null;
        }

        StateDtoBuilder stateDto = StateDto.builder();

        stateDto.code( stateEntity.getCode() );
        stateDto.name( stateEntity.getName() );
        stateDto.country( countryEntityToCountryDto( stateEntity.getCountry() ) );

        return stateDto.build();
    }

    protected CityDto cityEntityToCityDto(CityEntity cityEntity) {
        if ( cityEntity == null ) {
            return null;
        }

        CityDtoBuilder cityDto = CityDto.builder();

        cityDto.code( cityEntity.getCode() );
        cityDto.name( cityEntity.getName() );
        cityDto.state( stateEntityToStateDto( cityEntity.getState() ) );

        return cityDto.build();
    }

    protected CustomerDto customerEntityToCustomerDto(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        CustomerDtoBuilder customerDto = CustomerDto.builder();

        customerDto.id( customerEntity.getId() );
        customerDto.nit( customerEntity.getNit() );
        customerDto.fullName( customerEntity.getFullName() );
        customerDto.address( customerEntity.getAddress() );
        customerDto.phone( customerEntity.getPhone() );
        customerDto.creditLimit( customerEntity.getCreditLimit() );
        customerDto.username( customerEntity.getUsername() );
        customerDto.password( customerEntity.getPassword() );
        customerDto.visitsPercentage( customerEntity.getVisitsPercentage() );
        customerDto.availableCredit( customerEntity.getAvailableCredit() );

        return customerDto.build();
    }
}
