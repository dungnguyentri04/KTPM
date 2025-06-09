package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticDto {
    private long totalRooms;

    private long countOccupiedRooms;

    private long totalHouseholds;

    private long totalUsers;

    private long totalDemographics;

    private long roomsPaid;

    private long roomsUnpaid;

    private BigDecimal totalFeeCollected;

    private BigDecimal totalFeeDebt;

    private long totalContribution;

    private long householdPaid;

    private long householdUnpaid;
}
