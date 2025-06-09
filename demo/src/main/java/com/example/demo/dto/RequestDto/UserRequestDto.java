package com.example.demo.dto.RequestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    @NotBlank(message = "User name is required")
    private String userName;

    @NotBlank(message = "User role is required")
    private String role;

    @NotBlank(message = "User password is required")
    private String password;

    @NotBlank(message = "User phone number is required")
    private String phoneNumber;
}
