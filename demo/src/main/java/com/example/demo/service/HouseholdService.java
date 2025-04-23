package com.example.demo.service;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.HouseholdDto;

import java.util.List;

public interface HouseholdService {

    List<HouseholdDto> getAllHouseholds();

     HouseholdDto addHousehold(HouseholdDto householdDto);

     HouseholdDto getHouseholdById(Long id);

     HouseholdDto updateHousehold(Long id, HouseholdDto householdDto);

     String deleteHousehold(Long id);


    // Household getHouseholdById(Long id);
    // Household createHousehold(Household household);
    // void deleteHousehold(Long id);
    // Household updateHousehold(Long id, Household household);
}
