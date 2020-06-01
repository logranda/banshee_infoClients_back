package com.banshee.infoclients.service.imp;

import com.banshee.infoclients.domain.CountryEntity;
import com.banshee.infoclients.repository.ICountryRepository;
import com.banshee.infoclients.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImp implements ICountryService {

    @Autowired
    private ICountryRepository countryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CountryEntity> findAll() {
        return countryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public CountryEntity findById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public CountryEntity save(CountryEntity countryEntity) {
        return countryRepository.save(countryEntity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public List<CountryEntity> findByName(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name);
    }
}
