package com.example.demo.controllers;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.UserCreationDto;
import com.example.demo.dto.UserDto;
import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(){
        return null;
    }

    @PostMapping("/users")
    public String addUser(@RequestBody UserCreationDto userCreationDto){

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

    @GetMapping("/allUsers")
    public ResponseEntity<?> getAllUsers(){
        ApiResponse<List<UserDto>> apiResponse = new ApiResponse<>();
        List<UserDto> userDtoList = userService.getAllUser();
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("total", userDtoList.size());
        apiResponse.setStatus("success");
        apiResponse.setMessage("All users");
        apiResponse.setMetadata(metadata);
        apiResponse.setData(userDtoList);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId){
        ApiResponse<UserDto> apiResponse = new ApiResponse<>();
        UserDto userDto = userService.findUserById(userId);
        apiResponse.setStatus("success");
        apiResponse.setMessage("Select user successfully");
        apiResponse.setMetadata(null);
        apiResponse.setData(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PostMapping("/users/{userId}/forget-password")
    public String forgetPassword(){
        return null;
    }
}
