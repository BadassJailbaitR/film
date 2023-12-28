package com.example.apifilms.controller;


import com.example.apifilms.entities.User;
import com.example.apifilms.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserRep userRep;


    @CrossOrigin(origins = "**")
    @GetMapping("/users/{username}")
    Long getUid(@PathVariable String username){
        return userRep.findUserByUsername(username).getId();
    }

    @CrossOrigin(origins = "**")
    @PostMapping("/users/")
    void saveUser(@RequestBody User user) {
        System.out.println(user);
        userRep.save(user);
    }

    @CrossOrigin(origins = "**")
    @GetMapping("/users/verify/{username}/{password}")
    boolean verifyUser(@PathVariable("username") String username,@PathVariable("password") String password) {
        return userRep.existsUserByUsernameAndPassword(username,password);
    }
}
