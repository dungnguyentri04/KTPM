package com.example.demo.service.Impl;


import com.example.demo.dto.RequestDto.HouseholdMemberDto;
import com.example.demo.dto.RequestDto.HouseholdRequestDto;
import com.example.demo.dto.ResponseDto.HouseholdResponseDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.models.Demographics;
import com.example.demo.models.Demographics.Relationship;
import com.example.demo.models.Household;
import com.example.demo.models.Room;
import com.example.demo.repositories.DemographicsRepository;
import com.example.demo.repositories.HouseholdRepository;
import com.example.demo.repositories.RoomRepository;
import com.example.demo.service.HouseholdService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class HouseholdServiceImpl implements HouseholdService {
    @Autowired
    private HouseholdRepository householdRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DemographicsRepository demographicsRepository;

    @Autowired
    private RoomRepository roomRepository;

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

        //luu quan he giua demographics va household
        //kiem tra demographics co ton tai khong; da thuoc household nao chua
        //xem lai logic

        Demographics demographics = demographicsRepository.findByCitizenId(householdRequestDto.getCitizenIdOwner());
        //check demographics khong ton tai
        if (demographics == null) {
            throw new NotFoundException("Demographics not found");
        }

        Room room = roomRepository.findByName(householdRequestDto.getRoomName());
        if (room == null) {
            throw new NotFoundException("Room not found");
        }
        if (room.getRoomStatus() != Room.RoomStatus.EMPTY) {
            throw new IllegalArgumentException("Room is not empty");
        }
        if (demographics.getHousehold() != null) {
            throw new IllegalArgumentException("Demographic is already in a household");
        }

        demographics.setRelationship(Relationship.OWNER);
        demographics.setIsOwner(true);
        room.setRoomStatus(Room.RoomStatus.valueOf("OCCUPIED"));
        room.setOwnerName(householdRequestDto.getOwnerName());
        // Save entity to the database
        household.setAreaCode(room.getArea());
        household.getDemographicsList().add(demographics);
        household.setNumberOfPeople(household.getDemographicsList().size());
        household.setOwnerId(demographics.getId());
        household.setCreatedAt(LocalDate.now());
        household.setRoomName(room.getName());
        Household savedHousehold = householdRepository.save(household);
        demographics.setHousehold(household);
        demographicsRepository.save(demographics);
        roomRepository.save(room);
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
//        existingHousehold.setNumberOfPeople(householdRequestDto.getNumberOfPeople());
        existingHousehold.setCitizenIdOwner(householdRequestDto.getCitizenIdOwner());
        existingHousehold.setUpdateAt(LocalDate.now());
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

    @Override
    public String addDemographicToHousehold(Long id, HouseholdMemberDto householdMemberDto) {
        Household household = householdRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Household not found")
        );
        Demographics demographics = demographicsRepository.findById(householdMemberDto.getId()).orElseThrow(
                () -> new NotFoundException("Demographics not found")
        );
        if (demographics.getHousehold() != null) {
            throw new IllegalArgumentException("Demographic is already in a household");
        }
        demographics.setRelationship(Relationship.valueOf(householdMemberDto.getRelationship()));
        demographics.setIsOwner(householdMemberDto.getIsOwner());
        demographics.setHousehold(household);
        demographicsRepository.save(demographics);
        household.getDemographicsList().add(demographics);
        household.setNumberOfPeople(household.getDemographicsList().size());
        householdRepository.save(household);
        return "Add demographic to household successfully";
    }

    @Override
    public String deleteDemographicFromHousehold(Long id, Long demographicId) {
        Household household = householdRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Household not found")
        );
        Demographics demographics = demographicsRepository.findById(demographicId).orElseThrow(
                () -> new NotFoundException("Demographics not found")
        );
        if (demographics.getHousehold() == null) {
            throw new IllegalArgumentException("Demographic is not in a household");
        }
        demographics.setHousehold(null);
        demographicsRepository.save(demographics);
        household.getDemographicsList().remove(demographics);
        household.setNumberOfPeople(household.getDemographicsList().size());
        householdRepository.save(household);
        return null;
    }

    @Override
    public String updateDemographicInHousehold(Long id, Long demographicId, HouseholdMemberDto householdMemberDto) {
        Household household = householdRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Household not found")
        );
        Demographics demographics = demographicsRepository.findById(demographicId).orElseThrow(
                () -> new NotFoundException("Demographics not found")
        );
        if (demographics.getHousehold() == null) {
            throw new IllegalArgumentException("Demographic is not in a household");
        }
        demographics.setRelationship(Relationship.valueOf(householdMemberDto.getRelationship()));
        demographics.setIsOwner(householdMemberDto.getIsOwner());
        demographicsRepository.save(demographics);
        return null;
    }

}
