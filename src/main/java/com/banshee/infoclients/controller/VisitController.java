package com.banshee.infoclients.controller;

import com.banshee.infoclients.dto.VisitDto;
import com.banshee.infoclients.exception.ApplicationException;
import com.banshee.infoclients.facade.IVisitFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visit")
public class VisitController {

    @Autowired
    private IVisitFacade visitFacade;

    @GetMapping(value = "/all")
    public Object findAll() {
        return visitFacade.findAll();
    }

    @GetMapping(value = "/{id}")
    public Object findById(@PathVariable Long id) {
        return visitFacade.findById(id);
    }

    @PostMapping(value = "/")
    public Object save(@RequestBody VisitDto visitDto) throws ApplicationException {
        return visitFacade.save(visitDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        visitFacade.deleteById(id);
    }

}
