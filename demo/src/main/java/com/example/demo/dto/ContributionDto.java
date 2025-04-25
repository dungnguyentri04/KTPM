package com.example.demo.dto;

import com.example.demo.models.Contribution.StatusContribution;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContributionDto {
    private Long id;

    private Long feeId;

    private Long householdId;

    private Long money;

    private String status;

    private Date paymentDate;

    private Date deadline;

}
