package com.example.lma.repos;

import com.example.lma.model.City;
import com.example.lma.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SectorRepository extends JpaRepository<Sector, Long> {
    boolean existsById(Long id);

    boolean existsByNameIgnoreCase(String name);

    Optional<Sector> findById(Long id);
}
