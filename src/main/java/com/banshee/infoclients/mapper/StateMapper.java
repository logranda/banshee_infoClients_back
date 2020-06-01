package com.banshee.infoclients.mapper;

import com.banshee.infoclients.domain.StateEntity;
import com.banshee.infoclients.dto.StateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StateMapper {
    StateEntity convertStateEntityFromStateDto(StateDto stateDto);

    StateDto convertStateDtoFromStateEntity(StateEntity stateEntity);

}
