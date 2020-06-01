package com.banshee.infoclients.mapper;

import com.banshee.infoclients.domain.CountryEntity;
import com.banshee.infoclients.dto.CountryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryEntity convertCountryEntityFromCountryDto(CountryDto countryDto);
    CountryDto convertCountryDtoFromCountryEntity(CountryEntity countryEntity);
}
