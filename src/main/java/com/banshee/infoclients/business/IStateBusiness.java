package com.banshee.infoclients.business;

import com.banshee.infoclients.domain.StateEntity;

import java.util.List;

public interface IStateBusiness {

    List<StateEntity> findAll();

    StateEntity findById(Long id);

    StateEntity save(StateEntity stateEntity);

    void deleteById(Long id);

    List<StateEntity> findByName(String name);
}
