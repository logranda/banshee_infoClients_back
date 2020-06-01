package com.banshee.infoclients.service;

import com.banshee.infoclients.domain.VisitEntity;

import java.util.List;

public interface IVisitService {
    List<VisitEntity> findAll();

    VisitEntity findById(Long id);

    VisitEntity save(VisitEntity visitEntity);

    void deleteById(Long id);

    Long countVisitByCustmer(Long id);

}
