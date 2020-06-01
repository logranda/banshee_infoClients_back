package com.banshee.infoclients.business;

import com.banshee.infoclients.domain.SaleRepresentativeEntity;

import java.util.List;

public interface ISaleRepresentativeBusiness {

    List<SaleRepresentativeEntity> findAll();

    SaleRepresentativeEntity findById(Long id);

    SaleRepresentativeEntity save(SaleRepresentativeEntity saleRepresentativeEntity);

    void deleteById(Long id);

    List<SaleRepresentativeEntity> findByName(String name);

}
