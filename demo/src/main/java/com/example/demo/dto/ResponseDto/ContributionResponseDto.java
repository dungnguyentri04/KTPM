package com.example.demo.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContributionResponseDto {
    private Long feeId;

    private Long id;

    private Long householdId;

    private double money;

    private String status;

    private LocalDate paymentDate;

    private String feeName;

    private LocalDate createdAt;

    private LocalDate deadline;

    private LocalDate updateAt;

}
