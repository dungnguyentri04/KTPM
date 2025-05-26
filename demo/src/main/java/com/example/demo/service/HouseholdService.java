package com.example.demo.service;

import com.example.demo.dto.RequestDto.HouseholdMemberDto;
import com.example.demo.dto.RequestDto.HouseholdRequestDto;
import com.example.demo.dto.ResponseDto.HouseholdResponseDto;

import java.util.List;

public interface HouseholdService {

     public List<HouseholdResponseDto> getAllHouseholds();

     public HouseholdResponseDto addHousehold(HouseholdRequestDto householdRequestDto);

     public HouseholdResponseDto getHouseholdById(Long id);

     public HouseholdResponseDto updateHousehold(Long id, HouseholdRequestDto householdRequestDto);

     public String deleteHousehold(Long id);

     public String addDemographicToHousehold(Long id, HouseholdMemberDto householdMemberDto);


    // Household getHouseholdById(Long id);
    // Household createHousehold(Household household);
    // void deleteHousehold(Long id);
    // Household updateHousehold(Long id, Household household);
}
