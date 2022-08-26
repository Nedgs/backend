package com.example.lma.repos;

import com.example.lma.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "rest")
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
