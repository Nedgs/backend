package com.example.lma.controller;

import com.example.lma.model.City;
import com.example.lma.model.Sector;
import com.example.lma.repos.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sec")
@CrossOrigin
public class SectorController {

    @Autowired
    SectorRepository sectorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Sector>getAllSectors() {
        return sectorRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Sector getSectorById(@PathVariable("id") Long id) {
        return sectorRepository.findById(id).get();
    }

}
