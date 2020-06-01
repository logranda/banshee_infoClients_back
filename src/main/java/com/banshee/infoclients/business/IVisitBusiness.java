package com.banshee.infoclients.business;

import com.banshee.infoclients.domain.VisitEntity;
import com.banshee.infoclients.exception.ApplicationException;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IVisitBusiness {
    List<VisitEntity> findAll();

    VisitEntity findById(Long id);

    VisitEntity save(VisitEntity visitEntity) throws ApplicationException;

    void deleteById(Long id);

    Long countByCustomerId(Long id);

}
