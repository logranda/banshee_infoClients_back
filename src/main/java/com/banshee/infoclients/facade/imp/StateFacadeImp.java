package com.banshee.infoclients.facade.imp;

import com.banshee.infoclients.business.IStateBusiness;
import com.banshee.infoclients.domain.StateEntity;
import com.banshee.infoclients.dto.StateDto;
import com.banshee.infoclients.facade.IStateFacade;
import com.banshee.infoclients.mapper.StateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateFacadeImp implements IStateFacade {

    @Autowired
    private IStateBusiness stateBusiness;

    @Autowired
    private StateMapper stateMapper;


    @Override
    public List<StateDto> findAll() {
        List<StateEntity> customerList = stateBusiness.findAll();
        return customerList.stream().map(this::mapper)
                .collect(Collectors.toList());
    }

    @Override
    public StateDto findById(Long id) {
        return stateMapper.convertStateDtoFromStateEntity(stateBusiness.findById(id));
    }

    @Override
    public StateDto save(StateDto stateDto) {
        return stateMapper.convertStateDtoFromStateEntity(stateBusiness.save(stateMapper.convertStateEntityFromStateDto(stateDto)));
    }

    @Override
    public void deleteById(Long id) {
        stateBusiness.deleteById(id);
    }

    @Override
    public List<StateDto> findByName(String name) {
        List<StateEntity> customerList = stateBusiness.findByName(name);
        return customerList.stream().map(this::mapper)
                .collect(Collectors.toList());
    }

    private StateDto mapper(StateEntity stateEntity) {
        return stateMapper.convertStateDtoFromStateEntity(stateEntity);
    }
}
