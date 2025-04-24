package com.example.demo.service;

import com.example.demo.dto.UserCreationDto;
import com.example.demo.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    public List<UserResponseDto> getAllUser();

    public UserResponseDto findUserById(Long id);

    public String deleteUserById(Long id);

    public UserResponseDto addUser(UserCreationDto userDto);
}
