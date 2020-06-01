package com.banshee.infoclients.repository;

import com.banshee.infoclients.domain.StateEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStateRepository extends JpaRepository<StateEntity, Long> {

    List<StateEntity> findByCountry_NameContainingIgnoreCase(String name);

}
