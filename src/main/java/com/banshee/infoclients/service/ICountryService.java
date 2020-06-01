package com.banshee.infoclients.service;

import com.banshee.infoclients.domain.CityEntity;
import com.banshee.infoclients.domain.CountryEntity;

import java.util.List;

public interface ICountryService {

    List<CountryEntity> findAll();

    CountryEntity findById(Long id);

    CountryEntity save(CountryEntity countryEntity);

    void deleteById(Long id);

    List<CountryEntity> findByName(String name);

}


