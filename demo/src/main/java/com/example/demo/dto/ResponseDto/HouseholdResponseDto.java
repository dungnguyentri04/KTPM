package com.example.demo.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdResponseDto {
    private Long id;

    private String ownerName;

    private String numberOfHousehold;

    private String location;

    private float areaCode;

    private int numberOfPeople;

    private LocalDate createdAt;

    private LocalDate updateAt;

    private String citizenIdOwner;

    private String roomName;

}
