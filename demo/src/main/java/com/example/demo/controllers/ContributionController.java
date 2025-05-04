package com.example.demo.controllers;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.RequestDto.ContributionRequestDto;
import com.example.demo.dto.ResponseDto.ContributionResponseDto;
import com.example.demo.service.ContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ContributionController {
    @Autowired
    private ContributionService contributionService;

    @PostMapping("/contributes")
    public ResponseEntity<ApiResponse<ContributionResponseDto>> addContribute(@RequestBody ContributionRequestDto contributionRequestDto){
        ContributionResponseDto contributionResponseDto = contributionService.addContribute(contributionRequestDto);
        ApiResponse<ContributionResponseDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Household found");
        response.setData(contributionResponseDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/contributes/{id}")
    public ResponseEntity<ApiResponse<ContributionResponseDto>> getContribute(@PathVariable Long id){
        ContributionResponseDto contributionResponseDto = contributionService.getContributeById(id);
        ApiResponse<ContributionResponseDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Contribution found");
        response.setData(contributionResponseDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/contributes/{id}")
    public ResponseEntity<ApiResponse<ContributionResponseDto>> updateContribute(@PathVariable Long id, @RequestBody ContributionRequestDto contributionRequestDto){
        ContributionResponseDto contributionResponseDto = contributionService.updateContribute(id, contributionRequestDto);
        ApiResponse<ContributionResponseDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Contribution updated successfully");
        response.setData(contributionResponseDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/contributes/{id}")
    public ResponseEntity<ApiResponse<String>> deleteContribute(@PathVariable Long id){
        String message = contributionService.deleteContribute(id);
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Contribution deleted successfully");
        response.setData(message);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/households/{householdId}/contributes")
    public ResponseEntity<ApiResponse<List<ContributionResponseDto>>> getContributeByHousehold(@PathVariable Long householdId){
        List<ContributionResponseDto> contributionResponseDtos = contributionService.getContributeByHousehold(householdId);
        ApiResponse<List<ContributionResponseDto>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Contribute found");
        response.setData(contributionResponseDtos);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

///api/khoan-phi/{id}/ho-khau	GET	Lấy danh sách các hộ phải nộp phí theo khoản phí
///api/chi-tiet-khoan-thu/{id}/nop-tien	PATCH	Đánh dấu 1 khoản thu đã nộp tiền


}
