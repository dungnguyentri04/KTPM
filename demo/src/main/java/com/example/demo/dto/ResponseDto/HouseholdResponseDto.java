package com.example.demo.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdResponseDto {
    private Long id;

    private String ownerName;

    private String numberOfHousehold;

    private String location;

    private float areaCode;

    private int numberOfPeople;

    private LocalDate createdAt;

    private LocalDate updateAt;

    private String citizenIdOwner;

    private String roomName;

    // 🆕 Trường mở rộng phù hợp nghiệp vụ quản lý hộ dân
    private String householdType;

    private LocalDate registrationDate;

    private String status;

    private String note;

    private String createdBy;

    private String electricMeterCode;

    private String waterMeterCode;

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

    // 🧍‍♂️ Danh sách thành viên hộ dân (nếu cần trả về)
    private List<DemographicsResponseDto> demographicsList;

