package com.banshee.infoclients.facade;

import com.banshee.infoclients.dto.StateDto;

import java.util.List;

public interface IStateFacade {

    List<StateDto> findAll();

    StateDto findById(Long id);

    StateDto save(StateDto stateDto);

    void deleteById(Long id);

    List<StateDto> findByName(String name);
}
