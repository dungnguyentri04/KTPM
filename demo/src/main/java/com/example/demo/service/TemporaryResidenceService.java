package com.example.demo.service;

import com.example.demo.dto.RequestDto.TemporaryResidenceRequestDto;
import com.example.demo.dto.ResponseDto.TemporaryResidenceResponseDto;
import com.example.demo.models.TemporaryResidence;

import java.util.List;

public interface TemporaryResidenceService {
    public TemporaryResidenceResponseDto addTemporary(TemporaryResidenceRequestDto temporaryResidenceRequestDto);

    public List<TemporaryResidenceResponseDto> getAllTemporary();

    public TemporaryResidenceResponseDto getTemporaryById(Long id);

    public String deleteTemporary(Long id);

    public List<TemporaryResidenceResponseDto> getTemporaryByUserId(Long id);

    public List<TemporaryResidenceResponseDto> getTemporaryByUser();

    public List<TemporaryResidenceResponseDto> getTemporaryActive();

    public List<TemporaryResidenceResponseDto> getTemporaryExpire();

    public List<TemporaryResidenceResponseDto> getTemporaryInactive();

    public TemporaryResidenceResponseDto updateTemporary(Long id, TemporaryResidenceRequestDto temporaryResidenceRequestDto);

    public List<TemporaryResidenceResponseDto> findByDemographicId(Long id);

    public List<TemporaryResidenceResponseDto> getTemporaryByRoomName(String roomName);
}
