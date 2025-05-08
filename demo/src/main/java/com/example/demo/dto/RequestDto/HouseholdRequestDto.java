package com.example.demo.dto.RequestDto;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdRequestDto {
    //ID for demographics
//    private List<HouseholdMemberDto> householdMemberDtos;

    private String ownerName;

    private String numberOfHousehold;

    private String location;

    private int areaCode;

//    private int numberOfPeople;

    private String citizenIdOwner;

    private Long ownerId;
}