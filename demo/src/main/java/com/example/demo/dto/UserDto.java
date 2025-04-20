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
    /**
     * Unique identifier of the user.
     */
    private Long id;

    /**
     * List of Demographics record IDs created by this user.
     */
    private List<DemographicsDto> demographicsCreated;

    /**
     * List of Demographics record IDs deleted by this user.
     */
    private List<DemographicsDto> demographicsDeleted;

    /**
     * Username for login.
     */
    private String userName;

    /**
     * Encrypted password (handle carefully).
     */
    private String password;

    /**
     * Role of the user (ACCOUNTANT or MANAGER).
     */
    private UserRole role;
}
