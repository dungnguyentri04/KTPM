package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationDto {
    private Long id;

    private String userName;

    private String role;

    private String password;

    private String phoneNumber;
}
