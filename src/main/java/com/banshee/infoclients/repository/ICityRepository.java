package com.banshee.infoclients.repository;

import com.banshee.infoclients.domain.CityEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<CityEntity, Long> {

    List<CityEntity> findByState_NameContainingIgnoreCase(String name);

}
