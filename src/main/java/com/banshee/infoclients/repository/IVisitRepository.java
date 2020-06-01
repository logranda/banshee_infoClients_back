package com.banshee.infoclients.repository;

import com.banshee.infoclients.domain.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVisitRepository extends JpaRepository<VisitEntity, Long> {
    Long countByCustomerId(Long id);
}
