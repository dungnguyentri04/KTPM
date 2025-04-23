package com.example.demo.service.Impl;


import com.example.demo.dto.HouseholdDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.models.Household;
import com.example.demo.repositories.HouseholdRepository;
import com.example.demo.service.HouseholdService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HouseholdServiceImpl implements HouseholdService {
    @Autowired
    private HouseholdRepository householdRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<HouseholdDto> getAllHouseholds() {
        List<Household> households = householdRepository.findAll();
        // Convert List<Household> to List<HouseholdDto>
        List<HouseholdDto> householdDtos = households.stream()
                .map(household -> modelMapper.map(household, HouseholdDto.class))
                .toList();
       return householdDtos;
    }

    @Override
    public HouseholdDto addHousehold(HouseholdDto householdDto) {
        // Convert DTO to entity
        Household household = modelMapper.map(householdDto, Household.class);
        // Save entity to the database
        Household savedHousehold = householdRepository.save(household);

        return modelMapper.map(savedHousehold, HouseholdDto.class);
    }

    @Override
    public HouseholdDto getHouseholdById(Long id) {
        // Find the household by ID
        Household household = householdRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Household not found")
        );

        return modelMapper.map(household, HouseholdDto.class);
    }

    @Override
    public HouseholdDto updateHousehold(Long id, HouseholdDto householdDto) {
        // Find the existing household by ID
        Household existingHousehold = householdRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Household not found")
        );
        // Update the existing household with new values
        existingHousehold.setOwnerName(householdDto.getOwnerName());
        existingHousehold.setNumberOfHousehold(householdDto.getNumberOfHousehold());
        existingHousehold.setLocation(householdDto.getLocation());
        existingHousehold.setAreaCode(householdDto.getAreaCode());
        existingHousehold.setNumberOfPeople(householdDto.getNumberOfPeople());
        existingHousehold.setCitizenIdOwner(householdDto.getCitizenIdOwner());
        existingHousehold.setUpdateAt(new Date());
        // Save the updated household to the database
        Household updatedHousehold = householdRepository.save(existingHousehold);


        return modelMapper.map(updatedHousehold, HouseholdDto.class);
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
