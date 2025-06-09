package com.example.demo.service;

import com.example.demo.dto.RequestDto.RoomRequestDto;
import com.example.demo.dto.ResponseDto.RoomResponseDto;

import java.util.List;
import java.util.Map;

public interface RoomService {
    public RoomResponseDto addRoom(RoomRequestDto roomRequestDto);

    public List<RoomResponseDto> getAllRooms();

    public RoomResponseDto findRoomById(Long id);

    public String deleteRoom(Long id);

    public RoomResponseDto updateRoom(Long id, RoomRequestDto roomRequestDto);

    public RoomResponseDto patchRoom(Long id, Map<String, String> roomRequestDto);

    public RoomResponseDto patchAllRoom(Map<String, String> roomRequestDto);

    public String deleteAllRoom();
}
