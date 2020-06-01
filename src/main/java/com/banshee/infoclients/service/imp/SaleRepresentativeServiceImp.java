package com.banshee.infoclients.service.imp;

import com.banshee.infoclients.domain.SaleRepresentativeEntity;
import com.banshee.infoclients.repository.ISaleRepresentativeRepository;
import com.banshee.infoclients.service.ISaleRepresentativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleRepresentativeServiceImp implements ISaleRepresentativeService {

    @Autowired
    private ISaleRepresentativeRepository saleRepresentativeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SaleRepresentativeEntity> findAll() {
        return saleRepresentativeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public SaleRepresentativeEntity findById(Long id) {
        return saleRepresentativeRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public SaleRepresentativeEntity save(SaleRepresentativeEntity saleRepresentativeEntity) {
        return saleRepresentativeRepository.save(saleRepresentativeEntity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        saleRepresentativeRepository.deleteById(id);
    }

    @Override
    public List<SaleRepresentativeEntity> findByName(String name) {
        return saleRepresentativeRepository.findByNameContainingIgnoreCase(name);
    }
}
