package com.banshee.infoclients.facade.imp;

import com.banshee.infoclients.business.ISaleRepresentativeBusiness;
import com.banshee.infoclients.domain.SaleRepresentativeEntity;
import com.banshee.infoclients.dto.SaleRepresentativeDto;
import com.banshee.infoclients.facade.ISaleRepresentativeFacade;
import com.banshee.infoclients.mapper.SaleRepresentativeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleRepresentativeFacadeImp implements ISaleRepresentativeFacade {

    @Autowired
    private ISaleRepresentativeBusiness saleRepresentativeBusiness;

    @Autowired
    private SaleRepresentativeMapper saleRepresentativeMapper;

    @Override
    public List<SaleRepresentativeDto> findAll() {
        List<SaleRepresentativeEntity> customerList = saleRepresentativeBusiness.findAll();
        return customerList.stream().map(this::mapper)
                .collect(Collectors.toList());
    }

    @Override
    public SaleRepresentativeDto findById(Long id) {
        return saleRepresentativeMapper.convertSaleRepresentativeDtoFromSaleRepresentativeEntity(saleRepresentativeBusiness.findById(id));
    }

    @Override
    public SaleRepresentativeDto save(SaleRepresentativeDto saleRepresentativeDto) {
        return saleRepresentativeMapper.convertSaleRepresentativeDtoFromSaleRepresentativeEntity(saleRepresentativeBusiness.save(saleRepresentativeMapper.convertSaleRepresentativeEntityFromSaleRepresentativeDto(saleRepresentativeDto)));
    }

    @Override
    public void deleteById(Long id) {
        saleRepresentativeBusiness.deleteById(id);
    }

    @Override
    public List<SaleRepresentativeDto> findByName(String name) {
        List<SaleRepresentativeEntity> customerList = saleRepresentativeBusiness.findByName(name);
        return customerList.stream().map(this::mapper)
                .collect(Collectors.toList());
    }

    private SaleRepresentativeDto mapper(SaleRepresentativeEntity saleRepresentativeEntity) {
        return saleRepresentativeMapper.convertSaleRepresentativeDtoFromSaleRepresentativeEntity(saleRepresentativeEntity);
    }
}
