package com.banshee.infoclients.service.imp;

import com.banshee.infoclients.domain.StateEntity;
import com.banshee.infoclients.repository.IStateRepository;
import com.banshee.infoclients.service.IStateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StateServiceImp implements IStateService {

    @Autowired
    private IStateRepository stateRepository;

    @Override
    @Transactional(readOnly = true)
    public List<StateEntity> findAll() {
        return stateRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public StateEntity findById(Long id) {
        return stateRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public StateEntity save(StateEntity stateEntity) {
        return stateRepository.save(stateEntity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        stateRepository.deleteById(id);
    }

    @Override
    public List<StateEntity> findByName(String name) {
        return stateRepository.findByCountry_NameContainingIgnoreCase(name);
    }
}
