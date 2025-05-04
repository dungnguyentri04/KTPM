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

}
