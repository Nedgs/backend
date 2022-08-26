package com.example.lma.controller;


import com.example.lma.model.Company;
import com.example.lma.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/companys")
    List<Company> getAllCompanys(){
        return companyService.getAllCompanys();
    }

    @GetMapping("/company/{id}")
    public  Company getCompanyById(@PathVariable("id") Long id){
        return companyService.getCompany(id);
    }

    @PostMapping("/company/save")
    public Company CreateCompany(@RequestBody Company company){
        return companyService.saveCompany(company);
    }

    @PutMapping("/company/save")
    public Company UpdateCompany(@RequestBody Company company){
        return companyService.updateCompany(company);
    }

    @DeleteMapping("/company/delete/{id}")
    public  void deleteCompany(@PathVariable("id") Long id){
        companyService.deleteCompanyById(id);
    }
}
