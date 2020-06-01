package com.banshee.infoclients.mapper;

import com.banshee.infoclients.domain.SaleRepresentativeEntity;
import com.banshee.infoclients.dto.SaleRepresentativeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleRepresentativeMapper {
    SaleRepresentativeEntity convertSaleRepresentativeEntityFromSaleRepresentativeDto(SaleRepresentativeDto saleRepresentativeDto);

    SaleRepresentativeDto convertSaleRepresentativeDtoFromSaleRepresentativeEntity(SaleRepresentativeEntity saleRepresentativeEntity);

}
