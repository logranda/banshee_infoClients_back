package com.banshee.infoclients.business;

import com.banshee.infoclients.domain.CountryEntity;

import java.util.List;

public interface ICountryBusiness {

    List<CountryEntity> findAll();

    CountryEntity findById(Long id);

    CountryEntity save(CountryEntity countryEntity);

    void deleteById(Long id);

    List<CountryEntity> findByName(String name);
}
