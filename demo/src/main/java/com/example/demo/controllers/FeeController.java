package com.example.demo.controllers;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.FeeDto;
import com.example.demo.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
public class FeeController {
    @Autowired
    private FeeService feeService;

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<FeeDto>>> getAllFees(){
        List<FeeDto> feeDtos = feeService.getAllFees();
        ApiResponse<List<FeeDto>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Fees retrieved successfully");
        response.setData(feeDtos);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/{feeId}")
    public ResponseEntity<ApiResponse<FeeDto>> getFee(@PathVariable Long feeId){
        FeeDto feeDto = feeService.getFeeById(feeId);
        ApiResponse<FeeDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Fee found");
        response.setData(feeDto);
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<FeeDto>> addFee(@RequestBody FeeDto feeDto){
        FeeDto addedFee = feeService.addFee(feeDto);
        ApiResponse<FeeDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Fee added successfully");
        response.setData(addedFee);
        return ResponseEntity.status(201).body(response);
    }

    @DeleteMapping("/{feeId}")
    public ResponseEntity<ApiResponse<String>> deleteFee(@PathVariable Long feeId){
        String message = feeService.deleteFee(feeId);
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Fee deleted successfully");
        response.setData(message);
        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/{feeId}")
    public ResponseEntity<ApiResponse<FeeDto>> updateFee(@PathVariable Long feeId, @RequestBody FeeDto feeDto){
        FeeDto updatedFee = feeService.upDateFee(feeId, feeDto);
        ApiResponse<FeeDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Fee updated successfully");
        response.setData(updatedFee);
        return ResponseEntity.status(200).body(response);
    }
}
