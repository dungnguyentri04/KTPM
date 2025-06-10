package com.example.demo.controllers;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.RequestDto.DemographicsRequestDto;
import com.example.demo.dto.ResponseDto.DemographicsResponseDto;
import com.example.demo.service.DemographicService;
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
public class DemographicController {
    @Autowired
    private DemographicService demographicService;

    @GetMapping("/demographics")
    public ResponseEntity<ApiResponse<List<DemographicsResponseDto>>> getAllDemographics(){
        List<DemographicsResponseDto> demographicResponseDtos = demographicService.getAllDemographics();
        ApiResponse<List<DemographicsResponseDto>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Demographics retrieved successfully");
        response.setData(demographicResponseDtos);
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("total", demographicResponseDtos.size());
        response.setMetadata(metadata);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/demographics/{demographicId}")
    public ResponseEntity<ApiResponse<DemographicsResponseDto>> getDemographic(@PathVariable Long demographicId){
        DemographicsResponseDto demographicResponseDto = demographicService.getDemographicById(demographicId);
        ApiResponse <DemographicsResponseDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Demographic found");
        response.setData(demographicResponseDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/demographics")
    public ResponseEntity<ApiResponse<DemographicsResponseDto>> addDemographic(@Valid @RequestBody DemographicsRequestDto demographicsRequestDto){
        DemographicsResponseDto demographicResponseDto = demographicService.addDemographic(demographicsRequestDto);
        ApiResponse<DemographicsResponseDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Demographic added successfully");
        response.setData(demographicResponseDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/demographics/{demographicId}")
    public ResponseEntity<ApiResponse<String>> deleteDemographic(@PathVariable Long demographicId){
        String message = demographicService.deleteDemographic(demographicId);
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Demographic deleted successfully");
        response.setData(message);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/demographics/{demographicId}")
    public ResponseEntity<ApiResponse<DemographicsResponseDto>> updateDemographic(@PathVariable Long demographicId,
                                    @RequestBody DemographicsRequestDto demographicsRequestDto){
        DemographicsResponseDto demographicResponseDto = demographicService.updateDemographic(demographicId, demographicsRequestDto);
        ApiResponse<DemographicsResponseDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Demographic updated successfully");
        response.setData(demographicResponseDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //xem lai cach tao api
    @GetMapping("/demographics/households/{householdId}")
    public ResponseEntity<ApiResponse<List<DemographicsResponseDto>>> getHouseholdDemographics(@PathVariable Long householdId){
        List<DemographicsResponseDto> demographicResponseDtos = demographicService.getHouseholdDemographics(householdId);
        ApiResponse<List<DemographicsResponseDto>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Demographics retrieved successfully");
        response.setData(demographicResponseDtos);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/demographics/users/{userId}")
    public ResponseEntity<ApiResponse<List<DemographicsResponseDto>>> getUserDemographics(@PathVariable Long userId){
        List<DemographicsResponseDto> demographicResponseDtos = demographicService.getUserDemographics(userId);
        ApiResponse<List<DemographicsResponseDto>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Demographics retrieved successfully");
        response.setData(demographicResponseDtos);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/demographics/users/{userId}/households/{householdId}")
    public ResponseEntity<ApiResponse<List<DemographicsResponseDto>>> getHouseholdDemographics(@PathVariable Long userId, @PathVariable Long householdId){


    //Get query parameter tuỳ chỉnh với các tham số
}
