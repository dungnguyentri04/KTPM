package com.example.demo.service;


import com.example.demo.dto.RequestDto.FeeRequestDto;
import com.example.demo.dto.ResponseDto.FeeResponseDto;

import java.util.List;

public interface FeeService {
    List<FeeResponseDto> getAllFees();

    FeeResponseDto getFeeById(Long id);

    FeeResponseDto addFee(FeeRequestDto feeRequestDto);

    FeeResponseDto upDateFee(Long id, FeeRequestDto feeRequestDto);

    String deleteFee(Long id);

    public FeeResponseDto getFeeByType(String type);

    public FeeResponseDto patchFee(Long id, FeeRequestDto feeRequestDto);

    public List<FeeResponseDto> getFeesByType(String type);

    public List<FeeResponseDto> getFeesByHouseholdId(Long id);

    public List<FeeResponseDto> getFeesByUserId(Long id);

    public List<FeeResponseDto> getFeesByHouseholdIdAndUserId(Long householdId, Long userId);

    public List<FeeResponseDto> getFeesByHouseholdIdAndUserIdAndStatus(Long householdId, Long userId, String status);

}
