package com.example.demo.service;

import com.example.demo.dto.RequestDto.ContributionRequestDto;
import com.example.demo.dto.ResponseDto.ContributionResponseDto;

import java.util.List;
import java.util.Map;

public interface ContributionService {
    public ContributionResponseDto addContribute(ContributionRequestDto contributionRequestDto);

    public ContributionResponseDto getContributeById(Long id);

    public ContributionResponseDto updateContribute(Long id, ContributionRequestDto contributionRequestDto);

    public String deleteContribute(Long id);

    public List<ContributionResponseDto> getContributeByHousehold(Long id, String status);

    public ContributionResponseDto patchContribution(Long id, Map<String, String> contributionRequestDto);
}
