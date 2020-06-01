package com.banshee.infoclients.business.imp;

import com.banshee.infoclients.business.ISaleRepresentativeBusiness;
import com.banshee.infoclients.domain.SaleRepresentativeEntity;
import com.banshee.infoclients.service.ISaleRepresentativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleRepresentativeBusinessImp implements ISaleRepresentativeBusiness {

    @Autowired
    private ISaleRepresentativeService saleRepresentativeService;

    @Override
    public List<SaleRepresentativeEntity> findAll() {
        return saleRepresentativeService.findAll();
    }

    @Override
    public SaleRepresentativeEntity findById(Long id) {
        return saleRepresentativeService.findById(id);
    }

    @Override
    public SaleRepresentativeEntity save(SaleRepresentativeEntity saleRepresentativeEntity) {
        return saleRepresentativeService.save(saleRepresentativeEntity);
    }

    @Override
    public void deleteById(Long id) {
        saleRepresentativeService.deleteById(id);
    }

    @Override
    public List<SaleRepresentativeEntity> findByName(String name) {
        return saleRepresentativeService.findByName(name);
    }
}
