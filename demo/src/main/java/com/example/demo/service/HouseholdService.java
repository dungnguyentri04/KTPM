package com.example.demo.service;

import com.example.demo.dto.RequestDto.HouseholdMemberDto;
import com.example.demo.dto.RequestDto.HouseholdRequestDto;
import com.example.demo.dto.ResponseDto.HouseholdResponseDto;

import java.util.List;

public interface HouseholdService {

    List<HouseholdResponseDto> getAllHouseholds();

     HouseholdResponseDto addHousehold(HouseholdRequestDto householdRequestDto);

     HouseholdResponseDto getHouseholdById(Long id);

     HouseholdResponseDto updateHousehold(Long id, HouseholdRequestDto householdRequestDto);

     String deleteHousehold(Long id);

     String addDemographicToHousehold(Long id, HouseholdMemberDto householdMemberDto);


    // Household getHouseholdById(Long id);
    // Household createHousehold(Household household);
    // void deleteHousehold(Long id);
    // Household updateHousehold(Long id, Household household);
}
