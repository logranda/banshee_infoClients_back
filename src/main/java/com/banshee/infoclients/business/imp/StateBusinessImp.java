package com.banshee.infoclients.business.imp;

import com.banshee.infoclients.business.IStateBusiness;
import com.banshee.infoclients.domain.StateEntity;
import com.banshee.infoclients.service.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateBusinessImp implements IStateBusiness {

    @Autowired
    private IStateService stateService;

    @Override
    public List<StateEntity> findAll() {
        return stateService.findAll();
    }

    @Override
    public StateEntity findById(Long id) {
        return stateService.findById(id);
    }

    @Override
    public StateEntity save(StateEntity stateEntity) {
        return stateService.save(stateEntity);
    }

    @Override
    public void deleteById(Long id) {
        stateService.deleteById(id);
    }

    @Override
    public List<StateEntity> findByName(String name) {
        return stateService.findByName(name);
    }
}
