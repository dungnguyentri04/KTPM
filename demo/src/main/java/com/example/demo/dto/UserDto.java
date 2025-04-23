package com.example.demo.dto;

import com.example.demo.models.User.UserRole;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for User entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    private String userName;

    private String password;

    private String role;

    private String phoneNumber;
}
