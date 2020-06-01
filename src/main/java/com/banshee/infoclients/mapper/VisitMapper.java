package com.banshee.infoclients.mapper;

import com.banshee.infoclients.domain.VisitEntity;
import com.banshee.infoclients.dto.VisitDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitMapper {

    VisitEntity convertVisitEntityFromVisitDto(VisitDto VisitDto);

    VisitDto convertVisitDtoFromVisitEntity(VisitEntity VisitEntity);
}
