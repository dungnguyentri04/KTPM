package com.example.demo.service.Impl;

import com.example.demo.dto.ContributionDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.models.Contribution;
import com.example.demo.models.Fee;
import com.example.demo.models.Household;
import com.example.demo.repositories.ContributionRepository;
import com.example.demo.repositories.FeeRepository;
import com.example.demo.repositories.HouseholdRepository;
import com.example.demo.service.ContributionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ContributionServiceImpl implements ContributionService {
    @Autowired
    private ContributionRepository contributionRepository;

    @Autowired
    private FeeRepository feeRepository;

    @Autowired
    private HouseholdRepository householdRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ContributionDto addContribute(ContributionDto contributionDto) {
        Fee fee = feeRepository.findById(contributionDto.getFeeId()).orElseThrow(
                () -> new NotFoundException("Fee not found")
        );
        Household household = householdRepository.findById(contributionDto.getHouseholdId()).orElseThrow(
                () -> new NotFoundException("Household not found")
        );
        Contribution contribution = modelMapper.map(contributionDto, Contribution.class);
//        contribution.setCreatedAt(LocalDate.now());

        return null;
    }
}
