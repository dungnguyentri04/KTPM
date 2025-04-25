package com.example.demo.service;


import com.example.demo.dto.FeeDto;

import java.util.List;

public interface FeeService {
    List<FeeDto> getAllFees();

    FeeDto getFeeById(Long id);

    FeeDto addFee(FeeDto feeDto);

    FeeDto upDateFee(Long id, FeeDto feeDto);

    String deleteFee(Long id);

}
