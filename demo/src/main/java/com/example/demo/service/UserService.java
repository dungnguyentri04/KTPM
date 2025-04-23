package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.models.User;

import java.util.List;

public interface UserService {
    public List<UserDto> getAllUser();

    public UserDto findUserById(Long id);
}
