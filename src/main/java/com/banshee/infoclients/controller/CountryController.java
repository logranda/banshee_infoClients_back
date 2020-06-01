package com.banshee.infoclients.controller;

import com.banshee.infoclients.dto.CountryDto;
import com.banshee.infoclients.facade.ICountryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private ICountryFacade countryFacade;

    @GetMapping(value = "/all")
    public Object findAll() {
        return countryFacade.findAll();
    }

    @GetMapping(value = "/{id}")
    public Object findById(@PathVariable Long id) {
        return countryFacade.findById(id);
    }

    @GetMapping(value = "/find/{name}")
    public Object findByName(@PathVariable String name) {
        return countryFacade.findByName(name);
    }

    @PostMapping(value = "/")
    public Object save(@RequestBody CountryDto countryDto) {
        return countryFacade.save(countryDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        countryFacade.deleteById(id);
    }

}
