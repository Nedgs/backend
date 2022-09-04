package com.example.lma.service;

import com.example.lma.model.City;
import com.example.lma.model.Company;
import com.example.lma.repos.CityRepository;
import com.example.lma.repos.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CityRepository cityRepository;


    @Override
    public Company saveCompany(Company company, String cityName) {
//        if (cityId == 0){
//            City city=  new City();
//            city.setName(cityName);
//            City savedCity = cityRepository.save(city);
//            company.setCity(savedCity);
//
//        }
//        if (cityRepository.existsById(cityId)) {
//            City city = cityRepository.findById(cityId).get();
//            company.setCity(city);
//        }

        if (cityRepository.existsByNameIgnoreCase(cityName)) {
            City city = cityRepository.findByName(cityName).get();
            company.setCity(city);
        } else{
            City city=  new City();
            city.setName(cityName);
            City savedCity = cityRepository.save(city);
            company.setCity(savedCity);
        }
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Company company, String cityName) {

        if (cityRepository.existsByNameIgnoreCase(cityName)) {
            City city = cityRepository.findByName(cityName).get();
            company.setCity(city);
        } else{
            City city=  new City();
            city.setName(cityName);
            City savedCity = cityRepository.save(city);
            company.setCity(savedCity);
        }
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Company company) {
        companyRepository.delete(company);
    }

    @Override
    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Company getCompany(Long id) {
      return companyRepository.findById(id).get();
    }

    @Override
    public List<Company> getAllCompanys() {
        return companyRepository.findAll();
    }
}
