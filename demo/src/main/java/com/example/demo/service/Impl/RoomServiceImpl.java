package com.example.demo.service.Impl;

import com.example.demo.dto.RequestDto.RoomRequestDto;
import com.example.demo.dto.ResponseDto.RoomResponseDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.models.Room;
import com.example.demo.repositories.RoomRepository;
import com.example.demo.service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RoomResponseDto addRoom(RoomRequestDto roomRequestDto) {
        Room room = roomRepository.findByName(roomRequestDto.getName());
        if (room != null) { throw new NotFoundException("Room already exists"); }
        room = modelMapper.map(roomRequestDto, Room.class);
        room.setRoomStatus(Room.RoomStatus.valueOf("EMPTY"));
        room.setCreatedAt(LocalDate.now());
        Room saveRoom = roomRepository.save(room);
        return modelMapper.map(saveRoom, RoomResponseDto.class);
    }

    @Override
    public List<RoomResponseDto> getAllRooms() {
        System.out.println("check");
        return roomRepository.findAll().stream().map(
                room -> {
                    RoomResponseDto room1 = modelMapper.map(room, RoomResponseDto.class);
                    room1.setStatus(room.getRoomStatus().name());
                    return room1;
                }).toList();
    }

    @Override
    public RoomResponseDto findRoomById(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Room not found")
        );
        return modelMapper.map(room, RoomResponseDto.class);
    }

    @Override
    public String deleteRoom(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Room not found")
        );
        roomRepository.delete(room);
        return "Deleted room with id: " + id + " successfully";
    }

    @Override
    public RoomResponseDto updateRoom(Long id, RoomRequestDto roomRequestDto) {
        Room room = roomRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Room not found")
        );
        room.setName(roomRequestDto.getName());
        room.setDescription(roomRequestDto.getDescription());
        room.setArea(roomRequestDto.getArea());
        room.setLocation(roomRequestDto.getLocation());
        room.setHouseholdId(roomRequestDto.getHouseholdId());
        Room saveRoom = roomRepository.save(room);
        return modelMapper.map(saveRoom, RoomResponseDto.class);
    }

    @Override
    public RoomResponseDto patchRoom(Long id, Map<String, String> roomRequestDto) {
        Room room = roomRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Room not found")
        );
        room.setRoomStatus(Room.RoomStatus.valueOf(roomRequestDto.get("roomStatus")));
        Room saveRoom = roomRepository.save(room);
        return null;
    }

    @Override
    public RoomResponseDto patchAllRoom(Map<String, String> roomRequestDto) {
        Room room = roomRepository.findById(Long.parseLong(roomRequestDto.get("id"))).orElseThrow(
                () -> new NotFoundException("Room not found")
        );
        room.setRoomStatus(Room.RoomStatus.valueOf(roomRequestDto.get("roomStatus")));
        Room saveRoom = roomRepository.save(room);
        return null;
    }

    @Override
    public String deleteAllRoom() {
        Room room = roomRepository.findById(Long.parseLong("1")).orElseThrow(
                () -> new NotFoundException("Room not found")
        );
        roomRepository.delete(room);
        return null;
    }
}
