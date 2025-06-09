package com.example.demo.service;

import com.example.demo.dto.RequestDto.RoomRequestDto;
import com.example.demo.dto.ResponseDto.RoomResponseDto;

import java.util.List;

public interface RoomService {
    public RoomResponseDto addRoom(RoomRequestDto roomRequestDto);

    public List<RoomResponseDto> getAllRooms();

    public RoomResponseDto findRoomById(Long id);

    public String deleteRoom(Long id);
}
