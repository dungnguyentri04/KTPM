package com.example.demo.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContributionResponseDto {
    private Long id;

    private Long feeId;

    private Long householdId;

    private double money;

    private String status;

    private Date paymentDate;

    private Date deadline;

    private Map<String, Object> attributes;

}
