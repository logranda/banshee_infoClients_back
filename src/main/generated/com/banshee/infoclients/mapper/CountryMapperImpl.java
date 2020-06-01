package com.banshee.infoclients.mapper;

import com.banshee.infoclients.domain.CountryEntity;
import com.banshee.infoclients.dto.CountryDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-31T10:56:54-0500",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.5 (Oracle Corporation)"
)
@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public CountryEntity convertCountryEntityFromCountryDto(CountryDto countryDto) {
        if ( countryDto == null ) {
            return null;
        }

        CountryEntity countryEntity = new CountryEntity();

        countryEntity.setCode( countryDto.getCode() );
        countryEntity.setName( countryDto.getName() );

        return countryEntity;
    }

    @Override
    public CountryDto convertCountryDtoFromCountryEntity(CountryEntity countryEntity) {
        if ( countryEntity == null ) {
            return null;
        }

        CountryDto countryDto = new CountryDto();

        countryDto.setCode( countryEntity.getCode() );
        countryDto.setName( countryEntity.getName() );

        return countryDto;
    }
}
