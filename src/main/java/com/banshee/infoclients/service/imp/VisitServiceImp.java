package com.banshee.infoclients.service.imp;

import com.banshee.infoclients.domain.VisitEntity;
import com.banshee.infoclients.repository.IVisitRepository;
import com.banshee.infoclients.service.IVisitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VisitServiceImp implements IVisitService {

    @Autowired
    private IVisitRepository visitRepository;


    @Override
    @Transactional(readOnly = true)
    public List<VisitEntity> findAll() {
        return visitRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public VisitEntity findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public VisitEntity save(VisitEntity visitEntity) {
        return visitRepository.saveAndFlush(visitEntity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }

    @Override
    public Long countVisitByCustmer(Long id) {
        return visitRepository.countByCustomerId(id);
    }

}
