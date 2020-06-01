package com.banshee.infoclients.business.imp;

import com.banshee.infoclients.business.ICountryBusiness;
import com.banshee.infoclients.domain.CountryEntity;
import com.banshee.infoclients.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryBusinessImp implements ICountryBusiness {

    @Autowired
    private ICountryService countryService;

    @Override
    public List<CountryEntity> findAll() {
        return countryService.findAll();
    }

    @Override
    public CountryEntity findById(Long id) {
        return countryService.findById(id);
    }

    @Override
    public CountryEntity save(CountryEntity countryEntity) {
        return countryService.save(countryEntity);
    }

    @Override
    public void deleteById(Long id) {
        countryService.deleteById(id);
    }

    @Override
    public List<CountryEntity> findByName(String name) {
        return countryService.findByName(name);
    }
}
