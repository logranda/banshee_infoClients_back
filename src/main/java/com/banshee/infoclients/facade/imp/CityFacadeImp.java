package com.banshee.infoclients.facade.imp;

import com.banshee.infoclients.business.ICityBusiness;
import com.banshee.infoclients.business.IVisitBusiness;
import com.banshee.infoclients.domain.CityEntity;
import com.banshee.infoclients.domain.VisitEntity;
import com.banshee.infoclients.dto.CityByVisitDto;
import com.banshee.infoclients.dto.CityDto;
import com.banshee.infoclients.dto.VisitDto;
import com.banshee.infoclients.facade.ICityFacade;
import com.banshee.infoclients.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityFacadeImp implements ICityFacade {

    @Autowired
    private ICityBusiness cityBusiness;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private IVisitBusiness visitBusiness;

    @Override
    public List<CityDto> findAll() {
        List<CityEntity> customerList = cityBusiness.findAll();
        return customerList.stream().map(this::mapper)
                .collect(Collectors.toList());
    }

    @Override
    public CityDto findById(Long id) {

        return cityMapper.convertSCityDtoFromSCityEntity(cityBusiness.findById(id));
    }

    @Override
    public CityDto save(CityDto cityDto) {
        return cityMapper.convertSCityDtoFromSCityEntity(cityBusiness.save(cityMapper.convertSCityEntityFromSCityDto(cityDto)));
    }

    @Override
    public void deleteById(Long id) {
        cityBusiness.deleteById(id);
    }

    @Override
    public List<CityDto> findByName(String name) {
        List<CityEntity> customerList = cityBusiness.findByName(name);
        return customerList.stream().map(this::mapper)
                .collect(Collectors.toList());
    }

    @Override
    public CityByVisitDto findCountVisits() {
        List<CityDto> cityDtoList = new ArrayList<>();
        List<Long> visitByCityList = new ArrayList<>();
        List<CityEntity> cityList = cityBusiness.findAll();
        List<VisitEntity> visitEntityList = visitBusiness.findAll();
        for(CityEntity city: cityList) {
            cityDtoList.add(cityMapper.convertSCityDtoFromSCityEntity(city));
            visitByCityList.add(visitEntityList.stream().filter(
                    c -> c.getCity().getName().equals(city.getName())
                    ).count()
            );
        }

        return CityByVisitDto.builder()
                .city(cityDtoList)
                .visitNumber(visitByCityList)
                .build();
    }

    private CityDto mapper(CityEntity cityEntity) {
        return cityMapper.convertSCityDtoFromSCityEntity(cityEntity);
    }
}
