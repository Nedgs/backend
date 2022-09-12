package com.example.lma.service;

import com.example.lma.model.Role;
import com.example.lma.model.User;
import com.example.lma.repos.RoleRepository;
import com.example.lma.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }


    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User addRoleToUser(String username, String rolename) {
        User usr = userRepository.findByUsername(username);
        Role role = roleRepository.findByrole(rolename);

        usr.getRoles().add(role);
        return usr;
    }

    @Override
    public User updateRoleToUser(String username, String rolename) {
        User usr = userRepository.findByUsername(username);
        Role role = roleRepository.findByrole(rolename);

        usr.getRoles().add(role);
        return usr;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
