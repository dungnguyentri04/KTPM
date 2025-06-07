package com.example.demo.dto.RequestDto;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContributionRequestDto {
    @NotNull(message = "Fee id is required")
    private Long feeId;

    @NotNull(message = "Household id is required")
    private Long householdId;

    @NotNull(message = "Money is required")
    private double money;

//    private double price;

    @NotNull(message = "Payment date is required")
    private LocalDate deadline;

    private int vehicle;

}
