package com.example.demo.dto.RequestDto;

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

import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.processing.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemographicsRequestDto {

    @NotBlank(message = "User name is required")
    private String name;

    @Email(message = "Invalid email format")

    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "User birthday is required")
    @Past(message = "Birthday must be in the past")

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

    @NotBlank(message = "citizenID is required")
    @Size(min = 9, max = 12, message = "citizenID must be between 9 and 12 digits")
    private String citizenId;

    // Có thể dùng @Pattern nếu bạn muốn validate định dạng ngày cấp (nếu là String)
    private String issuingDate;

    private LocalDate issuingLocation;

    private String reasonForMoving;

    @Past(message = "movingDate must be in the past")
    private LocalDate movingDate;

    private String reasonForLeaving;

        @Past(message = "leavingDate must be in the past")
    private LocalDate leavingDate;

    @NotBlank(message = "PhoneNumber is required")
    @Pattern(regexp = "^\\d{9,11}$", message = "PhoneNumber must be 9 to 11 digits")
    private String phoneNumber;

    @Min(value = 0, message = "NumofCar cannot be negative")
    private int NumofCar;

    @Min(value = 0, message = "PersonNum cannot be negative")
    private int PersonNum;

    private String Address;

    private String permanentAddress;

    private String temporaryAddress;

    private String householdCode;   

    private LocalDate registrationDate;

    private String stayDuration;

    private String emergencyContactName;

    private String emergencyContactPhone;

    private String emergencyContactRelation;

    private String educationLevel;

    private String maritalStatus;

    private String healthStatus;

    private String note;

}
