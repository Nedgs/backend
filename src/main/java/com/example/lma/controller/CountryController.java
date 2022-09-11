package com.example.lma.controller;

import com.example.lma.model.Country;
import com.example.lma.model.Sector;
import com.example.lma.repos.CountryRepository;
import com.example.lma.repos.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coun")
@CrossOrigin(origins = "*")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Country getCountryrById(@PathVariable("id") Long id) {
        return countryRepository.findById(id).get();
    }
}
