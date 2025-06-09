package com.example.demo.dto.RequestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomRequestDto {

    @NotBlank(message = "Room name is required")
    private String name;

    @NotNull(message = "Room description is required")
    private String description;

    @NotNull(message = "Room area is required")
    private Float area;

    @NotBlank(message = "Room location is required")
    private String location;


    @NotBlank(message = "Building code is required") // ví dụ: A, B, C
    private String buildingCode;

    @NotNull(message = "Floor number is required")
    private Integer floorNumber;

    @NotNull(message = "Maximum number of people is required")
    private Integer maxPeople;

    @NotNull(message = "Room type is required") // Ví dụ: căn hộ, penhouse, kiot, văn phòng
    private String type;

    private Boolean hasBalcony;

    private Boolean hasAirConditioner;

    private Boolean isOccupied;

    private Boolean isPetFriendly;

    private Boolean hasFireSafetyCertificate;

    private String notes;

    private String electricMeterCode;

    private String waterMeterCode;
}
