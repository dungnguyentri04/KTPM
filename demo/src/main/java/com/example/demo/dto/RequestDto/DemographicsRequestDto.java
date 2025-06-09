package com.example.demo.dto.RequestDto;

import com.example.demo.dto.ResponseDto.UserResponseDto;
import com.example.demo.models.Demographics.Gender;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemographicsRequestDto {

//    private HouseholdRequestDto household;

//    private List<TemporaryResidenceRequestDto> temporaryResidenceIds;

//    private Long createdUserId;
//
//    private Long deletedUserId;

//    private Boolean isOwner;

    @NotBlank(message = "User name is required")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "User birthday is required")
    private LocalDate birthday;

    @NotNull(message = "User gender is required")
    private Gender sex;

    private String placeOfBirth;

    @NotNull(message = "User nationality is required")
    private String nationality;

    @NotNull(message = "User countryside is required")
    private String countryside;

    @NotNull(message = "User ethnic is required")
    private String ethnic;

    @NotNull(message = "User job is required")
    private String job;

    @NotNull(message = "User workplace is required")
    private String workplace;

    private String citizenId;

    private String issuingLocation;

    private LocalDate issuingDate;

    private String reasonForMoving;

    private LocalDate movingDate;

    private String reasonForLeaving;

    private LocalDate leavingDate;

    private String phoneNumber;
}
