package com.example.demo.dto.RequestDto;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdRequestDto {
    //ID for demographics
//    private List<HouseholdMemberDto> householdMemberDtos;

    @NotBlank(message = "Owner name is required")
    private String ownerName;

    @NotNull(message = "Number of household is required")
    private String numberOfHousehold;

//    private String location;

//    private int areaCode;

//    private int numberOfPeople;

    @NotBlank(message = "Citizen id owner is required")
    private String citizenIdOwner;

    @NotBlank(message = "Room name is required")
    private String roomName;

//    private Long ownerId;
}