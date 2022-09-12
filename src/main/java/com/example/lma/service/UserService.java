package com.example.lma.service;

import com.example.lma.model.Role;
import com.example.lma.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(User user);
    void deleteUserById(Long id);
    User getUser(Long id);
    User findUserByUsername(String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);
    User updateRoleToUser(String username, String rolename);
    List<User> findAllUsers();
}
