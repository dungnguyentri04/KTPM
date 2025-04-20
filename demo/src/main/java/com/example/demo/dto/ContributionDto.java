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

    private FeeDto fee;

    /**
     * ID of the related Household.
     */
    private HouseholdDto household;

    /**
     * Amount of money contributed.
     */
    private Long money;

    /**
     * Status of the contribution (COMPLETE or IN_COMPLETE).
     */
    private StatusContribution status;

    /**
     * Date when payment was made.
     */
    private Date paymentDate;

    /**
     * Deadline for the payment.
     */
    private Date deadline;

    /**
     * Timestamp when the contribution was created.
     */
    private Date createdAt;

    /**
     * Timestamp when the contribution was last updated.
     */
    private Date updateAt;
}
