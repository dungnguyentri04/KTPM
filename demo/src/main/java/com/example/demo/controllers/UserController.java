package com.example.demo.controllers;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.RequestDto.UserRequestDto;
import com.example.demo.dto.ResponseDto.UserResponseDto;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<ApiResponse<UserResponseDto>> addUser(@Valid @RequestBody UserRequestDto userRequestDto){
        UserResponseDto userDto = userService.addUser(userRequestDto);
        ApiResponse<UserResponseDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("add user successfully");
        response.setData(userDto);
        response.setMetadata(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable Long userId){
        String message = userService.deleteUserById(userId);
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Delete user successfully");
        response.setData(message);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/users/{userId}")
    public String updateUser(){
        return null;
    }

    @GetMapping("/users/allUsers")
    public ResponseEntity<?> getAllUsers(){
        List<UserResponseDto> userDtoList = userService.getAllUser();
        ApiResponse<List<UserResponseDto>> apiResponse = new ApiResponse<>();
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
        UserResponseDto userDto = userService.findUserById(userId);
        ApiResponse<UserResponseDto> apiResponse = new ApiResponse<>();
        apiResponse.setStatus("success");
        apiResponse.setMessage("Select user successfully");
        apiResponse.setMetadata(null);
        apiResponse.setData(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/users/{userId}/profile")
    public String profile(){
        return null;
    }

    @PostMapping("/users/{userId}/forget-password")
    public String forgetPassword(){
        return null;
    }

    @PostMapping("/users/{userId}/reset-password")
    public String resetPassword(){

        return null;
    }

    @PostMapping("/users/{userId}/change-password")
    public String changePassword(){
        return null;
    }

}
