package com.banshee.infoclients.controller;

import com.banshee.infoclients.dto.StateDto;
import com.banshee.infoclients.facade.IStateFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private IStateFacade stateFacade;

    @GetMapping(value = "/all")
    public Object findAll() {
        return stateFacade.findAll();
    }

    @GetMapping(value = "/{id}")
    public Object findById(@PathVariable Long id) {
        return stateFacade.findById(id);
    }

    @GetMapping(value = "/find/{name}")
    public Object findByNameCountry(@PathVariable String name) {
        return stateFacade.findByName(name);
    }

    @PostMapping(value = "/")
    public Object save(@RequestBody StateDto stateDto) {
        return stateFacade.save(stateDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        stateFacade.deleteById(id);
    }

}
