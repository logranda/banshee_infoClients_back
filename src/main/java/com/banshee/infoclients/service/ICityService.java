package com.banshee.infoclients.service;

import com.banshee.infoclients.domain.CityEntity;

import java.util.List;

public interface ICityService {

    List<CityEntity> findAll();

    CityEntity findById(Long id);

    CityEntity save(CityEntity cityEntity);

    void deleteById(Long id);

    List<CityEntity> findByName(String name);
}
