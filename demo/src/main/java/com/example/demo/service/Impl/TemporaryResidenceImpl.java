package com.example.demo.service.Impl;

import com.example.demo.dto.RequestDto.TemporaryResidenceRequestDto;
import com.example.demo.dto.ResponseDto.TemporaryResidenceResponseDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.models.Demographics;
import com.example.demo.models.Room;
import com.example.demo.models.TemporaryResidence;
import com.example.demo.repositories.DemographicsRepository;
import com.example.demo.repositories.RoomRepository;
import com.example.demo.repositories.TemporaryResidenceRepository;
import com.example.demo.service.TemporaryResidenceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TemporaryResidenceImpl implements TemporaryResidenceService {
    @Autowired
    private DemographicsRepository demographicsRepository;

    @Autowired
    private TemporaryResidenceRepository temporaryResidenceRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TemporaryResidenceResponseDto addTemporary(TemporaryResidenceRequestDto temporaryResidenceRequestDto) {
        Demographics demographics = demographicsRepository.findById(temporaryResidenceRequestDto.getDemographicId()).orElseThrow(
                () -> new NotFoundException("Demographic not found")
        );

        String type = temporaryResidenceRequestDto.getType();
        String roomName = temporaryResidenceRequestDto.getRoomName();
        TemporaryResidence temporaryResidence = modelMapper.map(temporaryResidenceRequestDto, TemporaryResidence.class);

        if (type.equals("TEMPORARY_RESIDENCE")){
            Room room = roomRepository.findByName(roomName);
            if (room == null){
                throw new NotFoundException("Room not found");
            }
            if (room.getRoomStatus() == Room.RoomStatus.EMPTY) {
                room.setRoomStatus(Room.RoomStatus.valueOf("OCCUPIED"));
                roomRepository.save(room);
            }
            temporaryResidence.setType(TemporaryResidence.ResidenceType.valueOf(type));
            temporaryResidence.setDemographics(demographics);
            temporaryResidence.setDemographicName(demographics.getName());
            temporaryResidence.setRoomName(roomName);
            temporaryResidence.setCreatedAt(LocalDate.now());
        }
        else if (type.equals("TEMPORARY_ABSENCE")){
            if (demographics.getRelationship() == null){
                throw new NotFoundException("Demographic dont have household");
            }
            temporaryResidence.setType(TemporaryResidence.ResidenceType.valueOf(type));
            temporaryResidence.setDemographics(demographics);
            temporaryResidence.setDemographicName(demographics.getName());
            temporaryResidence.setCreatedAt(LocalDate.now());
        }
        else {
            throw new NotFoundException("Type not found");
        }
        temporaryResidenceRepository.save(temporaryResidence);
        return null;
    }

    @Override
    public List<TemporaryResidenceResponseDto> getAllTemporary() {
        List<TemporaryResidence> temporaryResidences = temporaryResidenceRepository.findAll();
        List<TemporaryResidenceResponseDto> temporaryResidenceResponseDtos = temporaryResidences.stream()
                .map(temporaryResidence -> modelMapper.map(temporaryResidence, TemporaryResidenceResponseDto.class)).toList();
        return temporaryResidenceResponseDtos;
    }

    @Override
    public TemporaryResidenceResponseDto getTemporaryById(Long id) {
        TemporaryResidence temporaryResidence = temporaryResidenceRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Temporary Residence not found")
        );
        TemporaryResidenceResponseDto temporaryResidenceResponseDto = modelMapper.map(temporaryResidence, TemporaryResidenceResponseDto.class);
        return temporaryResidenceResponseDto;
    }

    @Override
    public String deleteTemporary(Long id) {
        TemporaryResidence temporaryResidence = temporaryResidenceRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Temporary Residence not found")
        );
        Room room = roomRepository.findByName(temporaryResidence.getRoomName());
        if (room != null) {
            room.setRoomStatus(Room.RoomStatus.EMPTY);
            roomRepository.save(room);
        }
        temporaryResidenceRepository.delete(temporaryResidence);
        return "Deleted Temporary Residence with id: " + id + " successfully";
    }

    @Override
    public List<TemporaryResidenceResponseDto> getTemporaryByUserId(Long id) {
        List<TemporaryResidence> temporaryResidences = temporaryResidenceRepository.findByDemographicId(id);
        List<TemporaryResidenceResponseDto> temporaryResidenceResponseDtos = temporaryResidences.stream()
                .map(temporaryResidence -> modelMapper.map(temporaryResidence, TemporaryResidenceResponseDto.class)).toList();
        return temporaryResidenceResponseDtos;
    }

    @Override
    public List<TemporaryResidenceResponseDto> getTemporaryByUser() {

        return null;
    }

    @Override
    public List<TemporaryResidenceResponseDto> getTemporaryActive() {
        List<TemporaryResidence> temporaryResidences = temporaryResidenceRepository.findAll();
        List<TemporaryResidenceResponseDto> temporaryResidenceResponseDtos = temporaryResidences.stream()
                .map(temporaryResidence -> modelMapper.map(temporaryResidence, TemporaryResidenceResponseDto.class)).toList();
        return null;
    }

    @Override
    public List<TemporaryResidenceResponseDto> getTemporaryExpire() {
        List<TemporaryResidence> temporaryResidences = temporaryResidenceRepository.findAll();
        List<TemporaryResidenceResponseDto> temporaryResidenceResponseDtos = temporaryResidences.stream()
                .map(temporaryResidence -> modelMapper.map(temporaryResidence, TemporaryResidenceResponseDto.class)).toList();
        return null;
    }

    @Override
    public List<TemporaryResidenceResponseDto> getTemporaryInactive() {
        List<TemporaryResidence> temporaryResidences = temporaryResidenceRepository.findAll();
        List<TemporaryResidenceResponseDto> temporaryResidenceResponseDtos = temporaryResidences.stream()
                .map(temporaryResidence -> modelMapper.map(temporaryResidence, TemporaryResidenceResponseDto.class)).toList();
        return null;
    }

    @Override
    public TemporaryResidenceResponseDto updateTemporary(Long id, TemporaryResidenceRequestDto temporaryResidenceRequestDto) {
        TemporaryResidence temporaryResidence = temporaryResidenceRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Temporary Residence not found")
        );
        temporaryResidence.setRoomName(temporaryResidenceRequestDto.getRoomName());
        temporaryResidenceRepository.save(temporaryResidence);
        return null;
    }

    @Override
    public List<TemporaryResidenceResponseDto> findByDemographicId(Long id) {
        return null;
    }

    @Override
    public List<TemporaryResidenceResponseDto> getTemporaryByRoomName(String roomName) {
        return null;
    }
}
