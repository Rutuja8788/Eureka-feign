package com.userserviceproject.userserviceproject.controller;



import com.userserviceproject.userserviceproject.Entity.User;
import com.userserviceproject.userserviceproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user)

    {
        return userService.saveUser(user);
    }
}
