package com.example.demo.service;

import com.example.demo.dto.RequestDto.ContributionRequestDto;
import com.example.demo.dto.ResponseDto.ContributionResponseDto;

import java.util.List;

public interface ContributionService {
    public ContributionResponseDto addContribute(ContributionRequestDto contributionRequestDto);

    public ContributionResponseDto getContributeById(Long id);

    public ContributionResponseDto updateContribute(Long id, ContributionRequestDto contributionRequestDto);

    public String deleteContribute(Long id);

    public List<ContributionResponseDto> getContributeByHousehold(Long id);
}
