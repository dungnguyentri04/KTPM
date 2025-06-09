package com.example.demo.dto.RequestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdRequestDto {

    @NotBlank(message = "Owner name is required")
    private String ownerName;

    @NotNull(message = "Number of household is required")
    private String numberOfHousehold;

    @NotBlank(message = "Citizen id owner is required")
    private String citizenIdOwner;

    @NotBlank(message = "Room name is required")
    private String roomName;

    private String householdType;

    private LocalDate registrationDate;

    private String status;

    private String note;

    private String createdBy;

    private String electricMeterCode;

    private String waterMeterCode;

    private List<HouseholdMemberDto> householdMemberDtos;

    // Mở rộng
    private String ownershipType;

    private LocalDate startDateLiving;

    private LocalDate endDateLiving;

    private Boolean isEligibleForDiscount;

    private Integer discountPercent;

    private String buildingCode;

    private Integer floorNumber;

    private Boolean hasPet;

    private Integer parkingSlotCount;

    private Boolean fireSafetyCertified;

    private String lastUpdatedBy;
}
