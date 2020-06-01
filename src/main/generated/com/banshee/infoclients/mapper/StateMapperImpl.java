package com.banshee.infoclients.mapper;

import com.banshee.infoclients.domain.CountryEntity;
import com.banshee.infoclients.domain.StateEntity;
import com.banshee.infoclients.dto.CountryDto;
import com.banshee.infoclients.dto.StateDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-31T10:56:54-0500",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.5 (Oracle Corporation)"
)
@Component
public class StateMapperImpl implements StateMapper {

    @Override
    public StateEntity convertStateEntityFromStateDto(StateDto stateDto) {
        if ( stateDto == null ) {
            return null;
        }

        StateEntity stateEntity = new StateEntity();

        stateEntity.setCode( stateDto.getCode() );
        stateEntity.setName( stateDto.getName() );
        stateEntity.setCountry( countryDtoToCountryEntity( stateDto.getCountry() ) );

        return stateEntity;
    }

    @Override
    public StateDto convertStateDtoFromStateEntity(StateEntity stateEntity) {
        if ( stateEntity == null ) {
            return null;
        }

        StateDto stateDto = new StateDto();

        stateDto.setCode( stateEntity.getCode() );
        stateDto.setName( stateEntity.getName() );
        stateDto.setCountry( countryEntityToCountryDto( stateEntity.getCountry() ) );

        return stateDto;
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

    protected CountryDto countryEntityToCountryDto(CountryEntity countryEntity) {
        if ( countryEntity == null ) {
            return null;
        }

        CountryDto countryDto = new CountryDto();

        countryDto.setCode( countryEntity.getCode() );
        countryDto.setName( countryEntity.getName() );

        return countryDto;
    }
}
