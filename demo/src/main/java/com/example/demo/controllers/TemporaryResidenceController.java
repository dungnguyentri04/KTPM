package com.example.demo.controllers;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.RequestDto.TemporaryResidenceRequestDto;
import com.example.demo.dto.ResponseDto.TemporaryResidenceResponseDto;
import com.example.demo.service.TemporaryResidenceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class TemporaryResidenceController {
    @Autowired
    private TemporaryResidenceService temporaryResidenceService;

    @GetMapping("/temporaryResidence/{id}")
    public ResponseEntity<ApiResponse<TemporaryResidenceResponseDto>> getTemporaryResidence(@PathVariable long id) {
        TemporaryResidenceResponseDto temporaryResidenceResponseDto = temporaryResidenceService.getTemporaryById(id);
        ApiResponse<TemporaryResidenceResponseDto> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Temporary Residence");
        apiResponse.setData(temporaryResidenceResponseDto);
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/temporaryResidences")
    public ResponseEntity<ApiResponse<TemporaryResidenceResponseDto>> addTemporaryResidence(@Valid @RequestBody TemporaryResidenceRequestDto temporaryResidenceRequestDto) {
        TemporaryResidenceResponseDto temporaryResidenceResponseDto = temporaryResidenceService.addTemporary(temporaryResidenceRequestDto);
        ApiResponse<TemporaryResidenceResponseDto> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Temporary Residence");
        apiResponse.setData(temporaryResidenceResponseDto);
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/temporaryResidences")
    public ResponseEntity<ApiResponse<List<TemporaryResidenceResponseDto>>> getAllTemporaryResidence() {
        List<TemporaryResidenceResponseDto> temporaryResidenceResponseDtos = temporaryResidenceService.getAllTemporary();
        ApiResponse<List<TemporaryResidenceResponseDto>> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Temporary Residence");
        apiResponse.setData(temporaryResidenceResponseDtos);
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/temporaryResidences/{id}")
    public ResponseEntity<ApiResponse<String>> deleteTemporaryResidence(@PathVariable long id) {
        String message = temporaryResidenceService.deleteTemporary(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setMessage(message);
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/temporaryResidences/{id}")
    public ResponseEntity<ApiResponse<TemporaryResidenceResponseDto>> updateTemporaryResidence(@PathVariable long id, @Valid @RequestBody TemporaryResidenceRequestDto temporaryResidenceRequestDto) {
        TemporaryResidenceResponseDto temporaryResidenceResponseDto = temporaryResidenceService.updateTemporary(id, temporaryResidenceRequestDto);
        ApiResponse<TemporaryResidenceResponseDto> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Temporary Residence");
        apiResponse.setData(temporaryResidenceResponseDto);
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/temporaryResidences/user/{id}")
    public ResponseEntity<ApiResponse<List<TemporaryResidenceResponseDto>>> getTemporaryResidenceByUserId(@PathVariable long id) {
        List<TemporaryResidenceResponseDto> temporaryResidenceResponseDtos = temporaryResidenceService.getTemporaryByUserId(id);
        ApiResponse<List<TemporaryResidenceResponseDto>> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Temporary Residence");
        apiResponse.setData(temporaryResidenceResponseDtos);
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/temporaryResidences/user")
    public ResponseEntity<ApiResponse<List<TemporaryResidenceResponseDto>>> getTemporaryResidenceByUser() {
        List<TemporaryResidenceResponseDto> temporaryResidenceResponseDtos = temporaryResidenceService.getTemporaryByUser();
        ApiResponse<List<TemporaryResidenceResponseDto>> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Temporary Residence");
        apiResponse.setData(temporaryResidenceResponseDtos);
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/temporaryResidences/active")
    public ResponseEntity<ApiResponse<List<TemporaryResidenceResponseDto>>> getTemporaryResidenceActive() {
        List<TemporaryResidenceResponseDto> temporaryResidenceResponseDtos = temporaryResidenceService.getTemporaryActive();
        ApiResponse<List<TemporaryResidenceResponseDto>> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Temporary Residence");
        apiResponse.setData(temporaryResidenceResponseDtos);
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/temporaryResidences/inactive")
    public ResponseEntity<ApiResponse<List<TemporaryResidenceResponseDto>>> getTemporaryResidenceInactive() {
        List<TemporaryResidenceResponseDto> temporaryResidenceResponseDtos = temporaryResidenceService.getTemporaryInactive();
        ApiResponse<List<TemporaryResidenceResponseDto>> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Temporary Residence");
        apiResponse.setData(temporaryResidenceResponseDtos);
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/temporaryResidences/expire")
    public ResponseEntity<ApiResponse<List<TemporaryResidenceResponseDto>>> getTemporaryResidenceExpire() {
        List<TemporaryResidenceResponseDto> temporaryResidenceResponseDtos = temporaryResidenceService.getTemporaryExpire();
        ApiResponse<List<TemporaryResidenceResponseDto>> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Temporary Residence");
        apiResponse.setData(temporaryResidenceResponseDtos);
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/temporaryResidences/{id}")
    public ResponseEntity<ApiResponse<TemporaryResidenceResponseDto>> getTemporaryResidenceById(@PathVariable long id) {
        TemporaryResidenceResponseDto temporaryResidenceResponseDto = temporaryResidenceService.getTemporaryById(id);
        ApiResponse<TemporaryResidenceResponseDto> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Temporary Residence");
        apiResponse.setData(temporaryResidenceResponseDto);
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

}
