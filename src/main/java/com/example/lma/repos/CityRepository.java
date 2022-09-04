package com.example.lma.repos;

import com.example.lma.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
    boolean existsById(Long id);

    boolean existsByNameIgnoreCase(String name);

    Optional<City> findByName(String name);
}
