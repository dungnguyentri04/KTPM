package com.example.demo.service.Impl;

import com.example.demo.dto.RequestDto.UserRequestDto;
import com.example.demo.dto.ResponseDto.UserResponseDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.models.User;
import com.example.demo.models.User.UserRole;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserResponseDto> getAllUser() {
        List<UserResponseDto> userDtoList = userRepository.findAll().stream().map(
                user -> {
                    UserResponseDto userDto = modelMapper.map(user, UserResponseDto.class);
                    userDto.setRole(user.getRole().name());
                    return userDto;
                }
        ).toList();
        if (userDtoList.isEmpty()) throw new NotFoundException("Not found any user");
        return userDtoList;
    }

    @Override
    public UserResponseDto findUserById(Long id)  {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found user"));
        UserResponseDto userDto = modelMapper.map(user, UserResponseDto.class);
        userDto.setRole(user.getRole().name());
        return userDto;
    }

    @Override
    public String deleteUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User not found")
        );
        userRepository.delete(user);
        return "User with ID " + id + " deleted successfully";
    }

    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        //check user ton tai
        User user = modelMapper.map(userRequestDto, User.class);
        UserRole role = UserRole.valueOf(userRequestDto.getRole());
        User saveUser = userRepository.save(user);
        return modelMapper.map(saveUser, UserResponseDto.class);
    }

}
