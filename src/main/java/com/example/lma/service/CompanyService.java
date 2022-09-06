package com.example.lma.service;

import com.example.lma.model.Company;

import java.util.List;

public interface CompanyService {
    Company saveCompany(Company company, String cityName, Long sectorId);
    Company updateCompany(Company company, String cityName);
    void deleteCompany(Company company);
    void deleteCompanyById(Long id);
    Company getCompany(Long id);
    List<Company> getAllCompanys();
}
