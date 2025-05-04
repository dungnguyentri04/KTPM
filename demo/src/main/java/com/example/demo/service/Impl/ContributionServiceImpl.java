package com.example.demo.service.Impl;

import com.example.demo.dto.RequestDto.ContributionRequestDto;
import com.example.demo.dto.ResponseDto.ContributionResponseDto;
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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public ContributionResponseDto addContribute(ContributionRequestDto contributionRequestDto) {
        Fee fee = feeRepository.findById(contributionRequestDto.getFeeId()).orElseThrow(
                () -> new NotFoundException("Fee not found")
        );
        Household household = householdRepository.findById(contributionRequestDto.getHouseholdId()).orElseThrow(
                () -> new NotFoundException("Household not found")
        );
        Contribution contribution = modelMapper.map(contributionRequestDto, Contribution.class);

//        Xem lai
//        contribution.setCreatedAt(LocalDate.now());
//        contribution.setUpdateAt();

        double money = feeCaculator(household, fee, contributionRequestDto.getAttributes(), contributionRequestDto.getMoney());
        contribution.setMoney(money);

        contribution.setStatus(Contribution.StatusContribution.valueOf("IN_COMPLETE"));
        contribution.setFee(fee);

        contribution.setHousehold(household);
        contributionRepository.save(contribution);
        return modelMapper.map(contribution, ContributionResponseDto.class);
    }

    @Override
    public ContributionResponseDto getContributeById(Long id) {
        Contribution contribution = contributionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Contribution not found")
        );
        return modelMapper.map(contribution, ContributionResponseDto.class);
    }

    @Override
    public ContributionResponseDto updateContribute(Long id, ContributionRequestDto contributionRequestDto) {
        Contribution contribution = contributionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Contribution not found")
        );
        modelMapper.map(contributionRequestDto, contribution);
        return modelMapper.map(contribution, ContributionResponseDto.class);
    }

    @Override
    public String deleteContribute(Long id) {
        Contribution contribution = contributionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Contribution not found")
        );
        contributionRepository.delete(contribution);
        return "Deleted contribution with id: " + id;
    }

    @Override
    public List<ContributionResponseDto> getContributeByHousehold(Long id) {
        Household household = householdRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Household not found")
        );
        List<Contribution> contributions = contributionRepository.findByHouseholdId(id); // List<Contribution> contributions = contributionRepository.findByHousehold(household>
        List<ContributionResponseDto> contributionResponseDtos = contributions.stream()
                .map(contribution -> modelMapper.map(contribution, ContributionResponseDto.class))
                .toList();
        return contributionResponseDtos;
    }

    private double feeCaculator(Household household, Fee fee, Map<String, Object> attributes, double money) {
        double price;
        if (fee.getType().equals(Fee.TypeOfFee.MANDATORY)){
            double area = (double) attributes.getOrDefault("area", 0.0);
            switch (fee.getName()) {
                case "Eletricity":
                    price = money;
                case "Water":
                    price = money;
                case "Cleaning":
                    int numberOfPeople = household.getNumberOfPeople();
                    price = money * numberOfPeople;
                case "Service":
                    area = (double) attributes.getOrDefault("area", 0.0);
                    price = money * area;
                case "Manage":
                    area = (double) attributes.getOrDefault("area", 0.0);
                    price = money * area;
                case "Vehicle":
                    int numberOfVehicles = (int) attributes.getOrDefault("numberOfVehicles", 0);
                    price = money * numberOfVehicles;
                default:
                    return 0;
            }
        }
        else {
            price = money;
        }
        return price;
    }
}
