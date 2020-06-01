package com.banshee.infoclients.service.imp;

import com.banshee.infoclients.domain.CityEntity;
import com.banshee.infoclients.repository.ICityRepository;
import com.banshee.infoclients.service.ICityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CityServiceImp implements ICityService {

    @Autowired
    private ICityRepository cityRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CityEntity> findAll() {
        return cityRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public CityEntity findById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public CityEntity save(CityEntity cityEntity) {
        return cityRepository.save(cityEntity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public List<CityEntity> findByName(String name) {
        return cityRepository.findByState_NameContainingIgnoreCase(name);
    }

}
