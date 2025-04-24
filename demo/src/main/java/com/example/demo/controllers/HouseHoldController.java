package com.example.demo.controllers;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.HouseholdDto;

import com.example.demo.service.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/households")
public class HouseHoldController {
    @Autowired
    private HouseholdService householdService;

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<HouseholdDto>>> getAllHouseholds(){
        // Get all households
        List<HouseholdDto> householdDtos = householdService.getAllHouseholds();
        // Create a response object
        ApiResponse<List<HouseholdDto>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Households retrieved successfully");
        response.setData(householdDtos);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/{householdId}")
    public ResponseEntity<ApiResponse<HouseholdDto>> getHousehold(@PathVariable Long householdId){
        // Get household by ID
        HouseholdDto householdDto = householdService.getHouseholdById(householdId);
        // Create a response object
        ApiResponse<HouseholdDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Household added successfully");
        response.setData(householdDto);
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<HouseholdDto>> addHousehold(@RequestBody HouseholdDto householdDto){
        // Add a new household
        HouseholdDto addedHousehold = householdService.addHousehold(householdDto);
        // Create a response object
        ApiResponse<HouseholdDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Household found");
        response.setData(addedHousehold);
        return ResponseEntity.status(201).body(response);
    }

    @DeleteMapping("/{householdId}")
    public ResponseEntity<ApiResponse<String>> deleteHousehold(@PathVariable Long householdId){
        // Delete the household
        String message = householdService.deleteHousehold(householdId);
        // Create a response object
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Household deleted successfully");
        response.setData(message);
        // Return the response
        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/{householdId}")
    public ResponseEntity<ApiResponse<HouseholdDto>> updateHousehold(@PathVariable Long householdId,
                                                                      @RequestBody HouseholdDto householdDto){
        // Update the household
        HouseholdDto updatedHouseholdDto = householdService.updateHousehold(householdId, householdDto);
        // Create a response object
        ApiResponse<HouseholdDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Household updated successfully");
        response.setData(updatedHouseholdDto);
        // Return the response
        return ResponseEntity.status(200).body(response);
    }

    //get tuỳ chỉnh với các tham số

}
