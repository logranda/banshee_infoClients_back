package com.banshee.infoclients.repository;

import com.banshee.infoclients.domain.SaleRepresentativeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISaleRepresentativeRepository extends JpaRepository<SaleRepresentativeEntity, Long> {

    List<SaleRepresentativeEntity> findByNameContainingIgnoreCase(String name);

}
