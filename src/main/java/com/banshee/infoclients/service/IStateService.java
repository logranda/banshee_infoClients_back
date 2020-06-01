package com.banshee.infoclients.service;

import com.banshee.infoclients.domain.StateEntity;

import java.util.List;

public interface IStateService {

    List<StateEntity> findAll();

    StateEntity findById(Long id);

    StateEntity save(StateEntity stateEntity);

    void deleteById(Long id);

    List<StateEntity> findByName(String name);
}
