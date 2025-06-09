package com.example.demo.controllers;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.RequestDto.RoomRequestDto;
import com.example.demo.dto.ResponseDto.RoomResponseDto;
import com.example.demo.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/rooms")
    public ResponseEntity<ApiResponse<RoomResponseDto>> addRoom(@Valid @RequestBody RoomRequestDto roomRequestDto){
        RoomResponseDto roomResponseDto = roomService.addRoom(roomRequestDto);
        ApiResponse<RoomResponseDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Room added successfully");
        response.setData(roomResponseDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/rooms/{roomId}")
    public ResponseEntity<ApiResponse<RoomResponseDto>> getRoom(@PathVariable Long roomId){
        RoomResponseDto roomResponseDto = roomService.findRoomById(roomId);
        ApiResponse<RoomResponseDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Room found");
        response.setData(roomResponseDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/rooms")
    public ResponseEntity<ApiResponse<List<RoomResponseDto>>> getAllRooms(){
        List<RoomResponseDto> roomResponseDto = roomService.getAllRooms();
        ApiResponse<List<RoomResponseDto>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Rooms found");
        response.setData(roomResponseDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/rooms/{roomId}")
    public ResponseEntity<ApiResponse<String>> deleteRoom(@PathVariable Long roomId){
        String message = roomService.deleteRoom(roomId);
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage(message);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/rooms/{roomId}")
    public ResponseEntity<ApiResponse<RoomResponseDto>> updateRoom(@PathVariable Long roomId, @RequestBody RoomRequestDto roomRequestDto){
        RoomResponseDto roomResponseDto = roomService.updateRoom(roomId, roomRequestDto);
        ApiResponse<RoomResponseDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Room updated successfully");
        response.setData(roomResponseDto);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/rooms/{roomId}")
    public ResponseEntity<ApiResponse<RoomResponseDto>> updateStatusRoom(@PathVariable Long roomId, @RequestBody Map<String, String> roomRequestDto){
        RoomResponseDto roomResponseDto = roomService.patchRoom(roomId, roomRequestDto);
        ApiResponse<RoomResponseDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Room updated successfully");
        response.setData(roomResponseDto);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/rooms")
    public ResponseEntity<ApiResponse<RoomResponseDto>> updateStatusAllRoom(@RequestBody Map<String, String> roomRequestDto){
        RoomResponseDto roomResponseDto = roomService.patchAllRoom(roomRequestDto);
        ApiResponse<RoomResponseDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Room updated successfully");
        response.setData(roomResponseDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/rooms")
    public ResponseEntity<ApiResponse<String>> deleteAllRoom(){
        String message = roomService.deleteAllRoom();
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage(message);
        return ResponseEntity.ok(response);
    }

}
