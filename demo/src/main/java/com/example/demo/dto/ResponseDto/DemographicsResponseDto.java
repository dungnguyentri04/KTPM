package com.example.demo.dto.ResponseDto;

import com.example.demo.models.Demographics.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemographicsResponseDto {
    private Long id;

    private Boolean isOwner;

    private String nationality;

    private String email;

    private String phoneNumber;

    private LocalDate birthday;

    private int NumofCar;

    private Gender sex;

    private String issuingLocation;

    private String name;

    private String countryside;

    private String ethnic;

    private String job;

    private String workplace;

    private String citizenId;

    private String relationship;

    private String placeOfBirth;

    private Date issuingDate;

    private int age;

    private String reasonForMoving;

    private LocalDate movingDate;

    private String reasonForLeaving;

    private LocalDate leavingDate;

    private LocalDate createdAt;

    private LocalDate updatedAt;

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
