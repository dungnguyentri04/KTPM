package com.example.demo.dto.ResponseDto;

import com.example.demo.dto.RequestDto.HouseholdRequestDto;
import com.example.demo.dto.RequestDto.TemporaryResidenceRequestDto;
import com.example.demo.models.Demographics;
import com.example.demo.models.Demographics.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

//xem lai cac thuoc tinh
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemographicsResponseDto {
    private Long id;

//    private Long householdId;

//    private List<TemporaryResidenceResponseDto> temporaryResidences;

//    private Long createdUserId;
//
//    private Long deletedUserId;

    private Boolean isOwner;

    private String name;

    private String alias;

    private Date birthday;

    private Gender sex;

    private String placeOfBirth;

    private String nationality;

    private String countryside;

    private String ethnic;

    private String job;

    private String workplace;

    private String citizenId;

    private String issuingLocation;

    private Date issuingDate;

    private String reasonForMoving;

    private Date movingDate;

    private String reasonForLeaving;

    private Date leavingDate;

    private Date createdAt;

    private Date updatedAt;
}
