package com.example.lma.repos;

import com.example.lma.model.Lifecycle;
import com.example.lma.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LifecycleRepository  extends JpaRepository<Lifecycle, Long> {
    boolean existsById(Long id);

    boolean existsByNameIgnoreCase(String name);

    Optional<Lifecycle> findById(Long id);
}
