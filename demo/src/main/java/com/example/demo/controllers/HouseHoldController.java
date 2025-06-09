package com.example.demo.controllers;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.RequestDto.HouseholdMemberDto;
import com.example.demo.dto.RequestDto.HouseholdRequestDto;

import com.example.demo.dto.ResponseDto.DemographicsResponseDto;
import com.example.demo.dto.ResponseDto.HouseholdResponseDto;
import com.example.demo.service.DemographicService;
import com.example.demo.service.HouseholdService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class HouseHoldController {
    @Autowired
    private HouseholdService householdService;

    @Autowired
    private DemographicService demographicService;

    //them metadata số lượng household
        @GetMapping("/households")
    public ResponseEntity<ApiResponse<List<HouseholdResponseDto>>> getAllHouseholds(){
        // Get all households
        List<HouseholdResponseDto> householdResponseDtos = householdService.getAllHouseholds();
        // Create a response object
        ApiResponse<List<HouseholdResponseDto>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Households retrieved successfully");
        response.setData(householdResponseDtos);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/households/{householdId}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getHousehold(@PathVariable Long householdId){
        // Get household by ID
        HouseholdResponseDto householdResponseDto = householdService.getHouseholdById(householdId);
        List<DemographicsResponseDto> demographicResponseDtos = demographicService.getHouseholdDemographics(householdId);
        Map<String, Object> data = new HashMap<>();
        data.put("householdData", householdResponseDto);
        data.put("listDemographics", demographicResponseDtos);
        // Create a response object
        ApiResponse<Map<String, Object>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("successfully");
        response.setData(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/households")
    public ResponseEntity<ApiResponse<HouseholdResponseDto>> addHousehold(@Valid @RequestBody HouseholdRequestDto householdRequestDto){
        // Add a new household
        HouseholdResponseDto addedHousehold = householdService.addHousehold(householdRequestDto);
        // Create a response object
        ApiResponse<HouseholdResponseDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Household found");
        response.setData(addedHousehold);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/households/{householdId}")
    public ResponseEntity<ApiResponse<String>> deleteHousehold(@PathVariable Long householdId){
        // Delete the household
        String message = householdService.deleteHousehold(householdId);
        // Create a response object
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Household deleted successfully");
        response.setData(message);
        // Return the response
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/households/{householdId}")
    public ResponseEntity<ApiResponse<HouseholdResponseDto>> updateHousehold(@PathVariable Long householdId,
                                                                            @RequestBody HouseholdRequestDto householdRequestDto){
        // Update the household
        HouseholdResponseDto householdResponseDto = householdService.updateHousehold(householdId, householdRequestDto);
        // Create a response object
        ApiResponse<HouseholdResponseDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Household updated successfully");
        response.setData(householdResponseDto);
        // Return the response
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/households/{householdId}/addDemographics")
    public ResponseEntity<ApiResponse<String>> addDemographicToHousehold(@PathVariable Long householdId,
                                                                                       @RequestBody HouseholdMemberDto householdMemberDto) {
        String message = householdService.addDemographicToHousehold(householdId, householdMemberDto);
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Add demographic to household successfully");
        response.setData(message);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    //get tuỳ chỉnh với các tham số

}
