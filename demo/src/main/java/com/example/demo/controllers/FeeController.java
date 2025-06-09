package com.example.demo.controllers;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.RequestDto.FeeRequestDto;
import com.example.demo.dto.ResponseDto.FeeResponseDto;
import com.example.demo.service.FeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FeeController {
    @Autowired
    private FeeService feeService;

    @GetMapping("/fees")
    public ResponseEntity<ApiResponse<List<FeeResponseDto>>> getAllFees(){
        List<FeeResponseDto> feeResponseDtos = feeService.getAllFees();
        ApiResponse<List<FeeResponseDto>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Fees retrieved successfully");
        response.setData(feeResponseDtos);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/fees/{feeId}")
    public ResponseEntity<ApiResponse<FeeResponseDto>> getFee(@PathVariable Long feeId){
        FeeResponseDto feeResponseDto = feeService.getFeeById(feeId);
        ApiResponse<FeeResponseDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Fee found");
        response.setData(feeResponseDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/fees")
    public ResponseEntity<ApiResponse<FeeResponseDto>> addFee(@Valid @RequestBody FeeRequestDto feeRequestDto){
        FeeResponseDto addedFee = feeService.addFee(feeRequestDto);
        ApiResponse<FeeResponseDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Fee added successfully");
        response.setData(addedFee);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/fees/{feeId}")
    public ResponseEntity<ApiResponse<String>> deleteFee(@PathVariable Long feeId){
        String message = feeService.deleteFee(feeId);
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Fee deleted successfully");
        response.setData(message);
        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/fees/{feeId}")
    public ResponseEntity<ApiResponse<FeeResponseDto>> updateFee(@PathVariable Long feeId, @RequestBody FeeRequestDto feeRequestDto){
        FeeResponseDto updatedFee = feeService.upDateFee(feeId, feeRequestDto);
        ApiResponse<FeeResponseDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Fee updated successfully");
        response.setData(updatedFee);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
