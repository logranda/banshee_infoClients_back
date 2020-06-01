package com.banshee.infoclients.mapper;

import com.banshee.infoclients.domain.SaleRepresentativeEntity;
import com.banshee.infoclients.dto.SaleRepresentativeDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-31T10:56:54-0500",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.5 (Oracle Corporation)"
)
@Component
public class SaleRepresentativeMapperImpl implements SaleRepresentativeMapper {

    @Override
    public SaleRepresentativeEntity convertSaleRepresentativeEntityFromSaleRepresentativeDto(SaleRepresentativeDto saleRepresentativeDto) {
        if ( saleRepresentativeDto == null ) {
            return null;
        }

        SaleRepresentativeEntity saleRepresentativeEntity = new SaleRepresentativeEntity();

        saleRepresentativeEntity.setId( saleRepresentativeDto.getId() );
        saleRepresentativeEntity.setName( saleRepresentativeDto.getName() );

        return saleRepresentativeEntity;
    }

    @Override
    public SaleRepresentativeDto convertSaleRepresentativeDtoFromSaleRepresentativeEntity(SaleRepresentativeEntity saleRepresentativeEntity) {
        if ( saleRepresentativeEntity == null ) {
            return null;
        }

        SaleRepresentativeDto saleRepresentativeDto = new SaleRepresentativeDto();

        saleRepresentativeDto.setId( saleRepresentativeEntity.getId() );
        saleRepresentativeDto.setName( saleRepresentativeEntity.getName() );

        return saleRepresentativeDto;
    }
}
