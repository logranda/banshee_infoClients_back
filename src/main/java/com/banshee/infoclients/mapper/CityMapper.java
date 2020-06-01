package com.banshee.infoclients.mapper;

import com.banshee.infoclients.domain.CityEntity;
import com.banshee.infoclients.dto.CityDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityEntity convertSCityEntityFromSCityDto(CityDto cityDto);

    CityDto convertSCityDtoFromSCityEntity(CityEntity cityEntity);

}
