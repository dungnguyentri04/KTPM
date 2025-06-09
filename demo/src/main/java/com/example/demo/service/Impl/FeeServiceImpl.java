package com.example.demo.service.Impl;

import com.example.demo.dto.RequestDto.FeeRequestDto;
import com.example.demo.dto.ResponseDto.FeeResponseDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.models.Fee;
import com.example.demo.models.Household;
import com.example.demo.models.User;
import com.example.demo.repositories.FeeRepository;
import com.example.demo.repositories.HouseholdRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.FeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeeServiceImpl implements FeeService {
    @Autowired
    private FeeRepository feeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HouseholdServiceImpl householdService;

    @Autowired
    private HouseholdRepository householdRepository;


    @Override
    public List<FeeResponseDto> getAllFees() {
        return feeRepository.findAll().stream()
                .map(fee -> modelMapper.map(fee, FeeResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FeeResponseDto getFeeById(Long id) {
        Fee fee = feeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Fee not found")
        );

        return modelMapper.map(fee, FeeResponseDto.class);
    }

    @Override
    public FeeResponseDto addFee(FeeRequestDto feeRequestDto) {
        Fee fee = modelMapper.map(feeRequestDto,Fee.class);
        fee.setType(Fee.TypeOfFee.valueOf(feeRequestDto.getType()));
        fee.setCreatedAt(LocalDate.now());
        Fee saveFee = feeRepository.save(fee);
        return modelMapper.map(saveFee, FeeResponseDto.class);
    }

    @Override
    public FeeResponseDto upDateFee(Long id, FeeRequestDto feeRequestDto) {
        Fee existingFee = feeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Fee not found")
        );

        // Update the existing fee's properties
        existingFee.setType(Fee.TypeOfFee.valueOf(feeRequestDto.getType()));
        existingFee.setName(feeRequestDto.getName());
        existingFee.setCostStandard(feeRequestDto.getCostStandard());
        existingFee.setUpdatedAt(LocalDate.now());

        Fee updatedFee = feeRepository.save(existingFee);


        return modelMapper.map(updatedFee, FeeResponseDto.class);
    }

    @Override
    public String deleteFee(Long id) {
        Fee existingFee = feeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Fee not found")
        );
        feeRepository.delete(existingFee);
        return "Deleted fee with id: " + id;
    }

    @Override
    public FeeResponseDto getFeeByType(String type) {
        return null;
    }

    @Override
    public FeeResponseDto patchFee(Long id, FeeRequestDto feeRequestDto) {
        Fee existingFee = feeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Fee not found")
        );
        existingFee.setType(Fee.TypeOfFee.valueOf(feeRequestDto.getType()));
        existingFee.setName(feeRequestDto.getName());
        existingFee.setCostStandard(feeRequestDto.getCostStandard());
        existingFee.setUpdatedAt(LocalDate.now());
        Fee updatedFee = feeRepository.save(existingFee);
        return null;
    }

    @Override
    public List<FeeResponseDto> getFeesByType(String type) {

        return null;
    }

    @Override
    public List<FeeResponseDto> getFeesByHouseholdId(Long id) {
        Household household = householdRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Household not found")
        );
        return null;
    }

    @Override
    public List<FeeResponseDto> getFeesByUserId(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User not found")
        );

        return null;
    }

    @Override
    public List<FeeResponseDto> getFeesByHouseholdIdAndUserId(Long householdId, Long userId) {
        return null;
    }

    @Override
    public List<FeeResponseDto> getFeesByHouseholdIdAndUserIdAndStatus(Long householdId, Long userId, String status) {
        return null;
    }

}
