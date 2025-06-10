package com.example.demo.dto.RequestDto;

import com.example.demo.models.Demographics.Gender;


import jakarta.validation.constraints.*;

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

    private LocalDate birthday;

    private Gender sex;

    private String placeOfBirth;

    @NotBlank(message = "User nationality is required")
    private String nationality;

    @NotBlank(message = "User countryside is required")
    private String countryside;

    @NotBlank(message = "User ethnic is required")
    private String ethnic;

    @NotBlank(message = "User job is required")
    private String job;

    @NotBlank(message = "User workplace is required")

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
