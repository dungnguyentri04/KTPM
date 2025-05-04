package com.example.demo.service;

import com.example.demo.dto.RequestDto.DemographicsRequestDto;
import com.example.demo.dto.ResponseDto.DemographicsResponseDto;

import java.util.List;

public interface DemographicService {
    public List<DemographicsResponseDto> getAllDemographics();

    public DemographicsResponseDto getDemographicById(Long id);

    public DemographicsResponseDto addDemographic(DemographicsRequestDto demographicRequestDto);

    public String deleteDemographic(Long id);

    public DemographicsResponseDto updateDemographic(Long id, DemographicsRequestDto demographicRequestDto);

    public List<DemographicsResponseDto> getHouseholdDemographics(Long id);
}
