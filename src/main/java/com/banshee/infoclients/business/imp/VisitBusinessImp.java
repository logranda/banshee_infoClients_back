package com.banshee.infoclients.business.imp;

import com.banshee.infoclients.business.IVisitBusiness;
import com.banshee.infoclients.domain.VisitEntity;
import com.banshee.infoclients.exception.ApplicationException;
import com.banshee.infoclients.service.IVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitBusinessImp implements IVisitBusiness {

    @Autowired
    private IVisitService visitService;

    @Override
    public List<VisitEntity> findAll() {
        return visitService.findAll();
    }

    @Override
    public VisitEntity findById(Long id) {
        return visitService.findById(id);
    }

    @Override
    public VisitEntity save(VisitEntity visitEntity) throws ApplicationException {
        if (visitEntity.getCustomer().getCreditLimit() <= 0) {
            throw new ApplicationException("El limite de credito de visitas ha sido excedido");
        }
        visitEntity.getCustomer().setCreditLimit(visitEntity.getCustomer().getCreditLimit() - 1);
        return visitService.save(visitEntity);
    }

    @Override
    public void deleteById(Long id) {
        visitService.deleteById(id);
    }

    @Override
    public Long countByCustomerId(Long id) {
        return visitService.countVisitByCustmer(id);
    }

}
