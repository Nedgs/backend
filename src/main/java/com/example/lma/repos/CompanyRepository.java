package com.example.lma.repos;

import com.example.lma.model.Company;
import com.example.lma.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "rest")
public interface CompanyRepository extends JpaRepository<Company, Long> {

    boolean existsById(Long id);

    boolean existsByNameIgnoreCase(String name);

    Optional<Company> findById(Long id);
}
