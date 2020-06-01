package com.banshee.infoclients.facade;

import com.banshee.infoclients.dto.CountryDto;

import java.util.List;

public interface ICountryFacade {

    List<CountryDto> findAll();

    CountryDto findById(Long id);

    CountryDto save(CountryDto countryDto);

    void deleteById(Long id);

    List<CountryDto> findByName(String name);
}
