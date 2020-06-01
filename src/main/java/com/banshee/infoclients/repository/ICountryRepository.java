package com.banshee.infoclients.repository;

import com.banshee.infoclients.domain.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICountryRepository extends JpaRepository<CountryEntity, Long> {

    List<CountryEntity> findByNameContainingIgnoreCase(String name);
}
