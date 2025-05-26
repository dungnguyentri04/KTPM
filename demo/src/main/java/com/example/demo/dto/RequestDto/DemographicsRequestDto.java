package com.example.demo.dto.RequestDto;

import com.example.demo.dto.ResponseDto.UserResponseDto;
import com.example.demo.models.Demographics.Gender;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
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

    private String name;

    private String email;

    private LocalDate birthday;

    private Gender sex;

    private String placeOfBirth;

    private String nationality;

    private String countryside;

    private String ethnic;

    private String job;

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
