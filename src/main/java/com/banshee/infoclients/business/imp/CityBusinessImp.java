package com.banshee.infoclients.business.imp;

import com.banshee.infoclients.business.ICityBusiness;
import com.banshee.infoclients.domain.CityEntity;
import com.banshee.infoclients.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityBusinessImp implements ICityBusiness {

    @Autowired
    private ICityService cityService;

    @Override
    public List<CityEntity> findAll() {
        return cityService.findAll();
    }

    @Override
    public CityEntity findById(Long id) {
        return cityService.findById(id);
    }

    @Override
    public CityEntity save(CityEntity cityEntity) {
        return cityService.save(cityEntity);
    }

    @Override
    public void deleteById(Long id) {
        cityService.deleteById(id);
    }

    @Override
    public List<CityEntity> findByName(String name) {
        return cityService.findByName(name);
    }
}
