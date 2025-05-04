package com.example.demo.service.Impl;

import com.example.demo.dto.RequestDto.FeeRequestDto;
import com.example.demo.dto.ResponseDto.FeeResponseDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.models.Fee;
import com.example.demo.repositories.FeeRepository;
import com.example.demo.service.FeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeeServiceImpl implements FeeService {
    @Autowired
    private FeeRepository feeRepository;

    @Autowired
    private ModelMapper modelMapper;


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
        Fee saveFee = feeRepository.save(fee);

        return modelMapper.map(saveFee, FeeResponseDto.class);
    }

    @Override
    public FeeResponseDto upDateFee(Long id, FeeRequestDto feeRequestDto) {
        Fee existingFee = feeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Fee not found")
        );

        // Update the existing fee's properties
        existingFee.setType(feeRequestDto.getType());
        existingFee.setName(feeRequestDto.getName());
        existingFee.setCostStandard(feeRequestDto.getCostStandard());
        existingFee.setUpdatedAt(new Date());

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

}
