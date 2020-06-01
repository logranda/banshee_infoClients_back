package com.banshee.infoclients.controller;

import com.banshee.infoclients.dto.SaleRepresentativeDto;
import com.banshee.infoclients.facade.ISaleRepresentativeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/salerepresentative")
public class SaleRepresentativeController {

    @Autowired
    private ISaleRepresentativeFacade saleRepresentativeFacade;

    @GetMapping(value = "/all")
    public Object findAll() {
        return saleRepresentativeFacade.findAll();
    }

    @GetMapping(value = "/{id}")
    public Object findById(@PathVariable Long id) {
        return saleRepresentativeFacade.findById(id);
    }

    @GetMapping(value = "/find/{name}")
    public Object findByName(@PathVariable String name) {
        return saleRepresentativeFacade.findByName(name);
    }

    @PostMapping(value = "/")
    public Object save(@RequestBody SaleRepresentativeDto representativeDto) {
        return saleRepresentativeFacade.save(representativeDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        saleRepresentativeFacade.deleteById(id);
    }

}
