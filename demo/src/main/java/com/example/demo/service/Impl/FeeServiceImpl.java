package com.example.demo.service.Impl;

import com.example.demo.dto.FeeDto;
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
    public List<FeeDto> getAllFees() {
        return feeRepository.findAll().stream()
                .map(fee -> modelMapper.map(fee,FeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FeeDto getFeeById(Long id) {
        Fee fee = feeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Fee not found")
        );

        return modelMapper.map(fee,FeeDto.class);
    }

    @Override
    public FeeDto addFee(FeeDto feeDto) {
        Fee fee = modelMapper.map(feeDto,Fee.class);
        Fee saveFee = feeRepository.save(fee);

        return modelMapper.map(saveFee, FeeDto.class);
    }

    @Override
    public FeeDto upDateFee(Long id, FeeDto feeDto) {
        Fee existingFee = feeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Fee not found")
        );

        // Update the existing fee's properties
        existingFee.setId((feeDto.getId()));
        existingFee.setType(feeDto.getType());
        existingFee.setName(feeDto.getName());
        existingFee.setCostStandard(feeDto.getCostStandard());
        existingFee.setCreatedAt(feeDto.getCreatedAt());
        existingFee.setUpdatedAt(new Date());

        Fee updatedFee = feeRepository.save(existingFee);


        return modelMapper.map(updatedFee, FeeDto.class);
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
