package com.example.demo.dto.RequestDto;

import java.util.Date;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContributionRequestDto {
    private Long feeId;

    private Long householdId;

    private double money;

//    private double price;

    private Date deadline;

    private Map<String, Object> attributes;

}
