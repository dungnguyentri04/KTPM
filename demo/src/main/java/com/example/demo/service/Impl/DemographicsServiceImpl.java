package com.example.demo.service.Impl;

import com.example.demo.dto.RequestDto.DemographicsRequestDto;
import com.example.demo.dto.ResponseDto.DemographicsResponseDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.models.Demographics;
import com.example.demo.models.Household;
import com.example.demo.repositories.DemographicsRepository;
import com.example.demo.repositories.HouseholdRepository;
import com.example.demo.service.DemographicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DemographicsServiceImpl implements DemographicService {
    @Autowired
    private DemographicsRepository demographicsRepository;

    @Autowired
    private HouseholdRepository householdRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DemographicsResponseDto> getAllDemographics() {
        List<Demographics> demographics = demographicsRepository.findAll();
        List<DemographicsResponseDto> demographicsResponseDtos = demographics.stream()
                .map(demographic -> {
                            DemographicsResponseDto demographicResponseDto = modelMapper.map(demographic, DemographicsResponseDto.class);
                            if (demographic.getBirthday() != null) {
                                int age = LocalDate.now().getYear() - demographic.getBirthday().getYear();
                                demographicResponseDto.setAge(age);
                            }
                            return demographicResponseDto;
                        })
                .toList();
        return demographicsResponseDtos;
    }

    @Override
    public DemographicsResponseDto getDemographicById(Long id) {
        Demographics demographic = demographicsRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Demographic not found")
        );
        return modelMapper.map(demographic, DemographicsResponseDto.class);
    }

    @Override
    public DemographicsResponseDto addDemographic(@RequestBody DemographicsRequestDto demographicRequestDto) {
        //kiem tra nhan khau trung lap
        Demographics demographic = modelMapper.map(demographicRequestDto, Demographics.class);
        String email = demographicRequestDto.getEmail();
        String citizenId = demographicRequestDto.getCitizenId();
        Demographics existingDemographic = demographicsRepository.findByEmail(email);
        if (existingDemographic != null) {
            throw new IllegalArgumentException("Demographic with email " + email + " already exists");
        }
        existingDemographic = demographicsRepository.findByCitizenId(citizenId);
        if (existingDemographic != null) {
            throw new IllegalArgumentException("Demographic with citizenId " + citizenId + " already exists");
        }
        demographic.setCreatedAt(LocalDate.now());
        Demographics savedDemographic = demographicsRepository.save(demographic);
        return modelMapper.map(savedDemographic, DemographicsResponseDto.class);
    }

    @Override
    public String deleteDemographic(Long id) {
        Demographics demographic = demographicsRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Demographic not found")
        );
        demographicsRepository.delete(demographic);
        return "Deleted demographic with id: " + id;
    }

    @Override
    public DemographicsResponseDto updateDemographic(Long id, DemographicsRequestDto demographicRequestDto) {
        Demographics existingDemographic = demographicsRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Demographic not found")
        );
        existingDemographic.setEthnic(demographicRequestDto.getEthnic());
        existingDemographic.setSex(demographicRequestDto.getSex());
        existingDemographic.setBirthday(demographicRequestDto.getBirthday());
        existingDemographic.setCitizenId(demographicRequestDto.getCitizenId());

        //......
        Demographics updatedDemographic = demographicsRepository.save(existingDemographic);
        return modelMapper.map(updatedDemographic, DemographicsResponseDto.class);
    }

    @Override
    public List<DemographicsResponseDto> getHouseholdDemographics(Long householdId) {
        Household household = householdRepository.findById(householdId).orElseThrow(
                () -> new NotFoundException("Household not found")
        );
        List<Demographics> demographics = demographicsRepository.findByHouseholdId(householdId);
        List<DemographicsResponseDto> demographicsResponseDtos = demographics.stream()
                .map(demographic -> {
                    DemographicsResponseDto demographicResponseDto = modelMapper.map(demographic, DemographicsResponseDto.class);
                    if (demographic.getBirthday() != null) {
                        int age = LocalDate.now().getYear() - demographic.getBirthday().getYear();
                        demographicResponseDto.setAge(age);
                    }
                    return demographicResponseDto;
                })
                .toList();
        return demographicsResponseDtos;
    }

}
