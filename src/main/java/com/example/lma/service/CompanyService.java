package com.example.lma.service;

import com.example.lma.model.Company;

import java.util.List;

public interface CompanyService {
    Company saveCompany(Company company);
    Company updateCompany(Company company);
    void deleteCompany(Company company);
    void deleteCompanyById(Long id);
    Company getCompany(Long id);
    List<Company> getAllCompanys();
}
