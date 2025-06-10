package com.example.demo.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Data Transfer Object for User entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;

    private String userName;

    private String role;

    private String phoneNumber;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private String password;

    private String email;

    private String name;

    private String placeOfBirth;

    private String nationality;

    private String countryside;

    private String ethnic;

    private String job;

    private String workplace;

    private String citizenId;

    private String relationship;

    private String reasonForMoving;

    private LocalDate movingDate;


}
