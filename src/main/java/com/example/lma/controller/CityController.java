package com.example.lma.controller;

import com.example.lma.model.City;
import com.example.lma.repos.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cit")
@CrossOrigin
public class CityController {

    @Autowired
    CityRepository cityRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public City getCityById(@PathVariable("id") Long id) {
        return cityRepository.findById(id).get();
    }
}
