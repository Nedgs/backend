package com.example.lma.repos;

import com.example.lma.model.Country;
import com.example.lma.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    boolean existsById(Long id);

    boolean existsByNameIgnoreCase(String name);

    Optional<Country> findById(Long id);
}
