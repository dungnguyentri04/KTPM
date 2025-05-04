package com.example.demo.service.Impl;


import com.example.demo.dto.RequestDto.HouseholdRequestDto;
import com.example.demo.dto.ResponseDto.HouseholdResponseDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.models.Household;
import com.example.demo.repositories.HouseholdRepository;
import com.example.demo.service.HouseholdService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class HouseholdServiceImpl implements HouseholdService {
    @Autowired
    private HouseholdRepository householdRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<HouseholdResponseDto> getAllHouseholds() {
        List<Household> households = householdRepository.findAll();
        // Convert List<Household> to List<HouseholdDto>
        List<HouseholdResponseDto> householdResponseDtos = households.stream()
                .map(household -> modelMapper.map(household, HouseholdResponseDto.class))
                .toList();
       return householdResponseDtos;
    }

    @Override
    public HouseholdResponseDto addHousehold(@RequestBody HouseholdRequestDto householdRequestDto) {
        // Convert DTO to entity
        Household household = modelMapper.map(householdRequestDto, Household.class);
        // Save entity to the database
        Household savedHousehold = householdRepository.save(household);

        return modelMapper.map(savedHousehold, HouseholdResponseDto.class);
    }

    @Override
    public HouseholdResponseDto getHouseholdById(Long id) {
        // Find the household by ID
        Household household = householdRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Household not found")
        );

        return modelMapper.map(household, HouseholdResponseDto.class);
    }

    @Override
    public HouseholdResponseDto updateHousehold(Long id, HouseholdRequestDto householdRequestDto) {
        // Find the existing household by ID
        Household existingHousehold = householdRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Household not found")
        );
        // Update the existing household with new values
        existingHousehold.setOwnerName(householdRequestDto.getOwnerName());
        existingHousehold.setNumberOfHousehold(householdRequestDto.getNumberOfHousehold());
        existingHousehold.setLocation(householdRequestDto.getLocation());
        existingHousehold.setAreaCode(householdRequestDto.getAreaCode());
        existingHousehold.setNumberOfPeople(householdRequestDto.getNumberOfPeople());
        existingHousehold.setCitizenIdOwner(householdRequestDto.getCitizenIdOwner());
        existingHousehold.setUpdateAt(new Date());
        // Save the updated household to the database
        Household updatedHousehold = householdRepository.save(existingHousehold);


        return modelMapper.map(updatedHousehold, HouseholdResponseDto.class);
    }

    @Override
    public String deleteHousehold(Long id) {
        // Find the household by ID
        Household existingHousehold = householdRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Household not found")
        );
        // Delete the household from the database
        householdRepository.delete(existingHousehold);

        return "Household with ID " + id + " deleted successfully";
    }


}
