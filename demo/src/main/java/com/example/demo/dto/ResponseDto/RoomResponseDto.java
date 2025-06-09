package com.example.demo.dto.ResponseDto;

import com.example.demo.models.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponseDto {
    private Long id;

    private String name;

    private String description;

    private Float area;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private String ownerName;

    private Long householdId;

    private String status;
}
