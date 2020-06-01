package com.banshee.infoclients.facade;

import com.banshee.infoclients.dto.CityByVisitDto;
import com.banshee.infoclients.dto.CityDto;

import java.util.List;

public interface ICityFacade {

    List<CityDto> findAll();

    CityDto findById(Long id);

    CityDto save(CityDto cityDto);

    void deleteById(Long id);

    List<CityDto> findByName(String name);

    CityByVisitDto findCountVisits();

}
