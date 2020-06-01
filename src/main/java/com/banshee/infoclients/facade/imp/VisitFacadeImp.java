package com.banshee.infoclients.facade.imp;

import com.banshee.infoclients.business.IVisitBusiness;
import com.banshee.infoclients.domain.VisitEntity;
import com.banshee.infoclients.dto.VisitDto;
import com.banshee.infoclients.exception.ApplicationException;
import com.banshee.infoclients.facade.IVisitFacade;
import com.banshee.infoclients.mapper.VisitMapper;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitFacadeImp implements IVisitFacade {

    @Autowired
    private IVisitBusiness visitBusiness;

    @Autowired
    private VisitMapper visitMapper;

    @Override
    public List<VisitDto> findAll() {
        List<VisitEntity> customerList = visitBusiness.findAll();
        return customerList.stream().map(this::mapper)
            .collect(Collectors.toList());
    }

    @Override
    public VisitDto findById(Long id) {
        return visitMapper.convertVisitDtoFromVisitEntity(visitBusiness.findById(id));
    }

    @Override
    public VisitDto save(VisitDto visitDto) throws ApplicationException {
        visitDto.setDateVisit(new Date());
        return visitMapper.convertVisitDtoFromVisitEntity(visitBusiness.save(visitMapper.convertVisitEntityFromVisitDto(visitDto)));
    }

    @Override
    public void deleteById(Long id) {
        visitBusiness.deleteById(id);
    }

    private VisitDto mapper(VisitEntity visitEntity) {
        return visitMapper.convertVisitDtoFromVisitEntity(visitEntity);
    }
}
