package com.example.lma.controller;

import com.example.lma.model.Lifecycle;
import com.example.lma.model.Role;
import com.example.lma.repos.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
@CrossOrigin(origins = "*")
public class RoleControlleur {

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
