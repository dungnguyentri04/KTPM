package com.example.demo.controllers;

import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(){
        return null;
    }

    @PostMapping("/users")
    public String addUser(){
        return null;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(){
        return null;
    }

    @PutMapping("/users/{userId}")
    public String updateUser(){
        return null;
    }

    @GetMapping("/users")
    public String getAllUsers(){
        return null;
    }

    @GetMapping("/users/{userId}")
    public String getUser(){
        return null;
    }

    @PostMapping("/users/{userId}/forget-password")
    public String forgetPassword(){
        return null;
    }

}
