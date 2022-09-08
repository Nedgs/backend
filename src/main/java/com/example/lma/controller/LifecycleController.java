package com.example.lma.controller;

import com.example.lma.model.Lifecycle;
import com.example.lma.model.Sector;
import com.example.lma.repos.LifecycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lifec")
@CrossOrigin
public class LifecycleController {

    @Autowired
    LifecycleRepository lifecycleRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Lifecycle> getAllLifecycles() {
        return lifecycleRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Lifecycle getLifecycleById(@PathVariable("id") Long id) {
        return lifecycleRepository.findById(id).get();
    }
}
