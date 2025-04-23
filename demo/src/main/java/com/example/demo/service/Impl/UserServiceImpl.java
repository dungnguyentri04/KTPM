package com.example.demo.service.Impl;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> userDtoList = userRepository.findAll().stream().map(
                user -> {
                    UserDto userDto = modelMapper.map(user, UserDto.class);
                    userDto.setRole(user.getRole().name());
                    return userDto;
                }
        ).toList();
        if (userDtoList.isEmpty()) throw new NotFoundException("Not found any user");
        return userDtoList;
    }

    @Override
    public UserDto findUserById(Long id)  {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found user"));
        UserDto userDto = modelMapper.map(user,UserDto.class);
        userDto.setRole(user.getRole().name());
        return userDto;
    }

}
