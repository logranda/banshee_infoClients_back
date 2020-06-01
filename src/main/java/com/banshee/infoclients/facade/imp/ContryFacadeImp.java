package com.banshee.infoclients.facade.imp;

import com.banshee.infoclients.business.ICountryBusiness;
import com.banshee.infoclients.domain.CountryEntity;
import com.banshee.infoclients.dto.CountryDto;
import com.banshee.infoclients.facade.ICountryFacade;
import com.banshee.infoclients.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContryFacadeImp implements ICountryFacade {

    @Autowired
    private ICountryBusiness countryBusiness;

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public List<CountryDto> findAll() {

        List<CountryEntity> customerList = countryBusiness.findAll();
        return customerList.stream().map(this::mapper)
                .collect(Collectors.toList());
    }

    @Override
    public CountryDto findById(Long id) {
        return countryMapper.convertCountryDtoFromCountryEntity(countryBusiness.findById(id));
    }

    @Override
    public CountryDto save(CountryDto countryDto) {
        return countryMapper.convertCountryDtoFromCountryEntity(countryBusiness.save(countryMapper.convertCountryEntityFromCountryDto(countryDto)));
    }

    @Override
    public void deleteById(Long id) {
        countryBusiness.deleteById(id);
    }

    @Override
    public List<CountryDto> findByName(String name) {
        List<CountryEntity> customerList = countryBusiness.findByName(name);
        return customerList.stream().map(this::mapper)
                .collect(Collectors.toList());
    }

    private CountryDto mapper(CountryEntity countryEntity) {
        return countryMapper.convertCountryDtoFromCountryEntity(countryEntity);
    }
}
