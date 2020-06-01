package com.banshee.infoclients.facade;

import com.banshee.infoclients.dto.VisitDto;
import com.banshee.infoclients.exception.ApplicationException;

import java.util.List;

public interface IVisitFacade {

    List<VisitDto> findAll();

    VisitDto findById(Long id);

    VisitDto save(VisitDto visitDto) throws ApplicationException;

    void deleteById(Long id);

}
