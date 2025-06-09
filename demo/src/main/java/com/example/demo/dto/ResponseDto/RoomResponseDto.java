package com.example.demo.dto.ResponseDto;

<<<<<<< HEAD
=======
import com.example.demo.models.Room;
>>>>>>> main
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


    private String buildingCode;

    private Integer floorNumber;

    private Integer maxPeople;

    private String type; // căn hộ, penhouse, kiot, v.v.

    private Boolean hasBalcony;

    private Boolean hasAirConditioner;

    private Boolean isOccupied;

    private Boolean isPetFriendly;

    private Boolean hasFireSafetyCertificate;

    private String notes;

    private String electricMeterCode;

    private String waterMeterCode;

    private Boolean isUnderMaintenance;

    private LocalDate occupiedSince;

    private LocalDate expectedVacancyDate;
}
