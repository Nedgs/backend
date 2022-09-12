package com.example.lma.controller;


import com.example.lma.model.Contact;
import com.example.lma.model.User;
import com.example.lma.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return  userService.getUser(id);

    }

    @PostMapping("/user/save")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);

    }


    @PostMapping("/role/addtouser")
    public User addRoleToUser(@RequestBody RoleToUserForm form) {
        return userService.addRoleToUser(form.getUsername(), form.getRoleName());
    }

    @PutMapping("/role/addtouser")
    public User updateRoleToUser(@RequestBody RoleToUserForm form) {
        return userService.updateRoleToUser(form.getUsername(), form.getRoleName());
    }

    @DeleteMapping("/user/delete/{id}")
    public  void deleteContact(@PathVariable("id") Long id){

        userService.deleteUserById(id);
    }

    @PutMapping ("/user/save")
    public User updateUser(@RequestBody User user) {

        return userService.updateUser(user);
    }
}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}
