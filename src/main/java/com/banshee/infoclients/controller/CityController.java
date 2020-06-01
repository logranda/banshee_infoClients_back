package com.banshee.infoclients.controller;

import com.banshee.infoclients.dto.CityDto;
import com.banshee.infoclients.facade.ICityFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private ICityFacade cityFacade;

    @GetMapping(value = "/all")
    public Object findAll() {
        return cityFacade.findAll();
    }

    @GetMapping(value = "/{id}")
    public Object findById(@PathVariable Long id) {
        return cityFacade.findById(id);
    }

    @GetMapping(value = "/find/{name}")
    public Object findByNameState(@PathVariable String name) {
        return cityFacade.findByName(name);
    }

    @PostMapping(value = "/")
    public Object save(@RequestBody CityDto cityDto) {
        return cityFacade.save(cityDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        cityFacade.deleteById(id);
    }

    @GetMapping(value = "/visit")
    public Object findCountVisits() {
        return cityFacade.findCountVisits();
    }

}
