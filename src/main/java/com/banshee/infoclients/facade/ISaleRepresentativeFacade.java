package com.banshee.infoclients.facade;

import com.banshee.infoclients.dto.SaleRepresentativeDto;

import java.util.List;

public interface ISaleRepresentativeFacade {

    List<SaleRepresentativeDto> findAll();

    SaleRepresentativeDto findById(Long id);

    SaleRepresentativeDto save(SaleRepresentativeDto saleRepresentativeDto);

    void deleteById(Long id);

    List<SaleRepresentativeDto> findByName(String name);
}
