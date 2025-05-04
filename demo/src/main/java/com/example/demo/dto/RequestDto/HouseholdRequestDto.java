package com.example.demo.dto.RequestDto;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for Household entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdRequestDto {
    //ID for demographics
    private List<DemographicsRequestDto> demographicsList;

    private String ownerName;

    private String numberOfHousehold;

    private String location;

    private Integer areaCode;

    private Integer numberOfPeople;

    private String citizenIdOwner;
}